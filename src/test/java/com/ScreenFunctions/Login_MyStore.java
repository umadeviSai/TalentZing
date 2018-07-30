package com.ScreenFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;
import com.ReportGeneration.GenerateReports;
import com.thoughtworks.selenium.webdriven.commands.GetConfirmation;

public class Login_MyStore extends GenericFunctions {
	
	@FindBy(how=How.XPATH,using="//input[@id='email_create']")
	public static WebElement Edi_Login_Email;
	
	@FindBy(how=How.XPATH, using =".//*[@id='SubmitCreate']")
	public static WebElement Btn_Login_CreateAccount;
	@FindBy(how=How.XPATH, using ="//div[@class='alert alert-danger']/ol/li")
	public static WebElement Msg_Login_Duplicate;
	@FindBy(how=How.XPATH,using="//h1[text()='Authentication']")
	public static WebElement LblHdr_Login_Authentication;
	@FindBy(how=How.XPATH,using="//h3[text()='Create an account']")
	public static WebElement LblHdr_Login_CreateAccount;
	@FindBy(how=How.XPATH,using="//h3[text()='Already registered?']")
	public static WebElement LblHdr_Login_AlreadyRegistered;
	@FindBy(how=How.XPATH,using="//p[contains(text(),'Please enter your')]")
	public static WebElement Lbl_Login_EmailCreate;
	@FindBy(how=How.XPATH,using="//input[@id='email_create']/preceding-sibling::label[1]")
	public static WebElement Lbl_Login_Email1;
	@FindBy(how=How.XPATH,using="//input[@id='email']/preceding-sibling::label[1]")
	public static WebElement Lbl_Login_Email2;
	@FindBy(how=How.XPATH,using="//label[text()='Password']")
	public static WebElement Lbl_Login_Pwd;
	
	
	
	public void setEmailAddress() throws Exception
	{
		Edi_Login_Email.sendKeys(getdata("TestcaseData", "Email", 1));
		hoverAndClick(Btn_Login_CreateAccount);
		//Btn_Login_CreateAccount.click();
		Thread.sleep(2000);
		if(Msg_Login_Duplicate.isDisplayed())
		{System.out.println("The Email already exists in the System "+
		Msg_Login_Duplicate.getText());
		logEvent("PASS", "Report Log event :The Email Already exists");
		}
		
		else
		{System.out.println("The Email doesn't exist");
		logEvent("Fail", "The email doesn't exist in the system");}		
			}
	
	public boolean VerifySectionHeader(WebElement WE,String EText)
	{	boolean methodStatus=true;
	  try{
		  String expectedHeader= getdata("TestcaseData",EText,1);	
		String str= WE.getText().toString();
		String fsize=WE.getCssValue("font-weight");
		
		if(str.equals(expectedHeader.toUpperCase()) && fsize.equals("600"))
		
			logEvent("PASS","The Header is in Uppercase");
		else
			logEvent("Fail", "The header is not in uppercase");	
	  } catch (Exception e)
	  {
		  methodStatus=false;
		  logEvent("Fail", "Failed to validate the Header"); 
	  }
		
	  return methodStatus;
	}
	/* Method to compare the labels - First character should be in uppercase and 
	 * the remaining string is in lower case 
	 * EText is the expected status */
	public boolean VerifyLabels(WebElement WE,String EText)
	{    boolean methodStatus =true;
		try 
		{   String expectedLabel= getdata("TestcaseData",EText,1);
		  if(expectedLabel.equals(WE.getText()))
		  {
			String str=WE.getText().toString();
			String remainingstring=str.substring(1);
			String firstchar=str.substring(0,1);
			if(firstchar.equals(firstchar.toUpperCase()) && remainingstring.equals(remainingstring.toLowerCase()))
				{	
					logEvent("PASS", "The Label is in the correct format");
					System.out.println("the label is correct");
				}
			else
				{	
					methodStatus=false;
					logEvent("Fail","The Label is not in the correct format");
				}
		}
		}catch (Exception e)
		{
			methodStatus=false;
			logEvent("Fail","The Element couldn't be verified");
			
		}
		
		return methodStatus;
		
	}
/* Validate the page elements to validate all the page Headers and labels */
	public boolean ValidatePageElements()
	{	boolean methodstatus=true;
		try
		{
			VerifySectionHeader(LblHdr_Login_Authentication,"LblHdr_Login_Authentication");
			VerifySectionHeader(LblHdr_Login_CreateAccount,"LblHdr_Login_CreateAccount");
			VerifySectionHeader(LblHdr_Login_AlreadyRegistered,"LblHdr_Login_AlreadyRegistered");
			VerifyLabels(Lbl_Login_EmailCreate,"Lbl_Login_EmailCreate");
			VerifyLabels(Lbl_Login_Email1,"Lbl_Login_Email1");
			VerifyLabels(Lbl_Login_Email2,"Lbl_Login_Email2");
			VerifyLabels(Lbl_Login_Pwd,"Lbl_Login_Pwd");
		}catch(Exception e)
		{
			methodstatus=false;
			logEvent("Fail","The element is not found" +e.getMessage());
		}
		return methodstatus;
	}
	public boolean ValidateEmailColor()
	{  boolean methodstatus=true;
		try
		{	
			
			String Email=AppendDateNTime(getdata("TestcaseData", "Email", 1));
		System.out.println(Email);
		
		methodstatus=setText(Edi_Login_Email, Email);
		
		
		if(methodstatus)
		{
			System.out.println("User able to enter the data in Email field");
		}
		else
		{
			System.out.println("User unable to enter the data in Email field");
		}
		Edi_Login_Email.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		String color=Edi_Login_Email.getCssValue("color");
		if(color.equals("rgba(53, 179, 63, 1)"))
		{ 
			logEvent("Pass","The Email color code is correct");
			System.out.println("The color is "+color+"is correct");
		}
		else
		{
			methodstatus=false;
			System.out.println("The color is "+color+"is not correct");
			logEvent("Fail","The email color code is not correct");
			
		}
		
		}catch(Exception e)
		{
			methodstatus =false;
			logEvent("Fail","Unable to verify the color of the Email box" +e.getMessage());
			System.out.println("The Email color couldn't be validated");
			
		}
		return methodstatus;
	}
	
	public boolean EmailChkCreateAct()
	{	
		boolean methodstatus =true;
		if(ValidateEmailColor())
			Btn_Login_CreateAccount.click();		
		else methodstatus = false;
		return methodstatus;	
		
	}
	

}
