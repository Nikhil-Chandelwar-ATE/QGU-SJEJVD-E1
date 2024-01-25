package com.testScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.generic_Library.BaseTest_2;
import com.generic_Library.WebDriver_Utility;
import com.object_Repository.Apparel_And_Shoes_Page;
import com.object_Repository.Cart_Page;
import com.object_Repository.Home_Page;
import com.object_Repository.Welcome_Page;

public class TC003_RemoveFromCart_Test extends BaseTest_2 {

	@Test(groups = "regressionTesting")
	public void removeProductFromCart() throws InterruptedException {
		
		Home_Page hp = new Home_Page(driver);
		hp.getApparelAndShoesLink().click();
		Apparel_And_Shoes_Page asp = new Apparel_And_Shoes_Page(driver);
		asp.getAddToCartButton().click();
		Welcome_Page wp = new Welcome_Page(driver);
		wp.getShoppingCartLink().click();
		Thread.sleep(1000);
		Cart_Page cp = new Cart_Page(driver);
		cp.getRemoveCheckBox().click();
		cp.getUpdateShoppingCartButton();
		driver.findElement(By.xpath("//input[@name='updatecart']")).click();
		WebDriver_Utility.scrollToWebElement(driver, cp.getShoppingCartHeading());
		WebDriver_Utility.takeScreenshotOfWebpage(driver, "shoppingCartSS2");
		Thread.sleep(2000);
	}
}
