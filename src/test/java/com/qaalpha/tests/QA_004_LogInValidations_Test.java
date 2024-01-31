package com.qaalpha.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.qaalpha.base.BaseTest;
import com.qaalpha.page.HomePage;
import com.qaalpha.page.LogInPage;

public class QA_004_LogInValidations_Test extends BaseTest {

	public QA_004_LogInValidations_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test(description = "validating both message only")
	public void qa_004_logInValidations_test1() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logInValidations("", "");
	}

	@Test(description = "validating password message only")
	public void qa_004_logInValidations_test2() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logInValidations("alan", "");
	}

	@Test(description = "validating username message only")
	public void qqa_004_logInValidations_test3() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logInValidations("", "Pa$$w0rd");
	}
}