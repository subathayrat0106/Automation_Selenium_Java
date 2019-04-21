package com.yorkland_admin.webcontrol;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class RadioButtonWebControl extends WebControl{
	private final static Logger logger = Logger.getLogger(RadioButtonWebControl.class);

	public RadioButtonWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}

	public RadioButtonWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}

	public void ClickRadioButton() {
		control.click();
		logger.debug("Click Radio Button");
	}
}
