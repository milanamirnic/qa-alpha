package com.qaalpha.tests.api;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.qaalpha.base.RestApiBase;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class QA_002_Get_Single_Crocodile_Tests extends RestApiBase {

	@Test (description = "Positive test case")
	public void get_single_crocodile_test1() {
		Response response = methodGET("https://test-api.k6.io/public/crocodiles/6/");
		assertEquals(response.getStatusCode(), 200);
		JsonPath jp = new JsonPath(response.asString());
		assertEquals(jp.getString("id"), "6");
		assertEquals(jp.getString("name"), "Sang Buaya");
		assertEquals(jp.getString("sex"), "F");
		assertEquals(jp.getString("date_of_birth"), "2006-01-28");
		assertEquals(jp.getString("age"), "17");
	}
	
	@Test (description = "Negative test case: No matching ID")
	public void get_single_crocodile_test2() {
		Response response = methodGET("https://test-api.k6.io/public/crocodiles/11/");
		assertEquals(response.getStatusCode(), 404);
		JsonPath jp = new JsonPath(response.asString());
		assertEquals(jp.getString("detail"), "Not found.");
	}
}
