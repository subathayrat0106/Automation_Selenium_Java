package com.yorkland_admin.driverfactory;

public class DriverFactory {

	private DriverManager driverManager;
	
	public DriverManager getDriver(String browser) {
		switch (browser) {
		case "Chrome":
			driverManager = new ChromeDriverManager();
			break;
		case"FireFox":
			driverManager = new FireFoxDriverManager();
			break;
		case"IE":
			driverManager = new IEDriverManager();
			break;
		default:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}

}
