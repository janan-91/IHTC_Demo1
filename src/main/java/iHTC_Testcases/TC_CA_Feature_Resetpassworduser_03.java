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
import iHTC_page.IHTC_Gmailpage;
import iHTC_page.IHTC_SignUp_Page;
//import iHTC_page.IHTC_User_Page;

public class TC_CA_Feature_Resetpassworduser_03 extends ProjectMethods {
	
	private String Chrome_Company_UserName = "";
	private String Chrome_Company_Password = "";
	private String Firefox_Company_UserName="";
	private String Firefox_Company_Password="";
	private String Safari_Company_UserName="";
	private String Safari_Company_Password="";
	private String Edge_Company_UserName="";
	private String Edge_Company_Password="";	
	
	
	//Gmail//
	private String Chrome_Gmail_UserName = "";
	private String Chrome_Gmail_Password = "";
	private String Firefox_Gmail_UserName = "";
	private String Firefox_Gmail_Password = "";
	private String Safari_Gmail_UserName = "";
	private String Safari_Gmail_Password = "";
	private String Edge_Gmail_UserName = "";
	private String Edge_Gmail_Password = "";
	private String Chrome_SetPassword = "";
	private String Firefox_SetPassword = "";
	private String Safari_SetPassword = "";
	private String Edge_SetPassword = "";
	
	//Delete company
	
