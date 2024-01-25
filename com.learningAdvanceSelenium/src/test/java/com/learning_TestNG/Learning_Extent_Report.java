package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic_Library.Java_Utility;
import com.generic_Library.WebDriver_Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Learning_Extent_Report {

	@Test
	public void loginTest() throws InterruptedException {
		
		ExtentReports report = new ExtentReports("./src/test/resources/reports/"+Java_Utility.getName()+".html");
		ExtentTest test = report.startTest("Login Test");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		try {
			Assert.assertEquals(driver.getTitle(), "Demo Web Sho");
			test.log(LogStatus.PASS, "Welcome page displayed successfully");
			driver.findElement(By.linkText("Log in")).click();
			driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("nikhil123");
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Welcome page not displayed");
			test.log(LogStatus.FAIL, test.addScreenCapture(WebDriver_Utility.getScreenshotPath(driver)));
		}
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
