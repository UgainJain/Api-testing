package Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class wunderlist {
@Test
public void test1() {
	RestAssured.baseURI = "https://a.wunderlist.com";
	RequestSpecification httpReq = RestAssured.given();
	httpReq.header("Content-Type", "application/json");
	httpReq.header("X-Access-Token","613be6248ef86e87ccfc595bf067667b30cc4b81e18e5bbfe4c61cc0befc");
	httpReq.header("X-Client-ID","d3be97e3a6a4f75de94e");
	httpReq.log().all().when().get("api/v1/lists").then().log().all();
	
}
}
