package iHTC_Testcases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IHTC_wdMethods.ProjectMethods;
import iHTC_page.IHTC_Login_Page;
import iHTC_page.IHTC_Messaging;

public class TC_CA_Feature_Upgradetobyer extends ProjectMethods {
	
	private String Chrome_Buyer_Username="";
	private String Chrome_Buyer_Password="";
	private String Firefox_Buyer_Username="";
	private String Firefox_Buyer_Password="";
	private String Safari_Buyer_Username="";
	private String Safari_Buyer_Password="";
	private String Edge_Buyer_Username="";
	private String Edge_Buyer_Password="";
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Feature_Upgradetobyer";
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
			
			String browser=driver.getCapabilities().getBrowserName();
			
			System.out.println(browser);
			
			if(browser.contains("chrome"))
			{
				Chrome_Buyer_Username= prop.getProperty("CHROME_BUYER_USERNAME");
				Chrome_Buyer_Password= prop.getProperty("CHROME_BUYER_PASSWORD");
				
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Chrome_Buyer_Username, Chrome_Buyer_Password)
				.clickcompany()
				.upgradetobuyer();
			}
			
			if(browser.contains("firefox"))
			{
				Firefox_Buyer_Username= prop.getProperty("FIREFOX_BUYER_USERNAME");
				Firefox_Buyer_Password= prop.getProperty("FIREFOX_BUYER_PASSWORD");
				
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Firefox_Buyer_Username, Firefox_Buyer_Password)
				.clickcompany()
				.upgradetobuyer();
				
			}
			
			if(browser.contains("Safari"))
			{
				Safari_Buyer_Username= prop.getProperty("SAFARI_BUYER_USERNAME");
				Safari_Buyer_Password= prop.getProperty("SAFARI_BUYER_PASSWORD");
				
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Safari_Buyer_Username, Safari_Buyer_Password)
				.clickcompany()
				.upgradetobuyer();
			
			}
			
			if(browser.contains("MicrosoftEdge"))
			{
				Edge_Buyer_Username= prop.getProperty("EDGE_BUYER_USERNAME");
				Edge_Buyer_Password= prop.getProperty("EDGE_BUYER_PASSWORD");
				
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Edge_Buyer_Username, Edge_Buyer_Password)
				.clickcompany()
				.upgradetobuyer();
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
