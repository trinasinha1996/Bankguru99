package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.LoginPage;

public class Tc1loginpage extends BaseClass{
	@Test
	public void loginPage() throws Exception
	{
	
		
		log.info("url is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		log.info("Entered username");
		lp.setPassword(pwd);
		log.info("Entered password");
		lp.setLoginbtn();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("login test passed");
		}
		else
		{
			captureScreenshot( driver,"loginPage");
			Assert.assertTrue(false);
			log.info("login test failed");
		}
				
		
	}
	

}
