package com.noonpay.tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.noonpay.helper.APIConstants;
import com.noonpay.helper.BaseClass;
import com.noonpay.helper.TransactionHistoryHelper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TransactionHistoryTests extends BaseClass {

	@Test
	public void verifyTransactionhistory() {

		Response response = given().queryParam("token", token).when().get(APIConstants.userTransactionEndPoint).then()
				.statusCode(200).extract().response();
		io.restassured.path.json.JsonPath jpath = response.jsonPath();

		System.out.println(jpath.getString("data.txn[1].amount"));

		Assert.assertEquals(jpath.getString("data.txn[1].amount"), "15.0");
	}

	@Test
	public void verifyTransactionhistoryStatus() {

		Response response = given().queryParam("token", token).when().get(APIConstants.userTransactionEndPoint).then()
				.statusCode(200).extract().response();
		io.restassured.path.json.JsonPath jpath = response.jsonPath();

		System.out.println(jpath.getString("success"));

		Assert.assertEquals(jpath.getString("success"), "true");
	}

	@Test
	public void verifyTransactionhistoryTxnDate() {

		Response response = given().queryParam("token", token).when().get(APIConstants.userTransactionEndPoint).then()
				.statusCode(200).extract().response();
		io.restassured.path.json.JsonPath jpath = response.jsonPath();

		System.out.println(jpath.getString("data.txn[1].txnDate"));

		Assert.assertNotNull(jpath.getString("data.txn[1].txnDate"));
	}

	@Test
	public void verifyTransactionhistoryerrorMessage() {

		Response response = given().queryParam("token", token).when().get(APIConstants.userTransactionEndPoint).then()
				.statusCode(200).extract().response();
		io.restassured.path.json.JsonPath jpath = response.jsonPath();

		System.out.println(jpath.getString("errorMessage"));

		Assert.assertNull(jpath.getString("errorMessage"));
	}
}
