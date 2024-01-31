package com.qaalpha.new_pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qaalpha.base.PageBase;

public class LPLogInPage extends PageBase {

	public LPLogInPage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
		driver.get(qaalpha_properties.getValue("URL_LP"));
	}

	@FindBy(id = "UserName") // id locator
	private WebElement usernameWE;

	@FindBy(name = "Password") // name locator
	private WebElement passwordWE;

	public void clearUsernameWE() {
		WebDriverWait wait = new WebDriverWait(driver, 10); // Creating object "wait" with 10s time-out
		wait.until(ExpectedConditions.elementToBeClickable(usernameWE));
		usernameWE.clear();
	}

	public void clearPasswordWE() {
		WebDriverWait wait = new WebDriverWait(driver, 10); // Creating object "wait" with 10s time-out
		wait.until(ExpectedConditions.elementToBeClickable(passwordWE));
		passwordWE.clear();
	}
}