package com.yorkland_admin.general;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	private WebDriver driver;
	private String screenshotType;
	private final static Logger logger = Logger.getLogger(Screenshot.class);
	private final static String FILE_DIR = "AutomationDemo/test-output/screenshot/";

	public Screenshot(WebDriver driver, String screenshotType) {
		this.driver = driver;
		this.screenshotType = screenshotType;
	}

	public void takeScreenshot() {
		String filePath = FILE_DIR + screenshotType + "_" + getCurrentTime() + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File(filePath));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	private String getCurrentTime() {
		Date date = new Date();
		String tempTime = new Timestamp(date.getTime()).toString();
		String finalTimeStamp = tempTime.replace(":", "_").replace("-", "_").replace(" ", "_").replace(".", "_");
		return finalTimeStamp;
	}
}
