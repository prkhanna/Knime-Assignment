package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.UserPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Prince Khanna
 *
 */
public class User {

	UserPage userPage;

	public User(UserPage userPage) {
		this.userPage = userPage;
	}

	@When("I click on the {string} space")
	public void checkPersonalScreenDetails(String type) {
		userPage.addNewSpace(type);;
	}
	
	@Then("Verify the {string} message for new space")
	public void checkSuccessMessage(String msg) {
		userPage.displayMessage(msg);
	}
	

	
	
	
}
