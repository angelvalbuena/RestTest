package restTest.ressTest;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;


import com.jayway.restassured.response.Response;

public class ConsultBusTest {
	
	String baseURL = "http://172.17.0.4:8080";
	String path = "/cloudBRT/api/monitoreo/buses/consultar/ZOE101";

		@Test
		public void getConsultBus(){
		
			String url = baseURL + path;
		    Response response = get(url);
		
		
		String status = response.path("Placa");
		assertNotNull(status);
		
		int stat = response.path("Capacidad");
		assertNotNull(stat);
		
		String sta = response.path("TipoBus");
		assertNotNull(sta);
		
		boolean st = response.path("Estado");
		assertNotNull(st);
		
		Object statu = response.path("Coordenada");
		assertNotNull(statu);
		
		JSONObject jsonResponse = new JSONObject(response.asString());
		JSONObject Coordenada = jsonResponse.getJSONObject("Coordenada");
		Object lat = Coordenada.get("latitud");
		assertNotNull(lat);
		
		Object lon = Coordenada.get("longitud");
		assertNotNull(lon);

  }

}
