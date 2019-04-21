package com.yorkland_admin.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePageObject {
	protected WebDriver driver;
	protected String baseUrl;
	protected String completeUrl;
	protected String findById = "Id";
	protected String findByXpath = "Xpath";
	protected String findByCssSelector = "css";
	protected String findByLinkText = "LinkText";
	protected String findByName = "Name";
	private final static Logger logger = Logger.getLogger(BasePageObject.class);

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public BasePageObject(WebDriver driver, String baseUrl, String path) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		setURL(path);
		Navigate();
	}

	public void setURL(String path) {
		this.completeUrl = this.baseUrl + path;
	}

	public void Navigate() {
		driver.get(completeUrl);
		logger.info("go to URL : " + completeUrl);
	}

	public void threadSleep(double d) {
		try {
			Thread.sleep((long) (d * 1000));
		} catch (InterruptedException e) {
			logger.error("Error occurs 'Thread Sleep' :" + e.getMessage());
		}
	}

}
