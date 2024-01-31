package com.qaalpha.base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class RestApiBase {
	
	// method used for GET endpoints
	public Response methodGET(String endpoint) {
		return given().log().all().when().get(endpoint);
	}
	
	// method used for POST endpoints
	public Response methodPOST(String endpoint, String payload) {
		return given().log().all().contentType("application/json").body(payload).when().post(endpoint);
	}
}
