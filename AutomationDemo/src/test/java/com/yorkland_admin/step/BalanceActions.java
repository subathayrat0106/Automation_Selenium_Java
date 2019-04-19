package com.yorkland_admin.step;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.addbalancepage.BalancePage;
import com.yorkland_admin.pageobject.homepage.HomePage;
import com.yorkland_admin.pageobject.studentInfopage.StudentInfoPage;

public class BalanceActions extends BaseStep{

		private HomePage homePage;
		private StudentInfoPage studentInfo;
		private BalancePage balance;
		
		public BalanceActions (WebDriver driver) {
			homePage = new HomePage(driver);
			studentInfo = new StudentInfoPage(driver);
			balance = new BalancePage(driver);
		}
		public void addBalance_viahomePageTable() {
			homePage.click_addBalanceButtonOnRandomStudent();
			randombalance();
		}
		
		public void addBalance_viahomePageTable(String studentName,String tuition, String credit, String updateAfterSchoolFee
				,String insuranceFee, String lunchFee) {
			homePage.click_addBalanceViaStudentName(studentName);
			balance(tuition, credit, updateAfterSchoolFee, insuranceFee, lunchFee);
		}
		
		public void addBalance_viaStudentInfoPage() {
			homePage.click_aRandomStudentFromTheTable();
			studentInfo.click_balanceTab();
			studentInfo.click_addBalanceButton();
			randombalance();
		}
		
		public void addBalance_viaStudentInfoPage(String studentName, String tuition, String credit, String updateAfterSchoolFee
				,String insuranceFee, String lunchFee) {
			homePage.click_studentName(studentName);
			studentInfo.click_balanceTab();
			studentInfo.click_addBalanceButton();
			balance(tuition, credit, updateAfterSchoolFee, insuranceFee, lunchFee);
		}
		
		public void editAStudentBalance(String studentName, int numberOfRowToEdit,String tuition, String credit, String updateAfterSchoolFee
				,String insuranceFee, String lunchFee ) {
			homePage.click_studentName(studentName);
			studentInfo.click_balanceTab();
			studentInfo.click_theNumberOfEditBalanceButton(numberOfRowToEdit);
			balance(tuition, credit, updateAfterSchoolFee, insuranceFee, lunchFee);
		}
		
		public void editAStudentBalance() {
			homePage.click_aRandomStudentFromTheTable();
			studentInfo.click_balanceTab();
			studentInfo.click_randomEditBalanceButton();
			randombalance();
		}
		
		public void deletAStudentBalance() {
			homePage.click_aRandomStudentFromTheTable();
			studentInfo.click_balanceTab();
			studentInfo.click_randomDeleteBalanceButton();
		}
		
		
		public void deletAStudentBalance(String studentName,int numberofRowToDelet) {
			homePage.click_studentName(studentName);
			studentInfo.click_balanceTab();
			studentInfo.click_deleteBalanceButton(numberofRowToDelet);
		}
		
				
		private void balance(String tuition, String credit, String updateAfterSchoolFee
				,String insuranceFee, String lunchFee) {
			balance.enter_updateTuition(tuition);	
			balance.enter_updateCredit(credit);
			balance.enter_updateAfterSchoolFee(updateAfterSchoolFee);
			balance.enter_updateInsuranceFee(insuranceFee);
			balance.enter_updateLunchFee(lunchFee);
			balance.click_updateButton();
		}
		
		private void randombalance() {
			String tuition = createRandomNumber(4);
			String credit = createRandomNumber(2);
			String updateAfterSchoolFee = createRandomNumber(3);
			String insuranceFee = createRandomNumber(3);
			String lunchFee = createRandomNumber(3);
			balance(tuition, credit, updateAfterSchoolFee, insuranceFee, lunchFee);
		}
		
		
		
		
		
}
