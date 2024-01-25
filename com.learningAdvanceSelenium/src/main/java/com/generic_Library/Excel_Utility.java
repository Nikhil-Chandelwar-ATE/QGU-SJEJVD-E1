package com.generic_Library;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public static String getSingleDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		
				FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData/testScriptData.xlsx");
				Workbook book = WorkbookFactory.create(fis);
				Sheet sheet = book.getSheet(sheetName);
				Row row = sheet.getRow(rowNum);
				Cell cell = row.getCell(cellNum);
				String value = cell.getStringCellValue();
				return value;
	}
	
	public static Object[][] getMultipleDataFromExcel(String sheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData/testScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][cellCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}