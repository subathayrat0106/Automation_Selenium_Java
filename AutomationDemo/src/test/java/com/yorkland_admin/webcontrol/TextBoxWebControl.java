package com.yorkland_admin.webcontrol;

import org.openqa.selenium.WebDriver;

public class TextBoxWebControl extends WebControl{

	public TextBoxWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}

	public TextBoxWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}
	
	public void enterText(String text) {
		control.sendKeys(text);
	}
	
	public void clear() {
		control.clear();
	}
	
}
