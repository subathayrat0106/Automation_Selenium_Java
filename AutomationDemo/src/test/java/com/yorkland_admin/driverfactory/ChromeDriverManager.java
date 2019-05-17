package com.yorkland_admin.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeDriverManager extends DriverManager{
	
	private ChromeDriverService chromeDriverService;
	private static final String CHROME_DRIVER_PATH="./src/test/resources/chromedriver.exe";
	

	@Override
	public WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		return driver;
	}

	@Override
	public void startService() {
		chromeDriverService = ChromeDriverService.createDefaultService();
		try {
			chromeDriverService.start();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}



}
