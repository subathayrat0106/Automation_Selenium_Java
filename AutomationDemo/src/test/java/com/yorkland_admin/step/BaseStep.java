package com.yorkland_admin.step;

import com.yorkland_admin.general.ExcelManager;
import com.yorkland_admin.general.ExcelUtilities;
import com.yorkland_admin.general.RandomStringGenerator;

public class BaseStep {
	
	protected ExcelManager excelFile; 
	private String firstName;
	private String lastName;
	
	public BaseStep() {
		excelFile = new ExcelManager(ExcelUtilities.EXCEL_FILEPATH);
	}
			
	protected String createRandomFirstName() {		
		firstName = excelFile.randomDataFromExcelSheet(ExcelUtilities.SHEETNAME_RANDOM_NAME, 1);
		return firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	protected String createRandomLastName() {
		lastName = excelFile.randomDataFromExcelSheet(ExcelUtilities.SHEETNAME_RANDOM_NAME, 2);
		return lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

	protected String createRandomEmail() {
		String email = RandomStringGenerator.get_random_string("Aphla", 5)
				+ RandomStringGenerator.get_random_string("Numeric", 3) + "@gmail.com";
		return email;
	}

	protected String createRandomUsername() {
		String username = RandomStringGenerator.get_random_string("Mixed", 8);
		return username;
	}
	
	protected String createRandomPassword() {
		String password = RandomStringGenerator.get_random_string("Mixed", 10);
		return password;
	}


	protected String createRandomProgram() {
		String program = RandomStringGenerator.get_random_string("Aphla", 4).toUpperCase();
		return program;
	}

	protected String createRandomNumber(int digit) {
		String number = RandomStringGenerator.get_random_string("Numeric", digit);
		return number;
	}
	
	protected String createRandomAlpha(int digit) {
		String number = RandomStringGenerator.get_random_string("Aphla", digit);
		return number;
	}
	
	protected String createRandomDOB() {
		String dob = null;
		int year = randBetween(1990, 2000);
		int month = randBetween(1, 12);
		int day;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = randBetween(1, 31);
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = randBetween(1, 30);
		} else {
			day = randBetween(1, 28);
		}

		String yearStr = Integer.toString(year);
		String monthStr;
		String dayStr;
		if (month < 10) {
			monthStr = "0" + Integer.toString(month);
		}else {
			monthStr = Integer.toString(month);
		}
		
		if(day < 10) {
			dayStr = "0" + Integer.toString(day);
		}else {
			dayStr = Integer.toString(day);
		}
		
		dob = monthStr + dayStr + yearStr;
		return dob;
	}

	private static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	
	
}
