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

public class TC_CA_Feature_Approvecompany_01 extends ProjectMethods {
	
	private String Admin_Username="";
	private String Admin_Password="";
	private String Upassword="welcome@123";
	
	//Before executing the test case make sure you have set up the company name details belolw
	
	private String Chrome_WFAcompany="";
	private String Firefox_WFAcompany="";
	private String Safari_WFAcompany="";
	private String Edge_WFAcompany="";
	
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Feature_Approvecompany_01";
		testDescription = "To validate the company admin able to a approve a company or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void admin_Approvecompanyandcheckuserlogin()
	{
	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			
			//Admin login
			Admin_Username = prop.getProperty("IHTC_USERNAME");
			Admin_Password = prop.getProperty("IHTC_PASSWORD");
			Chrome_WFAcompany = prop.getProperty("CHROME_WFACOMPANY");
			Firefox_WFAcompany = prop.getProperty("FIREFOX_WFACOMPANY");
			Safari_WFAcompany = prop.getProperty("SAFARI_WFACOMPANY");
			Edge_WFAcompany = prop.getProperty("EDGE_WFACOMPANY");
					
			
			System.out.println(Admin_Username);
			System.out.println(Admin_Password);
			
			String browser=driver.getCapabilities().getBrowserName();
			
			System.out.println(browser);
			
			if(browser.contains("chrome"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickcompany_Chrome_Waitingforapproval(Chrome_WFAcompany)
				.approveCompanyandlogincheck(Upassword);
			}
			
			else if(browser.contains("firefox"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickcompany_Firefox_Waitingforapproval(Firefox_WFAcompany)
				.approveCompanyandlogincheck(Upassword);
			}
			
			else if(browser.contains("safari"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickcompany_Safari_Waitingforapproval(Safari_WFAcompany)
				.approveCompanyandlogincheck(Upassword);
			}
			
			if(browser.contains("MicrosoftEdge"))
			{
				new IHTC_Login_Page(driver, test)
				.enterCredentials(Admin_Username, Admin_Password)
				.clickadmincompanymenu()
				.clickcompany_Edge_Waitingforapproval(Edge_WFAcompany)
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
