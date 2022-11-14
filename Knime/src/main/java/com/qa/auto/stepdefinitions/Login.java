package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.LoginPage;

import io.cucumber.java.en.When;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Login {

	LoginPage loginPage;

	public Login(LoginPage loginPage) {
		this.loginPage = loginPage;
	}

	@When("User login into knime")
	public void checkPersonalDetails() {
		loginPage.enterLoginCredentials();
	}

}
