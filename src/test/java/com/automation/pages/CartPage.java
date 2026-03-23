package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	public WebElement cartProductName;
	
	public String productValidation() {
		wait.waitForElementVisibility(cartProductName);
		String productName=cartProductName.getText();
		return productName;
	}

}
