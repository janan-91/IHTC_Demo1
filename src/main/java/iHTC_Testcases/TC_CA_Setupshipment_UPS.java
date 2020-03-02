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

public class TC_CA_Setupshipment_UPS extends ProjectMethods {
	
	private String UserName = "";
	private String Password = "";
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Setupshipment for UPS carrier";
		testDescription = "After the payment is success, Seller can able to set up the shipment using the UPS carrier or not";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	
	//This method is used to set up shipment for the paid listing
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void setupshipment() throws AWTException
	{
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File("D:\\Automation\\ihtc_qa\\ihtc-qa\\src\\main\\resources\\config.properties")));

			UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD");
			
			String browser = driver.getCapabilities().getBrowserName();
			
			System.out.println(browser);
			
			if(browser.contains("chrome"))
			{
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.click_sales_menu()
				.searchlisting_Salespage()
				.click_paidlisting_Chrome()
				.click_action_shipment()
				.click_Carriernservice_dropdown()
				.add_shipment()
				.getstatus_Aftershipment();
	
			}
			
			else if(browser.contains("firefox"))
			{
				
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.click_sales_menu()
				.searchlisting_Salespage()
				.click_paidlisting_firefox()
				.click_action_shipment()
				.click_Carriernservice_dropdown()
				.add_shipment()
				.getstatus_Aftershipment();
	
				
			}
			
			else if(browser.contains("MicrosoftEdge"))
			{
				
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.click_sales_menu()
				.searchlisting_Salespage()
				.click_paidlisting_Edge()
				.click_action_shipment()
				.click_Carriernservice_dropdown()
				.add_shipment()
				.getstatus_Aftershipment();
	
			}
			
			else if(browser.contains("Safari"))
			{
				
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.click_sales_menu()
				.searchlisting_Salespage()
				.click_paidlisting_Safari()
				.click_action_shipment()
				.click_Carriernservice_dropdown()
				.add_shipment()
				.getstatus_Aftershipment();
	
			}
		
		
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
