package com.mystore.base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mystore.utility.ReadConfig;

public class BaseClass {
	ReadConfig readcon=new ReadConfig();
	public String url=readcon.getApplicationUrl();
	public String username=readcon.getUsername();
	public String pwd=readcon.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		DOMConfigurator.configure("log4j.xml");
		log = Logger.getLogger("MyStoreproject");
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readcon.getChromepath());
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		driver=new ChromeDriver(opt);
		}
		else if(br.equals("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver",readcon.getFirefoxpath());
		driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		
	}
		
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(src,target);
		System.out.println("screenshot taken");
	}
	public String randomstring()
	{
		String randomalpha=RandomStringUtils.randomAlphabetic(8);
		return randomalpha;
	}
	public String randomnumber()
	{
		String randomno=RandomStringUtils.randomNumeric(10);
		return randomno;
	}

}
