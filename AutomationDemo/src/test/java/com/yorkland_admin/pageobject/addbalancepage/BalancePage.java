package com.yorkland_admin.pageobject.addbalancepage;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.BasePageObject;
import com.yorkland_admin.webcontrol.ButtonWebControl;
import com.yorkland_admin.webcontrol.TextBoxWebControl;

public class BalancePage extends BasePageObject{
	
	private WebDriver driver;

	public BalancePage(WebDriver driver, String baseUrl, String path) {
		super(driver, baseUrl, path);
		this.driver = driver;
	}

	public BalancePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private String textBox_updateTuition = "update[updatedTuition]";
	private String textBox_updateCredit = "update[updatedCredit]";
	private String textBox_updateAfterSchoolFee = "update[updatedAfterSchoolFee]";
	private String textBox_updateInsuranceFee = "update[updatedInsuranceFee]";
	private String textBox_updateLunchFee = "update[updatedLunchFee]";
	private String button_updateButton = "updatedButton";
	
	public BalancePage enter_updateTuition(String tuition) {
		TextBoxWebControl updateTutition = new TextBoxWebControl(driver, textBox_updateTuition, findByName , 2);
		if (tuition != "") {
		updateTutition.clear();
		updateTutition.enterText(tuition);
		}
		return this;
	}
	
	public BalancePage enter_updateCredit(String credit) {
		TextBoxWebControl updatecreditWebControl = new TextBoxWebControl(driver, textBox_updateCredit, findByName);
		if(credit != "") {
		updatecreditWebControl.clear();
		updatecreditWebControl.enterText(credit);
		}
		return this;
	}
	
	public BalancePage enter_updateAfterSchoolFee(String afterSchoolFee) {
		TextBoxWebControl afterSchoolFeeWebControl = new TextBoxWebControl(driver, textBox_updateAfterSchoolFee, findByName);
		if(afterSchoolFee != "") {
		afterSchoolFeeWebControl.clear();
		afterSchoolFeeWebControl.enterText(afterSchoolFee);
		}
		return this;
	}
	
	public BalancePage enter_updateInsuranceFee(String insuranceFee) {
		TextBoxWebControl updateInsuranceFeeWebControl = new TextBoxWebControl(driver, textBox_updateInsuranceFee, findByName);
		if(insuranceFee != "") {
		updateInsuranceFeeWebControl.clear();
		updateInsuranceFeeWebControl.enterText(insuranceFee);
		}
		return this;
	}
	
	public BalancePage enter_updateLunchFee(String lunchFee) {
		TextBoxWebControl updateLunchFeeWebControl = new TextBoxWebControl(driver, textBox_updateLunchFee, findByName);
		if(lunchFee != "") {
		updateLunchFeeWebControl.clear();
		updateLunchFeeWebControl.enterText(lunchFee);
		}
		return this;
	}
	
	public BalancePage click_updateButton() {
		ButtonWebControl updateButtonWebControl = new ButtonWebControl(driver, button_updateButton, findById);
		updateButtonWebControl.clickButton();
		return this;
	}
}
