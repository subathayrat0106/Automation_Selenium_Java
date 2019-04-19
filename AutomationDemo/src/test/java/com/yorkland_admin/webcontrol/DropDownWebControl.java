package com.yorkland_admin.webcontrol;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownWebControl extends WebControl{
	
	Select dropDown;
	
	public DropDownWebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		super(driver, webElementToFind, findElementBy);
		dropDown = new Select(control);
	}

	public DropDownWebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		super(driver, webElementToFind, findElementBy, waitSecond);
		dropDown = new Select(control);
	}
	
	public void selectDropDownByText(String text) {
		dropDown.selectByVisibleText(text);
	}
	
	public void selectDropDownByValue(String value) {
		dropDown.selectByValue(value);
	}
	
	public void selectDropDownByIndext(int index) {
		dropDown.selectByIndex(index);
	}
	
	public int selectRandomDropDown() {
		int randomIndex = new Random().nextInt(dropDown.getOptions().size());
		return randomIndex;
	}

}
