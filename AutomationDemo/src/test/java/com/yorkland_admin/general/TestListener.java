package com.yorkland_admin.general;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.yorkland_admin.testcase.BaseTest;

public class TestListener extends BaseTest implements ITestListener{
	
	private Screenshot takeScreenshot;
	private final static Logger logger = Logger.getLogger(TestListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		takeScreenshot = new Screenshot(driver, "Success");
		takeScreenshot.takeScreenshot();	
		logger.info("Test has PASSED, screenshot has been taken");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		takeScreenshot = new Screenshot(driver, "Failure");
		takeScreenshot.takeScreenshot();
		logger.info("Test has FAILED, screenshot has been taken");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}
	
	

}
