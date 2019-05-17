package com.yorkland_admin.pageobject.commentpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.BasePageObject;
import com.yorkland_admin.webcontrol.ButtonWebControl;
import com.yorkland_admin.webcontrol.TextBoxWebControl;

public class CommentPage extends BasePageObject{
	
	private WebDriver driver;
	private final static Logger logger = Logger.getLogger(CommentPage.class);

	public CommentPage(WebDriver driver, String baseUrl, String path) {
		super(driver, baseUrl, path);
		this.driver = driver;
	}

	public CommentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private String textBox_commentTitle = "comment[title]";
	private String textBox_commentContent = "comment[text]";
	private String button_submit = "submitButton";
	
	public CommentPage enter_commentTitle(String title) {
		TextBoxWebControl commentTitleWebControl = new TextBoxWebControl(driver, textBox_commentTitle, findByName);
		if(title != "") {
		commentTitleWebControl.clear();
		commentTitleWebControl.enterText(title);
		logger.info("Enter comment title : " + title);
		}
		return this;
	}

	public CommentPage enter_commentContent(String content) {
		TextBoxWebControl commentContentWebControl = new TextBoxWebControl(driver, textBox_commentContent, findByName);
		if(content != "") {
		commentContentWebControl.clear();
		commentContentWebControl.enterText(content);
		logger.info("Enter comment content : " + content);
		}
		return this;
	}
	
	public CommentPage click_submitButton() {
		ButtonWebControl submitWebControl = new ButtonWebControl(driver, button_submit, findById);
		submitWebControl.clickButton();
		logger.info("Click 'Submit' Button");
		return this;
	}
}
