package com.yorkland_admin.webcontrol;

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

	public WebControl(WebDriver driver, String webElementToFind, String findElementBy) {
		this.driver = driver;
		this.webElementToFind = webElementToFind;
		waitSecond = 1;
		findElement(webElementToFind, findElementBy);
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
		 waitForElementToBeDisplayed(By.name(webElementToFind));
		return control = driver.findElement(By.name(webElementToFind));
	}

	private WebElement findByLinkText(String webElementToFind) {
		waitForElementToBeDisplayed(By.linkText(webElementToFind));
		return control= driver.findElement(By.linkText(webElementToFind));
	}

	private WebElement findByCssSelector(String webElementToFind) {
		waitForElementToBeDisplayed(By.cssSelector(webElementToFind));
		return control= driver.findElement(By.cssSelector(webElementToFind));
	}

	private WebElement findByXpath(String webElementToFind) {
		waitForElementToBeDisplayed(By.xpath(webElementToFind));
		return control = driver.findElement(By.xpath(webElementToFind));
	}

	private WebElement findById(String webElementToFind) {
		waitForElementToBeDisplayed(By.id(webElementToFind));
		return control = driver.findElement(By.id(webElementToFind));
	}

	private WebElement findByClassName(String webElementToFind) {
		waitForElementToBeDisplayed(By.className(webElementToFind));
		return control = driver.findElement(By.className(webElementToFind));
	}


	private void waitForElementToBeDisplayed(By element) {
		WebDriverWait wait = new WebDriverWait(driver, waitSecond);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
