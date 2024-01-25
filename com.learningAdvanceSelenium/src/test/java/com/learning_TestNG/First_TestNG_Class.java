package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class First_TestNG_Class {
	
	@Test	//It act like a main method
	public void registerTC() {
		
		Reporter.log("This is Register Test Case",true);
	}
	
	@Test	//It act like a main method
	public void loginTC() {
		
		Reporter.log("This login Test Case",true);
	}
	
	@Test	//It act like a main method
	public void searchTC() {
		
		Reporter.log("This is Search Test Case",true);
	}
}
