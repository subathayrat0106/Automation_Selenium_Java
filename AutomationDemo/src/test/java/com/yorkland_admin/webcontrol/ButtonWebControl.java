package com.yorkland_admin.webcontrol;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ButtonWebControl extends WebControl{
	private final static Logger logger = Logger.getLogger(ButtonWebControl.class);
	
	public ButtonWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
		this.driver = driver;
	}
	
	public ButtonWebControl(WebDriver driver, String webElementToFind, String findElementBy , int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}
	
	public void clickButton() {	
		control.click();
		logger.debug("Click Button");
	}
}
