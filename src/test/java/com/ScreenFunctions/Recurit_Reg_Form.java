package com.ScreenFunctions;

import javax.net.ssl.HostnameVerifier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Recurit_Reg_Form extends GenericFunctions{
	
	@FindBy(how=How.XPATH, using="//input[@type='submit']")
	public static WebElement Btn_RecRegform_Submit;
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder2_lblCheck']")
	public static WebElement Lbl_RecRegform_TandC;	
	@FindBy(how=How.XPATH, using="//input[@id='chkTerms']")
	public static WebElement Chk_RecRegform_chkTerms;
	
	public static void FillRegForm()
	{
		try{
			
		hoverAndClick(Btn_RecRegform_Submit);
		if(hoverOverElement(Lbl_RecRegform_TandC)){
			forceClick(Chk_RecRegform_chkTerms);
		}
		
		}catch(Exception e)
		{
			
		}
		
		
	}
	
	

}
