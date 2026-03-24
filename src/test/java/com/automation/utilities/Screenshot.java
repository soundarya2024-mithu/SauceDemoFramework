package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.automation.base.BaseTest;

public class Screenshot extends BaseTest{
	
	static WebDriver driver;
	public static String path;
	
	public static void captureScreenshot() {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		path=System.getProperty("user.dir")+"\\src\\test\\resources\\failureScreenshot\\Error.png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		return excel.getExcelData(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testData.xlsx",m.getName());
	}

}
