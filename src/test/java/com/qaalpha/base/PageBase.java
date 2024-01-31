package com.qaalpha.base;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qaalpha.util.PropertiesUtil;

public class PageBase {

	protected WebDriver driver;
	protected PropertiesUtil properties;
	protected PropertiesUtil qaalpha_properties = null;
	protected final String QAALPHA_PROPERTIES = "qaalpha.properties";

	public PageBase(WebDriver driver) throws FileNotFoundException, IOException {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		qaalpha_properties = new PropertiesUtil(QAALPHA_PROPERTIES);
	}

	// Common elements on multiple pages

	@FindBy(xpath = "//h3") // Page Object Modeling
	protected WebElement welcomeMessageWE;

	@FindBy(xpath = "//h4")
	protected WebElement logInMessageWE;

	@FindBy(id = "UserName") // id locator
	protected WebElement usernameWE;

	@FindBy(name = "Password") // name locator
	protected WebElement passwordWE;

	@FindBy(xpath = "//div[4]/input")
	protected WebElement logInWE;

	@FindBy(xpath = "//h2")
	protected WebElement pageTitleWE; // "protected" so child classes can access to

	@FindBy(xpath = "//label/input")
	protected WebElement searchWE;

	@FindBy(xpath = "//li[4]/a")
	private WebElement myCompanyWE;

	@FindBy(xpath = "//li[4]/ul/li/a")
	private WebElement clientsWE;

	@FindBy(xpath = "//a[@href=\"javascript:document.getElementById('logoutForm').submit()\"]")
	protected WebElement logOffBtnWE;

	@FindBy(xpath = "//div/ul/li[7]/a")
	private WebElement companySettingsWE;

	@FindBy(xpath = "//li[7]/ul/li/a")
	private WebElement tagsWE;

	@FindBy(xpath = "//li[5]/a")
	private WebElement leadManagementWE;

	@FindBy(xpath = "//li[5]/ul/li/a")
	private WebElement leadsWE;

	@FindBy(xpath = "//li[4]/a")
	private WebElement terminDistributionWE;

	@FindBy(xpath = "//a[@href=\"/Termin/Termin/Pool\"]") // custom xpath by link
	private WebElement terminPoolWE;

	@FindBy(xpath = "//*[contains(text(),'The User Name field is required.')]") // custom xpath by text
	private WebElement validationUsernameMessageWE;

	@FindBy(xpath = "//*[contains(text(),'The Password field is required.')]")
	private WebElement validationPasswordMessageWE;
	
	public void verifyLogInPage(String app) {
		WebDriverWait wait = new WebDriverWait(driver, 10); // Creating object "wait" with 10s time-out
		wait.until(ExpectedConditions.elementToBeClickable(usernameWE));
		wait.until(ExpectedConditions.elementToBeClickable(passwordWE));
		wait.until(ExpectedConditions.elementToBeClickable(logInWE));
		if (app=="bs") {
		assertTrue(welcomeMessageWE.getText().equals("Welcome to BrokerSoft"), "Message is not good!");
		}
		else if (app=="lp") {
			assertTrue(welcomeMessageWE.getText().equals("Welcome to Lead Platform"), "Message is not good!");
			}
		else if (app=="tm") {
			assertTrue(welcomeMessageWE.getText().equals("Welcome to Termin Manager"), "Message is not good!");
			}
		assertTrue(logInMessageWE.getText().equals("Use a local account to log in."), "Message is not good!");
	}

	public void logIn(String name) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(usernameWE));
		wait.until(ExpectedConditions.elementToBeClickable(passwordWE));
		wait.until(ExpectedConditions.elementToBeClickable(logInWE));
		if (name == "alan") {
			usernameWE.sendKeys(qaalpha_properties.getValue("USERNAME1")); // Selenium
			passwordWE.sendKeys(qaalpha_properties.getValue("PASSWORD1"));
		} else if (name == "bob") {
			usernameWE.sendKeys(qaalpha_properties.getValue("USERNAME2")); // Selenium
			passwordWE.sendKeys(qaalpha_properties.getValue("PASSWORD2"));
		} else if (name == "sir") {
			usernameWE.sendKeys(qaalpha_properties.getValue("USERNAME_LP")); // Selenium
			passwordWE.sendKeys(qaalpha_properties.getValue("PASSWORD_LP"));
		}
		logInWE.click();
	}

	public void logOff() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logOffBtnWE));
		logOffBtnWE.click();
	}

	public void navigateOnClients() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(myCompanyWE));
		myCompanyWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(clientsWE));
		clientsWE.click();
	}

	public void navigateOnTags() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(companySettingsWE));
		companySettingsWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(tagsWE));
		tagsWE.click();
	}

	public void navigateOnLeads() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(leadManagementWE));
		leadManagementWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(leadsWE));
		leadsWE.click();
	}

	public void navigateOnTerminPool() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(terminDistributionWE));
		terminDistributionWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(terminPoolWE));
		terminPoolWE.click();
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