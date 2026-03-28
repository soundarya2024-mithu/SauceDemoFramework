package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
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
		//System.out.println(productName);
		 String xpath = "//div[text()='" + productName.trim() + "']" +
                 "/ancestor::div[@class='inventory_item']" +
                 "//button";

		 WebElement addButton = driver.findElement(By.xpath(xpath));
		 wait.waitForElementClickable(addButton);
		 addButton.click();

		 System.out.println("Added product: " + productName);
	}
			
		//addToCartButton.click();
		//cartIcon.click();
	}
	
	


