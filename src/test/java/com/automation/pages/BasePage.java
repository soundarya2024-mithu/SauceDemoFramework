package com.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.utilities.WaitUtils;

public class BasePage {
	
	public WebDriver driver;
	public WaitUtils wait;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WaitUtils(driver);
	}
	

}
