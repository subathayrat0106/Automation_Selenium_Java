package com.yorkland_admin.webcontrol;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TextBoxWebControl extends WebControl{
	private final static Logger logger = Logger.getLogger(TextBoxWebControl.class);

	public TextBoxWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}

	public TextBoxWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}
	
	public void enterText(String text) {
		control.sendKeys(text);
		logger.debug("Enter Text : "+ text);
	}
	
	public void clear() {
		control.clear();
		logger.debug("Clear Text Field");
	}
	
}