	private String Chrome_Company="";
	private String Firefox_Company="";
	private String Safari_Company="";
	private String Edge_Company="";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Feature_Resetpassworduser_03";
		testDescription = "To validate the company admin able to reset the password for the user and user able to reset his password by setting the new password";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void companyadmin_UserResetPasswordandcheckuserlogin()
	{
	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			
			//Company admin login
			Chrome_Company_UserName = prop.getProperty("CHROME_IHTC_COMPANY_RESETPASSWORD_USERNAME");
			Chrome_Company_Password = prop.getProperty("CHROME_IHTC_COMPANY_RESETPASSWORD_PASSWORD");
			
			Firefox_Company_UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_RESETPASSWORD_USERNAME");
			Firefox_Company_Password = prop.getProperty("FIREFOX_IHTC_COMPANY_RESETPASSWORD_PASSWORD");
			
			Safari_Company_UserName = prop.getProperty("SAFARI_IHTC_COMPANY_RESETPASSWORD_USERNAME");
			Safari_Company_Password = prop.getProperty("SAFARI_IHTC_COMPANY_RESETPASSWORD_PASSWORD");
			
			Edge_Company_UserName = prop.getProperty("EDGE_IHTC_COMPANY_RESETPASSWORD_USERNAME");
			Edge_Company_Password = prop.getProperty("EDGE_IHTC_COMPANY_RESETPASSWORD_PASSWORD");
			
			//Gmail
			Chrome_Gmail_UserName = prop.getProperty("CHROME_IHTC_GMAIL_USERNAME");
			Chrome_Gmail_Password = prop.getProperty("CHROME_IHTC_GMAIL_PASSWORD");
			Chrome_SetPassword = prop.getProperty("CHROME_IHTC_GMAIL_SETNEWPASSWORD");
			
			Firefox_Gmail_UserName = prop.getProperty("FIREFOX_IHTC_GMAIL_USERNAME");
			Firefox_Gmail_Password = prop.getProperty("FIREFOX_IHTC_GMAIL_PASSWORD");
			Firefox_SetPassword = prop.getProperty("FIREFOX_IHTC_GMAIL_SETNEWPASSWORD");
			
			Safari_Gmail_UserName = prop.getProperty("SAFARI_IHTC_GMAIL_USERNAME");
			Safari_Gmail_Password = prop.getProperty("SAFARI_IHTC_GMAIL_PASSWORD");
			Safari_SetPassword = prop.getProperty("SAFARI_IHTC_GMAIL_SETNEWPASSWORD");
			
			Edge_Gmail_UserName = prop.getProperty("EDGE_IHTC_GMAIL_USERNAME");
			Edge_Gmail_Password = prop.getProperty("EDGE_IHTC_GMAIL_PASSWORD");
			Edge_SetPassword = prop.getProperty("EDGE_IHTC_GMAIL_SETNEWPASSWORD");
			
			//Delete Company
			
			Chrome_Company=prop.getProperty("CHROME_SUSPENDEDCOMPANY");
			Firefox_Company=prop.getProperty("FIREFOX_SUSPENDEDCOMPANY");
			Safari_Company=prop.getProperty("SAFARI_SUSPENDEDCOMPANY");
			Edge_Company=prop.getProperty("EDGE_SUSPENDEDCOMPANY");
			
			
		
			String browser = driver.getCapabilities().getBrowserName();
			System.out.println(browser);

			if(browser.contains("chrome"))
			{
				//Company admin login and reset password
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(Chrome_Company_UserName, Chrome_Company_Password)
				.companyadmin_clickusermenu()
				.chrome_click_Activeuser()
				.click_Actionbutton()
				.user_clickresetpassword()
				.click_Okbutton();
				
				//Gmail login//
				
				sleep(5000);
				
				new IHTC_Gmailpage(driver, test)
				.entergmailurl()
				.entergmailusername(Chrome_Gmail_UserName)
				.clicknextbutton()
				.entergmailpassword(Chrome_Gmail_Password)
				.clicknextbutton()
				
				.clickcredentailsemail()
				.clickurlLink()
				.enternewpassword(Chrome_SetPassword)
				.getredirectedportalUrl();
				
				sleep(10000);
				
				//User Login check
				
				new IHTC_Company_Login_Page(driver,test)
				.enterCredentials(Chrome_Gmail_UserName, Chrome_SetPassword)
				.user_verifylistingmenu();
				
				//Delete company
				
				new IHTC_SignUp_Page(driver, test)
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", Chrome_Company)
				.Deletecompany();
	
			}
			
			else if(browser.contains("firefox"))
			{
				//Company admin login and reset password
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(Firefox_Company_UserName, Firefox_Company_Password)
				.companyadmin_clickusermenu()
				.chrome_click_Activeuser()
				.click_Actionbutton()
				.user_clickresetpassword()
				.click_Okbutton();
				
				//Gmail login//
				
				sleep(5000);
				
				new IHTC_Gmailpage(driver, test)
				.entergmailurl()
				.entergmailusername(Firefox_Gmail_UserName)
				.clicknextbutton()
				.entergmailpassword(Firefox_Gmail_Password)
				.clicknextbutton()
				
				.clickcredentailsemail()
				.clickurlLink()
				.enternewpassword(Firefox_SetPassword)
				.getredirectedportalUrl();
				
				sleep(5000);
				
				//User login check
				
				new IHTC_Company_Login_Page(driver,test)
				.enterCredentials(Firefox_Gmail_UserName, Firefox_SetPassword)
				.user_verifylistingmenu();
				
				//Delete company
				
				new IHTC_SignUp_Page(driver, test)
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", Firefox_Company)
				.Deletecompany();
	
	
			}
			
			else if(browser.contains("safari"))
			{
				//Company admin login and reset password
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(Safari_Company_UserName, Safari_Company_Password)
				.companyadmin_clickusermenu()
				.chrome_click_Activeuser()
				.click_Actionbutton()
				.user_clickresetpassword()
				.click_Okbutton();
				
				//Gmail login//
				
				sleep(5000);
				
				new IHTC_Gmailpage(driver, test)
				.entergmailurl()
				.entergmailusername(Safari_Gmail_UserName)
				.clicknextbutton()
				.entergmailpassword(Safari_Gmail_Password)
				.clicknextbutton()
				
				.clickcredentailsemail()
				.clickurlLink()
				.enternewpassword(Safari_SetPassword)
				.getredirectedportalUrl();
				
				sleep(5000);
				
				//User login check
				
				new IHTC_Company_Login_Page(driver,test)
				.enterCredentials(Safari_Gmail_UserName, Safari_SetPassword)
				.user_verifylistingmenu();
				
				//Delete company
				
				new IHTC_SignUp_Page(driver, test)
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", Safari_Company)
				.Deletecompany();
	
	
			}
			
			else if(browser.contains("MicrosoftEdge"))
			{
				//Company admin login and reset password
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(Edge_Company_UserName, Edge_Company_Password)
				.companyadmin_clickusermenu()
				.chrome_click_Activeuser()
				.click_Actionbutton()
				.user_clickresetpassword()
				.click_Okbutton();
				
				//Gmail login//
				
				sleep(5000);
				
				new IHTC_Gmailpage(driver, test)
				.entergmailurl()
				.entergmailusername(Edge_Gmail_UserName)
				.clicknextbutton()
				.entergmailpassword(Edge_Gmail_Password)
				.clicknextbutton()
			
				.clickcredentailsemail()
				.clickurlLink()
				.enternewpassword(Edge_SetPassword)
				.getredirectedportalUrl();
				
				sleep(5000);
				
				//Userlogin check
				new IHTC_Company_Login_Page(driver,test)
				.enterCredentials(Edge_Gmail_UserName, Edge_SetPassword)
				.user_verifylistingmenu();
	
				//Delete company
				
				new IHTC_SignUp_Page(driver, test)
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", Edge_Company)
				.Deletecompany();
	
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
