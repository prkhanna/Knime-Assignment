package com.qa.api.clients;

import java.util.Map;

import com.qa.api.test.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Generic class for CRUD operation
 * @author Prince Khanna
 *
 */
public class RestClient extends TestBase {

	public Response doGetRequest(Map<String, ?> para, String requestPath) {

		return RestAssured.given()
				.when()
				.params(para)
				.when()
				.get(requestPath);
	}
	
	public Response doDeleteRequest(String token, String name) {
		
		 return RestAssured.given().auth()
				 .oauth2(token)
				 .when()
		         .delete(name);
	}
	
	public Response doPutRequest(String token, Map<String,?> para , String payload, String name) {
		
		 return RestAssured.given().auth().oauth2(token)
				 .when()
				 .params(para)
				 .when()
				 .body(payload)
				 .put(name);	
	}

}
