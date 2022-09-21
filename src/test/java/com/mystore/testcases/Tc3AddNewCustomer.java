package com.mystore.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddCustomer;
import com.mystore.pageobject.LoginPage;

public class Tc3AddNewCustomer extends BaseClass{
	@Test
	public void addNewCust() throws  Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		log.info("user name is provided");
		lp.setPassword(pwd);
		log.info("password is provided");
		lp.setLoginbtn();
		
		
		AddCustomer addcust=new AddCustomer(driver);
		addcust.clickNewCast();
		 Thread.sleep(5000);
		
		WebElement ele=driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(ele);
		driver.switchTo().frame(driver.findElement( By.id("ad_iframe")));
		driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		log.info("customer info details");
		addcust.setNameCast("Dipanjan Das");
		addcust.setGen("male");
		addcust.setDate("09","22","01");
		addcust.custAdd("Banipara garia");
		addcust.custCity("kolkata");
		Thread.sleep(3000);
		addcust.custState("WestBengal");
		addcust.custPin("7000154");
		addcust.custPh(randomnumber());
		addcust.custEmail(randomstring()+"@gmail.com");
		addcust.custPass("abcdwq");
		addcust.submitBtn();
		Thread.sleep(3000);
		log.info("customer validation start");
		Boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("test case passed");
		}
		else
		{
			log.info("test case failed");
			captureScreenshot(driver,"addNewcustomer");
			Assert.assertTrue(false);
		}
			
		
		
	}
	

}
