package restAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasXPath;
import static org.hamcrest.Matchers.is;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


//import static com.jayway.restassured.RestAssured.given;


import java.io.IOException;
import java.io.InputStream;

public class RestExamples {

	// 1. Status Code

	// @Test
	public void testStatusCode() {

		given().get("http://dummy.restapiexample.com/api/v1/employee/1").then().statusCode(200);
	}

	// 2. Logs and "and" and status line

	// @Test
	public void testLogAll() {

		given().get("http://dummy.restapiexample.com/api/v1/employee/1").then().statusCode(200).and().log().all().and()
				.statusLine("HTTP/1.1 200 OK");
	}

	// 3. Verifying the response of body not in JSON format - Direct

	// @Test
	public void equals() {

		given().get("http://dummy.restapiexample.com/api/v1/employee/1").then().equals("false");

	}

	// 4. Verifying Single content using Hamcrest Matcher library's equalTo Method - 
	//		Useful when you have just one JSON response only.

		 //@Test
//		public void equalsToMethodOfHamcrest() {
//
//			given().
//				get("http://services.groupkt.com/state/get/IND/UP").
//			)
//			then().
//				assertThat().body();
//			
			

}


				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

