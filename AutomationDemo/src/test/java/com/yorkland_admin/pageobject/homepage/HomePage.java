package com.yorkland_admin.pageobject.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.BasePageObject;
import com.yorkland_admin.webcontrol.ButtonWebControl;
import com.yorkland_admin.webcontrol.LinkWebControl;
import com.yorkland_admin.webcontrol.TableWebControl;
import com.yorkland_admin.webcontrol.TextBoxWebControl;

public class HomePage extends BasePageObject{
	
	private WebDriver driver;
	private String button_addStudent = "//a[@class='btn btn-primary btn-lg']";
	private String textBox_search = "search";
	private String button_search = "//button[@class='btn btn-lg btn-info']";
	private String link_logout = "Logout";
	private String button_tuitionTab = "nav-home-tab";
	private String button_afterSchoolTab = "nav-profile-tab";
	private String button_otherTab = "nav-contact-tab";
	private String button_listAddBalanceButton = "//*[contains (@href, 'fee/update')]";
	private String element_listElementInTheTable = "//*[@id='nav-home']//*[contains(@href,'home')]";
	private final static Logger logger = Logger.getLogger(HomePage.class);


	public HomePage(WebDriver driver, String baseUrl, String path) {
		super(driver, baseUrl, path);
		this.driver = driver;
	}

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public HomePage click_addStudentButton() {
		ButtonWebControl addStudentWebControl = new ButtonWebControl(driver,button_addStudent,findByXpath,1);
		addStudentWebControl.clickButton();
		logger.info("Click 'Add Student' Button");
		return this;
	}
	
	public HomePage enter_searchBox(String searchName) {
		TextBoxWebControl searchBoxWebControl = new TextBoxWebControl(driver, textBox_search, findByName);
		searchBoxWebControl.enterText(searchName);
		logger.info("Enter student name : " + searchName + " to search Box");
		return this;
	}
	
	public HomePage click_searchButton() {
		ButtonWebControl searchButton = new ButtonWebControl(driver,button_search,findByXpath);
		searchButton.clickButton();
		logger.info("Click 'Search' Button");
		return this;
	}
	
	public HomePage click_logOutLink() {
		LinkWebControl logoutLinkControl = new LinkWebControl(driver, link_logout, findByLinkText);
		logoutLinkControl.clickLinkText();
		logger.info("Click 'LogOut' Link");
		return this;
	}

	public HomePage click_tuitionTab() {
		ButtonWebControl tuitionTabWebControl = new ButtonWebControl(driver, button_tuitionTab, findById);
		tuitionTabWebControl.clickButton();
		logger.info("Click 'Tuition' Tab");
		return this;
	}
	
	public HomePage click_afterSchoolTab() {
		ButtonWebControl afterSchoolTabWebControl = new ButtonWebControl(driver, button_afterSchoolTab, findById);
		afterSchoolTabWebControl.clickButton();
		logger.info("Click 'After School' Tab");
		return this;
	}
	
	public HomePage click_otherTab() {
		ButtonWebControl otherTabWebControl = new ButtonWebControl(driver, button_otherTab, findById);
		otherTabWebControl.clickButton();
		logger.info("Click 'Other' Tab");
		return this;
	}
	
	public HomePage click_studentName(String name) {
		String studentNameLocotor = String.format("//*[@id='nav-home']//a[text()='%s']", name);
		ButtonWebControl studentNameWebControl = new ButtonWebControl(driver, studentNameLocotor, findByXpath, 2);
		studentNameWebControl.clickButton();
		logger.info("Click student name: " + name);
		return this;
	}
	
	public HomePage click_addBalanceViaStudentName(String name) {
		String addBalanceButton =String.format("((//a[text()='%s'])[1]//following::a)[1]", name) ;
		ButtonWebControl addButtonWebControl = new ButtonWebControl(driver, addBalanceButton, findByXpath, 2);
		addButtonWebControl.clickButton();
		logger.info("Click 'Add Balance 'Button to student : " + name);
		return this;
	}
	
	public HomePage click_addBalanceButtonOnRandomStudent() {
		TableWebControl randomAddBalanceWebControl = new TableWebControl(driver,button_listAddBalanceButton, findByXpath);
		randomAddBalanceWebControl.click_randomItemFromTable();
		logger.info("Click 'Add Balance' Button to a random student");
		return this;
	}
	
	public HomePage click_aRandomStudentFromTheTable() {
		TableWebControl listElementWebControl = new TableWebControl(driver,element_listElementInTheTable, findByXpath);
		String oddNumber = Integer.toString(listElementWebControl.selectOddNumber());
		String randomStudent = String.format("(//*[@id='nav-home']//*[contains(@href,'home')])[%s]", oddNumber) ;
		ButtonWebControl randomStudentNameWebControl = new ButtonWebControl(driver, randomStudent, findByXpath, 2);
		randomStudentNameWebControl.clickButton();
		logger.info("Click a random student from the table");
		return this;
	}
	
}
