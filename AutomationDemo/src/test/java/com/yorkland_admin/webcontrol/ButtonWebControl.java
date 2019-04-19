package com.yorkland_admin.webcontrol;

import org.openqa.selenium.WebDriver;

public class ButtonWebControl extends WebControl{
	
	public ButtonWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
		this.driver = driver;
	}
	
	public ButtonWebControl(WebDriver driver, String webElementToFind, String findElementBy , int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
	}
	
	public void clickButton() {
		control.click();
	}
}
