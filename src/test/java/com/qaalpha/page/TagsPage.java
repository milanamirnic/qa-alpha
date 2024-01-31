package com.qaalpha.page;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qaalpha.base.PageBase;
import com.qaalpha.util.HelperUtil;

public class TagsPage extends PageBase {

	public TagsPage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
	}

	@FindBy(xpath = "//a[@href=\"/Tag/Tag/Action/Create\"]")	// custom xpath by link
	private WebElement createTagBtnWE;
	
	// create tag name
	
	@FindBy(xpath = "//tr/td[2]")
	private WebElement nameTableWE;
	
	@FindBy(xpath = "//tr/td[3]")
	private WebElement noteTableWE;
	
	@FindBy(xpath = "//tr/td[4]")
	private WebElement isActiveTableWE;
	
	@FindBy(xpath = "//tr/td[5]/a")
	private WebElement deactivateBtnWE;
	
	// Create tag form

	@FindBy(id = "Name")
	private WebElement nameWE;
	
	@FindBy(id = "Note")
	private WebElement noteWE;
	
	@FindBy(xpath = "//div[2]/input")
	private WebElement saveBtnWE;
	

	public void verifyTagsPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createTagBtnWE));
		wait.until(ExpectedConditions.elementToBeClickable(searchWE));
		assertTrue(pageTitleWE.getText().equals("Tags"), "Title is not good!");
	}

	public String[] createTag() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String[] data = new String [2];
		Thread.sleep(2000);
		data [0] = "Tag " + HelperUtil.getRandomString(7);
		data [1] = "Note " + HelperUtil.getRandomString(7);
		wait.until(ExpectedConditions.elementToBeClickable(createTagBtnWE));
		createTagBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(nameWE));
		nameWE.sendKeys(data [0]);
		noteWE.sendKeys(data [1]);
		wait.until(ExpectedConditions.elementToBeClickable(saveBtnWE));
		saveBtnWE.click();
		return data;
	}

	public void verifyTag(String name, String note, boolean tag) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(searchWE));
		searchWE.clear();
		searchWE.sendKeys(name);
		Thread.sleep(3000);
		assertTrue(nameTableWE.getText().equals(name), "Tag name not found!");
		assertTrue(noteTableWE.getText().equals(note), "Tag note not found!");
		if (tag == true) {
			assertTrue(isActiveTableWE.getText().equals("Yes"), "Tag status is not correct!");
		} else {
			assertTrue(isActiveTableWE.getText().equals("No"), "Tag status is not correct!");
		}
	}
	
	public void deactivateTag(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(deactivateBtnWE));
		deactivateBtnWE.click();

	}
	
}
