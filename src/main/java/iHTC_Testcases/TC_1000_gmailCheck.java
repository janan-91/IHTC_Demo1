package iHTC_Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IHTC_wdMethods.ProjectMethods;
import iHTC_page.IHTC_Gmailpage;


public class TC_1000_gmailCheck extends ProjectMethods {
	
	private String Chrome_UserName = "";
	private String Chrome_Password = "";
	private String Firefox_UserName = "";
	private String Firefox_Password = "";
	private String Safari_UserName = "";
	private String Safari_Password = "";
	private String Edge_UserName = "";
	private String Edge_Password = "";
	private String Chrome_SetPassword = "";
	private String Firefox_SetPassword = "";
	private String Safari_SetPassword = "";
	private String Edge_SetPassword = "";
	
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Company admin set new password after sign up";
		testDescription = "Ensure the company admin able to set the new password";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void Gmailpage() {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			Chrome_UserName = prop.getProperty("CHROME_IHTC_GMAIL_USERNAME");
			Chrome_Password = prop.getProperty("CHROME_IHTC_GMAIL_PASSWORD");
			Chrome_SetPassword = prop.getProperty("CHROME_IHTC_GMAIL_SETNEWPASSWORD");
			
			Firefox_UserName = prop.getProperty("FIREFOX_IHTC_GMAIL_USERNAME");
			Firefox_Password = prop.getProperty("FIREFOX_IHTC_GMAIL_PASSWORD");
			Firefox_SetPassword = prop.getProperty("FIREFOX_IHTC_GMAIL_SETNEWPASSWORD");
			
			Safari_UserName = prop.getProperty("SAFARI_IHTC_GMAIL_USERNAME");
			Safari_Password = prop.getProperty("SAFARI_IHTC_GMAIL_PASSWORD");
			Safari_SetPassword = prop.getProperty("SAFARI_IHTC_GMAIL_SETNEWPASSWORD");
			
			Edge_UserName = prop.getProperty("EDGE_IHTC_GMAIL_USERNAME");
			Edge_Password = prop.getProperty("EDGE_IHTC_GMAIL_PASSWORD");
			Edge_SetPassword = prop.getProperty("EDGE_IHTC_GMAIL_SETNEWPASSWORD");
			
			String browser = driver.getCapabilities().getBrowserName();
			
			if(browser.contains("chrome"))
			{
				System.out.println(browser);
			new IHTC_Gmailpage(driver, test)
			.entergmailusername(Chrome_UserName)
			.clicknextbutton()
			.entergmailpassword(Chrome_Password)
			.clicknextbutton()
			.clickslingremail()
			.clickurlLink()
			.enternewpassword(Chrome_SetPassword)
			.getredirectedportalUrl();
			
			}
			
			if(browser.contains("Firefox"))
			{
				System.out.println(browser);
			new IHTC_Gmailpage(driver, test)
			.entergmailusername(Firefox_UserName)
			.clicknextbutton()
			.entergmailpassword(Firefox_Password)
			.clicknextbutton()
			.clickslingremail()
			.clickurlLink()
			.enternewpassword(Firefox_SetPassword)
			.getredirectedportalUrl();
			
			}
			
			if(browser.contains("safari"))
			{
				System.out.println(browser);
			new IHTC_Gmailpage(driver, test)
			.entergmailusername(Safari_UserName)
			.clicknextbutton()
			.entergmailpassword(Safari_Password)
			.clicknextbutton()
			.clickslingremail()
			.clickurlLink()
			.enternewpassword(Safari_SetPassword)
			.getredirectedportalUrl();
			
			}
			
			if(browser.contains("Edge"))
			{
				System.out.println(browser);
			new IHTC_Gmailpage(driver, test)
			.entergmailusername(Edge_UserName)
			.clicknextbutton()
			.entergmailpassword(Edge_Password)
			.clicknextbutton()
			.clickslingremail()
			.clickurlLink()
			.enternewpassword(Edge_SetPassword)
			.getredirectedportalUrl();
			
			}

}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}
