// package com.

import io.restassured.RestAssured.*
import io.restassured.matcher.RestAssuredMatchers.*
import org.hamcrest.Matchers.*

public class BasicTest_V1 {
	
		@test
		void basicTest() {
			RestAssured
				.given()
					.header(headerName: "name", headerValue: "value")
				.when()
					.get("http://url")
				.then()
					.statusCode()
					.header("headerName": "Content-Type", expectValue: "application/json, charset=utf-8")
					.body("page". Matchers.equalTo(1))									// True
					.body("data.first_name[0]", Matchers.equalTo("Jiana"))				// True
					.body("data.first_name", Matchers.equalTo("Jiana", "Liam"))			// False
		}
		
}

/** 
{
	page: 1,
	total: 12,
	total_page: 2,
	data: [
		{
			id: 1,
			email: jiana@email.com
			first_name: "Jiana"
		}
		{
			id: 2,
			email: matt@email.com
			first_name: "matt"
		}
		... ...
	]
}

**/