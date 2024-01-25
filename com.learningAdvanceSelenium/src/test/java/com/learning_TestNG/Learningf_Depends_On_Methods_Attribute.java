package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Learningf_Depends_On_Methods_Attribute {

	@Test
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
	
	@Test(dependsOnMethods = "registerTest")
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
	
	@Test(dependsOnMethods = {"registerTest", "loginTest"})
	public void searchTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("nikhil123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.id("small-searchterms")).sendKeys("mobile",Keys.ENTER);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
