package com.generic_Library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base_Test {

	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeSuite
	public void reportConfiguration() {
		report = new ExtentReports("./src/test/resources/reports/"+Java_Utility.getName()+".html");
		
	}
	
	@BeforeTest
	public void startTest() {
		test = report.startTest(Java_Utility.getName());
	}
	
	@Parameters("browser")	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(String browser) throws Throwable {
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.getPropertyValue("url"));
		Reporter.log("Application Lauched Successfully....");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToDWS() throws Throwable {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(File_Utility.getPropertyValue("username"));
		driver.findElement(By.id("Password")).sendKeys(File_Utility.getPropertyValue("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("Logged in Successfully to Demo Web Shop....");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromDWS() {
		
		driver.findElement(By.linkText("Log out")).click();
		Reporter.log("Logged out Successfully from Demo Web Shop....");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		
		//driver.quit();
		Reporter.log("Browser closed Successfully....");

	}
	
	@AfterTest
	public void endTest() {
		report.endTest(test);
	}
	
	@AfterSuite
	public void flushReport() {
		report.flush();
	}
}
