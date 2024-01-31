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

public class TMHomePage extends PageBase {

	public TMHomePage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
	}

	@FindBy(xpath = "//h2")
	private WebElement secondWelcomeMessageWE;
	
	@FindBy(xpath = "//nav/ul/li[1]/a")
	private WebElement LanguageWE;
	
	@FindBy(xpath = "//li[1]/ul/li[1]/a")
	private WebElement EnglishWE;

	public void verifyTMHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logOffBtnWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Welcome to Termin Manager"), "Message is not good!");
	}

	public void changeLanguageToEN() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		LanguageWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(EnglishWE));
		EnglishWE.click();
		wait.until(ExpectedConditions.elementToBeClickable(LanguageWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Welcome to Termin Manager"), "Message is not good!");
	}	
}

