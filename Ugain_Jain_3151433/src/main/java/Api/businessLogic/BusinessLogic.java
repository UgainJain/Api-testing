package Api.businessLogic;

import io.restassured.response.Response;
import utils.Base.BaseClass;
import utils.Common.CommonUtils;

public class BusinessLogic extends BaseClass{
	String req = null;
	public boolean getLists() {
		req = "getalllists";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(200);
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean deleteLists() {
		req = "deleteList";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		req = "deleteList";
		resp.then().assertThat().statusCode(204);
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean getspecificList() {
		req = "getSpecificList";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(200);
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public boolean createList() {
		req = "createlist";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(201);
		CommonUtils.updateID(resp.jsonPath().get("id"));
		CommonUtils.updateRevision(resp.jsonPath().get("revision"));
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean updatepatchList() {
		req = "updatepatchList";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(200);

		CommonUtils.updateRevisionforupdate();
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean updateputList() {
		req = "updateputList";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(200);

		CommonUtils.updateRevisionforupdate();
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean gettasks() {
		req = "gettasks";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(200);
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean createtasks() {
		req = "createtasks";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(201);
		CommonUtils.updatetaskID(resp.jsonPath().get("id"));
		CommonUtils.updateRevisionfortask(resp.jsonPath().get("revision"));
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean updatepatchtasks() {
		req = "updatepatchtasks";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(200);

		CommonUtils.updatetaskRevision();
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateputtasks() {
		req = "updateputtasks";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(200);

		CommonUtils.updatetaskRevision();
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

			e.printStackTrace();
			return false;
		}
	}
	public boolean deletetasks() {
		req = "deletetasks";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		resp.then().assertThat().statusCode(204);
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

			e.printStackTrace();
			return false;
		}
	}

}
