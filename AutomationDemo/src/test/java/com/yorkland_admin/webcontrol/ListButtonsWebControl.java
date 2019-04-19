package com.yorkland_admin.webcontrol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListButtonsWebControl extends ListWebElementControl{

	public ListButtonsWebControl(WebDriver driver, String webElementToFind, String findElementsBy) {
		super(driver, webElementToFind, findElementsBy);
	}
	
	public void click_numbersOfButton(int number) {
		WebElement element = control.get(number - 1);
		element.click();
	}

}
