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

public class ClientsPage extends PageBase {

	public ClientsPage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
	}

	@FindBy(xpath = "//a[@href=\"/Client/Client/Action/Create\"]")	// custom xpath by link
	private WebElement createClientBtnWE;
	
	@FindBy(xpath = "//td[2]")
	private WebElement firstNameTableWE;
	
	@FindBy(xpath = "//td[8]/a[2]")
	private WebElement editBtnWE;


	// Create Client form

	@FindBy(xpath = "//form/div/div[1]/div[1]/div[1]/div/input")
	private WebElement firstNameBtnWE;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/div/input")
	private WebElement lastNameBtnWE;

	@FindBy(xpath = "//div[2]/div[1]/div/input")
	private WebElement phoneBtnWE;

	@FindBy(xpath = "//div[2]/div[2]/div/input")
	private WebElement streetBtnWE;

	@FindBy(xpath = "//form/div/div[1]/div[2]/div[3]/div/div")
	private WebElement townBtnWE;

	@FindBy(xpath = "//div[3]/div/div/div/ul/li[3]")
	private WebElement chooseTownBtnWE;

	@FindBy(xpath = "//div[3]/div/input")
	private WebElement saveBtnWE;
	
	// Edit client form
	
	@FindBy(xpath = "//div[3]/div/input")
	private WebElement saveChangesBtnWE;
	
	// Verify ValidationMessage
	
	@FindBy(xpath = "//*[contains(text(),'First name must contain between 2 and 50 characters.')]") // custom xpath by text
	private WebElement validationFirstNameMessageWE;
	
	@FindBy(xpath = "//*[contains(text(),'Last name must contain between 2 and 50 characters.')]") // custom xpath by text
	private WebElement validationLastNameMessageWE;
	
	@FindBy(xpath = "//*[contains(text(),'Field should not be empty.')]") // custom xpath by text
	private WebElement validationStreetNameMessageWE;
	
	@FindBy(xpath = "//*[contains(text(),'A value is required.')]") // custom xpath by text
	private WebElement validationTownNameMessageWE;

	public void verifyClientsPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createClientBtnWE));
		assertTrue(pageTitleWE.getText().equals("Clients"), "Title is not good!");
	}

	public String createClient() throws InterruptedException {
		String name = ("Name " + HelperUtil.getRandomString(7));
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createClientBtnWE));
		createClientBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(firstNameBtnWE));
		firstNameBtnWE.sendKeys(name);
		lastNameBtnWE.sendKeys("LastName " + HelperUtil.getRandomString(7));
		phoneBtnWE.sendKeys("+41" + HelperUtil.getRandomNumbers(9));
		streetBtnWE.sendKeys("Street " + HelperUtil.getRandomString(7));
		townBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(chooseTownBtnWE));
		chooseTownBtnWE.click();
		saveBtnWE.click();
		return name;
	}

	public void verifyClient(String name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(searchWE));
		searchWE.clear();
		searchWE.sendKeys(name);
		Thread.sleep(3000);
		assertTrue(firstNameTableWE.getText().equals(name), "Client not found!");
	}
	
	public void createClientWithData(String name, String lastName, String street) throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createClientBtnWE));
		createClientBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(firstNameBtnWE));
		firstNameBtnWE.sendKeys(name);
		lastNameBtnWE.sendKeys("LastName " + HelperUtil.getRandomString(7));
		phoneBtnWE.sendKeys("+41" + HelperUtil.getRandomNumbers(9));
		streetBtnWE.sendKeys("Street " + HelperUtil.getRandomString(7));
		townBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(chooseTownBtnWE));
		chooseTownBtnWE.click();
		saveBtnWE.click();
	}

	public String editClient() {
		String name = "Name " + HelperUtil.getRandomString(7);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(editBtnWE));
		editBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(firstNameBtnWE));
		firstNameBtnWE.clear();
		firstNameBtnWE.sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(saveChangesBtnWE));
		saveChangesBtnWE.click();
		return name;
	}
	
	public void verifyValidationMessages() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(createClientBtnWE));
		createClientBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(saveBtnWE));
		saveBtnWE.click();
		wait.until(ExpectedConditions.visibilityOf(validationFirstNameMessageWE));
		wait.until(ExpectedConditions.visibilityOf(validationLastNameMessageWE));
		wait.until(ExpectedConditions.visibilityOf(validationStreetNameMessageWE));
		wait.until(ExpectedConditions.visibilityOf(validationTownNameMessageWE));
	}
	
}
