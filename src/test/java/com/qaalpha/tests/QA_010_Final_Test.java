package com.qaalpha.tests;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.qaalpha.base.BaseTest;
import com.qaalpha.new_pages.LPHomePage;
import com.qaalpha.new_pages.LPLeadsPage;
import com.qaalpha.new_pages.LPLogInPage;
import com.qaalpha.new_pages.TMHomePage;
import com.qaalpha.new_pages.TMLogInPage;
import com.qaalpha.new_pages.TMTerminPoolPage;

public class QA_010_Final_Test extends BaseTest {

	public QA_010_Final_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test
	public void qa_010_final_test1() throws Exception {
		LPLogInPage logInLP = new LPLogInPage(driver);
		logInLP.verifyLogInPage("lp");
		logInLP.logInValidations("", "");
		logInLP.verifyLogInPage("lp");
		logInLP.logInValidations("sir", "");
		logInLP.clearUsernameWE();
		logInLP.verifyLogInPage("lp");
		logInLP.logInValidations("", "Pa$$w0rd12");
		logInLP.clearPasswordWE();
		logInLP.verifyLogInPage("lp");
		logInLP.logIn("sir");
		LPHomePage homePage = new LPHomePage(driver);
		homePage.verifyLPHomePage();
		homePage.navigateOnLeads();
		LPLeadsPage leadsPage = new LPLeadsPage(driver);
		leadsPage.verifyLeadsPage();
		leadsPage.verifyValidationMessages();
		leadsPage.refreshLeadsPage();
		String data[] = leadsPage.createNewLead();
		leadsPage.verifyLead(data[0], data[1], data[2], true);
		leadsPage.editLead(data[0], data[1], data[2], true);
		leadsPage.verifyEditedLead(data[0], data[1], data[2], true);
		TMLogInPage logInTM = new TMLogInPage(driver);
		logInTM.verifyLogInPage("tm");
		logInTM.logIn("sir");
		TMHomePage homePageTM = new TMHomePage(driver);
		homePageTM.changeLanguageToEN();
		homePageTM.verifyTMHomePage();
		homePageTM.navigateOnTerminPool();
		TMTerminPoolPage leadsPageTM = new TMTerminPoolPage(driver);
		leadsPageTM.verifyLead(data[0]);
		leadsPageTM.leaveNegativeFeedback(data[0]);
		logInLP = new LPLogInPage(driver);
		homePage.verifyLPHomePage();
		homePage.navigateOnLeads();
		leadsPage.verifyLeadsPage();
		leadsPage.verifyNegativeTermin(data[0], data[1], data[2], true);
		leadsPage.verifyStatus(data[0], data[1], data[2], true);
	}

}