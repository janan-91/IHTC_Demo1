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

public class TC_CA_Feature_Make_A_Bid_04 extends ProjectMethods{
	
	private String UserName = "";
	private String Password = "";
	private String UserName1 = "";
	private String Password2 = "";
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "CA_Feature_Make a bid_04";
		testDescription = "To validate Buy it now";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() {

		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_PAYMENT_USERNAME");
			Password = prop.getProperty("CHROME_PAYMENT_PASSWORD");
			
			UserName1 = prop.getProperty("CHROME_APPROVELISTING_USERNAME");
			Password2 = prop.getProperty("CHROME_APPROVELISTING_PASSWORD");
			
			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
				
			{
				System.out.println(browser);
			new IHTC_Company_Login_Page(driver, test)
			.clickSignIn()
			.enterCredentials(UserName, Password)
			.clickIhtcLogo()
			.clickListing()
			.SelectNewListingChrome()
			.clickAction()
			.clickMakeaBid()
			.buyItNow()
			.loginBuyer();
			
			new IHTC_Company_Login_Page(driver, test)
			.enterCredentials(UserName1, Password2)
			.clickIhtcLogo()
			.verifyAcceptBid_Chrome();
			
			}

			else if(browser.contains("firefox"))
				
			{
			
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.SelectNewListingFireFox()
				.clickAction()
				.clickMakeaBid()
				.buyItNow()
				.ShoppingFirefox()
				.loginBuyer();
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName1, Password2)
				.clickIhtcLogo()
				.verifyAcceptBid_Firefox();
			}

			else if(browser.contains("safari"))
			{
				
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.SelectNewListingSafari()
				.clickAction()
				.clickMakeaBid()
				.buyItNow()
				.ShoppingEdge()
				.loginBuyer();
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName1, Password2)
				.clickIhtcLogo()
				.verifyAcceptBid();
				
			}
			else if(browser.contains("MicrosoftEdge"))
			{
			
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.SelectNewListingEdge()
				.clickAction()
				.clickMakeaBid()
				.buyItNow()
				.ShoppingEdge()
				.loginBuyer();
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName1, Password2)
				.clickIhtcLogo()
				.verifyAcceptBid_Edge();
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
