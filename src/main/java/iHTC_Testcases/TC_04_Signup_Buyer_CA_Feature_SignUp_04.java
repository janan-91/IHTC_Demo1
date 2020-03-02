package iHTC_Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IHTC_wdMethods.ProjectMethods;
import iHTC_page.IHTC_SignUp_Page;

public class TC_04_Signup_Buyer_CA_Feature_SignUp_04 extends ProjectMethods{
	
	private String FirstName = "";
	private String LastName = "";
	private String Email = "";
	private String PhoneNumber = "";
	private String CompanyName = "";
	private String CompanyPhoneNumber = "";
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

		testCaseName = "CA_Feature_Sign Up_04";
		testDescription = "To validate the user able to sign up as a buyer or not";
		authors = "Prabu";
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
				System.out.println("Browser is: "+browser);
				
				FirstName = prop.getProperty("CHROME_BUYER_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("CHROME_BUYER_SIGNUPLASTNAME");
				Email = prop.getProperty("CHROME_BUYER_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("CHROME_BUYER_SIGNUPPHONENUMBER");
				CompanyName = prop.getProperty("CHROME_BUYER_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("CHROME_BUYER_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("CHROME_BUYER_ADDRESSLINE1");
				City = prop.getProperty("CHROME_BUYER_CITY");
				Zip = prop.getProperty("CHROME_BUYER_ZIPCODE");
				FederalEIN = prop.getProperty("CHROME_BUYER_FEDERANLEIN");
				ExpirationDate = prop.getProperty("CHROME_BUYER_EXPIRATIONDATE");
				filepath= prop.getProperty("PATH_UPLOAD_FILE");
				
				new IHTC_SignUp_Page (driver, test)
				
				.signupbuyer_Checklist()
				.enterFirstname(FirstName)
				.enterLastname(LastName)
				.enterEmail(Email)
				.enterPhoneNumber(PhoneNumber)
				.enterName(CompanyName)
				.enterCompanyPhoneNumber(CompanyPhoneNumber)
				.enterAddressLine1(AddressLine1)
				.enterCompanyCity(City)
				.stateDropDown()
				.enterZipCode(Zip)
				
				.Agriculturecertificateupload(filepath)
				.FederalEINupload(filepath)
				.FederalEIN(FederalEIN)
				.Formationcertificateupload(filepath)
				.BusinessLicenceupload(filepath)
				.BussinessExpirationDate(ExpirationDate)
				.howDidYouHearAbout()
				.submitButton()
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Deletecompany();
	
				/*.entergmailusername(Chrome_UserName)
				.clicknextbutton()
				.entergmailpassword(Chrome_Password)
				.clicknextbutton()
				.clickslingremail()
				.clickurlLink()
				.enternewpassword(Chrome_SetPassword)
				.getredirectedportalUrl()
				.CA_login(Chrome_UserName, Chrome_SetPassword)
				.Company();*/
				
			}

			else if(browser.contains("firefox"))
				
			{
				
				FirstName = prop.getProperty("FIREFOX_BUYER_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("FIREFOX_BUYER_SIGNUPLASTNAME");
				Email = prop.getProperty("FIREFOX_BUYER_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("FIREFOX_BUYER_SIGNUPPHONENUMBER");
				CompanyName = prop.getProperty("FIREFOX_BUYER_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("FIREFOX_BUYER_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("FIREFOX_BUYER_ADDRESSLINE1");
				City = prop.getProperty("FIREFOX_BUYER_CITY");
				Zip = prop.getProperty("FIREFOX_BUYER_ZIPCODE");
				FederalEIN = prop.getProperty("FIREFOX_BUYER_FEDERANLEIN");
				ExpirationDate = prop.getProperty("FIREFOX_BUYER_EXPIRATIONDATE");
				filepath= prop.getProperty("PATH_UPLOAD_FILE");
				
				new IHTC_SignUp_Page (driver, test)
				
				.signupbuyer_Checklist()
				.enterFirstname(FirstName)
				.enterLastname(LastName)
				.enterEmail(Email)
				.enterPhoneNumber(PhoneNumber)
				.enterName(CompanyName)
				.enterCompanyPhoneNumber(CompanyPhoneNumber)
				.enterAddressLine1(AddressLine1)
				.enterCompanyCity(City)
				.stateDropDown()
				.enterZipCode(Zip)
				
				.Agriculturecertificateupload(filepath)
				.FederalEINupload(filepath)
				.FederalEIN(FederalEIN)
				.Formationcertificateupload(filepath)
				.BusinessLicenceupload(filepath)
				.BussinessExpirationDate(ExpirationDate)
				.howDidYouHearAbout()
				.submitButton()
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Deletecompany();
	
				
			}

			else if(browser.contains("Safari"))
				
			{
				
				FirstName = prop.getProperty("SAFARI_BUYER_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("SAFARI_BUYER_SIGNUPLASTNAME");
				Email = prop.getProperty("SAFARI_BUYER_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("SAFARI_BUYER_SIGNUPPHONENUMBER");
				CompanyName = prop.getProperty("SAFARI_BUYER_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("SAFARI_BUYER_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("SAFARI_BUYER_ADDRESSLINE1");
				City = prop.getProperty("SAFARI_BUYER_CITY");
				Zip = prop.getProperty("SAFARI_BUYER_ZIPCODE");
				FederalEIN = prop.getProperty("SAFARI_BUYER_FEDERANLEIN");
				ExpirationDate = prop.getProperty("SAFARI_BUYER_EXPIRATIONDATE");
				filepath= prop.getProperty("PATH_UPLOAD_FILE");
				
				new IHTC_SignUp_Page (driver, test)
				
				.signupbuyer_Checklist()
				.enterFirstname(FirstName)
				.enterLastname(LastName)
				.enterEmail(Email)
				.enterPhoneNumber(PhoneNumber)
				.enterName(CompanyName)
				.enterCompanyPhoneNumber(CompanyPhoneNumber)
				.enterAddressLine1(AddressLine1)
				.enterCompanyCity(City)
				.stateDropDown()
				.enterZipCode(Zip)
				
				.Agriculturecertificateupload(filepath)
				.FederalEINupload(filepath)
				.FederalEIN(FederalEIN)
				.Formationcertificateupload(filepath)
				.BusinessLicenceupload(filepath)
				.BussinessExpirationDate(ExpirationDate)
				.howDidYouHearAbout()
				.submitButton()
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Deletecompany();
	
				
			}
			
			else if(browser.contains("MicrosoftEdge"))
				
			{
				
				FirstName = prop.getProperty("EDGE_BUYER_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("EDGE_BUYER_SIGNUPLASTNAME");
				Email = prop.getProperty("EDGE_BUYER_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("EDGE_BUYER_SIGNUPPHONENUMBER");
				CompanyName = prop.getProperty("EDGE_BUYER_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("EDGE_BUYER_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("EDGE_BUYER_ADDRESSLINE1");
				City = prop.getProperty("EDGE_BUYER_CITY");
				Zip = prop.getProperty("EDGE_BUYER_ZIPCODE");
				FederalEIN = prop.getProperty("EDGE_BUYER_FEDERANLEIN");
				ExpirationDate = prop.getProperty("EDGE_BUYER_EXPIRATIONDATE");
				filepath= prop.getProperty("PATH_UPLOAD_FILE");
				
				new IHTC_SignUp_Page (driver, test)
				
				.signupbuyer_Checklist()
				.enterFirstname(FirstName)
				.enterLastname(LastName)
				.enterEmail(Email)
				.enterPhoneNumber(PhoneNumber)
				.enterName(CompanyName)
				.enterCompanyPhoneNumber(CompanyPhoneNumber)
				.enterAddressLine1(AddressLine1)
				.enterCompanyCity(City)
				.stateDropDown()
				.enterZipCode(Zip)
				
				.Agriculturecertificateupload(filepath)
				.FederalEINupload(filepath)
				.FederalEIN(FederalEIN)
				.Formationcertificateupload(filepath)
				.BusinessLicenceupload(filepath)
				.BussinessExpirationDate(ExpirationDate)
				.howDidYouHearAbout()
				.submitButton()
				.GetCompanystatus("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Deletecompany();
	
				
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
