package iHTC_Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.Ntifs.REPARSE_DATA_BUFFER;

import IHTC_wdMethods.ProjectMethods;
import iHTC_page.IHTC_SignUp_Page;

public class TC_05_Signup_Seller_CA_Feature_SignUp_06 extends ProjectMethods{
	
	private String FirstName = "";
	private String LastName = "";
	private String Email = "";
	private String PhoneNumber = "";
	private String CompanyName = "";
	private String CompanyPhoneNumber = "";
	private String Url = "";
	private String ProductDescription = "";
	private String AccountHolderName = "";
	private String AccountNumber = "";
	private String RoutingNumber = "";
	private String ResellerExpirationDate = "";
	private String DOB="";
	private String SSN="";
	private String Jobdescription="";
	
	private String AddressLine1 = "";
	private String City = "";
	private String Zip = "";
	private String FederalEIN = "";
	private String ExpirationDate = "";
	private String filepath="";
	private String Chrome_UserName = "";
	private String Chrome_Password = "";
	private String Chrome_SetPassword = "";
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "CA_Feature_Sign Up_06";
		testDescription = "To validate the user able to sign up as a Seller or not";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	
	
	public void IHTCPage() {

		Properties prop = new Properties();
		
		try {
			
			String browser = driver.getCapabilities().getBrowserName();
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			if(browser.contains("chrome"))
				
			{
				FirstName = prop.getProperty("CHROME_SELLER_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("CHROME_SELLER_SIGNUPLASTNAME");
				Email = prop.getProperty("CHROME_SELLER_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("CHROME_SELLER_SIGNUPPHONENUMBER");
				DOB = prop.getProperty("CHROME_SELLER_DOB");
				SSN= prop.getProperty("CHROME_SELLER_SSN");
				Jobdescription= prop.getProperty("CHROME_SELLER_JOBDESCRIPTION");
				
				CompanyName = prop.getProperty("CHROME_SELLER_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("CHROME_SELLER_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("CHROME_SELLER_ADDRESSLINE1");
				City = prop.getProperty("CHROME_SELLER_CITY");
				Zip = prop.getProperty("CHROME_SELLER_ZIPCODE");
				FederalEIN = prop.getProperty("CHROME_SELLER_FEDERANLEIN");
				ResellerExpirationDate = prop.getProperty("CHROME_SELLER_RESELLEREXPIRATIONDATE");
				ExpirationDate = prop.getProperty("CHROME_SELLER_EXPIRATIONDATE");
				Url = prop.getProperty("CHROME_SELLER_URL");
				ProductDescription = prop.getProperty("CHROME_SELLER_PRODUCTDESCRIPTION");
				AccountHolderName = prop.getProperty("CHROME_SELLER_ACCOUNTHOLDERNAME");
				AccountNumber = prop.getProperty("CHROME_SELLER_ACCOUNTNUMBER");
				RoutingNumber = prop.getProperty("CHROME_SELLER_ROUTINGNUMBER");
				filepath= prop.getProperty("PATH_UPLOAD_FILE");
				
				Chrome_UserName = prop.getProperty("CHROME_SELLER_IHTC_GMAIL_USERNAME");
				Chrome_Password = prop.getProperty("CHROME_SELLER_IHTC_GMAIL_PASSWORD");
				Chrome_SetPassword = prop.getProperty("CHROME_SELLER_GMAIL_SETNEWPASSWORD");
				
				
				System.out.println(browser);
				
				new IHTC_SignUp_Page (driver, test)
				
				.clicksellerradiobutton()
				.signupbuyer_Checklist()
				.SellerButton()
				.enterFirstname(FirstName)
				.enterLastname(LastName)
				.enterEmail(Email)
				.enterPhoneNumber(PhoneNumber)
				.Dateofbirth(DOB)
				.entersellerAddressLine1(AddressLine1)
				.enterrepCity(City)
				.repstateDropDown()
				.enterrepZipCode(Zip)
				.SSNdigit(SSN)
				.Jobdescription(Jobdescription)
				
				.enterName(CompanyName)
				.entercompanyPhoneNumber(CompanyPhoneNumber)
				.enterAddressLine1(AddressLine1)
				.enterCompanyCity(City)
				.stateDropDown()
				.enterZipCode(Zip)
				.CompanyUrl(Url)
				.productDescription(ProductDescription)
				
				.accountHolderName(AccountHolderName)
				.RoutingNumber(RoutingNumber)
				.accountNumber(AccountNumber)
				
				.Agriculturecertificateupload(filepath)
				.FederalEINupload(filepath)
				.FederalEIN(FederalEIN)
				.Resellercertificateupload(filepath)
				.ResellerExpirationDate(ExpirationDate)
				.Formationcertificateupload(filepath)
				.BusinessLicenceupload(filepath)
				.BussinessExpirationDate(ExpirationDate)
				
				
				.howDidYouHearAbout()
				.submitButton()
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Deletecompany1();
								
			}

			else if(browser.contains("firefox"))
				
			{
				FirstName = prop.getProperty("FIREFOX_SELLER_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("FIREFOX_SELLER_SIGNUPLASTNAME");
				Email = prop.getProperty("FIREFOX_SELLER_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("FIREFOX_SELLER_SIGNUPPHONENUMBER");
				DOB = prop.getProperty("FIREFOX_SELLER_DOB");
				SSN= prop.getProperty("FIREFOX_SELLER_SSN");
				Jobdescription= prop.getProperty("FIREFOX_SELLER_JOBDESCRIPTION");
				
				CompanyName = prop.getProperty("FIREFOX_SELLER_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("FIREFOX_SELLER_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("FIREFOX_SELLER_ADDRESSLINE1");
				City = prop.getProperty("FIREFOX_SELLER_CITY");
				Zip = prop.getProperty("FIREFOX_SELLER_ZIPCODE");
				FederalEIN = prop.getProperty("FIREFOX_SELLER_FEDERANLEIN");
				ResellerExpirationDate = prop.getProperty("FIREFOX_SELLER_RESELLEREXPIRATIONDATE");
				ExpirationDate = prop.getProperty("FIREFOX_SELLER_EXPIRATIONDATE");
				Url = prop.getProperty("FIREFOX_SELLER_URL");
				ProductDescription = prop.getProperty("FIREFOX_SELLER_PRODUCTDESCRIPTION");
				AccountHolderName = prop.getProperty("FIREFOX_SELLER_ACCOUNTHOLDERNAME");
				AccountNumber = prop.getProperty("FIREFOX_SELLER_ACCOUNTNUMBER");
				RoutingNumber = prop.getProperty("FIREFOX_SELLER_ROUTINGNUMBER");
				filepath= prop.getProperty("PATH_UPLOAD_FILE");
				
				System.out.println(browser);
				
				new IHTC_SignUp_Page (driver, test)
				.clicksellerradiobutton()
				.signupbuyer_Checklist()
				.SellerButton()
				.enterFirstname(FirstName)
				.enterLastname(LastName)
				.enterEmail(Email)
				.enterPhoneNumber(PhoneNumber)
				.Dateofbirth(DOB)
				.entersellerAddressLine1(AddressLine1)
				.enterrepCity(City)
				.repstateDropDown()
				.enterrepZipCode(Zip)
				.SSNdigit(SSN)
				.Jobdescription(Jobdescription)
				
				.enterName(CompanyName)
				.entercompanyPhoneNumber(PhoneNumber)
				.enterAddressLine1(AddressLine1)
				.enterCompanyCity(City)
				.stateDropDown()
				.enterZipCode(Zip)
				.CompanyUrl(Url)
				.productDescription(ProductDescription)
				
				.accountHolderName(AccountHolderName)
				.RoutingNumber(RoutingNumber)
				.accountNumber(AccountNumber)
				
				.Agriculturecertificateupload(filepath)
				.FederalEINupload(filepath)
				.FederalEIN(FederalEIN)
				.Resellercertificateupload(filepath)
				.ResellerExpirationDate(ExpirationDate)
				.Formationcertificateupload(filepath)
				.BusinessLicenceupload(filepath)
				.BussinessExpirationDate(ExpirationDate)
				
				
				.howDidYouHearAbout()
				.submitButton()
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Deletecompany1();
				

			}

			else if(browser.contains("Safari"))
				
			{
				
				FirstName = prop.getProperty("SAFARI_SELLER_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("SAFARI_SELLER_SIGNUPLASTNAME");
				Email = prop.getProperty("SAFARI_SELLER_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("SAFARI_SELLER_SIGNUPPHONENUMBER");
				DOB = prop.getProperty("SAFARI_SELLER_DOB");
				SSN= prop.getProperty("SAFARI_SELLER_SSN");
				Jobdescription= prop.getProperty("SAFARI_SELLER_JOBDESCRIPTION");
				
				CompanyName = prop.getProperty("SAFARI_SELLER_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("SAFARI_SELLER_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("SAFARI_SELLER_ADDRESSLINE1");
				City = prop.getProperty("SAFARI_SELLER_CITY");
				Zip = prop.getProperty("SAFARI_SELLER_ZIPCODE");
				FederalEIN = prop.getProperty("SAFARI_SELLER_FEDERANLEIN");
				ResellerExpirationDate = prop.getProperty("SAFARI_SELLER_RESELLEREXPIRATIONDATE");
				ExpirationDate = prop.getProperty("SAFARI_SELLER_EXPIRATIONDATE");
				Url = prop.getProperty("SAFARI_SELLER_URL");
				ProductDescription = prop.getProperty("SAFARI_SELLER_PRODUCTDESCRIPTION");
				AccountHolderName = prop.getProperty("SAFARI_SELLER_ACCOUNTHOLDERNAME");
				AccountNumber = prop.getProperty("SAFARI_SELLER_ACCOUNTNUMBER");
				RoutingNumber = prop.getProperty("SAFARI_SELLER_ROUTINGNUMBER");
				filepath= prop.getProperty("PATH_UPLOAD_FILE");
				
				System.out.println(browser);
				
				new IHTC_SignUp_Page (driver, test)
				
				.clicksellerradiobutton()
				.signupbuyer_Checklist()
				.SellerButton()
				.enterFirstname(FirstName)
				.enterLastname(LastName)
				.enterEmail(Email)
				.enterPhoneNumber(PhoneNumber)
				.Dateofbirth(DOB)
				.entersellerAddressLine1(AddressLine1)
				.enterrepCity(City)
				.repstateDropDown()
				.enterrepZipCode(Zip)
				.SSNdigit(SSN)
				.Jobdescription(Jobdescription)
				
				.enterName(CompanyName)
				.entercompanyPhoneNumber(PhoneNumber)
				.enterAddressLine1(AddressLine1)
				.enterCompanyCity(City)
				.stateDropDown()
				.enterZipCode(Zip)
				.CompanyUrl(Url)
				.productDescription(ProductDescription)
				
				.accountHolderName(AccountHolderName)
				.RoutingNumber(RoutingNumber)
				.accountNumber(AccountNumber)
				
				.Agriculturecertificateupload(filepath)
				.FederalEINupload(filepath)
				.FederalEIN(FederalEIN)
				.Resellercertificateupload(filepath)
				.ResellerExpirationDate(ExpirationDate)
				.Formationcertificateupload(filepath)
				.BusinessLicenceupload(filepath)
				.BussinessExpirationDate(ExpirationDate)
				
				
				.howDidYouHearAbout()
				.submitButton()
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Deletecompany1();
				

			}
			
			else if(browser.contains("MicrosoftEdge"))
			{
				FirstName = prop.getProperty("EDGE_SELLER_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("EDGE_SELLER_SIGNUPLASTNAME");
				Email = prop.getProperty("EDGE_SELLER_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("EDGE_SELLER_SIGNUPPHONENUMBER");
				DOB = prop.getProperty("EDGE_SELLER_DOB");
				SSN= prop.getProperty("EDGE_SELLER_SSN");
				Jobdescription= prop.getProperty("EDGE_SELLER_JOBDESCRIPTION");
				
				CompanyName = prop.getProperty("EDGE_SELLER_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("EDGE_SELLER_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("EDGE_SELLER_ADDRESSLINE1");
				City = prop.getProperty("EDGE_SELLER_CITY");
				Zip = prop.getProperty("EDGE_SELLER_ZIPCODE");
				FederalEIN = prop.getProperty("EDGE_SELLER_FEDERANLEIN");
				ResellerExpirationDate = prop.getProperty("EDGE_SELLER_RESELLEREXPIRATIONDATE");
				ExpirationDate = prop.getProperty("EDGE_SELLER_EXPIRATIONDATE");
				Url = prop.getProperty("EDGE_SELLER_URL");
				ProductDescription = prop.getProperty("EDGE_SELLER_PRODUCTDESCRIPTION");
				AccountHolderName = prop.getProperty("EDGE_SELLER_ACCOUNTHOLDERNAME");
				AccountNumber = prop.getProperty("EDGE_SELLER_ACCOUNTNUMBER");
				RoutingNumber = prop.getProperty("EDGE_SELLER_ROUTINGNUMBER");
				filepath= prop.getProperty("PATH_UPLOAD_FILE");
				
				System.out.println(browser);
				
				new IHTC_SignUp_Page (driver, test)
				
				.clicksellerradiobutton()
				.signupbuyer_Checklist()
				.SellerButton()
				.enterFirstname(FirstName)
				.enterLastname(LastName)
				.enterEmail(Email)
				.enterPhoneNumber(PhoneNumber)
				.Dateofbirth(DOB)
				.entersellerAddressLine1(AddressLine1)
				.enterrepCity(City)
				.repstateDropDown()
				.enterrepZipCode(Zip)
				.SSNdigit(SSN)
				.Jobdescription(Jobdescription)
				
				.enterName(CompanyName)
				.entercompanyPhoneNumber(PhoneNumber)
				.enterAddressLine1(AddressLine1)
				.enterCompanyCity(City)
				.stateDropDown()
				.enterZipCode(Zip)
				.CompanyUrl(Url)
				.productDescription(ProductDescription)
				
				.accountHolderName(AccountHolderName)
				.RoutingNumber(RoutingNumber)
				.accountNumber(AccountNumber)
				
				.Agriculturecertificateupload(filepath)
				.FederalEINupload(filepath)
				.FederalEIN(FederalEIN)
				.Resellercertificateupload(filepath)
				.ResellerExpirationDate(ExpirationDate)
				.Formationcertificateupload(filepath)
				.BusinessLicenceupload(filepath)
				.BussinessExpirationDate(ExpirationDate)
				
				
				.howDidYouHearAbout()
				.submitButton()
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Deletecompany1();
				

				
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	

}
