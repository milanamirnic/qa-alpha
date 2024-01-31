package com.qaalpha.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.qaalpha.base.BaseTest;
import com.qaalpha.page.ClientsPage;
import com.qaalpha.page.HomePage;
import com.qaalpha.page.LogInPage;

public class QA_005_CreateClient_Test extends BaseTest {

	public QA_005_CreateClient_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test(priority = 2)
	public void qa_005_create_client_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("bob");
		HomePage homePage = new HomePage (driver);
		homePage.verifyHomePage();
		homePage.navigateOnClients();
		ClientsPage clientsPage = new ClientsPage(driver);
		clientsPage.verifyClientsPage();
		String name = clientsPage.createClient();
		clientsPage.verifyClient(name);
	}
	
	@Test(priority = 1)
	public void qa_005_create_client_with_data_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("bob");
		HomePage homePage = new HomePage (driver);
		homePage.verifyHomePage();
		homePage.navigateOnClients();
		ClientsPage clientsPage = new ClientsPage(driver);
		clientsPage.verifyClientsPage();
		clientsPage.createClientWithData("Test1","Test2","Test3");
		clientsPage.verifyClient("Test1");
	}
	
	@Test(priority = 3)
	public void qa_005_create_multiple_clients_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("bob");
		HomePage homePage = new HomePage (driver);
		homePage.verifyHomePage();
		homePage.navigateOnClients();
		ClientsPage clientsPage = new ClientsPage(driver);
		clientsPage.verifyClientsPage();
		for (int i=1; i<4; i++) {
		String name = clientsPage.createClient();
		clientsPage.verifyClient(name);
		}
	}
	
	@Test(priority = 2)
	public void qa_005_create_clients_validation_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("bob");
		HomePage homePage = new HomePage (driver);
		homePage.verifyHomePage();
		homePage.navigateOnClients();
		ClientsPage clientsPage = new ClientsPage(driver);
		clientsPage.verifyClientsPage();
		clientsPage.verifyValidationMessages();
	}
	
}