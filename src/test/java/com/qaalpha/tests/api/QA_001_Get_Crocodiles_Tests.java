package com.qaalpha.tests.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QA_001_Get_Crocodiles_Tests {

	@Test
	public static void get_crocodiles_test() {
		given().when().get("https://test-api.k6.io/public/crocodiles/").then().log().all().statusCode(200);
		
		//log().all() vraca sve krokodile, kad se izbrise, ne vraca te podatke
	}

	@Test
	public static void get_single_crocodile_test() {
		given().when().get("https://test-api.k6.io/public/crocodiles/3/").then().log().all().statusCode(200);
	}
}
