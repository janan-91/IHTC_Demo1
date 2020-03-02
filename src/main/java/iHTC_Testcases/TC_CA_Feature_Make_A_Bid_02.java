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

public class TC_CA_Feature_Make_A_Bid_02 extends ProjectMethods{
	
	private String UserName = "";
	private String Password = "";
	private String HigherAmount = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	
	public void setData() {

		testCaseName = "CA_Feature_Make a bid_02";
		testDescription = "Making a Bid successfull";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() throws AWTException {

		Properties prop = new Properties();
		
		try {
			
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_PAYMENT_USERNAME");
			Password = prop.getProperty("CHROME_PAYMENT_PASSWORD");
			
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
			.bidSuccessfull(HigherAmount)
			.bidAmountValidation();
			
			
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
				.bidSuccessfull(HigherAmount)
				.bidAmountValidation();
				
			}

			else if(browser.contains("safari"))
				
			{
				
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.SelectListing()
				.clickAction()
				.clickMakeaBid()
				.bidSuccessfull(HigherAmount)
				.bidAmountValidation();
				
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
				.bidAmountValidation();
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
