package com.yorkland_admin.webcontrol;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListButtonsWebControl extends ListWebElementControl{
	private final static Logger logger = Logger.getLogger(ListButtonsWebControl.class);

	public ListButtonsWebControl(WebDriver driver, String webElementToFind, String findElementsBy) {
		super(driver, webElementToFind, findElementsBy);
	}
	
	public void click_numbersOfButton(int number) {
		WebElement element = control.get(number - 1);
		element.click();
		logger.debug("Click list number : " + (number - 1) + " element : " + element.toString());
	}

}
