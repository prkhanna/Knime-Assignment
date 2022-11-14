package com.qa.api.test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.qa.api.clients.RestClient;

import io.restassured.response.Response;

public class KnimeTest  extends TestBase{

	
     RestClient restClient = new RestClient();
	@Test
	public void getSpace() {
	HashMap<String, Object> para = new HashMap<>();
	para.put("spaceDetails", true);
	para.put("contribSpaces", "children");
	restClient.doGetRequest(para, "/").then().statusCode(200);				
				  
}
	
	
	@Test
	public void createSpace() {
	File schema = new File(System.getProperty("user.dir")+"//schema//create.json");
		String payload = "{\r\n"
				+ "  \"private\": true,\r\n"
				+ "  \"type\": \"Space\"\r\n"
				+ "}";
		
		HashMap<String, Object> para = new HashMap<>();
		para.put("overwrite", true);
		Response response =	restClient.doPutRequest(prop.getProperty("token"), para, payload, prop.getProperty("space"));	
		response.then().statusCode(201);
		response.then().body(matchesJsonSchema(schema));
					  
}
	
	@Test
	public void deleteSpace() {
		
		Response response = restClient.doDeleteRequest(prop.getProperty("token"), prop.getProperty("space"));		
		response. then().statusCode(204);
		
				  
}
}
