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

public class TC_CA_Feature_CreateUser_04 extends ProjectMethods {
	
	private String Chrome_Company_UserName = "";
	private String Chrome_Company_Password = "";
	private String Firefox_Company_UserName="";
	private String Firefox_Company_Password="";
	private String Safari_Company_UserName="";
	private String Safari_Company_Password="";
	private String Edge_Company_UserName="";
	private String Edge_Company_Password="";
	
	private String	Chrome_usercreation_Firstname="";
	private String	Chrome_Usercreation_Lastname="";
	private String	Chrome_Usercreation_emailId="";
	private String	Chrome_Usercreation_Phonenumber="";
	private String  Chrome_Usercreation_Password="";
	
	private String Edge_usercreation_Firstname="";
	private String Edge_Usercreation_Lastname="";
	private String Edge_Usercreation_emailId="";		
	private String Edge_Usercreation_Phonenumber="";
	private String Edge_Usercreation_Password="";
	
	private String Firefox_usercreation_Firstname="";
	private String Firefox_Usercreation_Lastname="";
	private String Firefox_Usercreation_emailId="";		
	private String Firefox_Usercreation_Phonenumber="";
	private String Firefox_Usercreation_Password="";
	
	private String Safari_usercreation_Firstname="";
	private String Safari_Usercreation_Lastname="";
	private String Safari_Usercreation_emailId="";		
	private String Safari_Usercreation_Phonenumber="";
	private String Safari_Usercreation_Password="";
	
	
	
	
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Feature_Createnewuser_04";
		testDescription = "To validate the company admin able to a new user and validate new user able to set password and able to login to the portal";
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
			
			//Company admin login
			Chrome_Company_UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME");
			Chrome_Company_Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD");
			
			Edge_Company_UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
			Edge_Company_Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");
			
			Safari_Company_UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
			Safari_Company_Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");
			
			Firefox_Company_UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
			Firefox_Company_Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");
			
			//User creation data
			Chrome_usercreation_Firstname = prop.getProperty("CHROME_USERCREATION_FIRSTNAME");
			Chrome_Usercreation_Lastname = prop.getProperty("CHROME_USERCREATION_LASTNAME");
			Chrome_Usercreation_emailId = prop.getProperty("CHROME_USERCREATION_EMAILID");
			Chrome_Usercreation_Phonenumber= prop.getProperty("CHROME_USERCREATION_PHONENUMBER");
			Chrome_Usercreation_Password= prop.getProperty("CHROME_USER_GMAIL_LOGIN_PASSWORD");
			
			
			Edge_usercreation_Firstname = prop.getProperty("EDGE_USERCREATION_FIRSTNAME");
			Edge_Usercreation_Lastname = prop.getProperty("EDGE_USERCREATION_LASTNAME");
			Edge_Usercreation_emailId = prop.getProperty("EDGE_USERCREATION_EMAILID");
			Edge_Usercreation_Phonenumber= prop.getProperty("EDGE_USERCREATION_PHONENUMBER");
			Edge_Usercreation_Password= prop.getProperty("EDGE_USER_GMAIL_LOGIN_PASSWORD");
			
			Firefox_usercreation_Firstname = prop.getProperty("FIREFOX_USERCREATION_FIRSTNAME");
			Firefox_Usercreation_Lastname = prop.getProperty("FIREFOX_USERCREATION_LASTNAME");
			Firefox_Usercreation_emailId = prop.getProperty("FIREFOX_USERCREATION_EMAILID");
			Firefox_Usercreation_Phonenumber= prop.getProperty("FIREFOX_USERCREATION_PHONENUMBER");
			Firefox_Usercreation_Password= prop.getProperty("FIREFOX_USER_GMAIL_LOGIN_PASSWORD");
			
			Safari_usercreation_Firstname = prop.getProperty("SAFARI_USERCREATION_FIRSTNAME");
			Safari_Usercreation_Lastname = prop.getProperty("SAFARI_USERCREATION_LASTNAME");
			Safari_Usercreation_emailId = prop.getProperty("SAFARI_USERCREATION_EMAILID");
			Safari_Usercreation_Phonenumber= prop.getProperty("SAFARI_USERCREATION_PHONENUMBER");
			Safari_Usercreation_Password= prop.getProperty("SAFARI_USER_GMAIL_LOGIN_PASSWORD");
			
			
			
			String browser = driver.getCapabilities().getBrowserName();
			System.out.println(browser);

