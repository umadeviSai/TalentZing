package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class RegisterForm extends GenericFunctions{

	@FindBy(how=How.XPATH, using="//span[@id='lnkRegistration']")
	public static WebElement Lnk_HomePage_Reg;
	@FindBy(how=How.XPATH, using="//span[@id='lblRecruiterReg']")
	public static WebElement Lnk_HomePage_Recruiter;
	
	
	
	
	public static boolean clickRecruiter()
	{
		boolean methodstatus = true;
		
		
		hoverOverElement(Lnk_HomePage_Reg);
		
		hoverAndClick(Lnk_HomePage_Recruiter);
		
		if(driver.getTitle().contains("Recruiter registration form - Talent Zing"))
				System.out.println("Suceesfully navigated to the Recruiter page");
		else
		{
			System.out.println("Page not loaded");
			methodstatus=false;
		}
		return methodstatus;
				
		
		
	}

	
	
	
}
