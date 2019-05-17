package com.yorkland_admin.webcontrol;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownWebControl extends WebControl{
	
	private Select dropDown;
	private final static Logger logger = Logger.getLogger(DropDownWebControl.class);
	
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
		logger.debug("Select Drop Down By Text : " + text);
	}
	
	public void selectDropDownByValue(String value) {
		dropDown.selectByValue(value);
		logger.debug("Select Drop Down By Value : " + value);
	}
	
	public void selectDropDownByIndext(int index) {
		dropDown.selectByIndex(index);
		logger.debug("Select Drop Down By Index : " + index);
	}
	
	public int selectRandomDropDown() {
		int randomIndex = new Random().nextInt(dropDown.getOptions().size());
		logger.debug("Select Drop Down By Random Index Number :" + randomIndex);
		return randomIndex;
	}

}
