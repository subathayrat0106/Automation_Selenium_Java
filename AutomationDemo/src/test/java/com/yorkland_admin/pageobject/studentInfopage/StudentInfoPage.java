package com.yorkland_admin.pageobject.studentInfopage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.BasePageObject;
import com.yorkland_admin.webcontrol.ButtonWebControl;
import com.yorkland_admin.webcontrol.ListButtonsWebControl;
import com.yorkland_admin.webcontrol.TableWebControl;

public class StudentInfoPage extends BasePageObject{

	public StudentInfoPage(WebDriver driver, String baseUrl, String path) {
		super(driver, baseUrl, path);		
	}

	public StudentInfoPage(WebDriver driver) {
		super(driver);
	}

	private String button_editStudent = "//a[@class='btn btn-xs btn-warning']";
	private String button_deleteStudent = "//button[@class='btn btn-xs btn-danger']";
	private String button_addNewComment = "//a[text()='Add New Comment']";
	private String tab_entryFee = "//a[@aria-controls='home']";
	private String tab_balance = "//a[contains(@href, '#tab2')]";
	private String button_addBalance = "addBalance";
	private String button_editCommentList = "//*[@id='commentBox']//child::a";
	private String button_deleteCommentList = "//*[@id='commentBox']//child::input";
	private String button_editBalanceList = "//*[@id='v-pills-tab1']//a[@class='btn btn-sm btn-warning']";
	private String button_deleteBalanceList = "//*[@id='v-pills-tab1']//child::input";
	private final static Logger logger = Logger.getLogger(StudentInfoPage.class);
	
	public StudentInfoPage click_editStudentButton() {
		ButtonWebControl editStudentWebControl = new ButtonWebControl(driver, button_editStudent, findByXpath, 5);
		editStudentWebControl.clickButton();
		logger.info("Click 'Edit' button for student");
		return this;
	}
	
	public StudentInfoPage click_deleteStudentButton() {
		ButtonWebControl deleteStudentWebControl = new ButtonWebControl(driver, button_deleteStudent, findByXpath);
		deleteStudentWebControl.clickButton();
		logger.info("Click 'Delete' button for student");
		return this;
	}
	
	public StudentInfoPage click_addNewCommentButton() {
		ButtonWebControl addNewCommentWebControl = new ButtonWebControl(driver, button_addNewComment, findByXpath);
		addNewCommentWebControl.clickButton();
		logger.info("Click 'Add New Comment' button");
		return this;
	}
	
	public StudentInfoPage click_entryFeeTab() {
		ButtonWebControl entryFeeTabWebControl = new ButtonWebControl(driver, tab_entryFee, findByXpath);
		entryFeeTabWebControl.clickButton();
		logger.info("Click 'Entry Fee' tab");
		return this;
	}
	
	public StudentInfoPage click_balanceTab() {
		ButtonWebControl balaceTabWebControl = new ButtonWebControl(driver, tab_balance, findByXpath ,3);
		balaceTabWebControl.clickButton();
		logger.info("Click 'Balance' tab");
		return this;
	}
	
	public StudentInfoPage click_addBalanceButton() {
		ButtonWebControl addBalanceButtonWebControl = new ButtonWebControl(driver, button_addBalance, findById , 2);
		addBalanceButtonWebControl.clickButton();
		logger.info("Click 'Add Balance' Button");
		return this;
	}
	
	public StudentInfoPage click_editCommentButton(int eidtCommentNumber) {
		ListButtonsWebControl editCommentButtonsWebControl = new ListButtonsWebControl
				(driver, button_editCommentList, findByXpath);
		editCommentButtonsWebControl.click_numbersOfButton(eidtCommentNumber);
		logger.info("Click 'Edit' button for comment row number : " + eidtCommentNumber);
		return this;
	}
	
	public StudentInfoPage click_editCommentButton() {
		TableWebControl editCommentButtonsWebControl = new TableWebControl
				(driver, button_editCommentList, findByXpath);
		editCommentButtonsWebControl.click_randomItemFromTable();
		logger.info("Click 'Edit' button for a random comment");
		return this;
	} 
	
	public StudentInfoPage click_deleteCommentButton(int deletCommentNumber) {
		ListButtonsWebControl deletCommentButtonsWebControl = new ListButtonsWebControl
				(driver, button_deleteCommentList, findByXpath);
		deletCommentButtonsWebControl.click_numbersOfButton(deletCommentNumber);
		logger.info("Click 'Delete' button for comment row number : " + deletCommentNumber);
		return this;
	}
	
	public StudentInfoPage click_deleteCommentButton() {
		TableWebControl deletCommentButtonsWebControl = new TableWebControl
				(driver, button_deleteCommentList, findByXpath);
		deletCommentButtonsWebControl.click_randomItemFromTable();
		logger.info("Click 'Delete' button for a random comment");
		return this;
	}
	
	public StudentInfoPage click_theNumberOfEditBalanceButton(int number) {
		ListButtonsWebControl editBalanceButtonsWebControl = new ListButtonsWebControl
				(driver, button_editBalanceList, findByXpath);
		editBalanceButtonsWebControl.click_numbersOfButton(number);
		logger.info("Click 'Edit' button for balance row number : " + number);
		return this;
	}
	
	public StudentInfoPage click_randomEditBalanceButton() {
		TableWebControl editBalanceButtonsWebControl = new TableWebControl
				(driver, button_editBalanceList, findByXpath);
		editBalanceButtonsWebControl.click_randomItemFromTable();
		logger.info("Click 'Edit' button for a random balance");
		return this;
	}
	
	public StudentInfoPage click_deleteBalanceButton(int number) {
		ListButtonsWebControl deletBalanceButtonsWebControl = new ListButtonsWebControl
				(driver, button_deleteBalanceList, findByXpath);
		deletBalanceButtonsWebControl.click_numbersOfButton(number);
		logger.info("Click 'Delete' button for balance row number : " + number);
		return this;
	}
	
	public StudentInfoPage click_randomDeleteBalanceButton() {
		TableWebControl deletBalanceButtonsWebControl = new TableWebControl
				(driver, button_deleteBalanceList, findByXpath);
		deletBalanceButtonsWebControl.click_randomItemFromTable();
		logger.info("Click 'Delete' button for a random balance");
		return this;
	}
}
