package com.yorkland_admin.webcontrol;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MessageWebControl extends WebControl{
	private final static Logger logger = Logger.getLogger(MessageWebControl.class);

	public MessageWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}

	public MessageWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}
	
	public String getTextMessage() {
		String text = control.getText();
		logger.debug("Get Text Message");
		return text;
	}

}
