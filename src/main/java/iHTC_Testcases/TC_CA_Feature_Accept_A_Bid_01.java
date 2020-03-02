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

public class TC_CA_Feature_Accept_A_Bid_01 extends ProjectMethods{

	private String UserName = "";
	private String Password = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Accepting a Bid";
		testDescription = "Login as seller and Accept a Bid";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() {

		Properties prop = new Properties();
		
		try {
			
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_APPROVELISTING_USERNAME");
			Password = prop.getProperty("CHROME_APPROVELISTING_PASSWORD");
		
			
			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
				
			{
				System.out.println(browser);
			new IHTC_Company_Login_Page(driver, test)
			.clickSignIn()
			.enterCredentials(UserName, Password)
			.clickIhtcLogo()
			.clickListing()
			.clickSalesChrome();

			}

			else if(browser.contains("firefox"))
				
			{
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.clickSalesFireFox();
			}

			else if(browser.contains("safari"))
				
			{
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.clickSalesSafari();
			}
			
			else if(browser.contains("MicrosoftEdge"))
				
			{
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.clickSalesEdge();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
