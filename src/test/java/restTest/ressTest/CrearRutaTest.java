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

public class CrearRutaTest {
	
	String baseURL = "http://localhost:8080";
	String path = "/cloudBRT/api/admin/rutas/crear/T4";
	
	@Test
	public void getCrearRuta() throws JSONException {
	
		String url = baseURL + path;
		
		//make get request 
	Response resp = get(url);
		
		//Fetching response in JSON
		JSONObject jsonResponse = new JSONObject(resp.asString());
		
		boolean  Encontrado = jsonResponse.getBoolean("Encontrado");
		
		
		Assert.assertEquals(Encontrado, false);
		
		
   }

}
