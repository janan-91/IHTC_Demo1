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
import iHTC_page.IHTC_Login_Page;

	public class TC159_CompanyAdmin_Create_Listings_Both_Validate_EmptyFields extends ProjectMethods {
		
		private String UserName = "";
		private String Password = "";
		
		@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
		public void setData() {

			testCaseName = "IHTC_159_CompanyAdmin_Create_Listings_Both_Validate_EmptyFields";
			testDescription = "create new listings as company admin(Both) with empty fields to validate error message";
			authors = "Mohammad Rafi";
			browserName = "chrome";
			runGroup = "IHTC";
		}
		
		@Test(groups = { "Regression", "Sanity", "Smoke" }, priority =6)
		public void TC159_CompanyAdmin_Create_Listings_Both_Validate_EmptyFields() throws InterruptedException
		{
		
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

				String browser = driver.getCapabilities().getBrowserName();
							

				if(browser.contains("chrome"))
				{
					
				UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD_BOTH");
								
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings()
				.clickCreateListings()
				.clickCreate().validateEmptyfield();
				
				}

				else if(browser.contains("firefox"))
				{
				UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD_BOTH");
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings()
				.clickCreateListings()
				.clickCreate().validateEmptyfield();
				}

				else if(browser.contains("Safari"))
				{
				UserName = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD_BOTH");
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().clickCreate().validateEmptyfield();
				}
				
				else if(browser.contains("MicrosoftEdge"))
				{
				UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD_BOTH");
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().clickCreate().validateEmptyfield();
				}
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

	}

