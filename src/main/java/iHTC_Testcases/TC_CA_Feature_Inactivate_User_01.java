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

public class TC_CA_Feature_Inactivate_User_01 extends ProjectMethods {
	
	private String UserName = "";
	private String Password = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Feature_Inactivate_User_01";
		testDescription = "To validate the company admin able to Inactivate the user or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}
	
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void companyadmin_deactivatecompanyandcheckuserlogin()
	{
	
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD");

			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.companyadmin_clickusermenu()
				.chrome_click_Activeuser()
				.click_Actionbutton()
				.click_Deactivateoption()
				.click_Okbutton();
				//.user_Statuscheckafterdeactivate();
				
			
			}
			
			if(browser.contains("firefox"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.companyadmin_clickusermenu()
				.firefox_click_Activeuser()
				.click_Actionbutton()
				.click_Deactivateoption()
				.click_Okbutton();
				//.user_Statuscheckafterdeactivate();
				
			
			}
			
			if(browser.contains("Safari"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.companyadmin_clickusermenu()
				.safari_click_Activeuser()
				.click_Actionbutton()
				.click_Deactivateoption()
				.click_Okbutton();
				//.user_Statuscheckafterdeactivate();
				
			
			}
			
			if(browser.contains("MicrosoftEdge"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.companyadmin_clickusermenu()
				.edge_click_Activeuser()
				.click_Actionbutton()
				.click_Deactivateoption()
				.click_Okbutton();
				//.user_Statuscheckafterdeactivate();
				
			
			}
		}
		
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		

}
}
