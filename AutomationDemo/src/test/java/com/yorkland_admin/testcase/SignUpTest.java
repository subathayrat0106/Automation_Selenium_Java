package com.yorkland_admin.testcase;

import org.testng.annotations.Test;

import com.yorkland_admin.general.AlertUtilites;
import com.yorkland_admin.pageobject.assertion.Assertion;
import com.yorkland_admin.step.Login;
import com.yorkland_admin.step.SignUp;

import junit.framework.Assert;

public class SignUpTest extends BaseTest{
	
	private Login login;
	private SignUp signUp;
	private Assertion assertpage;
	
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 1)
	public void signUpTest() {
		login = new Login(driver);
		signUp = new SignUp(driver);
		assertpage = new Assertion(driver);
		
		 login.click_signupLink();
		 signUp.createAnRandomAdminUserAccount();
		 Assert.assertEquals(AlertUtilites.ASSERT_SIGNUP + signUp.getFirstName() + " " + signUp.getLastName(), assertpage.assert_successAlert());
	}
			
}
