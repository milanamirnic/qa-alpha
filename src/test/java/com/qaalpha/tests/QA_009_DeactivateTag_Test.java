package com.qaalpha.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.qaalpha.base.BaseTest;
import com.qaalpha.page.HomePage;
import com.qaalpha.page.LogInPage;
import com.qaalpha.page.TagsPage;

public class QA_009_DeactivateTag_Test extends BaseTest {

	public QA_009_DeactivateTag_Test() throws IOException, FileNotFoundException {
		super();
	}

	@Test(priority = 1)
	public void qa_009_deactivate_tag_test() throws Exception {
		LogInPage logIn = new LogInPage(driver);
		logIn.verifyLogInPage();
		logIn.logIn("bob");
		HomePage homePage = new HomePage (driver);
		homePage.verifyHomePage();
		homePage.navigateOnTags();
		TagsPage tagsPage = new TagsPage(driver);
		tagsPage.verifyTagsPage();
		String data[] = tagsPage.createTag();
		tagsPage.verifyTag(data [0], data [1], true);
		tagsPage.deactivateTag();
		tagsPage.verifyTag(data [0], data [1], false);
	}
	
}