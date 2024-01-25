package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Learning_Soft_Assert {

	@Test
	public void loginTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		SoftAssert ast = new SoftAssert();
		ast.assertEquals(driver.getTitle(), "Demo Web", "Validating Wellcome Page by title");
		driver.findElement(By.linkText("Log in")).click();
		ast.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/login", "Validating Login Page by url");
		driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com",Keys.TAB,"nikhil123",Keys.ENTER);
		ast.assertEquals(driver.getTitle(), "Demo Web Shop", "Validating Home Page by title");
		Thread.sleep(3000);
		driver.quit();
		ast.assertAll();
		
	}
}
