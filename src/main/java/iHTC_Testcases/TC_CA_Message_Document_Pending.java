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

public class TC_CA_Message_Document_Pending extends ProjectMethods {
	
	private String SUserName="";
	private String SPassword="";
	private String Upassword="welcome@123";
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Messaging - Document pending";
		testDescription = "To check the message is been received to the company admin for the document upload";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	
	//This method is used to set up shipment for the paid listing
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void Message_Documentpending() throws AWTException
	{
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			SUserName = prop.getProperty("IHTC_USERNAME");
			SPassword = prop.getProperty("IHTC_PASSWORD");
			
			
			String browser = driver.getCapabilities().getBrowserName();
			
			System.out.println(browser);
			
			if(browser.contains("chrome"))
			{
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(SUserName, SPassword)
				.click_Superadmin_Companiesmenu()
				.searchcompany_Waitingfordocument()
				.click_Company_Chrome()
				.getemailId()
				.documents_Pendingcheck(Upassword);

			}
			
			else if(browser.contains("firefox"))
			{
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(SUserName, SPassword)
				.click_Superadmin_Companiesmenu()
				.searchcompany_Waitingfordocument()
				.click_Company_firefox()
				.getemailId()
				.documents_Pendingcheck(Upassword);
		}
			
			else if(browser.contains("MicrosoftEdge"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(SUserName, SPassword)
				.click_Superadmin_Companiesmenu()
				.searchcompany_Waitingfordocument()
				.click_Company_Edge()
				.getemailId()
				.documents_Pendingcheck(Upassword);
		}
			
			else if(browser.contains("Safari"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(SUserName, SPassword)
				.click_Superadmin_Companiesmenu()
				.searchcompany_Safari_Waitingfordocument()
				.click_Company_Safari()
				.getemailId()
				.documents_Pendingcheck(Upassword);
		}
		
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
