package com.yorkland_admin.step;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.general.ExcelUtilities;
import com.yorkland_admin.pageobject.homepage.HomePage;
import com.yorkland_admin.pageobject.studentInfopage.StudentInfoPage;
import com.yorkland_admin.pageobject.studentpage.StudentPage;

public class StudentActions extends BaseStep{

	private StudentPage student;
	private HomePage homePage;
	private StudentInfoPage studentInfo;
	private String firstName;
	private String nameOfStudentDelete;

	public StudentActions(WebDriver driver) {
		student = new StudentPage(driver);
		homePage = new HomePage(driver);
		studentInfo = new StudentInfoPage(driver);
	}
	
	public void addANewStudent() {
		firstName = createRandomFirstName();
		excelFile.setCellData(ExcelUtilities.SHEETNAME_STUDENT_INFO, 1, 2, firstName);
		String lastName = createRandomLastName();
		excelFile.setCellData(ExcelUtilities.SHEETNAME_STUDENT_INFO, 2, 2, lastName);
		String dob = createRandomDOB();
		excelFile.setCellData(ExcelUtilities.SHEETNAME_STUDENT_INFO, 3, 2, dob);
		String tuition = createRandomNumber(5);
		String credit = createRandomNumber(2);
		String afterSchoolProgram = createRandomProgram();
		String afterSchoolFee = createRandomNumber(3);
		String insuranceFee = createRandomNumber(3);
		String lunchFee = createRandomNumber(3);
		homePage.click_addStudentButton();	
		student.enter_firstName(firstName);
		student.enter_lastName(lastName);
		student.enter_dob(dob);
		student.enter_tuitionFee(tuition);
		student.enter_numberOfCredit(credit);
		student.dropdown_selectStudentEntryTime(student.select_randomStudentEntryTimeIndex());
		student.enter_afterSchoolProgram(afterSchoolProgram);
		student.enter_afterSchoolProgramFee(afterSchoolFee);
		student.enter_insuranceFee(insuranceFee);
		student.enter_lunchFee(lunchFee);
		student.click_addStudent();
	}

	public void addANewStudent(String firstName, String lastName, String dob, String tuition, String credit,
			String entryTimeDropDown, String afterSchoolProgram, String afterSchoolFee, String insuranceFee, String lunchFee) {
		homePage.click_addStudentButton();	
		enterStudentInfo(firstName, lastName, dob, tuition, credit, entryTimeDropDown, afterSchoolProgram, afterSchoolFee,
				insuranceFee, lunchFee);
	}

	public void editAStudent(String eidtStudentName,String firstName, String lastName, String dob, String tuition, String credit,
			String entryTimeDropDown, String afterSchoolProgram, String afterSchoolFee, String insuranceFee, String lunchFee) {
		homePage.click_studentName(eidtStudentName);
		studentInfo.click_editStudentButton();
		enterStudentInfo(firstName, lastName, dob, tuition, credit, entryTimeDropDown, afterSchoolProgram, afterSchoolFee,
				insuranceFee, lunchFee);
	}
	
	public void editAStudent(String firstName, String lastName, String dob, String tuition, String credit,
			String entryTimeDropDown, String afterSchoolProgram, String afterSchoolFee, String insuranceFee, String lunchFee) {
		String editStudentName = excelFile.getCellData(ExcelUtilities.SHEETNAME_STUDENT_INFO, 1, 2);
		homePage.click_studentName(editStudentName);
		studentInfo.click_editStudentButton();
		enterStudentInfo(firstName, lastName, dob, tuition, credit, entryTimeDropDown, afterSchoolProgram, afterSchoolFee,
				insuranceFee, lunchFee);
	}

	public void deletAStudent(String deletStudentName) {
		homePage.click_studentName(deletStudentName);
		studentInfo.click_deleteStudentButton();
	}
	
	public void deletAStudent() {
		nameOfStudentDelete = excelFile.getCellData(ExcelUtilities.SHEETNAME_EDIT_STUDENT, 2, 1);
		homePage.click_studentName(nameOfStudentDelete);
		studentInfo.click_deleteStudentButton();
	}

	private void enterStudentInfo(String firstName, String lastName, String dob, String tuition, String credit,
			String entryTimeDropDown, String afterSchoolProgram, String afterSchoolFee, 
			String insuranceFee, String lunchFee) {
		student.enter_firstName(firstName);
		student.enter_lastName(lastName);
		student.enter_dob(dob);
		student.enter_tuitionFee(tuition);
		student.enter_numberOfCredit(credit);
		student.dropdown_selectStudentEntryTime(entryTimeDropDown);		
		student.enter_afterSchoolProgram(afterSchoolProgram);
		student.enter_afterSchoolProgramFee(afterSchoolFee);
		student.enter_insuranceFee(insuranceFee);
		student.enter_lunchFee(lunchFee);
		student.click_addStudent();
	}
	
}
