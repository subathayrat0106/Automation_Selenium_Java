package com.yorkland_admin.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.yorkland_admin.driverfactory.DriverFactory;
import com.yorkland_admin.driverfactory.DriverManager;
import com.yorkland_admin.general.PropertiesManager;

public class BaseTest {
	
	protected WebDriver driver;
	private DriverFactory driverFactory;
	private DriverManager driverManager;
	private PropertiesManager prop;
	private final static Logger logger = Logger.getLogger(BaseTest.class);
	
	@BeforeClass
	public void startClass() {
		prop = new PropertiesManager("src/test/resources/config.properties");
		driverFactory = new DriverFactory();
		driverManager = driverFactory.getDriver(prop.readProperty("Browser"));	
	}
	
	@BeforeMethod
	public void setUp() {
		logger.info("//////////***************TEST START***************//////////");
		driver = driverManager.createDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driverManager.quitDriver();
		logger.info("//////////***************TEST END***************//////////");
	}
	
	@AfterClass
	public void afterClassTestCaseCompleted() {
		//driverManager.quitDriver();
	}
		
}
