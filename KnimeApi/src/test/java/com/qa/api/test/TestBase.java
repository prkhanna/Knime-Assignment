package com.qa.api.test;



import org.testng.annotations.BeforeTest;

import com.qa.api.util.PropertyReader;

import io.restassured.RestAssured;

/**
 * Test Base class 
 * @authorPrince Khanna
 *
 */
public class TestBase {
	
	public static PropertyReader prop;
	@BeforeTest
	public static void init() {
		
		prop = PropertyReader.getInstance();
		RestAssured.baseURI =prop.getProperty("baseUrl");
		RestAssured.basePath= prop.getProperty("basePath");
	}

}
