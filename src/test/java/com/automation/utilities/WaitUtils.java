package com.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitUtils(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	public void waitForElementVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
