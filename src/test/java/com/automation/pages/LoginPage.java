package com.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
	public static String currentUrl;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="user-name")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="login-button")
	public WebElement loginButton;
	
	
	
	public String login(String username, String passWord) {
		wait.waitForElementVisibility(userName);
		wait.waitForElementVisibility(password);
		wait.waitForElementClickable(loginButton);
		
		userName.sendKeys(username);
		password.sendKeys(passWord);
		loginButton.click();
		currentUrl=driver.getCurrentUrl();
		return currentUrl;
	}
}
