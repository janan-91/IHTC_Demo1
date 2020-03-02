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

public class TC_CA_Feature_Accept_A_Bid_02 extends ProjectMethods{

	private String UserName = "";
	private String Password = "";
	private String BuyitnowAmount = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Accepting a Bid with lower amount";
		testDescription = "Login as seller and Accept a Bid with lower amount";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() throws AWTException {

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
				.userListingChrome()
				.getamountList();
				
			
			}

			else if(browser.contains("firefox"))
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.userListingFirefox()
				.getamountList();
			}

			else if(browser.contains("safari"))
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.userListingSafari()
				.getamountList();
			}
			else if(browser.contains("Edge"))
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.userListingEdge()
				.getamountList();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
