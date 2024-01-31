package com.qaalpha.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.qaalpha.base.BaseTest;
import com.qaalpha.page.HomePage;
import com.qaalpha.page.LogInPage;

public class QA_001_LogIn_Test extends BaseTest {

	public QA_001_LogIn_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void qa_001_logIn_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("bob");
		HomePage homePage = new HomePage (driver);
		homePage.verifyHomePage();
	}

}