package com.yorkland_admin.pageobject.homepage;

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
		return this;
	}
	
	public HomePage enter_searchBox(String searchName) {
		TextBoxWebControl searchBoxWebControl = new TextBoxWebControl(driver, textBox_search, findByName);
		searchBoxWebControl.enterText(searchName);
		return this;
	}
	
	public HomePage click_searchButton() {
		ButtonWebControl searchButton = new ButtonWebControl(driver,button_search,findByXpath);
		searchButton.clickButton();
		return this;
	}
	
	public HomePage click_logOutLink() {
		LinkWebControl logoutLinkControl = new LinkWebControl(driver, link_logout, findByLinkText);
		logoutLinkControl.clickLinkText();
		return this;
	}

	public HomePage click_tuitionTab() {
		ButtonWebControl tuitionTabWebControl = new ButtonWebControl(driver, button_tuitionTab, findById);
		tuitionTabWebControl.clickButton();
		return this;
	}
	
	public HomePage click_afterSchoolTab() {
		ButtonWebControl afterSchoolTabWebControl = new ButtonWebControl(driver, button_afterSchoolTab, findById);
		afterSchoolTabWebControl.clickButton();
		return this;
	}
	
	public HomePage click_otherTab() {
		ButtonWebControl otherTabWebControl = new ButtonWebControl(driver, button_otherTab, findById);
		otherTabWebControl.clickButton();
		return this;
	}
	
	public HomePage click_studentName(String name) {
		String studentNameLocotor = String.format("//*[@id='nav-home']//a[text()='%s']", name);
		ButtonWebControl studentNameWebControl = new ButtonWebControl(driver, studentNameLocotor, findByXpath, 2);
		studentNameWebControl.clickButton();
		return this;
	}
	
	public HomePage click_addBalanceViaStudentName(String name) {
		String addBalanceButton =String.format("((//a[text()='%s'])[1]//following::a)[1]", name) ;
		ButtonWebControl addButtonWebControl = new ButtonWebControl(driver, addBalanceButton, findByXpath, 2);
		addButtonWebControl.clickButton();
		return this;
	}
	
	public HomePage click_addBalanceButtonOnRandomStudent() {
		TableWebControl randomAddBalanceWebControl = new TableWebControl(driver,button_listAddBalanceButton, findByXpath);
		randomAddBalanceWebControl.click_randomItemFromTable();
		return this;
	}
	
	public HomePage click_aRandomStudentFromTheTable() {
		TableWebControl listElementWebControl = new TableWebControl(driver,element_listElementInTheTable, findByXpath);
		String oddNumber = Integer.toString(listElementWebControl.selectOddNumber());
		String randomStudent = String.format("(//*[@id='nav-home']//*[contains(@href,'home')])[%s]", oddNumber) ;
		ButtonWebControl randomStudentNameWebControl = new ButtonWebControl(driver, randomStudent, findByXpath, 2);
		randomStudentNameWebControl.clickButton();
		return this;
	}
	
}
