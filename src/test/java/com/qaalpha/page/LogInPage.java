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

public class LogInPage extends PageBase {

	public LogInPage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
		driver.get(qaalpha_properties.getValue("URL"));
	}

	@FindBy(xpath = "//h3") // Page Object Modeling
	private WebElement welcomeMessageWE;

	@FindBy(xpath = "//h4")
	private WebElement logInMessageWE;

	@FindBy(id = "UserName") // id locator
	private WebElement usernameWE;

	@FindBy(name = "Password") // name locator
	private WebElement passwordWE;

	@FindBy(xpath = "//div[4]/input")
	private WebElement logInWE;

	@FindBy(xpath = "//*[contains(text(),'The User Name field is required.')]") // custom xpath by text
	private WebElement validationUsernameMessageWE;

	@FindBy(xpath = "//*[contains(text(),'The Password field is required.')]")
	private WebElement validationPasswordMessageWE;

	public void verifyLogInPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10); // Creating object "wait" with 10s time-out
		wait.until(ExpectedConditions.elementToBeClickable(usernameWE));
		wait.until(ExpectedConditions.elementToBeClickable(passwordWE));
		wait.until(ExpectedConditions.elementToBeClickable(logInWE));
		assertTrue(welcomeMessageWE.getText().equals("Welcome to BrokerSoft"), "Message is not good!"); // assert from
		// TestNG
		assertTrue(logInMessageWE.getText().equals("Use a local account to log in."), "Message is not good!");
	}

	public void logInValidations(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(usernameWE));
		wait.until(ExpectedConditions.elementToBeClickable(passwordWE));
		wait.until(ExpectedConditions.elementToBeClickable(logInWE));
		usernameWE.sendKeys(username);
		passwordWE.sendKeys(password);
		logInWE.click();
		if (username == "") {
			wait.until(ExpectedConditions.visibilityOf(validationUsernameMessageWE));
		}
		if (password == "") {
			wait.until(ExpectedConditions.visibilityOf(validationPasswordMessageWE));
		}
	}
}