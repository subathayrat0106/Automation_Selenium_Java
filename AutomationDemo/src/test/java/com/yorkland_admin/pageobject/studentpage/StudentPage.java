package com.yorkland_admin.pageobject.studentpage;

import org.apache.log4j.Logger;
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
	private final static Logger logger = Logger.getLogger(StudentPage.class);
	
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
		logger.info("Enter student first name : " + firstName);
		}
		return this;
	}
	
	public StudentPage enter_lastName(String lastName) {
		TextBoxWebControl lastNameWebControl = new TextBoxWebControl(driver, textBox_lastName, findByName);
		if(lastName != "") {
		lastNameWebControl.clear();
		lastNameWebControl.enterText(lastName);
		logger.info("Enter student last name : " + lastName);
		}
		return this;
	}
	
	public StudentPage enter_dob(String dob) {
		TextBoxWebControl dobWebControl = new TextBoxWebControl(driver, textBox_dob, findByName);
		if(dob != "") {
		dobWebControl.clear();
		dobWebControl.enterText(dob);
		logger.info("Enter student date of birth : " + dob);
		}
		return this;
	}
	
	public StudentPage enter_tuitionFee(String tuition) {
		TextBoxWebControl tuitionFeeWebControl = new TextBoxWebControl(driver, textBox_tuitionFee, findByName);
		if(tuition != "") {
		tuitionFeeWebControl.clear();
		tuitionFeeWebControl.enterText(tuition);
		logger.info("Enter student tuition : " + tuition);
		}
		return this;
	}
	
	public StudentPage enter_numberOfCredit(String credit) {
		TextBoxWebControl numberOfCreditWebControl = new TextBoxWebControl(driver, textBox_numberOfCredit, findByName);
		if(credit != "") {
		numberOfCreditWebControl.clear();
		numberOfCreditWebControl.enterText(credit);
		logger.info("Enter student number of the credit : " + credit);
		}
		return this;
	}
	
	public StudentPage dropdown_selectStudentEntryTime(int entryTimeDropDownIndex) {
		DropDownWebControl studentEntryTimeWebControl = new DropDownWebControl(driver,dropDown_studentEntryTime,findByName);		
		studentEntryTimeWebControl.selectDropDownByIndext(entryTimeDropDownIndex);
		logger.info("Select student entry time by index : " + entryTimeDropDownIndex);
		return this;
	}
	
	public StudentPage dropdown_selectStudentEntryTime(String entryTimeDropDown) {
		if( entryTimeDropDown != "") {
		DropDownWebControl studentEntryTimeWebControl = new DropDownWebControl(driver,dropDown_studentEntryTime,findByName);		
		studentEntryTimeWebControl.selectDropDownByText(entryTimeDropDown);
		logger.info("Select student entry time : " + entryTimeDropDown);
		}
		return this;
	} 
	
	public StudentPage enter_afterSchoolProgram(String afterSchoolProgram) {
		TextBoxWebControl afterSchoolProgameWebControl = new TextBoxWebControl(driver,textBox_afterSchoolProgram,findByName);
		if(afterSchoolProgram != "") {
		afterSchoolProgameWebControl.clear();
		afterSchoolProgameWebControl.enterText(afterSchoolProgram);
		logger.info("Enter student after school program : " + afterSchoolProgram);
		}
		return this;
	}
	
	public StudentPage enter_afterSchoolProgramFee(String afterSchoolProgramFee) {
		TextBoxWebControl afterSchoolProgameFeeWebControl = new TextBoxWebControl(driver,textBox_afterSchoolFee,findByName);
		if(afterSchoolProgramFee != "") {
		afterSchoolProgameFeeWebControl.clear();
		afterSchoolProgameFeeWebControl.enterText(afterSchoolProgramFee);
		logger.info("Enter student after school program fee: " + afterSchoolProgramFee);
		}
		return this;
	}
	
	public StudentPage enter_insuranceFee(String insuranceFee) {
		TextBoxWebControl insuranceFeeWebControl = new TextBoxWebControl(driver,textBox_InsuranceFee,findByName);
		if(insuranceFee != "") {
		insuranceFeeWebControl.clear();
		insuranceFeeWebControl.enterText(insuranceFee);
		logger.info("Enter student insurance fee : " + insuranceFee);
		}
		return this;
	}
	
	public StudentPage enter_lunchFee(String lunchFee) {
		TextBoxWebControl lunchFeeWebControl = new TextBoxWebControl(driver,textBox_lunchFee,findByName);
		if(lunchFee != "") {
		lunchFeeWebControl.clear();
		lunchFeeWebControl.enterText(lunchFee);
		logger.info("Enter student lunch fee : " + lunchFee);
		}
		return this;
	}
	
	public StudentPage click_addStudent(){
		ButtonWebControl addStudentWebControl = new ButtonWebControl(driver,button_addStudent,findByXpath);
		addStudentWebControl.clickButton();
		logger.info("Click 'Add Student' button");
		return this;
	}
	
	public int select_randomStudentEntryTimeIndex() {
		DropDownWebControl studentEntryTimeIndexWebControl = new DropDownWebControl(driver,dropDown_studentEntryTime,findByName);
		int indexNumber = studentEntryTimeIndexWebControl.selectRandomDropDown();
		logger.info("Select a random index number :" + indexNumber);
		return indexNumber;
	}
}
