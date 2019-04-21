package com.yorkland_admin.pageobject.loginpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.BasePageObject;
import com.yorkland_admin.webcontrol.ButtonWebControl;
import com.yorkland_admin.webcontrol.LinkWebControl;
import com.yorkland_admin.webcontrol.TextBoxWebControl;

public class LoginPage extends BasePageObject{
	
	private WebDriver driver;
	private String textBox_userName = "inputUsername";
	private String textBox_password = "inputPassword";
	private String button_signIn = "signinButton";
	private String link_signUp ="SignUp";
	private String link_home = "Home";
	private String link_forgetMyPassword = "Forgot my password";
	private final static Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver, String baseUrl, String path) {
		super(driver, baseUrl, path);
		this.driver = driver;
	}

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public LoginPage enter_username(String userName) {
		TextBoxWebControl userNameTextBoxControl = new TextBoxWebControl(driver,textBox_userName,findById);
		userNameTextBoxControl.enterText(userName);
		logger.info("Enter the unsername : " + userName);
		return this;
	}
	
	public LoginPage enter_password(String password) {
		TextBoxWebControl passwordTextBoxControl = new TextBoxWebControl(driver,textBox_password,findById);
		passwordTextBoxControl.enterText(password);
		logger.info("Enter the password : " + password);
		return this;
	}
	
	public LoginPage click_signInButton() {
		ButtonWebControl signInButtonWebControl = new ButtonWebControl(driver, button_signIn,findById);
		signInButtonWebControl.clickButton();
		logger.info("click 'sign in' button ");
		return this;
	}
	
	public LoginPage click_signUpLink() {
		LinkWebControl signUpLinkWebControl = new LinkWebControl(driver,link_signUp,findByLinkText);
		signUpLinkWebControl.clickLinkText();
		logger.info("click 'sign up' link ");
		return this;
	}
	
	public LoginPage click_homeLink() {
		LinkWebControl homeLinkWebControl = new LinkWebControl(driver,link_home,findByLinkText);
		homeLinkWebControl.clickLinkText();
		logger.info("click 'home' link ");		
		return this;
	}
	
	public LoginPage click_forgetMyPasswordLink() {
		LinkWebControl forgetMyPasswordLinkWebControl = new LinkWebControl(driver,link_forgetMyPassword,findByLinkText);
		forgetMyPasswordLinkWebControl.clickLinkText();
		logger.info("click 'forget my password' link ");
		return this;
	}
}
