package com.yorkland_admin.testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.yorkland_admin.general.ExcelManager;
import com.yorkland_admin.general.ExcelUtilities;
import com.yorkland_admin.pageobject.assertion.Assertion;
import com.yorkland_admin.pageobject.homepage.HomePage;
import com.yorkland_admin.step.Login;

@Listeners(com.yorkland_admin.general.TestListener.class)
public class LoginTest extends BaseTest{
	
	Login login;
	HomePage homePage;
	Assertion assertpage;
	
	@DataProvider
	public Object[][] loginTestData(){
		ExcelManager execelData = new ExcelManager(ExcelUtilities.EXCEL_FILEPATH);
		return execelData.getCellData(ExcelUtilities.SHEETNAME_LOGIN);
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String username, String password, String assertion) {
		login = new Login(driver);
		assertpage = new Assertion(driver);
		
		login.enter_usernameAndPassword(username, password);
		Assert.assertEquals(assertpage.assert_validateLogin(), assertion);
	}
}
