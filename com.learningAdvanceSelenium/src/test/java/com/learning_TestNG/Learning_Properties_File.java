package com.learning_TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Learning_Properties_File {

	@Test(invocationCount = 5)
	public void loginTest() throws InterruptedException, IOException {
		
		//Java Representation Object of external file
		FileInputStream fis = new FileInputStream("./src/test/resources/commanData/commanData.properties");
		
		//Class which is used to work on properties file
		Properties prop = new Properties();
		
		//To load all the keys in Properties class
		prop.load(fis);
		
		//Fetching value by passing key
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(USERNAME);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
