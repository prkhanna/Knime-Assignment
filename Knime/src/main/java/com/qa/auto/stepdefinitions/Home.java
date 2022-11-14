package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Home {

	HomePage homePage;

	public Home(HomePage homePage) {
		this.homePage = homePage;
	}

	@Given("User clicks on signin")
	public void signInButtonClick() {
		homePage.clickSignIn();
	}

	@Given("I click on user profile")
	public void clicksUserProfile() {
		homePage.clickUser();
	}
	
	@Given("User accept the cookies")
	public void acceptCookies() {
		homePage.acceptCookies();
	}
	@Then("I click on user account")
	public void userSpaceClick() {
		homePage.userSpaces();
	}
}
