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

public class TC_CA_Feature_Reactivatecompany_01 extends ProjectMethods {
	
	private String Admin_Username="";
	private String Admin_Password="";
	
	private String Chrome_Companyname="";
	private String Firefox_Companyname="";
	private String Safari_Companyname="";
	private String Edge_Companyname="";
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Feature_Reapprovecompany_01";
		testDescription = "To validate the company admin able to a reactivate the suspended company or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void admin_Reapprovecompanyandcheckuserlogin() throws AWTException
	{
	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			
			//Admin login
			Admin_Username = prop.getProperty("IHTC_USERNAME");
			Admin_Password = prop.getProperty("IHTC_PASSWORD");
			Chrome_Companyname = prop.getProperty("CHROME_SUSPENDEDCOMPANY");
			Firefox_Companyname = prop.getProperty("FIREFOX_SUSPENDEDCOMPANY");
			Safari_Companyname = prop.getProperty("SAFARI_SUSPENDEDCOMPANY");
			Edge_Companyname = prop.getProperty("EDGE_SUSPENDEDCOMPANY");
			
			System.out.println(Admin_Username);
			System.out.println(Admin_Password);
			
			String browser=driver.getCapabilities().getBrowserName();
			
			System.out.println(browser);
			
			if(browser.contains("chrome"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickCompany_Chrome(Chrome_Companyname)
				.reapproveCompanyandlogincheck();
			}
			
			if(browser.contains("firefox"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickCompany_Firefox(Firefox_Companyname)
				.reapproveCompanyandlogincheck();
			}
			
			if(browser.contains("Safari"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickCompany_safari(Safari_Companyname)
				.reapproveCompanyandlogincheck();
			}
			
			if(browser.contains("MicrosoftEdge"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickCompany_edge(Edge_Companyname)
				.reapproveCompanyandlogincheck();
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
