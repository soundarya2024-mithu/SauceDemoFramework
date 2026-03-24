package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewCheckout extends BasePage{

	public OverviewCheckout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[@class='title']")
	public WebElement chekoutTitle;
	
	@FindBy(id="finish")
	public WebElement finish;
	
	public String titleValidation() {
		String titleVerify=chekoutTitle.getText();
		return titleVerify;
	}
	
	public void finishShopping() {
		finish.click();
	}
}
