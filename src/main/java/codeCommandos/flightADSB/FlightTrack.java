package codeCommandos.flightADSB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class FlightTrack {

    public List<Ac> getAircraftLocations() {
        List<Ac> aircraftList = new ArrayList<>();

        try {
            // API endpoint URL
            URL url = new URL("https://api.adsb.lol/v2/ladd");

            // HTTP GET isteği oluşturma
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Yanıtı okuma
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }

                // JSON olarak yanıtı işleme
                JSONObject jsonObject = new JSONObject(response.toString());

                // "ac" anahtarından uçaklar dizisini alma
                JSONArray aircrafts = jsonObject.getJSONArray("ac");

                // Her bir uçak için bilgileri alma ve Ac nesneleri oluşturma
                for (int i = 0; i < aircrafts.length(); i++) {
                    JSONObject aircraft = aircrafts.getJSONObject(i);
                    if (aircraft.has("lat")) { // "lat" anahtarının varlığını kontrol et
                        Ac ac = new Ac();
                        ac.setFlight(aircraft.optString("flight", "Bilinmeyen Uçuş"));
                        ac.setLat(aircraft.getDouble("lat"));
                        ac.setLon(aircraft.getDouble("lon"));
                        ac.setAlt_geom(aircraft.optInt("alt_geom", -1));
                        ac.setType(aircraft.optString("type","Bilinmeyen Tip"));
                        ac.setCategory(aircraft.optString("category","Bilinmeyen Tip"));
                        ac.setSil_type(aircraft.optString("sil_type","Bilinmeyen Tip"));
                        ac.setSquawk(aircraft.optString("squawk","Bilinmeyen Tip"));
                        // Diğer uçak özelliklerini burada da ekleyebilirsiniz
                        ac.setT(aircraft.optString("t","Bilinmeyen Tip"));
                        ac.setR(aircraft.optString("r","Bilinmeyen Tip"));
                        ac.setHex(aircraft.optString("hex","Bilinmeyen Tip"));
                        ac.setGs(aircraft.optInt("gs", -1));
                        ac.setSeen(aircraft.optInt("seen", -1));
                        ac.setSeen_pos(aircraft.optInt("seen_pos", -1));
                        ac.setTrue_heading(aircraft.optInt("true_heading", aircraft.optInt("mag_heading", 0))); // Yön bilgisi
                        ac.setHeading(aircraft.optInt("track", -1)); // Uçağın yön bilgisi (track) alınıyor
                        aircraftList.add(ac);

                    }
                }
            }
            // Bağlantıyı kapatma
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aircraftList;
    }
}
