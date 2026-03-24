package com.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public FileInputStream file;
	public Workbook wb;
	
	public Object[][] getExcelData(String filePath, String sheetName){
		
		try {
			file=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet=wb.getSheet(sheetName);
		int row=sheet.getPhysicalNumberOfRows();
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data=new Object[row-1][col];
		
		for(int i=1; i<row; i++) {
			Row rows=sheet.getRow(i);
			for(int j=0; j<col;j++) {
				Cell cell=rows.getCell(j);
				data[i-1][j]=cell.toString();
			}
		}
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
