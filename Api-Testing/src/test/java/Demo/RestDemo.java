package Demo;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestDemo {
	@BeforeSuite
	public void startSuite() {
		//RestAssured.baseURI = "http://localhost:3030";
		}
	/*@Test
	public void test1() {
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.when().get("products");
		//System.out.println(response.asString());
		//System.out.println(response.getStatusCode());
		//System.out.println(response.getContentType());
		System.out.println(response.jsonPath().getInt("total"));
		System.out.println(response.prettyPrint());
		response.then().assertThat().statusCode(200);
	}*/
	@Test
	public void test2() {
		RestAssured.baseURI= "https://maps.googleapis.com/maps";
		RequestSpecification req = RestAssured.given();
		req.queryParam("location", "28.494608,77.0680439");
		req.queryParam("radius", "10");
		req.queryParam("key", "AIzaSyANWDBj73F7zrgjLhvF15DVKl6bwE-MBts");
		req.log().all();
		req.log().body();
		req.log().everything();
		Response res = req.when().get("api/place/nearbysearch/json");
		res.then().log().ifValidationFails().assertThat().statusCode(201);
		res.then().log().status();
		res.then().log().ifStatusCodeIsEqualTo(200);
		System.out.println(res.prettyPrint());
		System.out.println(res.jsonPath().getList("results.vicinity").toString());
		System.out.println(res.statusCode());
		res.then().log().all();
	}
}
