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

public class RecorridEdit {
	
	String baseURL = "http://localhost:8080";
	String path = "/cloudBRT/api/admin/recorridos/editar";
	
	@Test
	public void httpPost() 
		throws JSONException,InterruptedException{
		
		String url = baseURL + path;
		
		//Inicializamos URL Rest API
		String APIUrl = url;
		String APIBody = "{\"Clave\": \"T3-1\",  \"Parada\":\"ST17\", \"HoraAnterior\": \"00:15:57\", \"HoraNueva\":\"00:14:00\"  }";

		//Solicitud de Construccion por medio de RequestSpecBuilder
				RequestSpecBuilder builder = new RequestSpecBuilder();

				//Seteando api del body
				builder.setBody(APIBody);
				
				//Seteando ContenType como aplicación json
				builder.setContentType("application/json");
				
				RequestSpecification requestSpec = builder.build();
				

		        //Creando post request
				Response response = given().spec(requestSpec).when().post(APIUrl);
				JSONObject JSONResponseBody= new JSONObject(response.body().asString());
				boolean result = JSONResponseBody.getBoolean("Encontrado");
				
				//Assert de resultado esperado
				Assert.assertEquals(result,false);
   }
}
