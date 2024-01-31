package com.qaalpha.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.qaalpha.base.BaseTest;
import com.qaalpha.page.ClientsPage;
import com.qaalpha.page.HomePage;
import com.qaalpha.page.LogInPage;

public class QA_006_Edit_Client_Test extends BaseTest {
	public QA_006_Edit_Client_Test() throws IOException, FileNotFoundException {
		super();
	}
	
	@Test(priority = 2)
	public void qa_006_edit_client_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("bob");
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.navigateOnClients();
		ClientsPage clientsPage = new ClientsPage(driver);
		clientsPage.verifyClientsPage();
		String name = clientsPage.createClient();
		clientsPage.verifyClient(name);
		String updatedName = clientsPage.editClient();
		clientsPage.verifyClient(updatedName);
	}
	
}
