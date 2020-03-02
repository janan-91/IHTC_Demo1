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

public class TC_CA_Message_Shipping_Instructions extends ProjectMethods {
	
	private String UserName = "";
	private String Password = "";
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "TC_CA_Message_Shipping_Instructions";
		testDescription = "After the payment is successfull, To check the message is received for the shipping instructions or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	
	//This method is used to set up shipment for the paid listing
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void verifymessage_Shippinginstructions() throws AWTException
	{
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD");

			String browser = driver.getCapabilities().getBrowserName();
			
			System.out.println(browser);
			
			if(browser.contains("chrome"))
			{
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.click_sales_menu()
				.click_Shippinginstruct_Paidchrome();
				
			}
			
			else if(browser.contains("firefox"))
			{
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.click_sales_menu()
				.click_Shippinginstruct_Paidfirefox();
					
				
				
			}
			
			else if(browser.contains("MicrosoftEdge"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.click_sales_menu()
				.click_Shippinginstruct_Paidedge();
				
				
			}
			
			else if(browser.contains("Safari"))
			{
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.click_sales_menu()
				.click_Shippinginstruct_Paidsafari();
				
				
			}
			
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
