package iHTC_Testcases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IHTC_wdMethods.ProjectMethods;
import iHTC_page.IHTC_Login_Page;
import iHTC_page.IHTC_Messaging;

public class TC_CA_Message_Upgradetoseller extends ProjectMethods {
	
	private String Admin_Username="";
	private String Admin_Password="";
	private String Chrome_Buyer="";
	private String Firefox_Buyer="";
	private String Safari_Buyer="";
	private String Edge_Buyer="";
	
	private String DOB="";
	private String Addressline1="";
	private String City="";
	private String Zipcode="";
	private String SSN="";
	private String Jobtitle="";
	private String URL="";
	private String productdescription="";
	private String accountholdername="";
	private String routingnumber="";
	private String accountnumber="";
	private String resellerexpdate="";
	private String fpath="";
	
	
	private String Chrome_Username="";
	private String Chrome_Password="";
	private String Firefox_Username="";
	private String Firefox_Password="";
	private String Edge_Username="";
	private String Edge_Password="";
	private String Safari_Username="";
	private String Safari_Password="";
	
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Message_Upgradetoseller";
		testDescription = "To validate the company admin able to upgrade the seller to buyer or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void admin_Upgradetobuyer() throws AWTException
	{
	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			fpath= prop.getProperty("PATH_UPLOAD_FILE");
			
			String browser=driver.getCapabilities().getBrowserName();
			
			System.out.println(browser);
			
			if(browser.contains("chrome"))
			{
				Chrome_Username=prop.getProperty("CHROME_USERNAME");
				Chrome_Password=prop.getProperty("CHROME_PASSWORD");
				
				DOB= prop.getProperty("CHROME_UPGRADETOSELLER_DOB");
				Addressline1= prop.getProperty("CHROME_UPGRADETOSELLER_ADDRESSLINE1");
				City= prop.getProperty("CHROME_UPGRADETOSELLER_CITY");
				Zipcode= prop.getProperty("CHROME_UPGRADETOSELLER_ZIPCODE");
				SSN= prop.getProperty("CHROME_UPGRADETOSELLER_SSN");
				Jobtitle= prop.getProperty("CHROME_UPGRADETOSELLER_JOBTITLE");
				URL= prop.getProperty("CHROME_UPGRADETOSELLER_URL");
				productdescription= prop.getProperty("CHROME_UPGRADETOSELLER_PRODUCTDESCRIPTION");
				accountholdername= prop.getProperty("CHROME_UPGRADETOSELLER_ACCOUNTHOLDERNAME");
				routingnumber= prop.getProperty("CHROME_UPGRADETOSELLER_ROUTINGNUMBER");
				accountnumber= prop.getProperty("CHROME_UPGRADETOSELLER_ACCOUNTNUMBER");
				resellerexpdate= prop.getProperty("CHROME_UPGRADETOSELLER_RESELLEREXPIRATIONDATE");
				
				 Map<String, String> map 
		            = new HashMap<String,String>();
				 
				 map.put("URL", URL);
				 map.put("productdescription", productdescription);
				 map.put("accountholdername", accountholdername);
				 map.put("routingnumber", routingnumber);
				 map.put("accountnumber", accountnumber);
				 map.put("resellerexpdate", resellerexpdate);
				 map.put("DOB", DOB);
				 map.put("Addressline1", Addressline1);
				 map.put("City", City);
				 map.put("Zipcode", Zipcode);
				 map.put("SSN", SSN);
				 map.put("Jobtitle", Jobtitle);
				 map.put("FPATH", fpath);
				 
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Chrome_Username, Chrome_Password)
				.clickcompany()
				.upgradetoseller(map);
				
				
				new IHTC_Messaging(driver, test)
				.Upgradetoseller_Messagecheck();
				
			}
			
