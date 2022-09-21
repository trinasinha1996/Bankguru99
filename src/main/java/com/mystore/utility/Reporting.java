package com.mystore.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onStart(ITestContext testContext) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timestamp+".html";
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		extent=new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("hostname","MyHost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","Trina");
		
		htmlreporter.config().setDocumentTitle("Guru99Bank");
		htmlreporter.config().setReportName("Guru99Bank automation report");
		htmlreporter.config().setTheme(Theme.DARK);
		
	}

	

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshot\\"+tr.getName()+".png";
		File f=new File(screenshotpath);
		if(f.exists())
		{
			try
			{
				logger.fail("fail screenshot is:"+logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		}
	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

	
	
}
	