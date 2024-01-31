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

public class LPHomePage extends PageBase {

	public LPHomePage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
	}

	@FindBy(xpath = "//h2")
	private WebElement secondWelcomeMessageWE;

	public void verifyLPHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logOffBtnWE));
		assertTrue(secondWelcomeMessageWE.getText().equals("Welcome to Lead Platform"), "Message is not good!");
	}

	
}

