package com.qaalpha.tests.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qaalpha.base.Payloads;
import com.qaalpha.base.RestApiBase;
import com.qaalpha.util.HelperUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class QA_004_Log_In_Tests extends RestApiBase {

	@Test(description = "Positive test case: create user and login")
	public void Log_in_test1() {
		// generate random data
		String username = HelperUtil.getRandomString(6);
		String firstName = "FirstName " + HelperUtil.getRandomString(6);
		String lastName = "LastName " + HelperUtil.getRandomString(6);
		String email = HelperUtil.getRandomEmail();
		String password = HelperUtil.getRandomString(8);
		// run post endpoint
		Response response1 = methodPOST("https://test-api.k6.io/user/register/",
				Payloads.createUser(username, firstName, lastName, email, password));
		// assert response
		assertEquals(response1.getStatusCode(), 201);
		JsonPath jp1 = new JsonPath(response1.asString());
		assertEquals(jp1.getString("username"), username);
		assertEquals(jp1.getString("first_name"), firstName);
		assertEquals(jp1.getString("last_name"), lastName);
		assertEquals(jp1.getString("email"), email);
		// log in
		Response response2 = methodPOST("https://test-api.k6.io/auth/token/login/",
				Payloads.logIn(username, password));
		assertEquals(response2.getStatusCode(), 200);
		JsonPath jp2 = new JsonPath(response2.asString());
		assertNotNull(jp2.get("refresh"), "Refresh not forwarded");
		assertNotNull(jp2.get("access"), "Access not forwarded");
	}
	
	@Test(description = "Positive test case: login with existing user")
	public void Log_in_test2() {
		// log in
		Response response = methodPOST("https://test-api.k6.io/auth/token/login/",
				Payloads.logIn("string", "string"));
		assertEquals(response.getStatusCode(), 200);
		JsonPath jp = new JsonPath(response.asString());
		assertNotNull(jp.get("refresh"), "Refresh not forwarded");
		assertNotNull(jp.get("access"), "Access not forwarded");
	}
	
	@Test (description = "Negative test case: wrong credentials")
	public void log_in_test3() {
		// log in
		String username = HelperUtil.getRandomString(6);
		String password = HelperUtil.getRandomString(6);
		Response response = methodPOST("https://test-api.k6.io/auth/token/login/", 
				Payloads.logIn(username, password));
		assertEquals(response.getStatusCode(), 401);
		JsonPath jp = new JsonPath(response.asString());
		assertEquals(jp.getString("detail"), "No active account found with the given credentials");
	}
	
	@Test (description = "Negative test case: username missing")
	public void log_in_test4() {
		// log in
		String password = HelperUtil.getRandomString(6);
		Response response = methodPOST("https://test-api.k6.io/auth/token/login/", 
				Payloads.logIn("", password));
		assertEquals(response.getStatusCode(), 400);
		JsonPath jp = new JsonPath(response.asString());
		assertTrue(jp.getString("username").contains("This field may not be blank."));
	}
	
	@Test (description = "Negative test case: password missing")
	public void log_in_test5() {
		// log in
		String email = HelperUtil.getRandomString(6);
		Response response = methodPOST("https://test-api.k6.io/auth/token/login/", 
				Payloads.logIn(email, ""));
		assertEquals(response.getStatusCode(), 400);
		JsonPath jp = new JsonPath(response.asString());
		assertTrue(jp.getString("password").contains("This field may not be blank."));
	}

}
