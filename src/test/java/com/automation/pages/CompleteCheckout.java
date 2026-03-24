package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteCheckout extends BasePage{

	public CompleteCheckout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement completeCheckoutTitle;
	
	@FindBy(xpath="//h2[@class='complete-header']")
	public WebElement checkoutMessage;
	
	@FindBy(id="back-to-products")
	public WebElement backHomebutton;
	
	public String completeCheckoutTitleValidation() {
		String completeTitle=completeCheckoutTitle.getText();
		
		return completeTitle;
	}
	
	public String checkoutMessageValidation() {
		String message=checkoutMessage.getText();
		return message;
	}
	
	public void backHome() {
		backHomebutton.click();
	}

}
