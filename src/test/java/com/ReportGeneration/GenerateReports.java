package com.ReportGeneration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.GenericFunctions.GenericFunctions;
import com.GenericFunctions.TestNGListeners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateReports {
	
	public static ExtentReports extent;
	
	
	public static ExtentTest test;
	
	public static String resultfile;
	
	
	public static void intializeReports()
	{
		
		extent=new ExtentReports(createResultFolder()+"\\"+TestNGListeners.crntclass+".html");
		resultfile=createResultFolder()+"\\"+TestNGListeners.crntclass+".html";
		
		extent.addSystemInfo("Project Name","Testing Masters Demo Project").
		addSystemInfo("Environment","QA")
		.addSystemInfo("Sprint Name","Sprint 1");
		
	
		extent.loadConfig(new File("extent.xml"));		
		
		
	}
	
	public static void startTest()
	{
		
		test=extent.startTest(TestNGListeners.crntclass);
	}
	
	
	public static void closeTest()
	{
		extent.endTest(test);
		extent.flush();
		
	}
	
	public static void logEvent(String status,String Description)
	{
		
		switch (status.toLowerCase()) {
		case "pass":
			
			test.log(LogStatus.PASS, Description+test.addScreenCapture(getScreenShot()));
			
			break;
			
		case "fail":
			
			test.log(LogStatus.FAIL, Description+test.addScreenCapture(getScreenShot()));
			
			break;
			
		case "warning":
			
			test.log(LogStatus.WARNING, Description);
			
			break;
		case "info":
			
			test.log(LogStatus.INFO, Description);
			
			break;	

		default:
			break;
		}
		
	}
	
	
	public static String getScreenShot()
	{
		TakesScreenshot sht=(TakesScreenshot) GenericFunctions.driver;
		
		String screenshot=sht.getScreenshotAs(OutputType.BASE64);
		
		return "data:image/png;base64,"+screenshot;
		
	}
	
	
	
	
	
	
	
	public static String createResultFolder()
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YY");
		
		String path="";
		
		File f=new File(System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date()).replace("/", "")+"\\"+TestNGListeners.crntclass);
		path=System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date()).replace("/", "")+"\\"+TestNGListeners.crntclass;
		
		if(!f.exists())
		{
			
			f.mkdirs();
		}
		
		return path;
	}

}
