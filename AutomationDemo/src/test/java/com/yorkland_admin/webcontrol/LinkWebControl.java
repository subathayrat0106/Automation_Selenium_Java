package com.yorkland_admin.webcontrol;

import org.openqa.selenium.WebDriver;

public class LinkWebControl extends WebControl{

	public LinkWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}

	public LinkWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}
	
	public void clickLinkText() {
		control.click();
	}
}
