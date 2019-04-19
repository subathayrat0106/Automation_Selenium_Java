package com.yorkland_admin.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelManager {

	private static XSSFWorkbook wb;
	private static XSSFSheet excelSheet;
	private static String excelFilePath;

	public ExcelManager(String excelFilePath) {
		ExcelManager.excelFilePath = excelFilePath;
	}

	public String[][] getCellData(String sheetName){
		String[][] arrayExcelData = null;
		try {
			wb = new XSSFWorkbook(excelFilePath);
			excelSheet = wb.getSheet(sheetName);
			int totalNumberOfRows = excelSheet.getLastRowNum();
			int totlNumberOfCols = excelSheet.getRow(0).getLastCellNum();
			
			arrayExcelData = new String[totalNumberOfRows][totlNumberOfCols];
			for(int i = 0; i<totalNumberOfRows ;i++) {
				for(int j = 0; j < totlNumberOfCols; j++) {
					XSSFCell cell = excelSheet.getRow(i+1).getCell(j);
					DataFormatter formatter = new DataFormatter();
					arrayExcelData [ i ][ j ] = formatter.formatCellValue(cell);
				}
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	
	public void setCellData(String sheetName, int row, int col, String value) {
		try {
				File file = new File (excelFilePath);
				FileInputStream inputStream = new FileInputStream (file);
				wb = new XSSFWorkbook(inputStream);
				excelSheet = wb.getSheet(sheetName);
				Row excelrow = excelSheet.getRow(row -1);
				excelrow.createCell(col -1).setCellValue(value);
				inputStream.close();
				FileOutputStream outputStream = new FileOutputStream(file);
				wb.write(outputStream);
				outputStream.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getCellData(String sheetName, int row , int col) {
		String celldata = null;
		try {
			wb = new XSSFWorkbook(excelFilePath);
			excelSheet = wb.getSheet(sheetName);
			celldata = excelSheet.getRow(row - 1).getCell(col - 1).getStringCellValue();		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return celldata;
	}
	
	public String randomDataFromExcelSheet(String sheetName, int row) {
		String celldata = null;
		try {
			wb = new XSSFWorkbook(excelFilePath);
			excelSheet = wb.getSheet(sheetName);
			int lastRow = excelSheet.getRow(row - 1).getLastCellNum();
			Random rand = new Random();
			int randomCol = rand.nextInt(lastRow);
			celldata = excelSheet.getRow(row - 1).getCell(randomCol).getStringCellValue();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return celldata;
	}
}
