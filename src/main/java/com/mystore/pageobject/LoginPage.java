package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	@FindBy(name="uid")
	@CacheLookup
	private WebElement usernametext;
	
	@FindBy(name="password")
	@CacheLookup
	private WebElement passwordtext;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	private WebElement btnclick;
	
	@FindBy(linkText="Log out")
	@CacheLookup
	private WebElement btnlogout;
	
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	public void setUsername(String username)
	{
		usernametext.sendKeys(username);
	}
	public void setPassword(String pwd)
	{
		passwordtext.sendKeys(pwd);
	}
	public void setLoginbtn()
	{
		btnclick.click();
	}
	public void setLogOut()
	{
		btnlogout.click();
	}


}
