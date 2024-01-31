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

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
	}
	
	@FindBy(xpath = "//h2")
	private WebElement secondWelcomeMessageWE;
	
	@FindBy(xpath = "//nav/ul/li[1]/a")
	private WebElement LanguageWE;
	
	@FindBy(xpath = "//li[1]/ul/li[1]/a")
	private WebElement EnglishWE;
	
	@FindBy(xpath = "//li[1]/ul/li[3]/a")
	private WebElement GermanWE;
	
	@FindBy(xpath = "//li[1]/ul/li[5]/a")
	private WebElement ItalianWE;
	
	@FindBy(xpath = "//li[1]/ul/li[7]/a")
	private WebElement FrenchWE;
	
	
	public void verifyHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logOffBtnWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Welcome to BrokerSoft"), "Message is not good!");
	}
	
	public void logOff() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logOffBtnWE));
		logOffBtnWE.click();
	}
	
	public void changeLanguageToEN() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		LanguageWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(EnglishWE));
		EnglishWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Welcome to BrokerSoft"), "Message is not good!");
	}
	
	public void changeLanguages() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		LanguageWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(GermanWE));
		GermanWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Wilkommen auf BrokerSoft"), "Message is not good!");
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		LanguageWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(ItalianWE));
		ItalianWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Benvenuti a BrokerSoft"), "Message is not good!");
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		LanguageWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(FrenchWE));
		FrenchWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Bienvenue dans BrokerSoft"), "Message is not good!");
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		LanguageWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(EnglishWE));
		EnglishWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Welcome to BrokerSoft"), "Message is not good!");
	}
	
}
