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

	public class TC161_CompanyAdmin_Create_Listings_BothAndBuyer_Validate_Draft extends ProjectMethods {
		
		private String UserName = "";
		private String Password = "";
		private String UserNameBuyer = "";
		private String PasswordBuyer = "";
		
		private String title="";
		private String weight="";
		private String batchno="";
		private String endoflistings="";
		private String dateofanalysis="";
		
		@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
		public void setData() {

			testCaseName = "IHTC_161_CompanyAdmin_Create_Listings_BothAndBuyer_Validate_Draft";
			testDescription = "create new listings as company admin(Both) to create draft status and login as buyer to validate the list with no draft status";
			authors = "Naveen";
			browserName = "chrome";
			runGroup = "IHTC";
			
		}
		
		@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
		public void TC161_CompanyAdmin_Create_Listings_BothAndBuyer_Validate_Draft() throws InterruptedException
		{
		
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

				String browser = driver.getCapabilities().getBrowserName();
							

				if(browser.contains("chrome"))
				{
				UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD_BOTH");
				
				
				UserNameBuyer = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME_BUYER");
				PasswordBuyer = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD_BUYER");
				
				title = prop.getProperty("CHROME_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("CHROME_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("CHROME_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("CHROME_IHTC_ENDOFLISTING_LISTINGS_BOTH");
				dateofanalysis = prop.getProperty("CHROME_IHTC_DATEOFANALYSIS_LISTINGS_BOTH");
				
				
				new IHTC_Company_Login_Page(driver, test)
				
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus().clickLogout();
				
				new IHTC_Company_Login_Page(driver, test)
				.launchIhtcAsCompanyAdmin()
				.enterCredentials(UserNameBuyer, PasswordBuyer)
				.clickListings().validateDraftStatusBuyer(title);
				
				}

				else if(browser.contains("firefox"))
				{
				UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME_BOTH");
				Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD_BOTH");
				
				UserNameBuyer = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME_BUYER");
				PasswordBuyer = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD_BUYER");

				title = prop.getProperty("FIREFOX_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("FIREFOX_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("FIREFOX_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("FIREFOX_IHTC_ENDOFLISTING_LISTINGS_BOTH");
				dateofanalysis = prop.getProperty("FIREFOX_IHTC_DATEOFANALYSIS_LISTINGS_BOTH");
				
				new IHTC_Company_Login_Page(driver, test)
				
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus().clickLogout();
				
				new IHTC_Company_Login_Page(driver, test)
				.launchIhtcAsCompanyAdmin()
				.enterCredentials(UserNameBuyer, PasswordBuyer)
				.clickListings().validateDraftStatusBuyer(title);		
				
				}

				else if(browser.contains("Safari"))
				{
				UserName = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME");
				Password = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD");
				
				UserNameBuyer = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME_BUYER");
				PasswordBuyer = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD_BUYER");
				
				title = prop.getProperty("SAFARI_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("SAFARI_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("SAFARI_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("SAFARI_IHTC_ENDOFLISTING_LISTINGS_BOTH");
				dateofanalysis = prop.getProperty("SAFARI_IHTC_DATEOFANALYSIS_LISTINGS_BOTH");
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus().clickLogout();
				
				new IHTC_Company_Login_Page(driver, test)
				.launchIhtcAsCompanyAdmin()
				.enterCredentials(UserNameBuyer, PasswordBuyer)
				.clickListings().validateDraftStatusBuyer(title);
				}
				
				else if(browser.contains("MicrosoftEdge"))
				{
				UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
				Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");
				
				UserNameBuyer = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME_BUYER");
				PasswordBuyer = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD_BUYER");
				
				title = prop.getProperty("EDGE_IHTC_TITLE_LISTINGS_BOTH");
				weight = prop.getProperty("EDGE_IHTC_WEIGHT_LISTINGS_BOTH");
				batchno = prop.getProperty("EDGE_IHTC_BATCHNO_LISTINGS_BOTH");
				endoflistings = prop.getProperty("EDGE_IHTC_ENDOFLISTING_LISTINGS_BOTH");
				dateofanalysis = prop.getProperty("EDGE_IHTC_DATEOFANALYSIS_LISTINGS_BOTH");
				
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus().clickLogout();
				
				new IHTC_Company_Login_Page(driver, test)
				.launchIhtcAsCompanyAdmin()
				.enterCredentials(UserNameBuyer, PasswordBuyer)
				.clickListings().validateDraftStatusBuyer(title);
				}
				
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

	}

