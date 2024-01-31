package com.qaalpha.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.qaalpha.util.PropertiesUtil;

public class BaseTest {

	protected WebDriver driver;
	protected PropertiesUtil qaalpha_properties = null;
	protected final String QAALPHA_PROPERTIES = "qaalpha.properties";

	public BaseTest() throws IOException, FileNotFoundException {
		qaalpha_properties = new PropertiesUtil(QAALPHA_PROPERTIES);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("security.sandbox.content.level", 5);
			profile.setPreference("browser.privatebrowsing.autostart", true);
			profile.setPreference("dom.disable_beforeunload", true);
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
			options.addArguments("--start-maximized");
			options.addArguments("incognito");
			options.addArguments("chrome.switches", "--disable-extensions");
			driver = new ChromeDriver(options);
		} else {
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanUp() {
	//driver.quit();
	}
}