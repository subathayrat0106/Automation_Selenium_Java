package com.yorkland_admin.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;


public class FireFoxDriverManager extends DriverManager{
	private GeckoDriverService firefoxDriverService;
	private static final String FIREFOX_DRIVER_PATH="./src/test/resources/geckodriver";
	

	@Override
	public WebDriver createDriver() {
		System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		driver = new FirefoxDriver(options);
		return driver;
	}

	@Override
	public void startService() {
		firefoxDriverService = GeckoDriverService.createDefaultService();
		try {
			firefoxDriverService.start();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
}
