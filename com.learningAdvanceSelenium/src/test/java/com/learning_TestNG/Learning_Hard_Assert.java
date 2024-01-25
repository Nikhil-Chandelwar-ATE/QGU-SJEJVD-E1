package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Learning_Hard_Assert {

		@Test
		public void loginTest() throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://demowebshop.tricentis.com/");
			
			Assert.assertEquals(driver.getTitle(), "Demo Shop", "I am validating title..");
			driver.findElement(By.linkText("Log in")).click();
			
			Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/login", "Validating URL of login page");
			driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com",Keys.TAB,"nikhil123",Keys.ENTER);
			
			Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Validating Home page title");
			Thread.sleep(3000);
			driver.quit();
		}

}
