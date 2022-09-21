package com.mystore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer 
{
	WebDriver ldriver;
	public AddCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(linkText="New Customer")
	@CacheLookup
	private WebElement custonmerbtn;
	
	@FindBy(name="name")
	@CacheLookup
	private WebElement customernametxt;
	
	@FindBy(name="rad1")
	@CacheLookup
	private WebElement genderradiobtn;
	
	@FindBy(name="dob")
	@CacheLookup
	private WebElement datetext;
	
	@FindBy(name="addr")
	@CacheLookup
	private WebElement addresstext;
	
	@FindBy(name="city")
	@CacheLookup
	private WebElement citytext;
	
	@FindBy(name="state")
	@CacheLookup
	private WebElement statetxt;
	
	@FindBy(name="pinno")
	@CacheLookup
	private WebElement pintext;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	private WebElement phtext;
	
	@FindBy(name="emailid")
	@CacheLookup
	private WebElement emailtext;
	
	@FindBy(name="password")
	@CacheLookup
	private WebElement passtext;
	
	@FindBy(xpath="//input[@name='sub']")
	@CacheLookup
	private WebElement subbtn;
	
	public void clickNewCast()
	{
		custonmerbtn.click();
	}
	public void setNameCast(String cname)
	{
		customernametxt.sendKeys(cname);
	}
	public void setGen(String cgender)
	{
		genderradiobtn.click();
	}
	public void setDate(String mm,String dd,String yy)
	{
		datetext.sendKeys(mm);
		datetext.sendKeys(dd);
		datetext.sendKeys(yy);
	}
	public void custAdd(String address)
	{
		addresstext.sendKeys(address);
	}
	public void custCity(String city)
	{
		citytext.sendKeys(city);
	}
	public void custState(String state)
	{
		statetxt.sendKeys(state);
	}
	public void custPin(String pin)
	{
		pintext.sendKeys(String.valueOf(pin));
	}
	public void custPh(String ph)
	{
		phtext.sendKeys(ph);
	}
	public void custEmail(String email)
	{
		emailtext.sendKeys(email);
	}
	public void custPass(String pass)
	{
		passtext.sendKeys(pass);
	}
	public void submitBtn()
	{
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click();", subbtn);
	}

}
