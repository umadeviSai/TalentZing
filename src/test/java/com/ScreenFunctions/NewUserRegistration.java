	
	package com.ScreenFunctions;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.GenericFunctions;


	public class NewUserRegistration extends GenericFunctions {
		@FindBy(how=How.ID,using="id_gender1")
		public static WebElement Rdo_Registration_TitleMr;
		@FindBy(how=How.ID,using="id_gender2")
		public static WebElement Rdo_Registration_TitleMrs;
		@FindBy(how=How.ID,using="customer_firstname")
		public static WebElement Edi_Registration_Fname;
		@FindBy(how=How.ID,using="customer_lastname")
		public static WebElement Edi_Registration_Lname;
		@FindBy(how=How.ID,using="email")
		public static WebElement Edi_Registration_Email;
		@FindBy(how=How.ID,using="passwd")
		public static WebElement Edi_Registration_Password;
		@FindBy(how=How.ID,using="firstname")
		public static WebElement Edi_Registration_FirstName;
		@FindBy(how=How.ID,using="lastname")
		public static WebElement Edi_Registration_LastName;
		@FindBy(how=How.ID,using="company")
		public static WebElement Edi_Registration_Company;
		@FindBy(how=How.ID,using="address1")
		public static WebElement Edi_Registration_Add1;
		@FindBy(how=How.ID,using="address2")
		public static WebElement Edi_Registration_Add2;
		@FindBy(how=How.ID,using="city")
		public static WebElement Edi_Registration_City;
		@FindBy(how=How.ID,using="id_state")
		//@FindBy(how=How.XPATH,using="//label[contains(text(),'State')]/following-sibling::div/select/option[2]")
		public static WebElement Sel_Registration_State;
		@FindBy(how=How.ID,using="postcode")
		public static WebElement Edi_Registration_Pcode;
		@FindBy(how=How.ID,using="id_country")
		public static WebElement Sel_Registration_Country;
		@FindBy(how=How.ID,using="phone")
		public static WebElement Edi_Registration_Phone;
		@FindBy(how=How.ID,using="phone_mobile")
		public static WebElement Edi_Registration_Mobile;
		@FindBy(how=How.ID,using="My address")
		public static WebElement Edi_Registration_AddressName;
		@FindBy(how=How.ID,using="submitAccount")
		public static WebElement Btn_Registration_Register;
		
		
		public boolean Fill_Registration_Page()
		{
			boolean methodstatus=true;
			//Select state=new Select(Sel_Registration_State, "Try");
			
			
		    
		//Select Selstate= new Select(driver.findElement(By.xpath("//select[@id='id_state']"));
		
		
		
			waitForElement(Edi_Registration_Fname);
			try
			{
			setText(Edi_Registration_Fname, getdata("TestcaseData", "Fname", 1));
			setText(Edi_Registration_Lname, getdata("TestcaseData", "Lname", 1));
			setText(Edi_Registration_Password, getdata("TestcaseData", "Password", 1));
			setText(Edi_Registration_FirstName, getdata("TestcaseData", "FirstName", 1));
			setText(Edi_Registration_LastName, getdata("TestcaseData", "LastName", 1));
			setText(Edi_Registration_Company, getdata("TestcaseData", "Company", 1));
			setText(Edi_Registration_Add1, getdata("TestcaseData", "Address1", 1));
			setText(Edi_Registration_Add2, getdata("TestcaseData", "Address2", 1));			
			setText(Edi_Registration_City, getdata("TestcaseData", "City", 1));
			Select selstate= new Select(Sel_Registration_State);
			selstate.selectByIndex(4);
			//selstate.selectByValue(getdata("TestcaseData", "State", 1));
			setText(Edi_Registration_Pcode, getdata("TestcaseData", "Pincode", 1));
			setText(Edi_Registration_Phone, getdata("TestcaseData", "Phone", 1));
			setText(Edi_Registration_Mobile, getdata("TestcaseData", "Mobile", 1));
			setText(Edi_Registration_AddressName, getdata("TestcaseData", "AddressName", 1));
			hoverAndClick(Btn_Registration_Register);
			
			
			}catch (Exception e)
			{
				methodstatus=false;
				logEvent("Fail", "Couldn't Enter Data in the new user Registration form.");
			}
			return methodstatus;
		}
		
	}


