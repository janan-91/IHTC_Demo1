package iHTC_Testcases;


	import java.awt.AWTException;
import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

//import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import IHTC_wdMethods.ProjectMethods;
import iHTC_page.IHTC_Company_Login_Page;
import iHTC_page.IHTC_Login_Page;

	public class TC151_CompanyAdmin_Create_Listings_Buyer extends ProjectMethods {
		
		private String UserName = "";
		private String Password = "";
		private String title="";
		private String weight="";
		private String batchno="";
		private String endoflistings="";
		private String dateofanalysis="";
		
		@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
		public void setData() {

			testCaseName = "IHTC_151_CompanyAdmin_Create_Listings";
			testDescription = "create new listings as company admin(Buyer)";
			authors = "Prabu";
			browserName = "chrome";
			runGroup = "IHTC";
		}
		
		@Test(groups = { "Regression", "Sanity", "Smoke" }, priority =1)
		public void TC151_CompanyAdmin_Create_Listings() throws InterruptedException, AWTException
		{
		
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

				String browser = driver.getCapabilities().getBrowserName();
						
				if(browser.contains("chrome"))
				{
				UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME_BUYER");
				Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD_BUYER");
				
				title = prop.getProperty("CHROME_IHTC_TITLE_LISTINGS_BUYER");
				weight = prop.getProperty("CHROME_IHTC_WEIGHT_LISTINGS_BUYER");
				batchno = prop.getProperty("CHROME_IHTC_BATCHNO_LISTINGS_BUYER");
				endoflistings = prop.getProperty("CHROME_IHTC_ENDOFLISTING_LISTINGS_BUYER");
				dateofanalysis = prop.getProperty("CHROME_IHTC_DATEOFANALYSIS_LISTINGS_BUYER");
								
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings()
				.enterTitleListings(title).selectLocation().selectCategory().enterWeight(weight)
				.enterBatchNo(batchno).scrollDown()				
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1()
				.selectLaboratory()				
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate()				
				//.scrollUp()
				.verifyErrorMsgBuyer();					
				}
				
				else if(browser.contains("firefox"))
				{
				UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME_BUYER");
				Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD_BUYER");
				
				title = prop.getProperty("FIREFOX_IHTC_TITLE_LISTINGS_BUYER");
				weight = prop.getProperty("FIREFOX_IHTC_WEIGHT_LISTINGS_BUYER");
				batchno = prop.getProperty("FIREFOX_IHTC_BATCHNO_LISTINGS_BUYER");
				endoflistings = prop.getProperty("FIREFOX_IHTC_ENDOFLISTING_LISTINGS_BUYER");
				dateofanalysis = prop.getProperty("FIREFOX_IHTC_DATEOFANALYSIS_LISTINGS_BUYER");
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings()
				.enterTitleListings(title).selectLocation().selectCategory().enterWeight(weight)
				.enterBatchNo(batchno).scrollDown()				
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()				
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate()				
				.scrollUp().verifyErrorMsgBuyer();
				}

				else if(browser.contains("Safari"))
				{
				UserName = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME_BUYER");
				Password = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD_BUYER");
				
				title = prop.getProperty("SAFARI_IHTC_TITLE_LISTINGS_BUYER");
				weight = prop.getProperty("SAFARI_IHTC_WEIGHT_LISTINGS_BUYER");
				batchno = prop.getProperty("SAFARI_IHTC_BATCHNO_LISTINGS_BUYER");
				endoflistings = prop.getProperty("SAFARI_IHTC_ENDOFLISTING_LISTINGS_BUYER");
				dateofanalysis = prop.getProperty("SAFARI_IHTC_DATEOFANALYSIS_LISTINGS_BUYER");
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings()
				.enterTitleListings(title).selectLocation().selectCategory().enterWeight(weight)
				.enterBatchNo(batchno).scrollDown()				
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()				
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate()				
				.scrollUp().verifyErrorMsgBuyer();
				}
				
				else if(browser.contains("MicrosoftEdge"))
				{
				UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME_BUYER");
				Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD_BUYER");
				
				title = prop.getProperty("EDGE_IHTC_TITLE_LISTINGS_BUYER");
				weight = prop.getProperty("EDGE_IHTC_WEIGHT_LISTINGS_BUYER");
				batchno = prop.getProperty("EDGE_IHTC_BATCHNO_LISTINGS_BUYER");
				endoflistings = prop.getProperty("EDGE_IHTC_ENDOFLISTING_LISTINGS_BUYER");
				dateofanalysis = prop.getProperty("EDGE_IHTC_DATEOFANALYSIS_LISTINGS_BUYER");
				
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings()
				.enterTitleListings(title).selectLocation().selectCategory().enterWeight(weight)
				.enterBatchNo(batchno).scrollDown()				
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()				
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate()				
				.scrollUp().verifyErrorMsgBuyer();
				}
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

	}

