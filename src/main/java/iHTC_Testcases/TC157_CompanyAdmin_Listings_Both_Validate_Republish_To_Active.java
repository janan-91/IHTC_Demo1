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

	public class TC157_CompanyAdmin_Listings_Both_Validate_Republish_To_Active extends ProjectMethods {

		private String UserName = "";
		private String Password = "";
		private String endoflistingdate = "";
		
		@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
		public void setData() {

			testCaseName = "IHTC_157_CompanyAdmin_Listings_Both_Validate_Republish_To_Active";
			testDescription = "validate listings as company admin(Both) for the status Republish to Active";
			authors = "Mohammad Rafi";
			browserName = "chrome";
			runGroup = "IHTC";
		}

		@Test(groups = { "Regression", "Sanity", "Smoke" }, priority =5)
		public void TC157_CompanyAdmin_Listings_Both_Validate_Republish_To_Active() throws InterruptedException
		{

			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

				String browser = driver.getCapabilities().getBrowserName();


				if(browser.contains("chrome"))
				{
					UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME_BOTH");
					Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD_BOTH");

					endoflistingdate=prop.getProperty("CHROME_IHTC_BASEPRICEINREPUBLISH_LISTINGS_BOTH");
					
					new IHTC_Company_Login_Page(driver, test)
					.enterCredentials(UserName, Password)
					.clickListings().clickParticularListInactiveChrome().clickActions()
					.clickRepublish().enterendflistingInRepublish(endoflistingdate).clickOkRepublish().scrollUp().validateRepublishToActiveStatus();
									
				}

				else if(browser.contains("firefox"))
				{
					UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME_BOTH");
					Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD_BOTH");
					
					endoflistingdate=prop.getProperty("FIREFOX_IHTC_BASEPRICEINREPUBLISH_LISTINGS_BOTH");
					
					new IHTC_Company_Login_Page(driver, test)
					.enterCredentials(UserName, Password)
					.clickListings().clickParticularListInactiveFirefox().clickActions()
					.clickRepublish().enterendflistingInRepublish(endoflistingdate).clickOkRepublish().scrollUp().validateRepublishToActiveStatus();
				}

				else if(browser.contains("Safari"))
				{
					UserName = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME");
					Password = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD");
					endoflistingdate=prop.getProperty("SAFARI_IHTC_BASEPRICEINREPUBLISH_LISTINGS_BOTH");
					//setData(browser);
					new IHTC_Company_Login_Page(driver, test)
					.enterCredentials(UserName, Password)
					.clickListings().clickParticularListInactiveSafari().clickActions()
					.clickRepublish().enterendflistingInRepublish(endoflistingdate).clickOkRepublish().scrollUp().validateRepublishToActiveStatus();
				}
				
				else if(browser.contains("MicrosoftEdge"))
				{
					UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
					Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");
					endoflistingdate=prop.getProperty("EDGE_IHTC_BASEPRICEINREPUBLISH_LISTINGS_BOTH");
					//setData(browser);
					new IHTC_Company_Login_Page(driver, test)
					.enterCredentials(UserName, Password)
					.clickListings().clickParticularListInactiveEdge().clickActions()
					.clickRepublish().enterendflistingInRepublish(endoflistingdate).clickOkRepublish().scrollUp().validateRepublishToActiveStatus();
				}


			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


		}

	}

