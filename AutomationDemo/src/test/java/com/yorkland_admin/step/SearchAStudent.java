package com.yorkland_admin.step;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.homepage.HomePage;

public class SearchAStudent extends BaseStep{
	
		private HomePage searchStudent;
		public SearchAStudent(WebDriver driver){
			searchStudent = new HomePage (driver);
		}
		
		public void searchAStudent(String studentName) {
			searchStudent.enter_searchBox(studentName);
			searchStudent.click_searchButton();
		}
}