			else if(browser.contains("firefox"))
			{
				Firefox_Username=prop.getProperty("FIREFOX_USERNAME");
				Firefox_Password=prop.getProperty("FIREFOX_PASSWORD");
				
				DOB= prop.getProperty("FIREFOX_UPGRADETOSELLER_DOB");
				Addressline1= prop.getProperty("FIREFOX_UPGRADETOSELLER_ADDRESSLINE1");
				City= prop.getProperty("FIREFOX_UPGRADETOSELLER_CITY");
				Zipcode= prop.getProperty("FIREFOX_UPGRADETOSELLER_ZIPCODE");
				SSN= prop.getProperty("FIREFOX_UPGRADETOSELLER_SSN");
				Jobtitle= prop.getProperty("FIREFOX_UPGRADETOSELLER_JOBTITLE");
				URL= prop.getProperty("FIREFOX_UPGRADETOSELLER_URL");
				productdescription= prop.getProperty("FIREFOX_UPGRADETOSELLER_PRODUCTDESCRIPTION");
				accountholdername= prop.getProperty("FIREFOX_UPGRADETOSELLER_ACCOUNTHOLDERNAME");
				routingnumber= prop.getProperty("FIREFOX_UPGRADETOSELLER_ROUTINGNUMBER");
				accountnumber= prop.getProperty("FIREFOX_UPGRADETOSELLER_ACCOUNTNUMBER");
				resellerexpdate= prop.getProperty("FIREFOX_UPGRADETOSELLER_RESELLEREXPIRATIONDATE");
				
				Map<String, String> map 
	            = new HashMap<String,String>();
			 
			 map.put("URL", URL);
			 map.put("productdescription", productdescription);
			 map.put("accountholdername", accountholdername);
			 map.put("routingnumber", routingnumber);
			 map.put("accountnumber", accountnumber);
			 map.put("resellerexpdate", resellerexpdate);
			 map.put("DOB", DOB);
			 map.put("Addressline1", Addressline1);
			 map.put("City", City);
			 map.put("Zipcode", Zipcode);
			 map.put("SSN", SSN);
			 map.put("Jobtitle", Jobtitle);
			 map.put("FPATH", fpath);
				
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Firefox_Username, Firefox_Password)
				.clickcompany()
				.upgradetoseller(map);
				
				
				new IHTC_Messaging(driver, test)
				.Upgradetoseller_Messagecheck();
				
			}
			
			else if(browser.contains("Safari"))
			{
				Safari_Username=prop.getProperty("SAFARI_USERNAME");
				Safari_Password=prop.getProperty("SAFARI_PASSWORD");
				
				DOB= prop.getProperty("SAFARI_UPGRADETOSELLER_DOB");
				Addressline1= prop.getProperty("SAFARI_UPGRADETOSELLER_ADDRESSLINE1");
				City= prop.getProperty("SAFARI_UPGRADETOSELLER_CITY");
				Zipcode= prop.getProperty("SAFARI_UPGRADETOSELLER_ZIPCODE");
				SSN= prop.getProperty("SAFARI_UPGRADETOSELLER_SSN");
				Jobtitle= prop.getProperty("SAFARI_UPGRADETOSELLER_JOBTITLE");
				URL= prop.getProperty("SAFARI_UPGRADETOSELLER_URL");
				productdescription= prop.getProperty("SAFARI_UPGRADETOSELLER_PRODUCTDESCRIPTION");
				accountholdername= prop.getProperty("SAFARI_UPGRADETOSELLER_ACCOUNTHOLDERNAME");
				routingnumber= prop.getProperty("SAFARI_UPGRADETOSELLER_ROUTINGNUMBER");
				accountnumber= prop.getProperty("SAFARI_UPGRADETOSELLER_ACCOUNTNUMBER");
				resellerexpdate= prop.getProperty("SAFARI_UPGRADETOSELLER_RESELLEREXPIRATIONDATE");
				
				Map<String, String> map 
	            = new HashMap<String,String>();
			 
			 map.put("URL", URL);
			 map.put("productdescription", productdescription);
			 map.put("accountholdername", accountholdername);
			 map.put("routingnumber", routingnumber);
			 map.put("accountnumber", accountnumber);
			 map.put("resellerexpdate", resellerexpdate);
			 map.put("DOB", DOB);
			 map.put("Addressline1", Addressline1);
			 map.put("City", City);
			 map.put("Zipcode", Zipcode);
			 map.put("SSN", SSN);
			 map.put("Jobtitle", Jobtitle);
			 map.put("FPATH", fpath);
				
				
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Safari_Username, Safari_Password)
				.clickcompany()
				.upgradetoseller(map);
				
			
				new IHTC_Messaging(driver, test)
				.Upgradetoseller_Messagecheck();
			}
			
			else if(browser.contains("MicrosoftEdge"))
			{
				Edge_Username=prop.getProperty("EDGE_USERNAME");
				Edge_Password=prop.getProperty("EDGE_PASSWORD");
				
				DOB= prop.getProperty("EDGE_UPGRADETOSELLER_DOB");
				Addressline1= prop.getProperty("EDGE_UPGRADETOSELLER_ADDRESSLINE1");
				City= prop.getProperty("EDGE_UPGRADETOSELLER_CITY");
				Zipcode= prop.getProperty("EDGE_UPGRADETOSELLER_ZIPCODE");
				SSN= prop.getProperty("EDGE_UPGRADETOSELLER_SSN");
				Jobtitle= prop.getProperty("EDGE_UPGRADETOSELLER_JOBTITLE");
				URL= prop.getProperty("EDGE_UPGRADETOSELLER_URL");
				productdescription= prop.getProperty("EDGE_UPGRADETOSELLER_PRODUCTDESCRIPTION");
				accountholdername= prop.getProperty("EDGE_UPGRADETOSELLER_ACCOUNTHOLDERNAME");
				routingnumber= prop.getProperty("EDGE_UPGRADETOSELLER_ROUTINGNUMBER");
				accountnumber= prop.getProperty("EDGE_UPGRADETOSELLER_ACCOUNTNUMBER");
				resellerexpdate= prop.getProperty("EDGE_UPGRADETOSELLER_RESELLEREXPIRATIONDATE");
				
				Map<String, String> map 
	            = new HashMap<String,String>();
			 
			 map.put("URL", URL);
			 map.put("productdescription", productdescription);
			 map.put("accountholdername", accountholdername);
			 map.put("routingnumber", routingnumber);
			 map.put("accountnumber", accountnumber);
			 map.put("resellerexpdate", resellerexpdate);
			 map.put("DOB", DOB);
			 map.put("Addressline1", Addressline1);
			 map.put("City", City);
			 map.put("Zipcode", Zipcode);
			 map.put("SSN", SSN);
			 map.put("Jobtitle", Jobtitle);
			 map.put("FPATH", fpath);
				
				
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Edge_Username, Edge_Password)
				.clickcompany()
				.upgradetoseller(map);
				
				
				new IHTC_Messaging(driver, test)
				.Upgradetoseller_Messagecheck();
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}


}
