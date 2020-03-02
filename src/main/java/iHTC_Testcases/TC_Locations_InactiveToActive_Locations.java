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

public class TC_Locations_InactiveToActive_Locations extends ProjectMethods{
	
	private String UserName = "";
	private String Password = "";
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	
	public void setData() {

		testCaseName = "Delete Locations";
		testDescription = "Delete a locations";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() {

		Properties prop = new Properties();
		
		try {
			
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD");  
			
			UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD");
			
			UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");
			
			UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");

			String browser = driver.getCapabilities().getBrowserName();
		
			if(browser.contains("chrome"))
				
			{
				System.out.println(browser);
				
			new IHTC_Company_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickLocations()
			.InactiveToActiveLocation_Chrome();
			
			}
			
			else if(browser.contains("firefox"))

			{	
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickLocations()
				.InactiveToActiveLocation_FireFox();
			}

			else if(browser.contains("MicrosoftEdge"))
				
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickLocations()
				.InactiveToActiveLocation_Edge();
			}
			
			else if(browser.contains("Safari"))
				
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickLocations()
				.InactiveToActiveLocation_Safari();
			
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
