package com.yorkland_admin.step;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.general.ExcelUtilities;
import com.yorkland_admin.general.PropertiesManager;
import com.yorkland_admin.pageobject.loginpage.LoginPage;

public class Login extends BaseStep{
	
	private LoginPage loginPage;
	private PropertiesManager prop;
	
	public Login(WebDriver driver) {
		super();
		prop = new PropertiesManager("src/test/resources/config.properties");
		loginPage = new LoginPage(driver,prop.readProperty("LoginPageURL"),"");
	}
	
	public void enter_usernameAndPassword() {
		String username = excelFile.getCellData(ExcelUtilities.SHEETNAME_AUTO_GENERATOR_ADMIN, 1, 2);
		String password = excelFile.getCellData(ExcelUtilities.SHEETNAME_AUTO_GENERATOR_ADMIN, 2, 2);
		loginPage.enter_username(username);
		loginPage.enter_password(password);
		loginPage.click_signInButton();
	}
	
	public void enter_usernameAndPassword(String username, String password) {
		loginPage.enter_username(username);
		loginPage.enter_password(password);
		loginPage.click_signInButton();
	}
	
	
	public void click_forgetPassword() {
		loginPage.click_forgetMyPasswordLink();
	}	
	
	public void click_signupLink() {
		loginPage.click_signUpLink();
	}
	
}
