package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement pageTitle;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	public WebElement addToCartButton;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public WebElement cartIcon;
	
	public String getPageTitle() {
		wait.waitForElementVisibility(pageTitle);
		String title=pageTitle.getText();
		return title;
	}
	
	public void addToCartFunctionalityValidation() {
		wait.waitForElementClickable(addToCartButton);
		wait.waitForElementClickable(cartIcon);
		addToCartButton.click();
		cartIcon.click();
	}
	
	

}
