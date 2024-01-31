package com.qaalpha.tests.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qaalpha.base.Payloads;
import com.qaalpha.base.RestApiBase;
import com.qaalpha.util.HelperUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;

import static io.restassured.RestAssured.*;

public class QA_003_Create_User_Tests extends RestApiBase {

	@Test(description = "Positive test case")
	public void post_create_user_test1() {
		String username = HelperUtil.getRandomString(6);
		String firstName = "FirstName " + HelperUtil.getRandomString(6);
		String lastName = "LastName " + HelperUtil.getRandomString(6);
		String email = HelperUtil.getRandomEmail();
		String password = HelperUtil.getRandomString(8);

		Response response = methodPOST("https://test-api.k6.io/user/register/",
				Payloads.createUser(username, firstName, lastName, email, password));
		assertEquals(response.getStatusCode(), 201);
		JsonPath jp = new JsonPath(response.asString());
		assertEquals(jp.getString("username"), username);
		assertEquals(jp.getString("first_name"), firstName);
		assertEquals(jp.getString("last_name"), lastName);
		assertEquals(jp.getString("email"), email);
	}

	@Test(description = "Negative test case: Wrong email format")
	public void post_create_user_test2() {
		String username = HelperUtil.getRandomString(6);
		String firstName = "FirstName " + HelperUtil.getRandomString(6);
		String lastName = "LastName " + HelperUtil.getRandomString(6);
		String password = HelperUtil.getRandomString(8);

		Response response = methodPOST("https://test-api.k6.io/user/register/",
				Payloads.createUser(username, firstName, lastName, HelperUtil.getRandomString(6), password));
		assertEquals(response.getStatusCode(), 400);
		JsonPath jp = new JsonPath(response.asString());
		assertTrue(jp.getString("email").contains("Enter a valid email address."));
	}

	@Test(description = "Negative test case: Username missing")
	public void post_create_user_test3() {
		String firstName = "FirstName " + HelperUtil.getRandomString(6);
		String lastName = "LastName " + HelperUtil.getRandomString(6);
		String email = HelperUtil.getRandomEmail();
		String password = HelperUtil.getRandomString(8);

		Response response = methodPOST("https://test-api.k6.io/user/register/",
				Payloads.createUser("", firstName, lastName, HelperUtil.getRandomString(6), password));
		assertEquals(response.getStatusCode(), 400);
		JsonPath jp = new JsonPath(response.asString());
		assertTrue(jp.getString("username").contains("This field may not be blank."));
	}

	@Test(description = "Negative test case: Password missing")
	public void post_create_user_test4() {
		String username = HelperUtil.getRandomString(6);
		String firstName = "FirstName " + HelperUtil.getRandomString(6);
		String lastName = "LastName " + HelperUtil.getRandomString(6);
		String email = HelperUtil.getRandomEmail();

		Response response = methodPOST("https://test-api.k6.io/user/register/",
				Payloads.createUser(username, firstName, lastName, HelperUtil.getRandomString(6), ""));
		assertEquals(response.getStatusCode(), 400);
		JsonPath jp = new JsonPath(response.asString());
		assertTrue(jp.getString("password").contains("This field may not be blank."));
	}

	@Test (description = "Negative test case: Duplicate validation")
	public void post_create_user_test5() {
		// generate random data
		String username =  HelperUtil.getRandomString(6);
		String firstName =  "FirstName " + HelperUtil.getRandomString(6);
		String lastName =  "LastName " + HelperUtil.getRandomString(6);
		String email = HelperUtil.getRandomEmail();
		String password =  HelperUtil.getRandomString(8);
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
		// try to create user with same data
		Response response2 = methodPOST("https://test-api.k6.io/user/register/",
				Payloads.createUser(username, firstName, lastName, email, password));
		assertEquals(response2.getStatusCode(), 400);
		JsonPath jp2 = new JsonPath(response2.asString());
		assertTrue(jp2.getString("username").contains("A user with that username already exists."));
		assertTrue(jp2.getString("email").contains("User with this email already exists!"));
		}
}
