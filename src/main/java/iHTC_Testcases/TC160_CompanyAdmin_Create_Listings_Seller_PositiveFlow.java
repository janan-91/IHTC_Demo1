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

	public class TC160_CompanyAdmin_Create_Listings_Seller_PositiveFlow extends ProjectMethods {
		
		private String UserName = "";
		private String Password = "";
		private String title="";
		private String weight="";
		private String batchno="";
		private String baseprice="";
		private String buyitnow="";
		private String endoflistings="";
		private String dateofanalysis="";
		
		private String Sadminusername="";
		private String Spassword="";
		
		@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
		public void setData() {

			testCaseName = "IHTC_160_CompanyAdmin_Create_Listings_Seller_PositiveFlow";
			testDescription = "create new listings as company admin(Seller) to validate active status";
			authors = "Mohammad Rafi";
			browserName = "chrome";
			runGroup = "IHTC";
		}
		
		@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
		public void TC160_CompanyAdmin_Create_Listings_Seller_PositiveFlow() throws InterruptedException
		{
		
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

				String browser = driver.getCapabilities().getBrowserName();
				
				Sadminusername= prop.getProperty("IHTC_USERNAME");
				Spassword= prop.getProperty("IHTC_PASSWORD");
				
							

				if(browser.contains("chrome"))
				{
				UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME_SELLER");
				Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD_SELLER");
				
				title = prop.getProperty("CHROME_IHTC_TITLE_LISTINGS_SELLER");
				weight = prop.getProperty("CHROME_IHTC_WEIGHT_LISTINGS_SELLER");
				batchno = prop.getProperty("CHROME_IHTC_BATCHNO_LISTINGS_SELLER");
				baseprice = prop.getProperty("CHROME_IHTC_BASEPRICE_LISTINGS_SELLER");
				buyitnow = prop.getProperty("CHROME_IHTC_BUYITNOW_LISTINGS_SELLER");
				endoflistings = prop.getProperty("CHROME_IHTC_ENDOFLISTING_LISTINGS_SELLER");
				dateofanalysis = prop.getProperty("CHROME_IHTC_DATEOFANALYSIS_LISTINGS_SELLER");
				
				
				new IHTC_Company_Login_Page(driver, test)
				
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).enterBaseprice(baseprice).enterBuyitnowprice(buyitnow).scrollDown()			
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()			
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus()			
				.clickActions().clickPublish().clickOkPublish().validateActiveStatus().Deletelisting(Sadminusername, Spassword, title);												
				}

				else if(browser.contains("firefox"))
				{
				UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME_SELLER");
				Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD_SELLER");
				
				title = prop.getProperty("FIREFOX_IHTC_TITLE_LISTINGS_SELLER");
				weight = prop.getProperty("FIREFOX_IHTC_WEIGHT_LISTINGS_SELLER");
				batchno = prop.getProperty("FIREFOX_IHTC_BATCHNO_LISTINGS_SELLER");
				baseprice= prop.getProperty("FIREFOX_IHTC_BASEPRICE_LISTINGS_SELLER");
				buyitnow= prop.getProperty("FIREFOX_IHTC_BUYITNOW_LISTINGS_SELLER");		
				endoflistings = prop.getProperty("FIREFOX_IHTC_ENDOFLISTING_LISTINGS_SELLER");
				dateofanalysis = prop.getProperty("FIREFOX_IHTC_DATEOFANALYSIS_LISTINGS_SELLER");
				
                new IHTC_Company_Login_Page(driver, test)
				
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).enterBaseprice(baseprice).enterBuyitnowprice(buyitnow).scrollDown()			
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()			
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus()			
				.clickActions().clickPublish().clickOkPublish().validateActiveStatus().Deletelisting(Sadminusername, Spassword, title);	
				}

				else if(browser.contains("Safari"))
				{
				UserName = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME_SELLER");
				Password = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD_SELLER");
				
			
				title = prop.getProperty("SAFARI_IHTC_TITLE_LISTINGS_SELLER");
				weight = prop.getProperty("SAFARI_IHTC_WEIGHT_LISTINGS_SELLER");
				batchno = prop.getProperty("SAFARI_IHTC_BATCHNO_LISTINGS_SELLER");
				baseprice = prop.getProperty("SAFARI_IHTC_BASEPRICE_LISTINGS_SELLER");
				buyitnow = prop.getProperty("SAFARI_IHTC_BUYITNOW_LISTINGS_SELLER");
				endoflistings = prop.getProperty("SAFARI_IHTC_ENDOFLISTING_LISTINGS_SELLER");
				dateofanalysis = prop.getProperty("SAFARI_IHTC_DATEOFANALYSIS_LISTINGS_SELLER");
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).scrollDown()			
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()			
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus()			
				.clickActions().clickPublish().clickOkPublish().validateActiveStatus().Deletelisting(Sadminusername, Spassword, title);	
				}
				
				else if(browser.contains("MicrosoftEdge"))
				{
				UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME_SELLER");
				Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD_SELLER");
				
							
				title = prop.getProperty("EDGE_IHTC_TITLE_LISTINGS_SELLER");
				weight = prop.getProperty("EDGE_IHTC_WEIGHT_LISTINGS_SELLER");
				batchno = prop.getProperty("EDGE_IHTC_BATCHNO_LISTINGS_SELLER");
				baseprice = prop.getProperty("EDGE_IHTC_BASEPRICE_LISTINGS_SELLER");
				buyitnow = prop.getProperty("EDGE_IHTC_BUYITNOW_LISTINGS_SELLER");
				endoflistings = prop.getProperty("EDGE_IHTC_ENDOFLISTING_LISTINGS_SELLER");
				dateofanalysis = prop.getProperty("EDGE_IHTC_DATEOFANALYSIS_LISTINGS_SELLER");
				//setData(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickListings().clickCreateListings().enterTitleListings(title).selectLocation()
				.selectCategory().enterWeight(weight).enterBatchNo(batchno).enterBaseprice(baseprice).enterBuyitnowprice(buyitnow).scrollDown()			
				.enterEndOfListing(endoflistings).uploadImageInCertificateOfAnalysis1().selectLaboratory()			
				.enterDateOfAnalysis(dateofanalysis).scrollDown().clickCreate().validateDraftStatus()			
				.clickActions().clickPublish().clickOkPublish().validateActiveStatus().Deletelisting(Sadminusername, Spassword, title);	
				}
				
				
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

	}

