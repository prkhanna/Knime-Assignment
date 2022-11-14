package com.qa.auto.pages;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionlLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class UserPage {

	FunctionlLibrary misc;

	public UserPage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//button[contains(text(),'Public space')]")
	public static WebElement publicSpace;

	@FindBy(xpath = "//span[@title='Discard message']")
	public static WebElement discardMsg;

	@FindBy(xpath = "//button[contains(text(),'Public space')]")
	public static WebElement privateSpace;

	@FindBy(xpath = "//span[@class='message']")
	public static WebElement successMsg;
	

	public void addNewSpace(String type) {
		switch (type) {
		case ("public"):
			misc.elementClick(publicSpace);
			break;
		case ("private"):
			misc.elementClick(privateSpace);
			break;
		default:
			fail("Incorrect space type selected");
		}
	}

	public void displayMessage(String msg) {
		misc.wait(2000);
		String actualMessage = misc.elementGetText(successMsg);
		if (msg.equals("success")) {
			String expectedMessage = "Your new space was created successfully!";
			Assert.assertEquals(actualMessage, expectedMessage);
			misc.elementClick(discardMsg);
		} else if (msg.equals("deleted")) {
			String expectedMessage = "Space was deleted successfully!";
			Assert.assertEquals(actualMessage, expectedMessage);
		}else if (msg.equals("rename")) {
			String expectedMessage = "Space was renamed successfully!";
			Assert.assertEquals(actualMessage, expectedMessage);
			misc.elementClick(discardMsg);
		}else {
			fail("Incorrect message type");
		}
	}
	
	

}
