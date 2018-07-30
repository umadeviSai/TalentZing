package com.ScreenFunctions;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.GenericFunctions;

public class MyStore extends GenericFunctions {

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	public static WebElement Edi_MyStore_SignIn;
	@FindBy(how = How.XPATH, using = "//a[@title='Women']")
	public static WebElement Lnk_MyStore_Women;
	@FindBy(how = How.XPATH, using = "//a[@title='Women']/../ul/li//a")
	public static List<WebElement> Lnks_MyStore_Women;
	// "//li[@class='sfHoverForce']//a")
	@FindBy(how = How.XPATH, using = "//a[@title='Summer Dresses']")
	public static WebElement Lnk_MyStore_SummerDresses;
	@FindBy(how = How.XPATH, using = "//select[@id='selectProductSort']")
	public static WebElement Sel_MyStore_SortyBy;
	@FindBy(how = How.XPATH, using = "//div[@class='right-block']//span[@itemprop='price']")
	public static List<WebElement> List_MyStore_Price;

	public void SignIn_Click() {
		Edi_MyStore_SignIn.click();
	}

	public void ValidateLinks_MyStore() throws Exception {
		hoverOverElement(Lnk_MyStore_Women);
		Thread.sleep(2000);
		for (WebElement we : Lnks_MyStore_Women) {
			waitForElement(we);
			System.out.println(we.getText());
		}

		ValidateLinks(Lnks_MyStore_Women);
	}

	public boolean CheckFilterLowtoHigh() throws Exception {
		boolean methodstatus=true;
		Float minprice;
		hoverOverElement(Lnk_MyStore_Women);
		Thread.sleep(2000);
		hoverAndClick(Lnk_MyStore_SummerDresses);
		waitForElement(Sel_MyStore_SortyBy);
		Select SelSortyby = new Select(Sel_MyStore_SortyBy);
		SelSortyby.selectByValue("price:asc");
		Thread.sleep(4000);
		String strprice = List_MyStore_Price.get(0).getText();
		strprice = strprice.replace("$", "");
		minprice = Float.valueOf(strprice);
		System.out.println(minprice +"  Is the min price");
		for (WebElement we : List_MyStore_Price) {
			strprice = we.getText();
			strprice = strprice.replace("$", "");		
			  Float price=Float.valueOf(strprice); 
			  System.out.println(price);
			  if(price < minprice)
			  {
			  System.out.println("The Order is incorrect " );
			  logEvent("Fail","The sorted order is incorrect");
			  methodstatus=false;
			  break;			  
			  } 
			  else 
			  {   
				  minprice=price; 			  		 
			  } 			 		 
		}
		if(methodstatus)
		{
			logEvent("Pass","The sorted order is correct");
			System.out.println("The List is in Sorted Order.");
		}
		return methodstatus;
	}

}
