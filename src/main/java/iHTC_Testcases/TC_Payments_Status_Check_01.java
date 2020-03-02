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
import iHTC_page.IHTC_Purchase;

public class TC_Payments_Status_Check_01 extends ProjectMethods{

	private String UserName = "";
	private String Password = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	
	public void setData() {

		testCaseName = "Verifying Payment Status";
		testDescription = "Amount Paid should be $10, and payment status should be partial";
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
			
			UserName = prop.getProperty("FIREFOX_PAYMENT_USERNAME");
			Password = prop.getProperty("FIREFOX_PAYMENT_PASSWORD");
			
			UserName = prop.getProperty("EDGE_PAYMENT_USERNAME");
			Password = prop.getProperty("EDGE_PAYMENT_PASSWORD");
			
			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome")) {
				
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickPurchase();
				new IHTC_Purchase(driver,test)
				.clickProduct();
			}
			
			else if(browser.contains("firefox"))
				
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickPurchase();
				new IHTC_Purchase(driver,test)
				.clickProduct();
			}
			
			else if(browser.contains("Edge"))
				
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickPurchase();
				new IHTC_Purchase(driver,test)
				.clickProduct();
			}
			
			else if(browser.contains("Safari"))
			{
				
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password)
				.clickPurchase();
				new IHTC_Purchase(driver,test)
				.clickProduct();
			}
		}
		
	catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	}
}
	

