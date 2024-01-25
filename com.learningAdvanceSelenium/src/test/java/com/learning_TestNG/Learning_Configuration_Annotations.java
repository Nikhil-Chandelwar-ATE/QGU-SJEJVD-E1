package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Learning_Configuration_Annotations {

	@BeforeSuite
	public void beforeSuite() {
		
		Reporter.log("Executing Before Suite", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		
		Reporter.log("Executing After Suite", true);
	}
	
	@BeforeTest
	public void beforeTest() {
		
		Reporter.log("Executing Before Test", true);
	}
	
	@AfterTest
	public void afterTest() {
		
		Reporter.log("Executing After Test", true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		Reporter.log("Executing Before Method", true);
	}
	
	@AfterMethod
	public void afterMethod() {
		
		Reporter.log("Executing After Method", true);
	}
	
	@BeforeClass
	public void beforeClass() {
		
		Reporter.log("Executing Before Class", true);
	}
	
	@AfterClass
	public void afterClass() {
		
		Reporter.log("Executing After Class", true);
	}
	
	@Test
	public void loginTest() {
		
		Reporter.log("Executing Login Test Case", true);
	}
	
	@Test
	public void registerTest() {
		
		Reporter.log("Executing Register test Case", true);
	}
	
	@Test
	public void searchTest() {
		
		Reporter.log("Executing Search Test Case", true);
	}	
}
