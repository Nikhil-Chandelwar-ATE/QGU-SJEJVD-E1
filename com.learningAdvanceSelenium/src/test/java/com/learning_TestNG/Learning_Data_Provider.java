package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Learning_Data_Provider {

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		
		Object [][] data = new Object[3][2];
		data[0][0] = "nikhil26@gmail.com";
		data[0][1] = "nikhil123";
		
		data[1][0] = "123Manisha@gmail.com";
		data[1][1] = "Manisha2";
		
		data[2][0] = "princek621@gmail.com";
		data[2][1] = "Princek621@";
		
		return data;
	}
	
	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}
}