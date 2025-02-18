package codeCommandos.flightADSB;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FlightAdsbApplicationTests {
	private AircraftLocationController controller;
	private FlightTrack mockFlightTrack;

	@BeforeEach
	public void setUp() {
		// FlightTrack'ı mocklayın
		mockFlightTrack = mock(FlightTrack.class);
		// Controller'ı oluşturun ve mockFlightTrack ile başlatın
		controller = new AircraftLocationController(mockFlightTrack);
	}


	@Mock
	private FlightTrack flightTrack;

	@InjectMocks
	private AircraftLocationController aircraftLocationController;

	@Test
	public void checkingAPIWorking() {//API ye atilan istekler gidip gelen kodun kac olduguna bakiyoruz boylece API nin calisip calismadigini anlariz
		String apiUrl = "https://api.adsb.lol/v2/ladd";
		RestTemplate restTemplate = new RestTemplate();

		try {
			// API'ye HTTP GET isteği yap
			restTemplate.getForEntity(apiUrl, String.class);

			// Eğer bir istisna oluşmadıysa ve istek başarılı olduysa (200 kodu ile),
			// API geçerli kabul edilebilir.
			// Eğer başarılı bir şekilde istek yapıldıysa test başarılı kabul edilir.
		} catch (HttpClientErrorException e) {

			HttpStatusCode statusCode = e.getStatusCode();

			// Eğer 404 hatası alınırsa, API geçersiz kabul edilebilir
			if (statusCode == HttpStatus.NOT_FOUND) {
				fail("API gecersiz. Hata kodu: " + statusCode);// eger hata olusursa fail methodu  kullanilarak test basarisiz sayilir

			} else {
				fail("bilinmeyen hata kodu : " + statusCode);
			}
		}

	}

	@Test
	public void checkingisAircraftListisNull() {//api linkinin bos ucak listesi yollayip yollamadigini test etme

		// Mock bir FlightTrack nesnesi oluşturulur (gerçek bir API çağrısı yapmadan)
		FlightTrack flightTrack = new FlightTrack();

		// API'den veri almak için FlightTrack sınıfının metodu çağrılır
		List<Ac> aircrafts = flightTrack.getAircraftLocations();

		// Dönen uçak konumu listesinin boş olup olmadığını kontrol eder
		assertNotNull(aircrafts);
		assertFalse(aircrafts.isEmpty());
	}

	@Test
	public void chekingNullVariableTest() {//ucaklarin verilerinde null olabilecek degerler olup omadigini test ediyoruz
		FlightTrack flightTrack = new FlightTrack();
		List<Ac> aircrafts = flightTrack.getAircraftLocations();

		assertNotNull(aircrafts);

		assertFalse(aircrafts.isEmpty());


		for (Ac aircraft : aircrafts) {
			assertNotNull(aircraft.getAlert());
			assertNotNull(aircraft.getAlt_baro());
			assertNotNull(aircraft.getAlt_geom());
			assertNotNull(aircraft.getCategory());
			assertNotNull(aircraft.getFlight());
			assertNotNull(aircraft.getGs());
			assertNotNull(aircraft.getHex());
			assertNotNull(aircraft.getLat());
			assertNotNull(aircraft.getLon());
			assertNotNull(aircraft.getSeen());
			assertNotNull(aircraft.getSeen_pos());
			assertNotNull(aircraft.getSil_type());
			assertNotNull(aircraft.getSquawk());
			assertNotNull(aircraft.getType());
			assertNotNull(aircraft.getT());
			assertNotNull(aircraft.getR());
			assertNotNull(aircraft.getHeading());
		}
	}

	@Test
	public void testGetAircraftLocations() {
		// Mock bir ucak listesi olusturma kismi
		List<Ac> mockAircraftList = new ArrayList<>();
		Ac mockAc1 = new Ac();
		mockAc1.setFlight("Flight1");
		mockAc1.setLat(42.123);
		mockAc1.setLon(-71.456);
		mockAc1.setAlt_geom(10000);
		mockAircraftList.add(mockAc1);

		Ac mockAc2 = new Ac();
		mockAc2.setFlight("Flight2");
		mockAc2.setLat(42.456);
		mockAc2.setLon(-71.789);
		mockAc2.setAlt_geom(15000);
		mockAircraftList.add(mockAc2);

		// Mock bir ucak listesi donduruyoruz ve lokasyonlarini aliyoruz
		when(mockFlightTrack.getAircraftLocations()).thenReturn(mockAircraftList);


		List<Ac> result = controller.getAircraftLocations();

		// Dogru sayida ucak donduruyor mu?
		assertEquals(2, result.size());

		// Deger dogrulama islemleri
		assertEquals("Flight1", result.get(0).getFlight());
		assertEquals(42.123, result.get(0).getLat(), 0.001); // 0.001 tolerans ile karşılaştırma yapılıyor
		assertEquals(-71.456, result.get(0).getLon(), 0.001);
		assertEquals(10000, result.get(0).getAlt_geom());


		assertEquals("Flight2", result.get(1).getFlight());
		assertEquals(42.456, result.get(1).getLat(), 0.001);
		assertEquals(-71.789, result.get(1).getLon(), 0.001);
		assertEquals(15000, result.get(1).getAlt_geom());
	}
}






