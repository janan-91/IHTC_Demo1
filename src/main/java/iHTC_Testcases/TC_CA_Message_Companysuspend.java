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

public class TC_CA_Message_Companysuspend extends ProjectMethods {
	
	private String SadminUserName = "";
	private String SadminPassword = "";
	private String Upassword="welcome@123";
	
	private String Chrome_Activecompany="";
	private String Firefox_Activecompany="";
	private String Safari_Activecompany="";
	private String Edge_Activecompany="prabu";
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Message_Companysuspend";
		testDescription = "To check the notification is being received by the company admin after the company is suspended";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	
	//This method is used to set up shipment for the paid listing
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void companysuspend_Message() throws AWTException
	{
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			
			SadminUserName = prop.getProperty("IHTC_USERNAME");
			SadminPassword = prop.getProperty("IHTC_PASSWORD");
			Chrome_Activecompany = prop.getProperty("CHROME_MESSAGE_ACTIVECOMPANY");
			Firefox_Activecompany = prop.getProperty("FIREFOX_MESSAGE_ACTIVECOMPANY");
			Safari_Activecompany = prop.getProperty("SAFARI_MESSAGE_ACTIVECOMPANY");
			Edge_Activecompany = prop.getProperty("EDGE_MESSAGE_ACTIVECOMPANY");
			
					
			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
			{
				System.out.println(browser);
			new IHTC_Login_Page(driver, test)
			.enterCredentials(SadminUserName, SadminPassword)
			.clickadmincompanymenu()
			.clickCompany_Chrome(Chrome_Activecompany)
			.Adminsuspendcompany()
			.getsuspendstatus(Upassword);
			
		
			new IHTC_Messaging(driver,test)
			.click_Messagemenu_suspend();
			
					
			}
			
			if(browser.contains("firefox"))
			{
				System.out.println(browser);
			new IHTC_Login_Page(driver, test)
			.enterCredentials(SadminUserName, SadminPassword)
			.clickadmincompanymenu()
			.clickCompany_Firefox(Firefox_Activecompany)
			.Adminsuspendcompany()
			.getsuspendstatus(Upassword);
			
			new IHTC_Messaging(driver,test)
			.click_Messagemenu_suspend();
			
					
			}
			
			if(browser.contains("Safari"))
			{
				System.out.println(browser);
			new IHTC_Login_Page(driver, test)
			.enterCredentials(SadminUserName, SadminPassword)
			.clickadmincompanymenu()
			.clickCompany_safari(Safari_Activecompany)
			.Adminsuspendcompany()
			.getsuspendstatus(Upassword);
			
			
			
			new IHTC_Messaging(driver,test)
			.click_Messagemenu_suspend();
			
					
			}
			
			if(browser.contains("MicrosoftEdge"))
			{
				System.out.println(browser);
			new IHTC_Login_Page(driver, test)
			.enterCredentials(SadminUserName, SadminPassword)
			.clickadmincompanymenu()
			.clickCompany_edge(Edge_Activecompany)
			.Adminsuspendcompany()
			.getsuspendstatus(Upassword);
			
						
			new IHTC_Messaging(driver,test)
			.click_Messagemenu_suspend();
			
					
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
