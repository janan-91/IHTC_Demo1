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
import iHTC_page.IHTC_Company_Login_Page;
import iHTC_page.IHTC_Login_Page;
import iHTC_page.IHTC_Messaging;

public class TC_CA_Message_Companyreactivate extends ProjectMethods {
	
	private String SadminUserName = "";
	private String SadminPassword = "";
	private String Upassword="welcome@123";
	
	private String Chrome_suspendedCompany="";
	private String Firefox_suspendedCompany="";
	private String Safari_suspendedCompany="";
	private String Edge_suspendedCompany="";
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Reactivate a company from superadmin and check the message in company admin login";
		testDescription = "To check the notification is being received by the company admin after the company is reactivated";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	
	//This method is used to set up shipment for the paid listing
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void reactivatecompany_Message() throws AWTException
	{
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			
			SadminUserName = prop.getProperty("IHTC_USERNAME");
			SadminPassword = prop.getProperty("IHTC_PASSWORD");
			Chrome_suspendedCompany = prop.getProperty("CHROME_MESSAGE_SUSPENDEDCOMPANY");
			Firefox_suspendedCompany = prop.getProperty("FIREFOX_MESSAGE_SUSPENDEDCOMPANY");
			Safari_suspendedCompany = prop.getProperty("SAFARI_MESSAGE_SUSPENDEDCOMPANY");
			Edge_suspendedCompany = prop.getProperty("EDGE_MESSAGE_SUSPENDEDCOMPANY");
			
			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
			{
				System.out.println(browser);
			new IHTC_Login_Page(driver, test)
			.enterCredentials(SadminUserName, SadminPassword)
			.clickadmincompanymenu()
			.clickCompany_Chrome(Chrome_suspendedCompany)
			.adminreactivatecompany(Upassword);
			
			new IHTC_Messaging(driver,test)
			.click_Messagemenu_Reactivate();
				
			}
			
			else if(browser.contains("firefox"))
			{
				System.out.println(browser);
				new IHTC_Login_Page(driver, test)
				.enterCredentials(SadminUserName, SadminPassword)
				.clickadmincompanymenu()
				.clickCompany_Firefox(Firefox_suspendedCompany)
				.adminreactivatecompany(Upassword);
				
				
				new IHTC_Messaging(driver,test)
				.click_Messagemenu_Reactivate();
			
			
			}

			else if(browser.contains("Safari"))
			{
				System.out.println(browser);
				new IHTC_Login_Page(driver, test)
				.enterCredentials(SadminUserName, SadminPassword)
				.clickadmincompanymenu()
				.clickCompany_safari(Safari_suspendedCompany)
				.adminreactivatecompany(Upassword);
				
				
				new IHTC_Messaging(driver,test)
				.click_Messagemenu_Reactivate();
			
			}
			
			else if(browser.contains("MicrosoftEdge"))
			{
				System.out.println(browser);
				new IHTC_Login_Page(driver, test)
				.enterCredentials(SadminUserName, SadminPassword)
				.clickadmincompanymenu()
				.clickCompany_edge(Edge_suspendedCompany)
				.adminreactivatecompany(Upassword);
				
				
				new IHTC_Messaging(driver,test)
				.click_Messagemenu_Reactivate();
			
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
