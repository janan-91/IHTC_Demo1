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

public class TC_CA_Feature_Activate_User_02 extends ProjectMethods {
	
	private String UserName = "";
	private String Password = "";
	private String Chrome_Usercreation_Lastname="";
	private String Edge_Usercreation_Lastname="";
	private String Firefox_Usercreation_Lastname="";
	private String Safari_Usercreation_Lastname="";
	private String Sadminusername="";
	private String Spassword="";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Feature_Inactivate_User_02";
		testDescription = "To validate the company admin able to inactivate the user or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void companyadmin_activatecompanyandcheckuserlogin()
	{
	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD");
			
			Sadminusername= prop.getProperty("IHTC_USERNAME");
			Spassword= prop.getProperty("IHTC_PASSWORD");
			
			Chrome_Usercreation_Lastname = prop.getProperty("CHROME_USERCREATION_LASTNAME");
			Edge_Usercreation_Lastname = prop.getProperty("EDGE_USERCREATION_LASTNAME");
			Firefox_Usercreation_Lastname = prop.getProperty("FIREFOX_USERCREATION_LASTNAME");
			Safari_Usercreation_Lastname = prop.getProperty("SAFARI_USERCREATION_LASTNAME");

			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.companyadmin_clickusermenu()
				.chrome_clickinactiveuser()
				.user_activateuser()
				.Deleteuser(Sadminusername, Spassword, Chrome_Usercreation_Lastname);
				
			}
			
			if(browser.contains("firefox"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.companyadmin_clickusermenu()
				.firefox_clickinactiveuser()
				.user_activateuser()
				.Deleteuser(Sadminusername, Spassword, Firefox_Usercreation_Lastname);
				
				
			
			}
			
			if(browser.contains("Safari"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.companyadmin_clickusermenu()
				.safari_clickinactiveuser()
				.user_activateuser()
				.Deleteuser(Sadminusername, Spassword, Safari_Usercreation_Lastname);
		}
			
			if(browser.contains("MicrosoftEdge"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.companyadmin_clickusermenu()
				.edge_clickinactiveuser()
				.user_activateuser()
				.Deleteuser(Sadminusername, Spassword, Edge_Usercreation_Lastname);
				
				
			
			}
			
			
			
			
		}
		
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		

}
}
