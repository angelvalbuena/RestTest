package restTest.ressTest;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;


import com.jayway.restassured.response.Response;

public class ConsultRecorTest {
	
	String baseURL = "http://localhost:8080";
	String path = "/cloudBRT/api/monitoreo/recorridos/consultar/T3-2";

		@Test
		public void getConsultReco(){
		
			String url = baseURL + path;
		    Response response = get(url);
		
		
		String status = response.path("Clave");
		assertNotNull(status);
		
		String stat = response.path("Ruta");
		assertNotNull(stat);
		
		String sta = response.path("HoraPartida");
		assertNotNull(sta);
		
		
		Object statu = response.path("Horario");
		assertNotNull(statu);
		
		JSONObject jsonResponse = new JSONObject(response.asString());
		JSONObject Horario = jsonResponse.getJSONObject("Horario");
		Object ST1 = Horario.get("ST1");
		assertNotNull(ST1);
		
		Object ST2 = Horario.get("ST2");
		assertNotNull(ST2);
		
		Object ST3 = Horario.get("ST3");
		assertNotNull(ST3);
		
		Object ST4 = Horario.get("ST4");
		assertNotNull(ST4);
		
		Object ST5 = Horario.get("ST5");
		assertNotNull(ST5);

  }

}
