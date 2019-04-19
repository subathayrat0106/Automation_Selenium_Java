package com.yorkland_admin.pageobject.assertion;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.BasePageObject;
import com.yorkland_admin.webcontrol.MessageWebControl;

public class Assertion extends BasePageObject{
	
	public WebDriver driver;
	
	public Assertion(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private String h1Title = "//h1[text()='Hello, Welcome To Yorkland High School Admin App']";
	private String success_alert = "//div[@class='alert alert-success']";
	
	public String assert_validateLogin() {
		MessageWebControl assertiontextWebControl = new MessageWebControl(driver, h1Title, findByXpath, 1);
		return assertiontextWebControl.getTextMessage();
	}
	
	public String assert_successAlert() {
		MessageWebControl assertiontextWebControl = new MessageWebControl(driver, success_alert, findByXpath, 2);
		return assertiontextWebControl.getTextMessage();
	}
	
}
