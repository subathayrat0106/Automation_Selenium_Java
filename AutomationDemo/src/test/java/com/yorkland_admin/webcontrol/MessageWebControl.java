package com.yorkland_admin.webcontrol;

import org.openqa.selenium.WebDriver;

public class MessageWebControl extends WebControl{

	public MessageWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}

	public MessageWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}
	
	public String getTextMessage() {
		return control.getText();
	}

}
