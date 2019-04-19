package com.yorkland_admin.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yorkland_admin.general.AlertUtilites;
import com.yorkland_admin.pageobject.assertion.Assertion;
import com.yorkland_admin.step.BalanceActions;
import com.yorkland_admin.step.Login;

public class BalanceActionsTest extends BaseTest{
	
	private Login login;
	private BalanceActions balance;
	private Assertion assertpage;
	
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 1)
	public void addBalaceToAStudent_viaHomePageTable() {
		login = new Login(driver);
		balance = new BalanceActions(driver);
		assertpage = new Assertion(driver);

		//Login using existing username and password from excel sheet
		login.enter_usernameAndPassword();
		
		//pick random student to add random numbers of  balance
		balance.addBalance_viahomePageTable();
		Assert.assertEquals(assertpage.assert_successAlert(), AlertUtilites.ALERT_SUCCESS_ADD_BALANCE);
	}
	
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 2)
	public void addBalanceToAStudent_viaStudentName() {
		login = new Login(driver);
		balance = new BalanceActions(driver);
		assertpage = new Assertion(driver);

		//Login using existing username and password from excel sheet
		login.enter_usernameAndPassword();
		
		//pick a random student and add random balance through student information page
		balance.addBalance_viaStudentInfoPage();
		Assert.assertEquals(assertpage.assert_successAlert(), AlertUtilites.ALERT_SUCCESS_ADD_BALANCE);
	}
	
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 3)
	public void editAStudentBalance() {
		login = new Login(driver);
		balance = new BalanceActions(driver);
		assertpage = new Assertion(driver);
		
		//Login using existing username and password from excel sheet
				login.enter_usernameAndPassword();
		//pick a random student and edit random line of the balance on student information page		
				balance.editAStudentBalance();
				Assert.assertEquals(assertpage.assert_successAlert(), AlertUtilites.ALERT_SUCCESS_EDIT_BALANCE);
	}
	
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 4)
	public void deleteAnBalanceFromStudentInformationPage() {
		login = new Login(driver);
		balance = new BalanceActions(driver);
		assertpage = new Assertion(driver);
		
		//Login using existing username and password from excel sheet
				login.enter_usernameAndPassword();
		//pick a random student and delete a random line of the balance
				balance.deletAStudentBalance();
				Assert.assertEquals(assertpage.assert_successAlert(), AlertUtilites.ALERT_SUCCESS_DELETE_BALANCE);
	}

}
