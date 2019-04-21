package com.yorkland_admin.pageobject.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.BasePageObject;
import com.yorkland_admin.webcontrol.MessageWebControl;

public class Assertion extends BasePageObject{
	
	public WebDriver driver;
	private final static Logger logger = Logger.getLogger(Assertion.class);
	
	public Assertion(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private String h1Title = "//h1[text()='Hello, Welcome To Yorkland High School Admin App']";
	private String success_alert = "//div[@class='alert alert-success']";
	
	public String assert_validateLogin() {
		MessageWebControl assertiontextWebControl = new MessageWebControl(driver, h1Title, findByXpath, 1);
		String assertMessage = assertiontextWebControl.getTextMessage();
		logger.info("validate message :" + assertMessage);
		return assertMessage;
	}
	
	public String assert_successAlert() {
		MessageWebControl assertiontextWebControl = new MessageWebControl(driver, success_alert, findByXpath, 2);
		String assertAlert = assertiontextWebControl.getTextMessage();
		logger.info("Alert message :" + assertAlert);
		return assertAlert;
	}
	
}
