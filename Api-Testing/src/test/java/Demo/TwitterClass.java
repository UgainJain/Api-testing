package Demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TwitterClass {

	@Test
	public void test3() throws IOException
	{
		RestAssured.baseURI = "https://api.twitter.com/1.1";
		RequestSpecification req = RestAssured.given();
		req.auth().oauth("QJNUVGFGKZtwvXVk12p7T3qFY", "OGLW1UEjLP1AieGFyr20RW38GGJRkg5NayzPcSg7lG12ju1Uvl", "990618864823259136-q70kVKdFbB2g7eJHWt57Q9qdAKeEEgk","7qtLnaxr5kPF2lND4iZOVHxhFt7ZBysl9vzkXOKJv0ZYI");
		req.queryParam("screen_name","@AamAadmiParty");
		Response res = req.when().get("statuses/user_timeline.json");
		FileOutputStream file = new FileOutputStream(new File("C:\\Users\\ugainjain\\Documents\\qwerty.txt"));
		file.write(res.prettyPrint().getBytes(),0,res.print().getBytes().length);
		res.then().log().all();
	}
}
