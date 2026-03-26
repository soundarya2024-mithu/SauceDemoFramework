package com.automation.test;

import org.testng.Assert;
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
	
	public void loginTest(String user, String pass, String productName) {
		
		LoginPage lp=new LoginPage(driver);
		
		lp.login(user, pass);
		if(LoginPage.currentUrl.contains("inventory")) {
			System.out.println("Login executed!!!  "+user);
			
			InventoryPage ip=new InventoryPage(driver);
			Assert.assertEquals(ip.getPageTitle(), "Products");
			System.out.println("Product title found corretly!!!");
			String[] products=productName.split(",");
			System.out.println(products);
			for (String prod : products) {
				System.out.println(prod);
				ip.addToCartFunctionalityValidation(prod);
			}
			ip.cartIcon.click();
			cartPageValidation();
			checkoutPageValidation();
			overviewCheckoutValidation();
			completeChecoutValidation();
			 
			driver.navigate().to("https://www.saucedemo.com/");
		}
		else {
			System.out.println("Login Failed!!! "+user);
		}		
	}
	
	public void cartPageValidation(){
		CartPage cp=new CartPage(driver); 
		String actualProduct=cp.productValidation();
		  Assert.assertEquals(actualProduct,"Sauce Labs Backpack");
		 System.out.println("cart product validation successfull "+actualProduct);
		 String currentUrl=driver.getCurrentUrl();
		System.out.println("url: "+currentUrl); 
	}
	
	public void checkoutPageValidation() {
		CheckoutPage cop=new
				 CheckoutPage(driver); 
				cop.checkoutValidation(); 
	}
	
	public void overviewCheckoutValidation() {
		OverviewCheckout oc=new
				 OverviewCheckout(driver); String pageTitle=oc.titleValidation();
				 Assert.assertEquals(pageTitle, "Checkout: Overview");
				  System.out.println("Checkout overview validated!!!"); 
				  oc.finishShopping();
	}
	
	public void completeChecoutValidation() {
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
		 
	}
	

}
