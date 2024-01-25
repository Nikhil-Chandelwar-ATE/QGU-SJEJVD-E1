package com.learning_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic_Library.BaseTest_2;
import com.generic_Library.WebDriver_Utility;

@Listeners(com.generic_Library.Listener_Implementation.class)
public class Learning_ITestListener extends BaseTest_2{

	@Test
	public void addProductToCart() throws InterruptedException {
		
		driver.findElement(By.partialLinkText("APPAREL & SHOES")).click();
		driver.findElement(By.xpath("//a[text()='Blue Jeans']/ancestor::div[@class='details']/descendant::input")).click();
		driver.findElement(By.partialLinkText("Shopping cart")).click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		WebDriver_Utility.scrollToWebElement(driver, driver.findElement(By.xpath("//h1[text()='Shopping cart']")));
		Thread.sleep(2000);
	}
}
