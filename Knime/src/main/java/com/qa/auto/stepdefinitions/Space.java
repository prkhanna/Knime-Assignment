package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.SpacePage;

import io.cucumber.java.en.When;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Space {
	

	SpacePage spacePage;
	
	public Space(SpacePage spacePage) {
        this.spacePage = spacePage;
    }
	
	
	@When("I edit the existing space name")
	public void checkPersonalDetails() {
		spacePage.editSpaceName();
	}
	
	@When("I delete the created space")
	public void checkNewUser() {
		spacePage.deleteSpace();
	}
}
