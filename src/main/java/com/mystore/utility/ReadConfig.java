package com.mystore.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public static Properties pro;
	public ReadConfig() 
	{
		try
		{
		FileInputStream fis=new FileInputStream("C:\\Users\\arupk\\eclipse-workspace\\MyStoreProject\\config.properties");
		pro=new Properties();
		pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: " +e.getMessage());
		}
	}
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseurl");
		return url;
	}
	public  String getUsername()
	{
		String user=pro.getProperty("username");
		return user;
	}
	public String getPassword()
	{
		String password=pro.getProperty("pwd");
		return password;
	}
	public String getChromepath()
	{
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	public String getFirefoxpath()
	{
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}

}
