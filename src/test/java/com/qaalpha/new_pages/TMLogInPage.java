package com.qaalpha.new_pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

import com.qaalpha.base.PageBase;

public class TMLogInPage extends PageBase {

	public TMLogInPage(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		super(driver);
		driver.get(qaalpha_properties.getValue("URL_TM"));
	}
}