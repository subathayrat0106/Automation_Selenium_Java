package com.yorkland_admin.webcontrol;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableWebControl extends ListWebElementControl{

	private final static Logger logger = Logger.getLogger(TableWebControl.class);
	public TableWebControl(WebDriver driver, String tableIDtoFind, String findElementBy) {
		super(driver, tableIDtoFind, findElementBy);
	}
	
	
	public void click_itemName(String name) {
		try {
		for (WebElement webElement : control) {
			System.out.println(control.size());
			if(webElement.getText().equals(name))
				webElement.click();
				logger.debug("click item : " + name);
				break;
		}	
		}catch(Exception e) {
			logger.error("Error occurs on click item : "  + e.getMessage());
		}
	}
	
	public void click_randomItemFromTable() {
		try {
		Random rand = new Random ();
		int number = rand.nextInt(control.size());
		control.get(number).click();
		logger.debug("Click Random Number From The Table");
		}catch(Exception e) {
			logger.error("Error occurs on click random item from table " + e.getMessage());
		}
	}
	

	
	public int selectOddNumber() {
		int oddNumber [] = new int[(control.size())/2];
		int k = 0;
		for(int i = 1; i <= control.size();i++) {
			if( i % 2 != 0) {
				oddNumber[k] = i;
				k++;
			}
		}
		Random rand = new Random();		
		int oddSingleNumber = oddNumber[rand.nextInt(oddNumber.length)];
		return oddSingleNumber;
	}
	
}
