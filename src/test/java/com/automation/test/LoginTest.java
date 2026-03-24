package com.automation.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.CompleteCheckout;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import com.automation.pages.OverviewCheckout;
import com.automation.utilities.Screenshot;

public class LoginTest extends BaseTest {
	
	@Test(dataProviderClass = Screenshot.class, dataProvider  = "dp")
	
	public void loginTest(String user, String pass) {
		/*
		 * String user=prop.getProperty("username"); String
		 * pass=prop.getProperty("password");
		 */
		
		LoginPage lp=new LoginPage(driver);
		
		lp.login(user, pass);
		if(LoginPage.currentUrl.contains("inventory")) {
			System.out.println("Login executed!!!  "+user);
			InventoryPage inventry=new InventoryPage(driver);
			String actualTitle=inventry.getPageTitle(); 
			Assert.assertEquals(actualTitle,"Products"); System.out.println("Product title found corretly");
			inventry.addToCartFunctionalityValidation();
			CartPage cp=new CartPage(driver);
			String actualProduct=cp.productValidation(); Assert.assertEquals(actualProduct,"Sauce Labs Backpack");
			System.out.println("cart product validation successfull "+actualProduct);
			String currentUrl=driver.getCurrentUrl(); System.out.println("url: "+currentUrl);
			CheckoutPage cop=new CheckoutPage(driver);
			cop.checkoutValidation();
			OverviewCheckout oc=new OverviewCheckout(driver);
			String pageTitle=oc.titleValidation();
			Assert.assertEquals(pageTitle, "Checkout: Overview");
			System.out.println("Checkout overview validated!!!");
			oc.finishShopping();
			CompleteCheckout cckp=new CompleteCheckout(driver);
			String titleverify=cckp.completeCheckoutTitleValidation();
			Assert.assertEquals(titleverify, "Checkout: Complete!");
			System.out.println("checkout complete title validated!!!");
			
			String messageVerify=cckp.checkoutMessageValidation();
			Assert.assertEquals(messageVerify, "Thank you for your order!");
			System.out.println("Message validated!!!");
			cckp.backHome();
			
			String cururl=driver.getCurrentUrl();
			System.out.println("redirected to home page: "+cururl);
			driver.navigate().to("https://www.saucedemo.com/");
		}
		else {
			System.out.println("Login Failed!!! "+user);
		}
		
		
	}

}
