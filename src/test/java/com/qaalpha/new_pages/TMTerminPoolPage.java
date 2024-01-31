package com.qaalpha.new_pages;

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

public class TMTerminPoolPage extends PageBase {

	public TMTerminPoolPage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
	}
	

	@FindBy(xpath = "//tr[1]/td[6]")
	private WebElement firstNameTableWE;
	
	@FindBy(xpath = "//tr[1]/td[47]/a[1]")
	private WebElement viewBtnWE;
	
	@FindBy(xpath = "//div[1]/div[2]/div[1]/div/div/button")
	private WebElement actionsBtnWE;
	
	@FindBy(xpath = "//div[2]/div[1]/div/div/ul/li[7]")
	private WebElement leaveFeedbackWE;
	
	@FindBy(xpath = "//form/div/div[1]/div/div/div/select")
	private WebElement selectFeedbackWE;
	
	@FindBy(xpath = "//form/div/div[1]/div/div/div/select/option[2]")
	private WebElement negativeFeedbackWE;
	
	@FindBy(xpath = "//div[2]/div[1]/div/select")
	private WebElement reasonWE;
	
	@FindBy(xpath = "//div[2]/div[1]/div/select/option[8]")
	private WebElement canceledWE;
	
	@FindBy(xpath = "//div[5]/div/input")
	private WebElement noteWE;
	
	@FindBy(xpath = "//form/div/div[4]/div/input")
	private WebElement saveChangesBtnWE;
	
	@FindBy(xpath = "//div[3]/div/input")
	private WebElement closeBtnWE;

	public void verifyLead(String name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(firstNameTableWE));
		Thread.sleep(3000);
		assertTrue(firstNameTableWE.getText().equals(name), "Client not found!");
	}
	
	public void leaveNegativeFeedback(String name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(viewBtnWE));
		viewBtnWE.click();
		actionsBtnWE.click();
		leaveFeedbackWE.click();
		selectFeedbackWE.click();
		negativeFeedbackWE.click();
		reasonWE.click();
		canceledWE.click();
		noteWE.sendKeys("Note " + HelperUtil.getRandomString(7));
		saveChangesBtnWE.click();
		Thread.sleep(3000);
		closeBtnWE.click();
	}

}
