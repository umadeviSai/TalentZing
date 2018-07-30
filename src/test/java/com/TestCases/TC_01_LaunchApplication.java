package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Recurit_Reg_Form;
import com.ScreenFunctions.RegisterForm;

public class TC_01_LaunchApplication extends GenericFunctions {
	
	@Test
	public static void LaunchApplication_Validate()
	{
		launchApplication("chrome");
		RegisterForm regform=PageFactory.initElements(driver,RegisterForm.class);
		if (regform.clickRecruiter())
		{
			Recurit_Reg_Form recform=PageFactory.initElements(driver,Recurit_Reg_Form.class);
			recform.FillRegForm();
			
		}
		else
		{
			
		}
		
		
	}

}
