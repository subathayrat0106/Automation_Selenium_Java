package com.yorkland_admin.webcontrol;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListWebElementControl {

	WebDriver driver;
	protected List<WebElement> control;
	protected String webElementToFind;
	protected int waitSecond;
	private final static Logger logger = Logger.getLogger(ListWebElementControl.class);

	public ListWebElementControl(WebDriver driver, String webElementToFind, String findElementsBy) {
		this.driver = driver;
		this.webElementToFind = webElementToFind;
		findElement(webElementToFind, findElementsBy);
		logger.debug("Element find by " + findElementsBy);
		logger.debug("Elements to find : " + webElementToFind);
	}

	private void findElement(String webElementToFind, String findElementsBy) {
		switch (findElementsBy) {
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

	public List<WebElement> getWebElement() {
		return control;
	}

	private List<WebElement> findByName(String webElementToFind) {
		try {
			control = driver.findElements(By.name(webElementToFind));
		} catch (Exception e) {
			logger.error("Error on find elements by name : " + e.getMessage());
		}
		return control;
	}

	private List<WebElement> findByLinkText(String webElementToFind) {
		try {
		control = driver.findElements(By.linkText(webElementToFind));
		}catch(Exception e) {
			logger.error("Error on find elements by link text : " + e.getMessage());
		}
		return control;
	}

	private List<WebElement> findByCssSelector(String webElementToFind) {
		try {
		control = driver.findElements(By.cssSelector(webElementToFind));
		}catch(Exception e) {
			logger.error("Error on find elements by Css Selector: " + e.getMessage());
		}
		return control;
	}

	private List<WebElement> findByXpath(String webElementToFind) {
		try {
			control = driver.findElements(By.xpath(webElementToFind));
		}catch(Exception e) {
			logger.error("Error on find elements by Xpath : " + e.getMessage());
		}
		return control;
	}

	private List<WebElement> findById(String webElementToFind) {
		try {
		control = driver.findElements(By.id(webElementToFind));
		}catch(Exception e) {
			logger.error("Error on find elements by ID : " + e.getMessage());
		}
		return control;
	}

	private List<WebElement> findByClassName(String webElementToFind) {
		try {
		control = driver.findElements(By.className(webElementToFind));
		}catch(Exception e) {
			logger.error("Error on find elements by class name : " + e.getMessage());
		}
		return control;
	}

}
