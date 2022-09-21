package com.mystore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCustomer {
	WebDriver ldriver;
	public EditCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	@FindBy(linkText="Edit Customer")
	@CacheLookup
	private WebElement editcustlink;
	
	@FindBy(name="cusid")
	@CacheLookup
	private WebElement custid;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	private WebElement submitbtn;
	
	@FindBy(name="addr")
	@CacheLookup
	private WebElement address;
	
	@FindBy(name="sub")
	@CacheLookup
	private WebElement subbtn;
	
	@FindBy(linkText="Home")
	@CacheLookup
	private WebElement homelink;

	public void editCustLink()
	{
		editcustlink.click();
	}
	public void custID(String id)
	{
		custid.sendKeys(String.valueOf(id));
	}
	public void subBtn()
	{
		submitbtn.click();
	}
	public void editAddress(String editadd)
	{
		address.clear();
		address.sendKeys(editadd);
	}
	public void subButton()
	{
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click();", subbtn);

	}
	public void backHome()
	{
		homelink.click();
	}
}
