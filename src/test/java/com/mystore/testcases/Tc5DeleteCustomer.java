package com.mystore.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.DeleteCustomer;
import com.mystore.pageobject.EditCustomer;
import com.mystore.pageobject.LoginPage;

public class Tc5DeleteCustomer extends BaseClass{
	@Test
	public void deleteCust() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		log.info("user name is provided");
		lp.setPassword(pwd);
		log.info("password is provided");
		lp.setLoginbtn();
		
		
		DeleteCustomer deletecust=new DeleteCustomer(driver);
		deletecust.deleteLink();
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(ele);
		driver.switchTo().frame(driver.findElement( By.id("ad_iframe")));
		driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		log.info("customer id provided");
		deletecust.custID("32219");
		deletecust.subBtn();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		deletecust.backHome();
		
		
	}

}
