package com.yorkland_admin.pageobject.loginpage;

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
		return this;
	}
	
	public LoginPage enter_password(String password) {
		TextBoxWebControl passwordTextBoxControl = new TextBoxWebControl(driver,textBox_password,findById);
		passwordTextBoxControl.enterText(password);
		return this;
	}
	
	public LoginPage click_signInButton() {
		ButtonWebControl signInButtonWebControl = new ButtonWebControl(driver, button_signIn,findById);
		signInButtonWebControl.clickButton();
		return this;
	}
	
	public LoginPage click_signUpLink() {
		LinkWebControl signUpLinkWebControl = new LinkWebControl(driver,link_signUp,findByLinkText);
		signUpLinkWebControl.clickLinkText();
		return this;
	}
	
	public LoginPage click_homeLink() {
		LinkWebControl homeLinkWebControl = new LinkWebControl(driver,link_home,findByLinkText);
		homeLinkWebControl.clickLinkText();
		return this;
	}
	
	public LoginPage click_forgetMyPasswordLink() {
		LinkWebControl forgetMyPasswordLinkWebControl = new LinkWebControl(driver,link_forgetMyPassword,findByLinkText);
		forgetMyPasswordLinkWebControl.clickLinkText();
		return this;
	}
}
