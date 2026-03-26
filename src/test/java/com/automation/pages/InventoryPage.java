package com.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[@class='title']")
	public WebElement pageTitle;
	
	@FindBy(xpath = "//div[@class='inventory_item_name '] ")
	public List<WebElement> productsName;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	public List<WebElement> addToCartButton;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public WebElement cartIcon;
	
	public String getPageTitle() {
		wait.waitForElementVisibility(pageTitle);
		String title=pageTitle.getText();
		return title;
	}
	
	public void addToCartFunctionalityValidation(String productName) {
		for(int i=0; i<=productsName.size(); i++) {
			String name=productsName.get(i).getText();
			if(name.equalsIgnoreCase(productName)) {
				wait.waitForElementClickable(addToCartButton.get(i));
				addToCartButton.get(i).click();
				break;
			}
		}
		//addToCartButton.click();
		//cartIcon.click();
	}
	
	

}
