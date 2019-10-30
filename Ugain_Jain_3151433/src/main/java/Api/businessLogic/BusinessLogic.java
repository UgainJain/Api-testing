package Api.businessLogic;

import io.restassured.response.Response;
import utils.Base.BaseClass;

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
		resp.then().assertThat().statusCode(200);
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
			return false;
		}
	}
	public boolean createList() {
		req = "createlist";
		try {
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(201);
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean updatepatchList() {
		req = "updatepatchList()";
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
	
	public boolean updateputList() {
		req = "updateputList()";
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

}
