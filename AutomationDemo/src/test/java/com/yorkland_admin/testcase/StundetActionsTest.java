package com.yorkland_admin.testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yorkland_admin.general.AlertUtilites;
import com.yorkland_admin.general.ExcelManager;
import com.yorkland_admin.general.ExcelUtilities;
import com.yorkland_admin.pageobject.assertion.Assertion;
import com.yorkland_admin.step.Login;
import com.yorkland_admin.step.StudentActions;

public class StundetActionsTest extends BaseTest {

	private Login login;
	private StudentActions student;
	private Assertion assertpage;
	
	@DataProvider
	public Object[][] editStudentData(){
		ExcelManager execelData = new ExcelManager(ExcelUtilities.EXCEL_FILEPATH);
		return execelData.getCellData(ExcelUtilities.SHEETNAME_EDIT_STUDENT);
	}
	
	/**
	 * Be able to enter the student information, add a new student and display the student on home page table
	 */
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 1)
	public void addAStudent() {
		login = new Login(driver);
		student = new StudentActions(driver);
		assertpage = new Assertion(driver);
		//Login using existing username and password from excel sheet
		login.enter_usernameAndPassword();
			
		//using random data to create a new student
      	student.addANewStudent();	
		Assert.assertEquals(assertpage.assert_successAlert(), student.getFullName() + 
				AlertUtilites.ALERT_SUCCESS_ADD_STUDENT);
	}
	
	/***
	 * Be able to edit a exist student information and display the new student on home page
	 * @param firstName
	 * @param lastName
	 * @param dob
	 * @param tuition
	 * @param credit
	 * @param entryTimeDropDown
	 * @param afterSchoolProgram
	 * @param afterSchoolFee
	 * @param insuranceFee
	 * @param lunchFee
	 */
	@Test(  groups = "Smoke Test",
			dataProvider = "editStudentData",
			priority = 2 ,
			enabled = true)
	public void editAStudent
	       (String firstName, String lastName, String dob,String tuition, String credit, 
			String entryTimeDropDown, String afterSchoolProgram, String afterSchoolFee,
			String insuranceFee, String lunchFee) {
		login = new Login(driver);
		student = new StudentActions(driver);
		assertpage = new Assertion(driver);
		//Login using existing username and password from excel sheet
		login.enter_usernameAndPassword();			
		//using excel data to edit a student 		
		student.editAStudent(firstName, lastName, dob, tuition, credit,
				entryTimeDropDown, afterSchoolProgram, afterSchoolFee, insuranceFee, lunchFee);	
		Assert.assertEquals(assertpage.assert_successAlert(),firstName + " " + lastName +
				AlertUtilites.ALERT_SUCCESS_EDIT_STUDENT);
	}
	
	/***
	 * Be able to delete a exist student and the student information not display table after delete 
	 */
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 3)
	public void deletetAStudent() {
		login = new Login(driver);
		student = new StudentActions(driver);
		assertpage = new Assertion(driver);
		
		//Login using existing username and password from excel sheet
		login.enter_usernameAndPassword();
		  
		//Delete a student from 'edit a student test case'
		student.deletAStudent();
		Assert.assertEquals(assertpage.assert_successAlert(), AlertUtilites.ALERT_SUCCESS_DELETE_STUDENT);		
	}
	
	
	
}
