package com.testScripts;

import org.testng.annotations.Test;

import com.generic_Library.BaseTest_2;
import com.generic_Library.WebDriver_Utility;
import com.object_Repository.Search_Page;
import com.object_Repository.Welcome_Page;
import com.relevantcodes.extentreports.LogStatus;

public class TC001_Search_Test extends BaseTest_2 {

	@Test(groups = "smokeTesting")
	public void searchTest() throws InterruptedException {
		
		Welcome_Page wp = new Welcome_Page(driver);
		wp.getSearchTextField().sendKeys("books");
		wp.getSearchButton().click();
		test.log(LogStatus.FAIL, "Product not available");
		Thread.sleep(1000);
		Search_Page sp = new Search_Page(driver);
		WebDriver_Utility.scrollToWebElement(driver, sp.getSearchHeading());
		Thread.sleep(1000);
		WebDriver_Utility.takeScreenshotOfWebpage(driver, "searchScreenshot");
	}
}
