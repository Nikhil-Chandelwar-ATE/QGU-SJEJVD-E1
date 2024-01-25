package com.learning_TestNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Learning_Priority_Attribute {

	@Test(priority = 1)
	public void registerTest() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Manisha",Keys.TAB,"Sahay",Keys.TAB,"manisha11@gmail.com",Keys.TAB,"manisha1",Keys.TAB,"manisha1",Keys.ENTER);
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("manisha11@gmail.com",Keys.TAB,"manisha1",Keys.ENTER);
		
		Thread.sleep(3000);
		driver.quit();
	}
}
