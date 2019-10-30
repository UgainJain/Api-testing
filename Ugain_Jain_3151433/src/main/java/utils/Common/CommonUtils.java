package utils.Common;

import java.util.HashMap;

import io.restassured.specification.RequestSpecification;
import utils.dataSource.LoadProperty;

public class CommonUtils {
	public static RequestSpecification addHeader(RequestSpecification httpReq) {
		System.out.println("qety");
		httpReq.headers(CreateHeaderMap());
		System.out.println(httpReq);
		httpReq.log().all();
		return httpReq;
	}
	public static HashMap<String, String> CreateHeaderMap() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", LoadProperty.getvar("Content-Type", "config"));
		headers.put("X-Client-ID", LoadProperty.getvar("ClientID", "config"));
		headers.put("X-Access-Token",LoadProperty.getvar("Access-token", "config"));
		return headers;
	}
	public static RequestSpecification addqueryParam(String key,String value,RequestSpecification httpReq) {
		httpReq.queryParam(key, value);
		return httpReq;
	}
	public static RequestSpecification addPathVariable(String key,String value,RequestSpecification httpReq) {
		httpReq.pathParam(key, value);
		return httpReq;
	}

}
  