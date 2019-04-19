package com.yorkland_admin.pageobject.studentpage;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.BasePageObject;
import com.yorkland_admin.webcontrol.ButtonWebControl;
import com.yorkland_admin.webcontrol.DropDownWebControl;
import com.yorkland_admin.webcontrol.TextBoxWebControl;

public class StudentPage extends BasePageObject{

	private WebDriver driver;
	private String textBox_firstName = "firstName";
	private String textBox_lastName = "lastName";
	private String textBox_dob = "dob";
	private String textBox_tuitionFee = "tuition";
	private String textBox_numberOfCredit = "credit";
	private String dropDown_studentEntryTime = "studentEntryTime";
	private String textBox_afterSchoolProgram = "afterSchoolProgram";
	private String textBox_afterSchoolFee = "afterSchoolFee";
	private String textBox_InsuranceFee = "insuranceFee";
	private String textBox_lunchFee = "lunchFee";
	private String button_addStudent = "//button[@class='btn btn-lg btn-primary btn-block']";
	
	public StudentPage(WebDriver driver, String baseUrl, String path) {
		super(driver, baseUrl, path);
		this.driver = driver;
	}

	public StudentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public StudentPage enter_firstName(String firstName) {
		TextBoxWebControl firstNameWebControl = new TextBoxWebControl(driver, textBox_firstName, findByName);
		if (firstName != "") {
		firstNameWebControl.clear();
		firstNameWebControl.enterText(firstName);
		}
		return this;
	}
	
	public StudentPage enter_lastName(String lastName) {
		TextBoxWebControl lastNameWebControl = new TextBoxWebControl(driver, textBox_lastName, findByName);
		if(lastName != "") {
		lastNameWebControl.clear();
		lastNameWebControl.enterText(lastName);
		}
		return this;
	}
	
	public StudentPage enter_dob(String dob) {
		TextBoxWebControl dobWebControl = new TextBoxWebControl(driver, textBox_dob, findByName);
		if(dob != "") {
		dobWebControl.clear();
		dobWebControl.enterText(dob);
		}
		return this;
	}
	
	public StudentPage enter_tuitionFee(String tuition) {
		TextBoxWebControl tuitionFeeWebControl = new TextBoxWebControl(driver, textBox_tuitionFee, findByName);
		if(tuition != "") {
		tuitionFeeWebControl.clear();
		}
		tuitionFeeWebControl.enterText(tuition);
		return this;
	}
	
	public StudentPage enter_numberOfCredit(String credit) {
		TextBoxWebControl numberOfCreditWebControl = new TextBoxWebControl(driver, textBox_numberOfCredit, findByName);
		if(credit != "") {
		numberOfCreditWebControl.clear();
		numberOfCreditWebControl.enterText(credit);
		}
		return this;
	}
	
	public StudentPage dropdown_selectStudentEntryTime(int entryTimeDropDownIndex) {
		DropDownWebControl studentEntryTimeWebControl = new DropDownWebControl(driver,dropDown_studentEntryTime,findByName);		
		studentEntryTimeWebControl.selectDropDownByIndext(entryTimeDropDownIndex);
		return this;
	}
	
	public StudentPage dropdown_selectStudentEntryTime(String entryTimeDropDown) {
		if( entryTimeDropDown != "") {
		DropDownWebControl studentEntryTimeWebControl = new DropDownWebControl(driver,dropDown_studentEntryTime,findByName);		
		studentEntryTimeWebControl.selectDropDownByText(entryTimeDropDown);
		}
		return this;
	} 
	
	public StudentPage enter_afterSchoolProgram(String afterSchoolProgram) {
		TextBoxWebControl afterSchoolProgameWebControl = new TextBoxWebControl(driver,textBox_afterSchoolProgram,findByName);
		if(afterSchoolProgram != "") {
		afterSchoolProgameWebControl.clear();
		afterSchoolProgameWebControl.enterText(afterSchoolProgram);
		}
		return this;
	}
	
	public StudentPage enter_afterSchoolProgramFee(String afterSchoolProgramFee) {
		TextBoxWebControl afterSchoolProgameFeeWebControl = new TextBoxWebControl(driver,textBox_afterSchoolFee,findByName);
		if(afterSchoolProgramFee != "") {
		afterSchoolProgameFeeWebControl.clear();
		afterSchoolProgameFeeWebControl.enterText(afterSchoolProgramFee);
		}
		return this;
	}
	
	public StudentPage enter_insuranceFee(String insuranceFee) {
		TextBoxWebControl insuranceFeeWebControl = new TextBoxWebControl(driver,textBox_InsuranceFee,findByName);
		if(insuranceFee != "") {
		insuranceFeeWebControl.clear();
		insuranceFeeWebControl.enterText(insuranceFee);
		}
		return this;
	}
	
	public StudentPage enter_lunchFee(String lunchFee) {
		TextBoxWebControl lunchFeeWebControl = new TextBoxWebControl(driver,textBox_lunchFee,findByName);
		if(lunchFee != "") {
		lunchFeeWebControl.clear();
		lunchFeeWebControl.enterText(lunchFee);
		}
		return this;
	}
	
	public StudentPage click_addStudent(){
		ButtonWebControl addStudentWebControl = new ButtonWebControl(driver,button_addStudent,findByXpath);
		addStudentWebControl.clickButton();
		return this;
	}
	
	public int select_randomStudentEntryTimeIndex() {
		DropDownWebControl studentEntryTimeIndexWebControl = new DropDownWebControl(driver,dropDown_studentEntryTime,findByName);
		return studentEntryTimeIndexWebControl.selectRandomDropDown();
	}
}
