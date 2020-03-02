package iHTC_Testcases;

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

public class TC_CA_Message_Companyapprove extends ProjectMethods {
	
	
	private String SadminUserName = "";
	private String SadminPassword = "";
	
	private String Chrome_WFA="";
	private String Firefox_WFA="";
	private String Safari_WFA="";
	private String Edge_WFA="";
	
	private String Upassword="welcome@123";
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Message_Companyapprove";
		testDescription = "To check the notification is being received by the company admin after the company is Approved from rejected status";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	
	//This method is used to set up shipment for the paid listing
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void companyapprove_Message()
	{
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			
			SadminUserName = prop.getProperty("IHTC_USERNAME");
			SadminPassword = prop.getProperty("IHTC_PASSWORD");
			Chrome_WFA = prop.getProperty("CHROME_MESSAGE_REJECTEDCOMPANY");
			Firefox_WFA = prop.getProperty("FIREFOX_MESSAGE_REJECTEDCOMPANY");
			Safari_WFA = prop.getProperty("SAFARI_MESSAGE_REJECTEDCOMPANY");
			Edge_WFA = prop.getProperty("EDGE_MESSAGE_REJECTEDCOMPANY");
		
			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
			{
				System.out.println(browser);
			new IHTC_Login_Page(driver, test)
			.enterCredentials(SadminUserName, SadminPassword)
			.clickadmincompanymenu()
			.clickcompany_Chrome_Waitingforapproval(Chrome_WFA)
			.approve_Message(Upassword);
			
			new IHTC_Messaging(driver,test)
			.click_Messagemenu_approve();
			
					
			}
			
			else if(browser.contains("firefox"))
			{
				System.out.println(browser);
				new IHTC_Login_Page(driver, test)
				.enterCredentials(SadminUserName, SadminPassword)
				.clickadmincompanymenu()
				.clickcompany_Firefox_Waitingforapproval(Firefox_WFA)
				.approve_Message(Upassword);
				
				new IHTC_Messaging(driver,test)
				.click_Messagemenu_approve();
			}
			
			else if(browser.contains("Safari"))
			{
				System.out.println(browser);
				new IHTC_Login_Page(driver, test)
				.enterCredentials(SadminUserName, SadminPassword)
				.clickadmincompanymenu()
				.clickcompany_Safari_Waitingforapproval(Safari_WFA)
				.approve_Message(Upassword);
				
				new IHTC_Messaging(driver,test)
				.click_Messagemenu_approve();
					
			}
			
			else if(browser.contains("MicrosoftEdge"))
			{
				System.out.println(browser);
				new IHTC_Login_Page(driver, test)
				.enterCredentials(SadminUserName, SadminPassword)
				.clickadmincompanymenu()
				.clickcompany_Edge_Waitingforapproval(Edge_WFA)
				.approve_Message(Upassword);
				
				new IHTC_Messaging(driver,test)
				.click_Messagemenu_approve();
				
					
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}
