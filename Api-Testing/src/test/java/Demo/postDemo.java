package Demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postDemo {

	@Test
	public void tst1() {
		RestAssured.baseURI="http://localhost:3030"; 
		RequestSpecification req = RestAssured.given();	
		
		JSONObject b = new JSONObject();
		
		b.put("name", "Throne");
		b.put("type", "Furniture");
		b.put("price", 200);
		b.put("shipping", 20);
		b.put("description", "GOT throne");
		b.put("manufacturer", "GOT");
		b.put("model", "123456");
		b.put("url", "qwerty");
		b.put("image", "123456");
		b.put("upc", "12345678901234");
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		httpRequest.accept(ContentType.JSON);
		System.out.println(b);
		httpRequest.body(b).log().all().when().post("products" ).then().log().all().extract().response();
//		httpRequest.log().all();
//		Response response = httpRequest.when().post("products");
//		response.then().log().all();
		
	}
}
