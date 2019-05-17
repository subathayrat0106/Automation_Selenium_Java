package com.yorkland_admin.webcontrol;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LinkWebControl extends WebControl{
	
	private final static Logger logger = Logger.getLogger(LinkWebControl.class);

	public LinkWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}

	public LinkWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}
	
	public void clickLinkText() {
		control.click();
		logger.debug("Click Link Text");
	}
}
