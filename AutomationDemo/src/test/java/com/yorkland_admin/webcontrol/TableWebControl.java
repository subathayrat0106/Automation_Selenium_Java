package com.yorkland_admin.webcontrol;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableWebControl extends ListWebElementControl{

	public TableWebControl(WebDriver driver, String tableIDtoFind, String findElementBy) {
		super(driver, tableIDtoFind, findElementBy);
	}
	
	
	public void click_itemName(String name) {
		for (WebElement webElement : control) {
			System.out.println(control.size());
			if(webElement.getText().equals(name))
				webElement.click();
				break;
		}	
	}
	
	public boolean isItemExistInTable(String itemName) {
		for (WebElement webElement : control) {
			if(webElement.getText().equals(itemName))
				return true;
		}
		return false;
	}
	
	public void click_randomItemFromTable() {
		Random rand = new Random ();
		int number = rand.nextInt(control.size());
		control.get(number).click();;
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
