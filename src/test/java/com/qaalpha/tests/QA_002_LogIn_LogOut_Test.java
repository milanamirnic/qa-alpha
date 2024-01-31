package com.qaalpha.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.qaalpha.base.BaseTest;
import com.qaalpha.page.HomePage;
import com.qaalpha.page.LogInPage;

public class QA_002_LogIn_LogOut_Test extends BaseTest {

	public QA_002_LogIn_LogOut_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void qa_002_logInLogOut_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("alan");
		HomePage homePage = new HomePage (driver);
		homePage.verifyHomePage();
		homePage.logOff();
		logIn.verifyLogInPage();

	
		
	}

}