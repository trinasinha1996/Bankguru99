package com.mystore.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddCustomer;
import com.mystore.pageobject.EditCustomer;
import com.mystore.pageobject.LoginPage;

public class Tc4EditCustomer extends BaseClass {
	@Test
	public void editCust() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		log.info("user name is provided");
		lp.setPassword(pwd);
		log.info("password is provided");
		lp.setLoginbtn();
		
		
		EditCustomer editcust=new EditCustomer(driver);

		editcust.editCustLink();
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(ele);
		driver.switchTo().frame(driver.findElement( By.id("ad_iframe")));
		driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		log.info("customer id provided");
		editcust.custID("50130");
		editcust.subBtn();
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			editcust.backHome();
			log.info("customer not exist");
		}
		else
		{
			Assert.assertTrue(true);
			log.info("customer exist");
			editcust.editAddress("Darjeeling");
			editcust.subButton();
			driver.switchTo().alert().accept();
			editcust.backHome();
			
			
		}
	}
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
		
		
	

}
