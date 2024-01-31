package com.qaalpha.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.qaalpha.base.BaseTest;
import com.qaalpha.page.HomePage;
import com.qaalpha.page.LogInPage;

public class QA_003_LogIn_ChangeLanguage_Test extends BaseTest {

	public QA_003_LogIn_ChangeLanguage_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void qa_003_logIn_change_language_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("alan");
		HomePage homePage = new HomePage (driver);
		homePage.changeLanguageToEN();
		homePage.verifyHomePage();
		homePage.changeLanguages();

	
		
	}

}