package com.generic_Library;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.object_Repository.Home_Page;
import com.object_Repository.Login_Page;
import com.object_Repository.Welcome_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest_2 {

	public static WebDriver sDriver;
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeSuite
	public void reportConfiguration() {
		report = new ExtentReports("./src/test/resources/reports/" + Java_Utility.getName() + ".html");
	}

	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.getPropertyValue("url"));
		Reporter.log("Application Lauched Successfully....");

		sDriver = driver;
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToDWS(Method method) throws Throwable {
		test = report.startTest(method.getName());
		Welcome_Page wp = new Welcome_Page(driver);
		wp.getLoginLink().click();
		Login_Page lp = new Login_Page(driver);
		lp.getEmailTextField().sendKeys(File_Utility.getPropertyValue("username"));
		lp.getPasswordTextField().sendKeys(File_Utility.getPropertyValue("password"));
		lp.getLoginButton().click();
		Reporter.log("Logged in Successfully to Demo Web Shop....");
	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromDWS() {
		Home_Page hp = new Home_Page(driver);
		hp.getLogoutLink().click();
		Reporter.log("Logged out Successfully from Demo Web Shop....");
		report.endTest(test);
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Browser closed Successfully....");
	}

	@AfterSuite
	public void flushReport() {
		report.flush();
		
	}
}
