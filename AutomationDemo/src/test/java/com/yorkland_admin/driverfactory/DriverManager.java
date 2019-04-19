package com.yorkland_admin.driverfactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends DriverFactory {

	protected WebDriver driver;

	public abstract WebDriver createDriver();

	public abstract void startService();
	
	public DriverManager() {
	}

	public DriverManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		if (null == driver) {
			startService();
			driver = createDriver();		
		}
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
