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

	public class TC154_CompanyAdmin_Create_Listings_Both_Validate_EOL_DOA extends ProjectMethods {
		
		private String UserName = "";
		private String Password = "";
		private String title="";
		private String weight="";
		private String batchno="";
		private String endoflistings="";
		private String dateofanalysis="";
		
		@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
		public void setData() {

			testCaseName = "IHTC_154_CompanyAdmin_Create_Listings_Both_Validate_EOL_DOA";
			testDescription = "create new listings as company admin(Both) to validate EOL and DOA";
			authors = "Mohammad Rafi";
			browserName = "chrome";
			runGroup = "IHTC";
		}
		
		@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
		public void TC154_CompanyAdmin_Create_Listings_Both_Validate_EOL_DOA() throws InterruptedException
		{
		
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("D:\\Automation\\ihtc_qa\\ihtc-qa\\src\\main\\resources\\config.properties")));

				String browser = driver.getCapabilities().getBrowserName();
							

				if(browser.contains("chrome"))
				{
				UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD_BOTH");
				
				title = prop.getProperty("CHROME_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("CHROME_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("CHROME_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("CHROME_IHTC_ENDOFLISTING_LISTINGS_BOTH_INVALID_EOL");
				dateofanalysis = prop.getProperty("CHROME_IHTC_DATEOFANALYSIS_LISTINGS_BOTH_INVALID_DOA");
				
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()		
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()	
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDOAAndEOL();												
				
				}

				else if(browser.contains("firefox"))
				{
				UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD_BOTH");
				
				title = prop.getProperty("FIREFOX_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("FIREFOX_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("FIREFOX_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("FIREFOX_IHTC_ENDOFLISTING_LISTINGS_BOTH_INVALID_EOL");
				dateofanalysis = prop.getProperty("FIREFOX_IHTC_DATEOFANALYSIS_LISTINGS_BOTH_INVALID_DOA");
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()		
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()	
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDOAAndEOL();	
				}

				else if(browser.contains("Safari"))
				{
				UserName = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD_BOTH");
				
				title = prop.getProperty("SAFARI_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("SAFARI_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("SAFARI_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("SAFARI_IHTC_ENDOFLISTING_LISTINGS_BOTH_INVALID_EOL");
				dateofanalysis = prop.getProperty("SAFARI_IHTC_DATEOFANALYSIS_LISTINGS_BOTH_INVALID_DOA");
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()		
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()	
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDOAAndEOL();
				}
				
				else if(browser.contains("MicrosoftEdge"))
				{
				UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD_BOTH");
				
				title = prop.getProperty("EDGE_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("EDGE_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("EDGE_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("EDGE_IHTC_ENDOFLISTING_LISTINGS_BOTH_INVALID_EOL");
				dateofanalysis = prop.getProperty("EDGE_IHTC_DATEOFANALYSIS_LISTINGS_BOTH_INVALID_DOA");
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()		
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()	
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDOAAndEOL();
				}
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

	}


