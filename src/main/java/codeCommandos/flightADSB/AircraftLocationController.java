package codeCommandos.flightADSB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AircraftLocationController {

    private final FlightTrack flightTrack;

    public AircraftLocationController(FlightTrack flightTrack) {
        this.flightTrack = flightTrack;
    }

    @GetMapping("/aircrafts")
    public List<Ac> getAircraftLocations() {
        return flightTrack.getAircraftLocations();
    }
}
