package com.qa.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionlLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class HomePage {

	FunctionlLibrary misc;

	public HomePage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	public static WebElement signIn;

	@FindBy(xpath = "//div[@class='submenu']//button[@type='button']")
	public static WebElement user;

	@FindBy(xpath = "//button[contains(text(),'Accept and close')]")
	public static WebElement acceptButton;
	
	@FindBy(xpath= "//li[@class='separator']//span[@class='text']")
	public static WebElement userDetails;

	public void clickSignIn() {
		misc.elementClick(signIn);
	}

	public void clickUser() {
		misc.elementClick(user);
	}

	public void acceptCookies() {
		misc.wait(2000);
		misc.elementClick(acceptButton);
	}

	public void userSpaces() {
		misc.elementClick(userDetails);
	}
}
