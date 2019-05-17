package com.yorkland_admin.step;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.general.ExcelUtilities;
import com.yorkland_admin.pageobject.signup.SignUpPage;

public class SignUp extends BaseStep{

	private SignUpPage signUp;

	public SignUp(WebDriver driver) {
		super();
		signUp = new SignUpPage(driver);
	}

	public void createAnAdminUserAccount(String userName, String password, String firstName, String lastName, String email,
			String adminCode) {
		signUp.enter_userName(userName);
		signUp.enter_password(password);
		signUp.enter_firstName(firstName);
		signUp.enter_lastName(lastName);
		signUp.enter_email(email);
		signUp.enter_adminCode(adminCode);
		signUp.click_signUpButton();
	}
	
	public void createAnRandomAdminUserAccount() {
		String username = faker.name().username();
		excelFile.setCellData(ExcelUtilities.SHEETNAME_AUTO_GENERATOR_ADMIN, 1, 2, username);
		
		String password = faker.internet().password(6, 10, true);
		excelFile.setCellData(ExcelUtilities.SHEETNAME_AUTO_GENERATOR_ADMIN, 2, 2, password);
		
		String firstName = getRandomFirstName();
		excelFile.setCellData(ExcelUtilities.SHEETNAME_AUTO_GENERATOR_ADMIN, 3, 2, firstName);
		
		String lastName = getRandomLastName();
		excelFile.setCellData(ExcelUtilities.SHEETNAME_AUTO_GENERATOR_ADMIN, 4, 2, lastName);
		
		String email = faker.internet().emailAddress();
		excelFile.setCellData(ExcelUtilities.SHEETNAME_AUTO_GENERATOR_ADMIN, 5, 2, email);
		
		String adminCode = excelFile.getCellData(ExcelUtilities.SHEETNAME_AUTO_GENERATOR_ADMIN, 6, 2);
		
		createAnAdminUserAccount(username, password, firstName, lastName, email, adminCode);
	}

}
