package com.learning_TestNG;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic_Library.Java_Utility;

public class Learning_Excel_File {

	@Test
	public void registerTest() throws Throwable {

		// Java representation object of excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData/testScriptData.xlsx");

		// open excel in read mode
		Workbook book = WorkbookFactory.create(fis);

		// Open sheet by name
		Sheet sheet = book.getSheet("registerData");

		// Go to Specific row
		Row row = sheet.getRow(1);

		// Go to specific cell
		Cell cell = row.getCell(0);

		// Fetch the data
		String firstName = cell.getStringCellValue();
		String lastName = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();
		String newEmail = email+Java_Utility.getRandomNumber()+"@gmail.com";
		String password = row.getCell(3).getStringCellValue();
		String cnfPassword = row.getCell(4).getStringCellValue();
		String gender = row.getCell(5).getStringCellValue();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");

		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(2000);
		if (gender.equals("M")) {
			driver.findElement(By.id("gender-male")).click();
		} else {
			driver.findElement(By.id("gender-female")).click();
		}

		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		driver.findElement(By.id("Email")).sendKeys(newEmail);
		System.out.println(driver.findElement(By.id("Email")).getAttribute("value"));
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(cnfPassword);
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
