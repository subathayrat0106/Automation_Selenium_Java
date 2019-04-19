package com.yorkland_admin.webcontrol;

import org.openqa.selenium.WebDriver;

public class CheckBoxWebControl extends WebControl{
	
	public CheckBoxWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}

	public CheckBoxWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}
	
	public void clickCheckBox() {
		control.click();
	}

}
