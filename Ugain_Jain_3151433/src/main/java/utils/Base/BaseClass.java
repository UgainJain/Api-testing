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
	
	public void createrequest(String req) {
		RestAssured.baseURI= LoadProperty.getvar("BaseUrl", "config");
		httpReq = RestAssured.given();
		if(req.equalsIgnoreCase("getalllists")) {
			httpReq= CommonUtils.addHeader(httpReq);
			httpReq.log().all();
		}
		else if (req.equalsIgnoreCase("getSpecificList")) {
			CommonUtils.addPathVariable("id", LoadProperty.getvar("GetListID", "ParamConfig"),httpReq);
			
			httpReq = CommonUtils.addHeader(httpReq);
		}
		else if (req.equalsIgnoreCase("createList"))
		{	
			httpReq = CommonUtils.addHeader(httpReq);
			httpReq.body(createBody(req));
		}
		else if (req.equalsIgnoreCase("updatepatchList"))
		{	
			httpReq = CommonUtils.addHeader(httpReq);
			httpReq = CommonUtils.addPathVariable("id", LoadProperty.getvar("GetListID", "ParamConfig"),httpReq);
			httpReq.body(createBody(req));
		}
		else if (req.equalsIgnoreCase("updateputList"))
		{	
			httpReq = CommonUtils.addHeader(httpReq);
			httpReq = CommonUtils.addPathVariable("id", LoadProperty.getvar("GetListID", "ParamConfig"),httpReq);
			httpReq.body(createBody(req));
		}
		else if (req.equalsIgnoreCase("deleteList"))
		{	
			httpReq = CommonUtils.addHeader(httpReq);
			httpReq = CommonUtils.addPathVariable("id", LoadProperty.getvar("GetListID", "ParamConfig"),httpReq);
			httpReq = CommonUtils.addqueryParam("revision", LoadProperty.getvar("Revision", "ParamConfig"), httpReq);;
		}
		else {
			System.out.println("Unspecified REquest");
		}
			
	}
	public HashMap<String,Object> createBody(String req){
		HashMap<String, Object> body = new HashMap<String, Object>();
		if(req.equalsIgnoreCase("createList")) {
			body.put("title",LoadProperty.getvar("CreteList_title", "ParamConfig"));
			return body;
		}
		else if(req.equalsIgnoreCase("updatepatchList")) {
			body.put("revision",CommonUtils.intparser( LoadProperty.getvar("Revision", "ParamConfig")));
			body.put("updateTitle", LoadProperty.getvar("updateTitle", "ParamConfig"));
			return body;
		}else if(req.equalsIgnoreCase("updateputList")) {
			body.put("revision",CommonUtils.intparser( LoadProperty.getvar("Revision", "ParamConfig")));
			body.put("updateTitle", LoadProperty.getvar("updateTitle", "ParamConfig"));
			return body;
		}
		else {
			System.out.println("wrong logic");
			return body;
		}
		
	}

	public Response createresponse(String req) {
		if(req.equalsIgnoreCase("getalllists")) {
			resp = httpReq.when().get("lists");
			resp.then().log().all();
			return resp;
		}
		else if(req.equalsIgnoreCase("getSpecificList")) {
			resp = httpReq.when().get(LoadProperty.getvar("Get-lists", "resource"));
			resp.then().log().all();
			return resp;
		}
		else if(req.equalsIgnoreCase("createList")) {
			resp = httpReq.when().post(LoadProperty.getvar("Get-lists", "resource"));
			resp.then().log().all();
			return resp;
		}else if(req.equalsIgnoreCase("updatepatchList")) {
			resp = httpReq.when().patch(LoadProperty.getvar("Get-lists", "resource"));
			resp.then().log().all();
			return resp;
		}else if(req.equalsIgnoreCase("updateputList")) {
			resp = httpReq.when().put(LoadProperty.getvar("Get-lists", "resource"));
			resp.then().log().all();
			return resp;
		}
		else if(req.equalsIgnoreCase("deleteList")) {
			resp = httpReq.when().delete(LoadProperty.getvar("Get-lists", "resource"));
			resp.then().log().all();
			return resp;
		}
		else {
			System.out.println("Wrong Param");
			return null;
		}
	}
}


