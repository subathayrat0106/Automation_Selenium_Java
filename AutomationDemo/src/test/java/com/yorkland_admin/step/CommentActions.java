package com.yorkland_admin.step;

import org.openqa.selenium.WebDriver;

import com.yorkland_admin.pageobject.commentpage.CommentPage;
import com.yorkland_admin.pageobject.homepage.HomePage;
import com.yorkland_admin.pageobject.studentInfopage.StudentInfoPage;

public class CommentActions extends BaseStep{

		private CommentPage comment;
		private StudentInfoPage studentInfo;
		private HomePage homepage;
		
		public CommentActions (WebDriver driver) {
			comment = new CommentPage(driver);
			studentInfo = new StudentInfoPage(driver);
			homepage = new HomePage(driver);
		}
		
		public void addNewComment() {
			String commentTitle = faker.lorem().characters(10);
			String commentContent = faker.lorem().paragraph();
			homepage.click_aRandomStudentFromTheTable();
			studentInfo.click_addNewCommentButton();
			enter_comment(commentTitle, commentContent);
		}
		
		public void addNewComment(String studentName,String commentTitle, String commentContent) {
			homepage.click_studentName(studentName);
			studentInfo.click_addNewCommentButton();
			enter_comment(commentTitle, commentContent);
		}
		
		public void editAComment() {
			String newCommentTitle = faker.lorem().characters(10);
			String newCommentContent = faker.lorem().paragraph();
			homepage.click_aRandomStudentFromTheTable();
			studentInfo.click_editCommentButton();
			enter_comment(newCommentTitle, newCommentContent);
		}
		
		public void editAComment(String studentName,int numberOfEditComments,String newCommentTitle, String newCommentContent) {
			homepage.click_studentName(studentName);
			studentInfo.click_editCommentButton(numberOfEditComments);
			enter_comment(newCommentTitle, newCommentTitle);
		}
		
		public void deletComment() {
			homepage.click_aRandomStudentFromTheTable();
			studentInfo.click_deleteCommentButton();
		}
		
		public void deletComment(int numberOfCommentToDelet) {
			studentInfo.click_deleteCommentButton(numberOfCommentToDelet);
		}
		
		private void enter_comment(String commentTitle, String commentContent) {
			comment.enter_commentTitle(commentTitle);
			comment.enter_commentContent(commentContent);
			comment.click_submitButton();
		}
}
