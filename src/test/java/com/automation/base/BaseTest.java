package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream file;
	public ExtentReports report=ExtentManager.getInstance();
	public ExtentTest test;
	
	@BeforeMethod
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();

        // 1️⃣ Disable Chrome password manager & autofill
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // 2️⃣ Extra arguments to avoid popups
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-save-password-bubble");

        // 3️⃣ Use a fresh temporary profile (prevents stored credentials from triggering popups)
        options.addArguments("--user-data-dir=/tmp/selenium_temp_profile"); // Linux/Mac
        // options.addArguments("--user-data-dir=C:/Temp/selenium_temp_profile"); // Windows

        // 4️⃣ Incognito mode for extra safety
        options.addArguments("--incognito");

        // 5️⃣ Optional: Headless mode (prevents all UI popups)
        // options.addArguments("--headless=new");
		if(driver==null) {
			try {
				prop=new Properties();
				file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
			}else if (prop.getProperty("browser").equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else if(prop.getProperty("browser").equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
			}
			
			driver.get(prop.getProperty("siteURL"));
			driver.manage().window().maximize();
			int wait=Integer.parseInt(prop.getProperty("wait_time"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
			
		}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
