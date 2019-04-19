package com.yorkland_admin.pageobject;

import org.openqa.selenium.WebDriver;

public class BasePageObject {
	protected WebDriver driver;
    protected String baseUrl;
    protected String completeUrl;
    protected String findById = "Id";
    protected String findByXpath = "Xpath";
    protected String findByCssSelector = "css";
    protected String findByLinkText = "LinkText";
    protected String findByName = "Name";
    
    
    
    public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public BasePageObject (WebDriver driver, String baseUrl, String path) {
    	this.driver = driver;
    	this.baseUrl = baseUrl;
    	setURL(path);
    	Navigate();
    }
    
    public void setURL(String path) {
    	this.completeUrl = this.baseUrl + path;
    }
    
    public void Navigate() {
    	driver.get(completeUrl);
    }
    
    public void threadSleep(double d) {  	
    		try {
    			Thread.sleep((long) (d * 1000));
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    
}
