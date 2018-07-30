package com.ScreenFunctions;

import java.util.List;

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
	@FindBy(how=How.XPATH, using="//span[contains(text(),'*')]/parent::label")
	public static List<WebElement> List_RecRegform_Labels;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Please specify')]")
	public static List<WebElement> List_RecRegform_Validators;
	
	
	public static void FillRegForm()
	{
		String label="";
		try{
			
		hoverAndClick(Btn_RecRegform_Submit);
		if(hoverOverElement(Lbl_RecRegform_TandC))
			{
				forceClick(Chk_RecRegform_chkTerms);
				hoverAndClick(Btn_RecRegform_Submit);
			}
			
		for(int i=0;i<List_RecRegform_Labels.size();i++)	
		{
			label =List_RecRegform_Labels.get(i).getText();
			label=label.replace("*:","").trim().toLowerCase();
			if (i==9)
				label="contact number";
			
			if(List_RecRegform_Validators.get(i).getText().contains(label))
			{
				System.out.println(label +"---matching ----"+List_RecRegform_Validators.get(i).getText());
			}
			else 
			{
			    System.out.println(label +"---not matching----"+List_RecRegform_Validators.get(i).getText());
			}
			
			
			
			//System.out.println(List_RecRegform_Labels.get(i).getText());
			//System.out.println(List_RecRegform_Validators.get(i).getText());
		}
				
		
		}catch(Exception e)
		{
			
		}
		
		
	}
	
	

}
