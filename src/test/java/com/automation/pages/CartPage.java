package com.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	public List<WebElement> cartProductName;
	
	public List<String> productValidation() {
		List<String> actualProducts=new ArrayList<>();
		for (WebElement el : cartProductName) {
			actualProducts.add(el.getText().trim());
		}
		return actualProducts;
	}

}
