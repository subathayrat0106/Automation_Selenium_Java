package com.yorkland_admin.webcontrol;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebControl{

	WebDriver driver;
	protected WebElement control;
	protected String webElementToFind;
	protected int waitSecond;
	private final static Logger logger = Logger.getLogger(WebControl.class);

	public WebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		this.driver = driver;
		this.webElementToFind = webElementToFind;
		waitSecond = 1;
		findElement(webElementToFind, findElementBy);
		logger.debug("Element find by " + findElementBy);
		logger.debug("Elements to find : " + webElementToFind);
	}

	public WebControl(WebDriver driver, String webElementToFind, String findElementBy, int waitSecond) {
		this.driver = driver;
		this.webElementToFind = webElementToFind;
		this.waitSecond = waitSecond;
		findElement(webElementToFind, findElementBy);
	}

	private void findElement(String webElementToFind, String findElementBy) {
		switch (findElementBy) {
		case "Id":
			findById(webElementToFind);
			break;
		case "Xpath":
			findByXpath(webElementToFind);
			break;
		case "css":
			findByCssSelector(webElementToFind);
			break;
		case "LinkText":
			findByLinkText(webElementToFind);
			break;
		case "Name":
			findByName(webElementToFind);
			break;
		case "ClassName":
			findByClassName(webElementToFind);
			break;
		}
		this.webElementToFind = webElementToFind;
	}
	
	public WebElement getWebElement() {
		return control;
	}
		
	 private WebElement findByName(String webElementToFind) {
		 try {
		 waitForElementToBeDisplayed(By.name(webElementToFind));
		 control = driver.findElement(By.name(webElementToFind));
		 }catch(Exception e) {
			 logger.error("Error occurs find by name : " + e.getMessage());
		 }
		 return control;
	}

	private WebElement findByLinkText(String webElementToFind) {
		try {
		waitForElementToBeDisplayed(By.linkText(webElementToFind));
		control= driver.findElement(By.linkText(webElementToFind));
		}catch(Exception e) {
			 logger.error("Error occurs find by text : " + e.getMessage());
		 }
		return control;
	}

	private WebElement findByCssSelector(String webElementToFind) {
		try {
		waitForElementToBeDisplayed(By.cssSelector(webElementToFind));
		control= driver.findElement(By.cssSelector(webElementToFind));
		}catch(Exception e) {
			logger.error("Error occurs find by css selector : " + e.getMessage());
		}
		return control;
	}

	private WebElement findByXpath(String webElementToFind) {
		try {
		waitForElementToBeDisplayed(By.xpath(webElementToFind));
		control = driver.findElement(By.xpath(webElementToFind));
		}catch(Exception e) {
			logger.error("Error occurs find by Xpath : " + e.getMessage());
		}
		return control;
	}

	private WebElement findById(String webElementToFind) {
		try {
		waitForElementToBeDisplayed(By.id(webElementToFind));
		control = driver.findElement(By.id(webElementToFind));
		}catch(Exception e) {
			logger.error("Error occurs find by ID : " + e.getMessage());
		}
		return control;
	}

	private WebElement findByClassName(String webElementToFind) {
		try {
		waitForElementToBeDisplayed(By.className(webElementToFind));
		return control = driver.findElement(By.className(webElementToFind));
		}catch(Exception e) {
			logger.error("Error occurs find by class name : " + e.getMessage());
		}
		return control;
	}


	private void waitForElementToBeDisplayed(By element) {
		WebDriverWait wait = new WebDriverWait(driver, waitSecond);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		logger.debug("Wait unit element display :" + element.toString());
	}
}
