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
import iHTC_page.IHTC_MessagingNotification;

public class TC_06_Message_PaymentReminder extends ProjectMethods{

	private String UserName = "";
	private String Password = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	
	public void setData() {

		testCaseName = "Payment Reminder";
		testDescription = "To read the message for Payment Reminder";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
}
	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)

	public void IHTCPage() throws AWTException {

		Properties prop = new Properties();
		
		try {
			
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_MESSAGE_USERNAME");
			Password = prop.getProperty("CHROME_MESSAGE_PASSWORD");
			
			UserName = prop.getProperty("FIREFOX_MESSAGE_USERNAME");
			Password = prop.getProperty("FIREFOX_MESSAGE_PASSWORD");
			
			UserName = prop.getProperty("EDGE_MESSAGE_USERNAME");
			Password = prop.getProperty("EDGE_MESSAGE_PASSWORD");
			
			String browser = driver.getCapabilities().getBrowserName();
			if(browser.contains("chrome")) {
				
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password);
				new IHTC_MessagingNotification (driver, test)
				.paymentReminderHours();
				
			}
			
			else if(browser.contains("firefox")){
				
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password);
				new IHTC_MessagingNotification (driver, test)
				.paymentReminderHours();
					
			}
			
			else if(browser.contains("Edge"))
				
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password);
				new IHTC_MessagingNotification (driver, test)
				.paymentReminderHours();
			}
			
			else if(browser.contains("Safari"))
				
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.clickSignIn()
				.enterCredentials(UserName, Password);
				new IHTC_MessagingNotification (driver, test)
				.transactionCancelled();
			}
			
}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
