package iHTC_Testcases;

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


public class TC_CA_Message_Rejectcompany extends ProjectMethods {

		private String UserName = "";
		private String Password = "";
		private String SadminUserName = "";
		private String SadminPassword = "";
		private String UPassword="welcome@123";
		
		private String Chrome_Cname="";
		private String Firefox_Cname="";
		private String Safari_Cname="";
		private String Edge_Cname="";

		@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
		public void setData() {

			testCaseName = "TC_CA_Message_Rejectcompany";
			testDescription = "To check the notification is being received by the company admin after the company is Rejected";
			authors = "Prabu";
			browserName = "chrome";
			runGroup = "IHTC";
		}

		
		//This method is used to set up shipment for the paid listing
		@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
		public void companyreject_Message()
		{
			Properties prop = new Properties();
			
			try {
				prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

				
				SadminUserName = prop.getProperty("IHTC_USERNAME");
				SadminPassword = prop.getProperty("IHTC_PASSWORD");
				
							
				String browser = driver.getCapabilities().getBrowserName();

				if(browser.contains("chrome"))
				{
					Chrome_Cname=prop.getProperty("CHROME_MESSAGE_WFA");
					
					System.out.println(browser);
				new IHTC_Login_Page(driver, test)
				.enterCredentials(SadminUserName, SadminPassword)
				.clickadmincompanymenu()
				.clickcompany_Chrome_Waitingforapproval(Chrome_Cname)
				.admin_RejectCompany()
				.getEmailId(UPassword);
	
				new IHTC_Messaging(driver,test)
				.click_Messagemenu_Rejected();
				
						
				}
				
				if(browser.contains("firefox"))
				{
					Firefox_Cname=prop.getProperty("FIREFOX_MESSAGE_WFA");
					System.out.println(browser);
					new IHTC_Login_Page(driver, test)
					.enterCredentials(SadminUserName, SadminPassword)
					.clickadmincompanymenu()
					.clickcompany_Firefox_Waitingforapproval(Firefox_Cname)
					.admin_RejectCompany()
					.getEmailId(UPassword);
		
					new IHTC_Messaging(driver,test)
					.click_Messagemenu_Rejected();
					
				}
				
				if(browser.contains("Safari"))
				{
					Safari_Cname=prop.getProperty("SAFARI_MESSAGE_WFA");
					System.out.println(browser);
					new IHTC_Login_Page(driver, test)
					.enterCredentials(SadminUserName, SadminPassword)
					.clickadmincompanymenu()
					.clickcompany_Safari_Waitingforapproval(Safari_Cname)
					.admin_RejectCompany()
					.getEmailId(UPassword);
		
					new IHTC_Messaging(driver,test)
					.click_Messagemenu_Rejected();
					
						
				}
				
				if(browser.contains("MicrosoftEdge"))
				{
					Edge_Cname=prop.getProperty("EDGE_MESSAGE_WFA");
					System.out.println(browser);
					new IHTC_Login_Page(driver, test)
					.enterCredentials(SadminUserName, SadminPassword)
					.clickadmincompanymenu()
					.clickcompany_Edge_Waitingforapproval(Edge_Cname)
					.admin_RejectCompany()
					.getEmailId(UPassword);
		
					new IHTC_Messaging(driver,test)
					.click_Messagemenu_Rejected();
					
						
				}
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	


}
