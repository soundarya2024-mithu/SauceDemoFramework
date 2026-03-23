package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() {
		String user=prop.getProperty("username");
		String pass=prop.getProperty("password");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.login(user, pass);
		System.out.println("Login executed");
		
		InventoryPage inventry=new InventoryPage(driver);
		
		String actualTitle=inventry.getPageTitle();
		Assert.assertEquals(actualTitle, "Products");
		System.out.println("Product title found corretly");
		
		inventry.addToCartFunctionalityValidation();
		
		CartPage cp=new CartPage(driver);
		String actualProduct=cp.productValidation();
		Assert.assertEquals(actualProduct, "Sauce Labs Backpack");
		
		System.out.println("cart product validation successfull "+actualProduct);
		
		String currentUrl=driver.getCurrentUrl();
		System.out.println("url: " +currentUrl);
	}
}
