package com.yorkland_admin.webcontrol;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListWebElementControl{

	WebDriver driver;
	protected List<WebElement> control;
	protected String webElementToFind;
	protected int waitSecond;

	public ListWebElementControl(WebDriver driver, String webElementToFind, String findElementsBy) {
		this.driver = driver;
		this.webElementToFind = webElementToFind;
		findElement(webElementToFind, findElementsBy);
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
		return control = driver.findElements(By.name(webElementToFind));
	}

	private List<WebElement> findByLinkText(String webElementToFind) {
		return control= driver.findElements(By.linkText(webElementToFind));
	}

	private List<WebElement> findByCssSelector(String webElementToFind) {
		return control= driver.findElements(By.cssSelector(webElementToFind));
	}

	private List<WebElement> findByXpath(String webElementToFind) {
		return control = driver.findElements(By.xpath(webElementToFind));
	}

	private List<WebElement> findById(String webElementToFind) {
		return control = driver.findElements(By.id(webElementToFind));
	}

	private List<WebElement> findByClassName(String webElementToFind) {
		return control = driver.findElements(By.className(webElementToFind));
	}

}
