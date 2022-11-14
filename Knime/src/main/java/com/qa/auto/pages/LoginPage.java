package com.qa.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionlLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class LoginPage {
	
	
	FunctionlLibrary misc;

	public LoginPage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//input[@id='edit-name']")
	public static WebElement userName;

	@FindBy(xpath = "//input[@id='edit-pass']")
	public static WebElement password;
	
	@FindBy(xpath = "//button[@id='edit-submit']")
	public static WebElement signIn;
	
	

	public void enterLoginCredentials() {
		JsonObject data = misc.getJsonData();
		misc.elementSendKeys(userName, data.get("userName").toString());
		misc.elementSendKeys(password, data.get("password").toString());
		misc.elementClick(signIn);
	}

	

}
