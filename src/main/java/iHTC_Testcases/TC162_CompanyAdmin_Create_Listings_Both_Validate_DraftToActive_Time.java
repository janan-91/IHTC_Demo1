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

	public class TC162_CompanyAdmin_Create_Listings_Both_Validate_DraftToActive_Time extends ProjectMethods {
		
		private String UserName = "";
		private String Password = "";
		private String title="";
		private String weight="";
		private String batchno="";
		private String endoflistings="";
		private String dateofanalysis="";
		
		@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
		public void setData() {

			testCaseName = "IHTC_162_CompanyAdmin_Create_Listings_Both_Validate_DraftToActive_Time";
			testDescription = "create new listings as company admin(Both) to validate draft to active status(time)";
			authors = "Naveen";
			browserName = "chrome";
			runGroup = "IHTC";
			
		}
		
		@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
		public void TC162_CompanyAdmin_Create_Listings_Both_Validate_DraftToActive_Time() throws InterruptedException
		{
		
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

				String browser = driver.getCapabilities().getBrowserName();
							

				if(browser.contains("chrome"))
				{
				UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD_BOTH");
				
				title = prop.getProperty("CHROME_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("CHROME_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("CHROME_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("CHROME_IHTC_ENDOFLISTING_LISTINGS_BOTH");
				dateofanalysis = prop.getProperty("CHROME_IHTC_DATEOFANALYSIS_LISTINGS_BOTH");
				
				
				new IHTC_Company_Login_Page(driver, test)
				
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis().selectLaboratory()
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus().explicitlyWaiting()	
				.clickActions().clickPublish().clickOkPublish().validateDraftToActiveStatusTime();
				}

				else if(browser.contains("firefox"))
				{
				UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD_BOTH");

				title = prop.getProperty("FIREFOX_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("FIREFOX_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("FIREFOX_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("FIREFOX_IHTC_ENDOFLISTING_LISTINGS_BOTH");
				dateofanalysis = prop.getProperty("FIREFOX_IHTC_DATEOFANALYSIS_LISTINGS_BOTH");
				
				new IHTC_Company_Login_Page(driver, test)
				
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis().selectLaboratory()
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus();			
				
				}

				else if(browser.contains("safari"))
				{
				UserName = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME");
				Password = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD");
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings();
				}
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

	}

