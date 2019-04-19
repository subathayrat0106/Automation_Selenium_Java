package com.yorkland_admin.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yorkland_admin.general.AlertUtilites;
import com.yorkland_admin.pageobject.assertion.Assertion;
import com.yorkland_admin.step.CommentActions;
import com.yorkland_admin.step.Login;

public class CommentActionsTest extends BaseTest{
	private Login login;
	private CommentActions comment;
	private Assertion assertpage;
	
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 1)
	public void addCommenttoAStudent() {
		login = new Login(driver);
		comment = new CommentActions(driver);
		assertpage = new Assertion(driver);

		//Login using existing username and password from excel sheet
		login.enter_usernameAndPassword();
		
		//add comment to a random student
		comment.addNewComment();
		Assert.assertEquals(assertpage.assert_successAlert(), AlertUtilites.ALERT_SUCCESS_ADD_COMMENT);
	}
	
	@Test(  groups = "Smoke Test" , 
			enabled = false , 
			priority = 2)
	public void editACommentToAStudent() {
		login = new Login(driver);
		comment = new CommentActions(driver);
		assertpage = new Assertion(driver);

		//Login using existing username and password from excel sheet
		login.enter_usernameAndPassword();
		
		//edit a random comment from a random student from information page
		comment.editAComment();
		Assert.assertEquals(assertpage.assert_successAlert(), AlertUtilites.ALERT_SUCCESS_EDIT_COMMENT);
	}
	
	@Test(  groups = "Smoke Test" , 
			enabled = true , 
			priority = 2)
	public void deleteAcommentToAStudent() {
		login = new Login(driver);
		comment = new CommentActions(driver);
		assertpage = new Assertion(driver);

		//Login using existing username and password from excel sheet
		login.enter_usernameAndPassword();
		
		//delete a random comment from a random student on information page
		comment.deletComment();
		Assert.assertEquals(assertpage.assert_successAlert(), AlertUtilites.ALERT_SUCCESS_DELETE_COMMENT);
	}
}
