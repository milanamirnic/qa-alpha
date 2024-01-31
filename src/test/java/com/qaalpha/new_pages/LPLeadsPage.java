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

public class LPLeadsPage extends PageBase {

	public LPLeadsPage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
	}

	@FindBy(xpath = "//td[8]/a[2]")
	private WebElement editBtnWE;

	@FindBy(xpath = "//a[@href=\"/Leads/Action/Create\"]") // custom xpath by link
	private WebElement createNewLeadBtnWE;

	@FindBy(xpath = "//div[2]/div/div[1]/div[1]/button[1]")
	protected WebElement refreshBtnWE;

	@FindBy(xpath = "//tr[1]/td[3]")
	protected WebElement firstNameTableWE;

	@FindBy(xpath = "//tr[1]/td[4]")
	protected WebElement lastNameTableWE;

	@FindBy(xpath = "//tr[1]/td[6]")
	protected WebElement phoneTableWE;

	@FindBy(xpath = "//tr[1]/td[2]")
	private WebElement isNewTableWE;

	// Create Lead form

	@FindBy(xpath = "//div[2]/div[2]/div/div/div/div[2]/form/div/div[1]/div/input")
	private WebElement firstNameBtnWE;

	@FindBy(xpath = "//form/div/div[2]/div/input")
	private WebElement lastNameBtnWE;

	@FindBy(xpath = "//div/div[3]/div/div/div/input")
	private WebElement birthdayBtnWE;

	@FindBy(xpath = "//div[4]/div/input")
	private WebElement phoneBtnWE;

	@FindBy(xpath = "//div[5]/div/div/a/span")
	private WebElement townBtnWE;

	@FindBy(xpath = "//div[5]/div/div/div/ul/li[7]")
	private WebElement chooseTownBtnWE;

	@FindBy(xpath = "//div[8]/div/input")
	private WebElement emailBtnWE;

	@FindBy(xpath = "//div[1]/div[3]/label/div/ins")
	protected WebElement leadInterest1WE;

	@FindBy(xpath = "//div[2]/div[1]/label/div/ins")
	protected WebElement leadInterest2WE;

	@FindBy(xpath = "//div[16]/div/input")
	private WebElement createBtnWE;

	// Edit lead form

	@FindBy(xpath = "//div[3]/div/input")
	private WebElement saveChangesBtnWE;

	@FindBy(xpath = "//tr[1]/td[21]/a[4]")
	private WebElement addNewTerminBtnWE;

	@FindBy(xpath = "//form/div[1]/div[1]/div[1]/div[1]/div/div/a/span")
	private WebElement insuranceHouseWE;

	@FindBy(xpath = "//form/div[1]/div[1]/div[1]/div[1]/div/div/div/ul/li[7]")
	private WebElement chooseInsuranceHouseWE;

	@FindBy(xpath = "//div[5]/div/input")
	private WebElement terminAddressWE;

	@FindBy(xpath = "//div[7]/div/input")
	private WebElement noteToAgentWE;

	@FindBy(xpath = "//div[1]/div[4]/div/div/div/input")
	private WebElement timeWE;

	@FindBy(xpath = "//div[14]/div/div/ul/li/input")
	private WebElement insuranceTypeWE;

	@FindBy(xpath = "//div[14]/div/div/div/ul/li[1]")
	private WebElement chooseinsuranceType1WE;

	@FindBy(xpath = "//div[14]/div/div/div/ul/li[4]")
	private WebElement chooseinsuranceType2WE;

	@FindBy(xpath = "//div/input[2]")
	private WebElement saveBtnWE;

	@FindBy(xpath = "//div[6]/div/div/div[3]/input")
	private WebElement confirmBtnWE;

	// Verify ValidationMessage

	@FindBy(xpath = "//*[contains(text(),'First name must contain between 2 and 50 characters.')]") // custom xpath by
																									// text
	private WebElement validationFirstNameMessageWE;

	@FindBy(xpath = "//*[contains(text(),'Last name must contain between 2 and 50 characters.')]") // custom xpath by
																									// text
	private WebElement validationLastNameMessageWE;

	@FindBy(xpath = "//*[contains(text(),'Phone can not be empty.')]") // custom xpath by text
	private WebElement validationPhoneMessageWE;

	@FindBy(xpath = "//*[contains(text(),'Town cannot  be empty.')]") // custom xpath by text
	private WebElement validationTownNameMessageWE;
	
	@FindBy(xpath = "//div[16]/div/a")
	private WebElement cancelBtnWE;

	public void verifyLeadsPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createNewLeadBtnWE));
		assertTrue(pageTitleWE.getText().equals("Leads"), "Title is not good!");
	}

	public void refreshLeadsPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createNewLeadBtnWE));
		Thread.sleep(1000);
		refreshBtnWE.click();
		Thread.sleep(1000);
		assertTrue(pageTitleWE.getText().equals("Leads"), "Title is not good!");
	}

	public String[] createNewLead() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String[] data = new String[3];
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(createNewLeadBtnWE));
		createNewLeadBtnWE.click();
		data[0] = "Name " + HelperUtil.getRandomString(7);
		data[1] = "LastName " + HelperUtil.getRandomString(7);
		data[2] = "+4175" + HelperUtil.getRandomNumbers(7);
		wait.until(ExpectedConditions.elementToBeClickable(firstNameBtnWE));
		firstNameBtnWE.sendKeys(data[0]);
		lastNameBtnWE.sendKeys(data[1]);
		phoneBtnWE.sendKeys(data[2]);
		birthdayBtnWE.click();
		birthdayBtnWE.sendKeys("21.1.2000");
		emailBtnWE.sendKeys(HelperUtil.getRandomEmail());
		townBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(chooseTownBtnWE));
		chooseTownBtnWE.click();
		leadInterest1WE.click();
		leadInterest2WE.click();
		createBtnWE.click();
		return data;
	}

	public void verifyLead(String name, String lastName, String phone, boolean status) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(searchWE));
		Thread.sleep(3000);
		assertTrue(firstNameTableWE.getText().equals(name), "First Name not found!");
		assertTrue(lastNameTableWE.getText().equals(lastName), "Last Name not found!");
		assertTrue(phoneTableWE.getText().equals(phone), "Phone not found!");
		if (status == true) {
			assertTrue(isNewTableWE.getText().equals("New"), "Lead status is not correct!");
		}
	}

	public String editLead(String name, String lastName, String phone, boolean status) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(addNewTerminBtnWE));
		addNewTerminBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(insuranceHouseWE));
		insuranceHouseWE.click();
		Thread.sleep(2000);
		chooseInsuranceHouseWE.click();
		terminAddressWE.sendKeys("Street_" + HelperUtil.getRandomString(7));
		noteToAgentWE.sendKeys("Note_" + HelperUtil.getRandomString(7));
		timeWE.click();
		timeWE.sendKeys("21.06.2024 20:00");
		insuranceTypeWE.click();
		chooseinsuranceType1WE.click();
		insuranceTypeWE.click();
		chooseinsuranceType2WE.click();
		saveBtnWE.click();
		confirmBtnWE.click();
		return name;
	}

	public void verifyEditedLead(String name, String lastName, String phone, boolean status)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(searchWE));
		Thread.sleep(3000);
		assertTrue(firstNameTableWE.getText().equals(name), "First Name not found!");
		assertTrue(lastNameTableWE.getText().equals(lastName), "Last Name not found!");
		assertTrue(phoneTableWE.getText().equals(phone), "Phone not found!");
		if (status == true) {
			assertTrue(isNewTableWE.getText().equals("Termin arranged"), "Lead status is not correct!");
		}
	}

	public void verifyNegativeTermin(String name, String lastName, String phone, boolean status)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(searchWE));
		Thread.sleep(3000);
		assertTrue(firstNameTableWE.getText().equals(name), "First Name not found!");
		assertTrue(lastNameTableWE.getText().equals(lastName), "Last Name not found!");
		assertTrue(phoneTableWE.getText().equals(phone), "Phone not found!");
		if (status == true) {
			assertTrue(isNewTableWE.getText().equals("Negative termin"), "Lead status is not correct!");
		}
	}

	public void verifyStatus(String name, String lastName, String phone, boolean status) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(searchWE));
		Thread.sleep(3000);
		assertTrue(firstNameTableWE.getText().equals(name), "First Name not found!");
		assertTrue(lastNameTableWE.getText().equals(lastName), "Last Name not found!");
		assertTrue(phoneTableWE.getText().equals(phone), "Phone not found!");
		if (status == true) {
			System.out.println("Feedback uspjesno ostavljen, sinhronizacija izmedju aplikacija radi!");
		} else {
			System.out.println("Greska! Lead nije u potrebnom statusu.");
		}
	}
	
	public void verifyValidationMessages() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(createNewLeadBtnWE));
		createNewLeadBtnWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(createBtnWE));
		createBtnWE.click();
		wait.until(ExpectedConditions.visibilityOf(validationFirstNameMessageWE));
		wait.until(ExpectedConditions.visibilityOf(validationLastNameMessageWE));
		wait.until(ExpectedConditions.visibilityOf(validationPhoneMessageWE));
		wait.until(ExpectedConditions.visibilityOf(validationTownNameMessageWE));
		cancelBtnWE.click();
	}
}
