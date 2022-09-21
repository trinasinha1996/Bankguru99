package com.mystore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteCustomer {
	WebDriver ldriver;
	public DeleteCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(linkText="Delete Customer")
	@CacheLookup
	private WebElement deletcustlink;
	
	@FindBy(xpath="//input[@onkeyup='validatecustomerid();']")
	@CacheLookup
	private WebElement custIdtext;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	private WebElement submitbtn;
	
	@FindBy(xpath="//a[text()='Home']")
	@CacheLookup
	private WebElement homelink;
	
	public void deleteLink()
	{
		deletcustlink.click();
	}
	public void custID(String id)
	{
		custIdtext.sendKeys(id);
	}
	public void subBtn()
	{
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click();", submitbtn);
	}
	public void backHome()
	{
		homelink.click();
	}

}
