package Api.businessLogic;

import io.restassured.specification.RequestSpecification;
import utils.Base.BaseClass;

public class BusinessLogic extends BaseClass{
	String req = null;
	public boolean getLists() {
		req = "getalllists";
		try {
//		createrequest(req);
//		createresponse(req);
		req = "getSpecificList";

		createrequest(req);
		createresponse(req);
		return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
