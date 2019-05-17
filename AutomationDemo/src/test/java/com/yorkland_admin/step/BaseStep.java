package com.yorkland_admin.step;

import com.github.javafaker.Faker;
import com.yorkland_admin.general.ExcelManager;
import com.yorkland_admin.general.ExcelUtilities;

public class BaseStep {
	
	protected ExcelManager excelFile; 
	protected Faker faker;
	private String firstName;
	private String lastName;
	
	public BaseStep() {
		excelFile = new ExcelManager(ExcelUtilities.EXCEL_FILEPATH);
		faker = new Faker();
	}
	
	
	protected String getRandomFirstName() {
		String firstName = faker.name().firstName();
		return firstName;
	}
	
	protected String getRandomLastName() {
		String lastName = faker.name().lastName();
		return lastName;
	} 
	
	public String getFullName() {
		return firstName + " " + lastName;
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
