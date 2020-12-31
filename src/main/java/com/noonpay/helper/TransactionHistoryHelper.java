package com.noonpay.helper;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TransactionHistoryHelper extends BaseClass{

public String getAccessToken() {
	
		File file=new File(APIConstants.tokenJsonPath);
		try {
			FileInputStream fi=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found");
		}
				Response response =  given().contentType(ContentType.JSON).body(file).
                when().post(APIConstants.tokenEndpoint).
                then().extract().response();
				io.restassured.path.json.JsonPath jpath=response.jsonPath();
				String token=jpath.getString("data.token");
		return token;
	}
	

}
