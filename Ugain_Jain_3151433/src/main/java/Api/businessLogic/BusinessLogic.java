package Api.businessLogic;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Base.BaseClass;
import utils.Common.CommonUtils;

public class BusinessLogic extends BaseClass{
	String req = null;
	static Logger logger;
	public void beforeAll() {
		logger = Logger.getLogger("APiTesting");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	public static ExtentTest test;
	public boolean getLists() {
		logger.info("Running \"getalllists\" function");
		req = "getalllists";
		test = reports.startTest("getalllists");
		try {
		logger.info("Creating Request ");
		test.log(LogStatus.INFO, "Creating Request ");
		RequestSpecification httpReq = createrequest(req);
		httpReq.log().all();
		Response resp = createresponse(req);
		logger.info("Response generated");
		System.out.println(resp.prettyPrint());

		logger.info("Response:"+resp.prettyPrint());

		test.log(LogStatus.INFO, "Response generated");
		resp.then().log().ifError().assertThat().statusCode(200);
		logger.info("\"getalllists\" passed");
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			logger.info("\"getalllists\"0 function failed");
			logger.info("Request :"+httpReq.log().all());
			logger.info("Response:"+resp.prettyPrint());
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean deleteLists() {
		req = "deleteList";

		logger.info("Running \"deleteList\" function");
		try {test = reports.startTest("getalllists");
			logger.info("Creating Request ");

			test.log(LogStatus.INFO, "Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);
		req = "deleteList";

		logger.info("Response generated");
		resp.then().assertThat().statusCode(204);
		test.log(LogStatus.INFO, "Response generated");
		logger.info("Response:"+resp.prettyPrint());
		
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {

			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean getspecificList() {
		req = "getSpecificList";
		logger.info("Running \"getSpecificList\" function");
		try {
			test = reports.startTest("getSpecificList");
			test.log(LogStatus.INFO, "Creating Request ");

			logger.info("Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);
		test.log(LogStatus.INFO, "Response generated");
		logger.info("Response generated");
		resp.then().assertThat().statusCode(200);
		logger.info("Response:"+resp.prettyPrint());
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public boolean createList() {
		req = "createlist";
		logger.info("Running \"createlist\" function");
		try {
			test = reports.startTest("createlist");
			test.log(LogStatus.INFO, "Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);
		test.log(LogStatus.INFO, "Response generated");
		logger.info("Response generated");
		resp.then().assertThat().statusCode(201);
		CommonUtils.updateID(resp.jsonPath().get("id"));
		CommonUtils.updateRevision(resp.jsonPath().get("revision"));
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean updatepatchList() {
		req = "updatepatchList";
		try {
			test = reports.startTest("updatepatchList");
			test.log(LogStatus.INFO, "Creating Request ");

			logger.info("Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);
		
		resp.then().assertThat().statusCode(200);
		test.log(LogStatus.INFO, "Response generated");
		logger.info("Response generated");
		logger.info("Response:"+resp.prettyPrint());
		CommonUtils.updateRevisionforupdate();
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean updateputList() {
		req = "updateputList";
		try {
			test = reports.startTest("updateputList");
			test.log(LogStatus.INFO, "Creating Request ");
			logger.info("Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);

		logger.info("Response generated");
		test.log(LogStatus.INFO, "Response generated");
		resp.then().assertThat().statusCode(200);
		logger.info("Response:"+resp.prettyPrint());
		CommonUtils.updateRevisionforupdate();
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean gettasks() {
		req = "gettasks";
		try {
			test = reports.startTest("gettasks");
			test.log(LogStatus.INFO, "Creating Request ");
			logger.info("Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);

		logger.info("Response generated");
		test.log(LogStatus.INFO, "Response generated");
		resp.then().assertThat().statusCode(200);
		logger.info("Response:"+resp.prettyPrint());
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean createtasks() {
		req = "createtasks";
		try {
			test = reports.startTest("createtasks");
			test.log(LogStatus.INFO, "Creating Request ");
			logger.info("Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);

		logger.info("Response generated");
		test.log(LogStatus.INFO, "Response generated");
		resp.then().assertThat().statusCode(201);
		logger.info("Response:"+resp.prettyPrint());
		CommonUtils.updatetaskID(resp.jsonPath().get("id"));
		CommonUtils.updateRevisionfortask(resp.jsonPath().get("revision"));
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean updatepatchtasks() {
		req = "updatepatchtasks";
		try {
			test = reports.startTest("updatepatchtasks");
			test.log(LogStatus.INFO, "Creating Request ");

			logger.info("Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);

		logger.info("Response generated");
		test.log(LogStatus.INFO, "Response generated");
		resp.then().assertThat().statusCode(200);
		logger.info("Response:"+resp.prettyPrint());
		CommonUtils.updatetaskRevision();
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateputtasks() {
		req = "updateputtasks";
		try {
			test = reports.startTest("updateputtasks");
			test.log(LogStatus.INFO, "Creating Request ");
			logger.info("Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);

		logger.info("Response generated");
		test.log(LogStatus.INFO, "Response generated");
		resp.then().assertThat().statusCode(200);
		logger.info("Response:"+resp.prettyPrint());
		CommonUtils.updatetaskRevision();
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());

			e.printStackTrace();
			return false;
		}
	}
	public boolean deletetasks() {
		req = "deletetasks";
		try {
			test = reports.startTest("deletetasks");
			test.log(LogStatus.INFO, "Creating Request ");
			logger.info("Creating Request ");
		createrequest(req);
		Response resp = createresponse(req);

		logger.info("Response generated");
		test.log(LogStatus.INFO, "Response generated");
		resp.then().assertThat().statusCode(204);
		logger.info("Response:"+resp.prettyPrint());
		test.log(LogStatus.PASS, "Passed");
		reports.flush();
		return true;
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed");
			System.out.println(e.getMessage());

			e.printStackTrace();
			return false;
		}
	}

}
