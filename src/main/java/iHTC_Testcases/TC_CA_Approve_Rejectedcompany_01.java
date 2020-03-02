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

public class TC_CA_Approve_Rejectedcompany_01 extends ProjectMethods {
	
	private String Admin_Username="";
	private String Admin_Password="";
	private String Upassword="welcome@123";
	
	private String Chrome_Rejectedcompany="";
	private String Firefox_Rejectedcompany="";
	private String Safari_Rejectedcompany="";
	private String Edge_Rejectedcompany="";
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Approve_Rejectedcompany_01";
		testDescription = "To validate the company admin able to a reapprove the rejected company or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void admin_Reapprove_rejectedcompanyandcheckuserlogin() throws AWTException
	{
	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			
			//Admin login
			Admin_Username = prop.getProperty("IHTC_USERNAME");
			Admin_Password = prop.getProperty("IHTC_PASSWORD");
			Chrome_Rejectedcompany= prop.getProperty("CHROME_REJECTEDCOMPANY");
			Firefox_Rejectedcompany= prop.getProperty("FIREFOX_REJECTEDCOMPANY");
			Safari_Rejectedcompany= prop.getProperty("SAFARI_REJECTEDCOMPANY");
			Edge_Rejectedcompany= prop.getProperty("EDGE_REJECTEDCOMPANY");
			
			
			System.out.println(Admin_Username);
			System.out.println(Admin_Password);
			
			String browser=driver.getCapabilities().getBrowserName();
			
			System.out.println(browser);
			
			if(browser.contains("chrome"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickcompany_Chrome_Rejectedstatus(Chrome_Rejectedcompany)
				.approveCompanyandlogincheck(Upassword);
			}
			
			if(browser.contains("firefox"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickcompany_Firefox_Rejectedstatus(Firefox_Rejectedcompany)
				.approveCompanyandlogincheck(Upassword);
			}
			
			if(browser.contains("Safari"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickcompany_Safari_Rejectedstatus(Safari_Rejectedcompany)
				.approveCompanyandlogincheck(Upassword);
			}
			
			if(browser.contains("MicrosoftEdge"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickcompany_Edge_Rejectedstatus(Edge_Rejectedcompany)
				.approveCompanyandlogincheck(Upassword);
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
