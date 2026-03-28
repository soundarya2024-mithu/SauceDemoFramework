package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="checkout")
	public WebElement checkoutButton;
	
	@FindBy(id="first-name")
	public WebElement firstName;
	
	@FindBy(id="last-name")
	public WebElement lastName;
	
	@FindBy(id="postal-code")
	public WebElement postalCode;
	
	@FindBy(id="continue")
	public WebElement continueButton;
	
	public void checkoutValidation() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
		checkoutButton.click();
		firstName.sendKeys("soundarya");
		lastName.sendKeys("Ramesh");
		postalCode.sendKeys("632059");
		continueButton.click();
	}

}
