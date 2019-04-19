package com.yorkland_admin.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager{
	private InternetExplorerDriverService ieDriverService;
	private static final String IE_DRIVER_PATH="./src/test/resources/IEDriverServer.exe";
	

	@Override
	public WebDriver createDriver() {
		System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.introduceFlakinessByIgnoringSecurityDomains();
		driver = new InternetExplorerDriver(options);
		return driver;
	}

	@Override
	public void startService() {
		ieDriverService = InternetExplorerDriverService.createDefaultService();
		try {
			ieDriverService.start();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
}
