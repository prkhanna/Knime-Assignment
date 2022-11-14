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
public class SpacePage {

	FunctionlLibrary misc;

	public SpacePage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//textarea[@placeholder='Enter public space name']")
	public static WebElement spaceTextField;
	
	@FindBy(xpath = "//button[@title='Save']//*[name()='svg']")
	public static WebElement addButton;
	
	@FindBy(xpath = "//a[contains(text(),'Spaces')]")
	public static WebElement spaceLink;
	
	
	@FindBy(xpath = "//input[@placeholder='space name']")
	public static WebElement popupInputField;
	
	@FindBy(xpath = "//div[@class='controls']")
	public static WebElement popupDeleteBtn;
	
	@FindBy(xpath = "//button[@class='toggle function-button single']//*[name()='svg']")
	public static WebElement deleteBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Delete space')]")
	public static WebElement deleteSpaceBtn;
	
	
	public void editSpaceName() {
		JsonObject data = misc.getJsonData();
		misc.elementSendKeys(spaceTextField, data.get("Name").toString());
		misc.elementClick(addButton);
	}
	
	public void deleteSpace() {
		JsonObject data = misc.getJsonData();
		misc.wait(5000);
		misc.elementClick(deleteBtn);
		misc.elementClick(deleteSpaceBtn);
		misc.elementSendKeys(popupInputField, data.get("Name").toString());
		misc.elementClick(popupDeleteBtn);
	}
	
	
	
	
}
