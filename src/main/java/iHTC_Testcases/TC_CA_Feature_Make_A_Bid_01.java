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

public class TC_CA_Feature_Make_A_Bid_01 extends ProjectMethods{

	
	private String UserName = "";
	private String Password = "";
	private String LesserAmountUSD = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "CA_Feature_Make a bid_01";
		testDescription = "The bid needs to be equals or higher than the base price";
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
			LesserAmountUSD = prop.getProperty("CHROME_LESSERAMOUNTUSD");
			
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
			.clickAmountUSD(LesserAmountUSD)
			.readAmountAlertMessage();
			
			}
			
			else if(browser.contains("firefox"))

			{
				System.out.println(browser);
			new IHTC_Company_Login_Page(driver, test)
			.clickSignIn()
			.enterCredentials(UserName, Password)
			.clickIhtcLogo()
			.clickListing()
			.SelectNewListingFireFox()
			.clickAction()
			.clickMakeaBid()
			.clickAmountUSD(LesserAmountUSD)
			.readAmountAlertMessage();
			
			}

			else if(browser.contains("MicrosoftEdge"))
				
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.SelectNewListingEdge()
				.clickAction()
				.clickMakeaBid()
				.clickAmountUSD(LesserAmountUSD)
				.readAmountAlertMessage();
			}
			
			else if(browser.contains("Safari"))
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickIhtcLogo()
				.clickListing()
				.SelectNewListingSafari()
				.clickAction()
				.clickMakeaBid()
				.clickAmountUSD(LesserAmountUSD)
				.readAmountAlertMessage();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
