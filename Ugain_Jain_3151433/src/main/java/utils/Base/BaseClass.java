package utils.Base;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Common.CommonUtils;
import utils.dataSource.LoadProperty;

public class BaseClass {
	public static RequestSpecification httpReq;
	public static Response resp;
	
	public void BeforeAll() {
		
	}
	
	public void createrequest(String req) {
		RestAssured.baseURI= LoadProperty.getvar("BaseUrl", "config");
		httpReq = RestAssured.given();
		if(req.equalsIgnoreCase("getalllists")) {
			httpReq= CommonUtils.addHeader(httpReq);
			httpReq.log().all();
		}
		else if (req.equalsIgnoreCase("getSpecificList")) {
//			CommonUtils.addPathVariable("id", LoadProperty.getvar("GetListID", "ParamConfig"),httpReq);
			httpReq.pathParam("id", LoadProperty.getvar("GetListID", "ParamConfig"));
			httpReq = CommonUtils.addHeader(httpReq);
		}
		else if (req.equalsIgnoreCase("createList"))
		{	
			httpReq = CommonUtils.addHeader(httpReq);
			httpReq.body(createBody(req));
		}
		else {
			System.out.println("Unspecified REquest");
		}
			
	}
	public HashMap<String,String> createBody(String req){
		HashMap<String, String> body = new HashMap<String, String>();
		if(req.equalsIgnoreCase("createList")) {
			body.put("title",LoadProperty.getvar("CreteList_title", "ParamConfig"));
			return body;
		}
		else if(req.equalsIgnoreCase("updateList")) {
			body.put("revision", LoadProperty.getvar("revision", "ParamConfig"));
			body.put("title", LoadProperty.getvar("updatetitle", "ParamConfig"));
			return body;
		}
		return body;
	}

	public void createresponse(String req) {
		if(req.equalsIgnoreCase("getalllists")) {
			resp = httpReq.when().get("lists");
			resp.then().log().all();
		}
		else if(req.equalsIgnoreCase("getSpecificList")) {
			resp = httpReq.when().get("lists");
			resp.then().log().all();
		}
		
		
	}
}

