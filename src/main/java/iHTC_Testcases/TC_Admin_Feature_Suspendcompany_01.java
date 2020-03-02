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

public class TC_Admin_Feature_Suspendcompany_01 extends ProjectMethods {
	
	
	private String UserName = "";
	private String Password = "";
	private String UPassword="welcome@123";
	//Before executing the test case make sure you have given the below data to select the company
	
	private String Chrome_Cname="";
	private String Firefox_Cname="";
	private String Safari_Cname="";
	private String Edge_Cname="";
	//private String Companyname="";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Suspend the company from admin portal and check the CA login";
		testDescription = "Ensure the Admin able to suspend the company from the portal or not.";
		authors = "Vinoth";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void Admin_suspendcompany() throws AWTException {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("IHTC_USERNAME");
			Password = prop.getProperty("IHTC_PASSWORD");
			Chrome_Cname= prop.getProperty("CHROME_COMPANYNAME");
			Firefox_Cname= prop.getProperty("FIREFOX_COMPANYNAME");
			Safari_Cname= prop.getProperty("SAFARI_COMPANYNAME");
			Edge_Cname= prop.getProperty("EDGE_COMPANYNAME");
			//Companyname=prop.getProperty("CHROME_IHTC_COMPANYNAME_SUSPEND");

			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
			{
				System.out.println(browser);
			new IHTC_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickadmincompanymenu()
			.clickCompany_Chrome(Chrome_Cname)
			.Adminsuspendcompany()
			.getsuspendstatus(UPassword);
						
			}

			else if(browser.contains("firefox"))
			{
			new IHTC_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickadmincompanymenu()
			.clickCompany_Firefox(Firefox_Cname)
			.Adminsuspendcompany()
			.getsuspendstatus(UPassword);

			
			}

			else if(browser.contains("Safari"))
			{
			new IHTC_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickadmincompanymenu()
			.clickCompany_safari(Safari_Cname)
			.Adminsuspendcompany()
			.getsuspendstatus(UPassword);

			}
			
			else if(browser.contains("MicrosoftEdge"))
			{
			new IHTC_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickadmincompanymenu()
			.clickCompany_edge(Edge_Cname)
			.Adminsuspendcompany()
			.getsuspendstatus(UPassword);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
