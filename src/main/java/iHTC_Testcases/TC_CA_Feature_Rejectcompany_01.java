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

public class TC_CA_Feature_Rejectcompany_01 extends ProjectMethods 

{
	
//This class is used to reject a company and check the status of the company immediately whether it is in rejected status or not.	
	private String Admin_Username="";
	private String Admin_Password="";
	
	private String Chrome_WFACompany="";
	private String Firefox_WFACompany="";
	private String Safari_WFACompany="";
	private String Edge_WFACompany="";
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Feature_Rejectcompany_01";
		testDescription = "To validate the company admin able to a reject a company which is in WFA status and check the status in CA login or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void companyadmin_createuserandcheckuserlogin()
	{
	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			
			//Admin login
			Admin_Username = prop.getProperty("IHTC_USERNAME");
			Admin_Password = prop.getProperty("IHTC_PASSWORD");
			Chrome_WFACompany= prop.getProperty("CHROME_WFACOMPANY_REJECT");
			Firefox_WFACompany=	prop.getProperty("FIREFOX_WFACOMPANY_REJECT");
			Safari_WFACompany= prop.getProperty("SAFARI_WFACOMPANY_REJECT");
			Edge_WFACompany= prop.getProperty("EDGE_WFACOMPANY_REJECT");
			
			String browser=driver.getCapabilities().getBrowserName();
			
			if(browser.contains("chrome"))
			{
			
			new IHTC_Login_Page(driver, suiteTest)
			.enterCredentials(Admin_Username, Admin_Password)
			.clickadmincompanymenu()
			.clickcompany_Chrome_Waitingforapproval(Chrome_WFACompany)
			.admin_RejectCompany()
			.check_CA_Status_Afterreject();
			
			}
			
			if(browser.contains("firefox"))
			{
			
			new IHTC_Login_Page(driver, suiteTest)
			.enterCredentials(Admin_Username, Admin_Password)
			.clickadmincompanymenu()
			.clickcompany_Firefox_Waitingforapproval(Firefox_WFACompany)
			.admin_RejectCompany()
			.check_CA_Status_Afterreject();
			
			}
			
			if(browser.contains("Safari"))
			{
			
			new IHTC_Login_Page(driver, suiteTest)
			.enterCredentials(Admin_Username, Admin_Password)
			.clickadmincompanymenu()
			.clickcompany_Safari_Waitingforapproval(Safari_WFACompany)
			.admin_RejectCompany()
			.check_CA_Status_Afterreject();
			
			}
			
			if(browser.contains("MicrosoftEdge"))
			{
			
			new IHTC_Login_Page(driver, suiteTest)
			.enterCredentials(Admin_Username, Admin_Password)
			.clickadmincompanymenu()
			.clickcompany_Edge_Waitingforapproval(Edge_WFACompany)
			.admin_RejectCompany()
			.check_CA_Status_Afterreject();
			
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
