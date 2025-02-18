let map;
const markers = {}; // Markerları saklamak için bir obje
const flightPaths = {}; // Her uçağın yolunu saklamak için bir obje
const infoWindowIntervals = {}; // InfoWindow içerik güncellemeleri için interval'ları saklamak için bir obje

function initMap() {
  const center = { lat: 0, lng: 0 };
  map = new google.maps.Map(document.getElementById("map"), {
    zoom: 2,
    center: center,
  });
  updateAircraftLocations();
}

function updateAircraftLocations() {
  setInterval(getAircraftLocations, 1000);
}

function getAircraftLocations() {
  fetch('http://localhost:8080/api/aircrafts')
    .then(response => response.json())
    .then(aircrafts => {
      aircrafts.forEach(aircraft => {
        const id = aircraft.hex;
        const newPosition = { lat: aircraft.lat, lng: aircraft.lon };
        let heading = aircraft.heading || 0;

        if (!flightPaths[id]) {
          flightPaths[id] = [newPosition];
        } else {
          const lastPosition = flightPaths[id][flightPaths[id].length - 1];
          if (newPosition.lat !== lastPosition.lat || newPosition.lng !== lastPosition.lng) {
            flightPaths[id].push(newPosition);
          }
        }

        const icon = getMarkerIcon(heading);

        if (markers[id]) {
          markers[id].setPosition(newPosition);
          markers[id].setIcon(icon);
          markers[id].aircraftData = aircraft; // Store the current data for use in the InfoWindow
          if (markers[id].line) {
            markers[id].line.setPath(flightPaths[id]);
          }
        } else {
          const marker = new google.maps.Marker({
            position: newPosition,
            map: map,
            //title: aircraft.flight,
            icon: icon
          });

          setupMarker(marker, aircraft, id);
          markers[id] = marker;
          markers[id].aircraftData = aircraft; // Store the current data for use in the InfoWindow
        }
      });

      Object.keys(markers).forEach(id => {
        if (!aircrafts.some(aircraft => aircraft.hex === id)) {
          clearInterval(infoWindowIntervals[id]);
          markers[id].setMap(null);
          delete markers[id];
        }
      });
    })
    .catch(error => {
      console.error('Error fetching aircraft locations:', error);
    });
}

function setupMarker(marker, aircraft, id) {
  let infoWindowOpen = false;
  const infowindow = new google.maps.InfoWindow({
    content: generateInfoContent(aircraft) // Set initial content
  });

  marker.addListener("mouseover", () => {
    infowindow.setContent(generateInfoContent(marker.aircraftData));
    infowindow.open(map, marker);
    infoWindowOpen = true;

    // Update the content of the InfoWindow as long as it's open
    if (infoWindowIntervals[id]) clearInterval(infoWindowIntervals[id]);
    infoWindowIntervals[id] = setInterval(() => {
      if (infoWindowOpen && markers[id]) {
        const newContent = generateInfoContent(markers[id].aircraftData);
        infowindow.setContent(newContent);
      }
    }, 1000);
  });

  marker.addListener("mouseout", () => {
    infowindow.close();
    infoWindowOpen = false;
    clearInterval(infoWindowIntervals[id]);
  });

  marker.addListener("click", () => {
    if (markers[id].line) {
      markers[id].line.setMap(null);
      delete markers[id].line;
    } else {
      const lineSymbol = {
        path: 'M 0,-1 0,1',
        strokeOpacity: 1,
        scale: 4
      };
      const line = new google.maps.Polyline({
        path: flightPaths[id],
        geodesic: true,
        strokeColor: "#000000",
        strokeOpacity: 0,
        strokeWeight: 4,
        icons: [{
          icon: lineSymbol,
          offset: '0',
          repeat: '20px'
        }],
      });
      line.setMap(map);
      markers[id].line = line;
    }
  });
}

function generateInfoContent(aircraft) {
  return `<div><strong>Uçuş Adı:</strong> ${aircraft.flight}</div>` +
         `<div><strong>İrtifa(feet):</strong> ${aircraft.alt_geom}</div>` +
         `<div><strong>Uçak Türü:</strong> ${aircraft.t}</div>` +
         `<div><strong>Uçağın kayıtlı ismi:</strong> ${aircraft.r}</div>` +
         `<div><strong>Hız:</strong> ${aircraft.gs}</div>`+
         `<div><strong>Track:</strong> ${aircraft.heading}</div>`;
}

function getMarkerIcon(rotation) {
  return {
    path: 'M42 32v-4l-16-10v-11c0-1.66-1.34-3-3-3s-3 1.34-3 3v11l-16 10v4l16-5v11l-4 3v3l7-2 7 2v-3l-4-3v-11l16 5z',
    scale: 0.5,
    strokeColor: 'black',
    strokeWeight: 1,
    rotation: rotation,
    fillColor: '#0000FF',
    fillOpacity: 1.0,
    anchor: new google.maps.Point(22.5, 25) // Adjust if needed
  };
}

window.onload = initMap;
