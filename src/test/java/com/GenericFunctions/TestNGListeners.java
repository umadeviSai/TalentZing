package com.GenericFunctions;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.testng.IClass;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestMethodFinder;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;
import org.testng.xml.XmlTest;

import com.ReportGeneration.GenerateReports;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class TestNGListeners extends GenerateReports implements ITestListener,IInvokedMethodListener {
	
	public static Fillo fillo;
	
	public static Connection connection;
	
	public static String crntclass;
	

@Override
public void onTestStart(ITestResult result) {
	
	crntclass=result.getInstanceName().substring(result.getInstanceName().lastIndexOf(".")+1).trim();
	
	GenerateReports.intializeReports();
	
}





@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	
}





@Override
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	
}





@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}





@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}





@Override
public void onStart(ITestContext context) {

	convertExcelAsDataBase();
	
	
}





@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}





@Override
public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	// TODO Auto-generated method stub
	GenerateReports.startTest();
}





@Override
public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	// TODO Auto-generated method stub
	GenerateReports.closeTest();
}


public static  void convertExcelAsDataBase()
{
	
	
	try {
		
		fillo=new Fillo();
		connection=fillo.getConnection(System.getProperty("user.dir")+"\\Testdata\\Testdata.xlsx");
		
		System.out.println("Excel connection is Estlablished");
		
	} catch (FilloException e) {
		
		e.printStackTrace();
	}
	
	
	
}




}
