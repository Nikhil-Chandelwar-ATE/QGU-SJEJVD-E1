package com.generic_Library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class WebDriver_Utility {

	public static void takeScreenshotOfWebpage(WebDriver driver, String screenshotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srs = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/test/resources/screenshots/" +screenshotName+ ".png");

		try {
			FileHandler.copy(srs, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrollToWebElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static String getScreenshotPath(WebDriver driver) {
		
		String path = "./src/test/resources/screenshots/" +Java_Utility.getName()+ ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srs = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);

		try {
			FileHandler.copy(srs, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+path;
	}
}
