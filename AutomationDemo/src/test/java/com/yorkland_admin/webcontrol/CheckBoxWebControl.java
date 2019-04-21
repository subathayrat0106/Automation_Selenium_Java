package com.yorkland_admin.webcontrol;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CheckBoxWebControl extends WebControl{
	
	private final static Logger logger = Logger.getLogger(CheckBoxWebControl.class);
	
	public CheckBoxWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}

	public CheckBoxWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}
	
	public void clickCheckBox() {
		control.click();
		logger.debug("Click Check Box");	
	}

}
