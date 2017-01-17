package restTest.ressTest;

import static org.junit.Assert.*;

import org.junit.Test;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;


import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class ConsultParTest {
	
	String baseURL = "http://172.17.0.2:8080";
	String path = "/cloudBRT/api/monitoreo/paradas/consultar/ST1";
	
	@Test
	public void getConsultPar(){
	
		String url = baseURL + path;
	    Response response = get(url);
	
	
	String status = response.path("Clave");
	assertNotNull(status);
	
	String stat = response.path("Nombre");
	assertNotNull(stat);
	
	
	Object statu = response.path("Coordenada");
	assertNotNull(statu);
	
	JSONObject jsonResponse = new JSONObject(response.asString());
	JSONObject Coordenada = jsonResponse.getJSONObject("Coordenada");
	Object lat = Coordenada.get("Latitud");
	assertNotNull(lat);
	
	Object lon = Coordenada.get("Longitud");
	assertNotNull(lon);

}


}
