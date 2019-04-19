package com.yorkland_admin.webcontrol;

import org.openqa.selenium.WebDriver;

public class RadioButtonWebControl extends WebControl{

	public RadioButtonWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}

	public RadioButtonWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
	}

	public void ClickRadioButton() {
		control.click();
	}
}
