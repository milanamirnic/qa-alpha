package com.qaalpha.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.qaalpha.base.BaseTest;
import com.qaalpha.page.ClientsPage;
import com.qaalpha.page.HomePage;
import com.qaalpha.page.LogInPage;

public class QA_007_Client_E2E_Test extends BaseTest {
	public QA_007_Client_E2E_Test() throws IOException, FileNotFoundException {
		super();
	}
	
	@Test(priority = 1)
	public void qa_007_client_e2e_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		// login with user Alan
		logIn.logIn("alan");
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.navigateOnClients();
		ClientsPage clientsPage = new ClientsPage(driver);
		clientsPage.verifyClientsPage();
		// create client with user Bob
		String name = clientsPage.createClient();
		clientsPage.verifyClient(name);
		clientsPage.logOff();
		logIn.verifyLogInPage();
		// login with user Bob
		logIn.logIn("bob");
		homePage.verifyHomePage();
		homePage.navigateOnClients();
		clientsPage.verifyClientsPage();
		// verify client Alan created
		clientsPage.verifyClient(name);
		// edit client
		String updatedName = clientsPage.editClient();
		clientsPage.verifyClient(updatedName);
		clientsPage.logOff();
		logIn.verifyLogInPage();
		// login with user Alan
		logIn.logIn("alan");
		homePage.verifyHomePage();
		homePage.navigateOnClients();
		// verify changes Bob did
		clientsPage.verifyClient(updatedName);
	}
}
