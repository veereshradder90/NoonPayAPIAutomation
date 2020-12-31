package com.noonpay.helper;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class BaseClass {
	public String token;
	@BeforeTest
	public void sertBaseURI() {
		RestAssured.baseURI="https://interview.noonpay.biz";
		 token=new TransactionHistoryHelper().getAccessToken();
	}
	
}