			if(browser.contains("chrome"))
			{
				//Company admin login and reset password
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(Chrome_Company_UserName, Chrome_Company_Password)
				.companyadmin_clickusermenu()
				.userhome_Clickcreatebutton()
				.enteruser_firstname(Chrome_usercreation_Firstname)
				.enteruser_Lastname(Chrome_Usercreation_Lastname)
				.enteruser_Emailid(Chrome_Usercreation_emailId)
				.enteruser_Phonenumber(Chrome_Usercreation_Phonenumber)
				.userclick_Createbutton();
				
				/*//gmail
				new IHTC_Gmailpage(driver,test)
				.entergmailurl()
				.entergmailusername(Chrome_Usercreation_emailId)
				.clicknextbutton()
				.entergmailpassword(Chrome_Usercreation_Password)
				.clicknextbutton()
				
				.clickwelcomeemail()
				.clickurlLink()
				.enternewpassword(Chrome_Usercreation_Password)
				.getredirectedportalUrl();
				
				sleep(5000);
				
				//User login check
				
				new IHTC_Company_Login_Page(driver,test)
				.enterCredentials(Chrome_Usercreation_emailId, Chrome_Usercreation_Password)
				.user_verifylistingmenu();*/
	
			}
			
			else if(browser.contains("firefox"))
			{
				//Company admin login and reset password
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(Firefox_Company_UserName, Firefox_Company_Password)
				.companyadmin_clickusermenu()
				.userhome_Clickcreatebutton()
				.enteruser_firstname(Firefox_usercreation_Firstname)
				.enteruser_Lastname(Firefox_Usercreation_Lastname)
				.enteruser_Emailid(Firefox_Usercreation_emailId)
				.enteruser_Phonenumber(Firefox_Usercreation_Phonenumber)
				.userclick_Createbutton();
				
				/*//gmail
				new IHTC_Gmailpage(driver,test)
				.entergmailurl()
				.entergmailusername(Firefox_Usercreation_emailId)
				.clicknextbutton()
				.entergmailpassword(Firefox_Usercreation_Password)
				.clicknextbutton()
			
				.clickwelcomeemail()
				.clickurlLink()
				.enternewpassword(Firefox_Usercreation_Password)
				.getredirectedportalUrl();
				
				sleep(5000); 
				
				//User login check
				
				new IHTC_Company_Login_Page(driver,test)
				.enterCredentials(Firefox_Usercreation_emailId, Firefox_Usercreation_Password)
				.user_verifylistingmenu();*/
	
			}
			
			else if(browser.contains("Safari"))
			{
				//Company admin login and reset password
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(Safari_Company_UserName, Safari_Company_Password)
				.companyadmin_clickusermenu()
				.userhome_Clickcreatebutton()
				.enteruser_firstname(Safari_usercreation_Firstname)
				.enteruser_Lastname(Safari_Usercreation_Lastname)
				.enteruser_Emailid(Safari_Usercreation_emailId)
				.enteruser_Phonenumber(Safari_Usercreation_Phonenumber)
				.userclick_Createbutton();
				
				/*//gmail
				new IHTC_Gmailpage(driver,test)
				.entergmailurl()
				.entergmailusername(Safari_Usercreation_emailId)
				.clicknextbutton()
				.entergmailpassword(Safari_Usercreation_Password)
				.clicknextbutton()
				
				.clickwelcomeemail()
				.clickurlLink()
				.enternewpassword(Safari_Usercreation_Password)
				.getredirectedportalUrl();
				
				sleep(5000);
				
				//User login check
				
				new IHTC_Company_Login_Page(driver,test)
				.enterCredentials(Safari_Usercreation_emailId, Safari_Usercreation_Password)
				.user_verifylistingmenu();
	*/
			}
			
			
			else if(browser.contains("MicrosoftEdge"))
			{
				//Company admin login and reset password
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(Edge_Company_UserName, Edge_Company_Password)
				.companyadmin_clickusermenu()
				.userhome_Clickcreatebutton()
				.enteruser_firstname(Edge_usercreation_Firstname)
				.enteruser_Lastname(Edge_Usercreation_Lastname)
				.enteruser_Emailid(Edge_Usercreation_emailId)
				.enteruser_Phonenumber(Edge_Usercreation_Phonenumber)
				.userclick_Createbutton();
				
				
				/*//gmail
				new IHTC_Gmailpage(driver,test)
				.entergmailurl()
				.entergmailusername(Edge_Usercreation_emailId)
				.clicknextbutton()
				.entergmailpassword(Edge_Usercreation_Password)
				.clicknextbutton()
				.clickwelcomeemail()
				.clickurlLink()
				.enternewpassword(Edge_Usercreation_Password)
				.getredirectedportalUrl();
				
				sleep(5000);
				
				//User login check
				
				new IHTC_Company_Login_Page(driver,test)
				.enterCredentials(Edge_Usercreation_emailId, Edge_Usercreation_Password)
				.user_verifylistingmenu();
	*/
	
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
