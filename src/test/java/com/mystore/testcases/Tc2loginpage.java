package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.XLUtils;

public class Tc2loginpage extends BaseClass{
	
	@Test(dataProvider="logindata")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp1=new LoginPage(driver);
		lp1.setUsername(user);
		log.info("user name provided");
		lp1.setPassword(pwd);
		log.info("password provided");
		lp1.setLoginbtn();
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			log.warn("login passed");
			lp1.setLogOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
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
	
	
	@DataProvider(name="logindata")
	public String[][] getData() throws Exception
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/mystore/TestData/logindata.xlsx";
		XLUtils ul=new XLUtils(path);
		int rowcount=ul.getRowCount("Sheet1");
		int cellcount=ul.getColCount("Sheet1",1);
		String[][] logindata= new String[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				logindata[i-1][j]=ul.getCellData("Sheet1",i,j);
			}
		}
	
		return logindata;
				
	}			
	
		
		
	

}
