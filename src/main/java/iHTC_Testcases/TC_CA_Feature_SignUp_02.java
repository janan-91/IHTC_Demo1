package iHTC_Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IHTC_wdMethods.ProjectMethods;

import iHTC_page.IHTC_SignUp_Page;

public class TC_CA_Feature_SignUp_02 extends ProjectMethods{
	
	private String FirstName = "";
	private String LastName = "";
	private String Email = "";
	private String PhoneNumber = "";
	private String CompanyName = "";
	private String CompanyPhoneNumber = "";
	private String AddressLine1 = "";
	private String City = "";
	private String Zip = "";
	private String Expirationdate= "";
	private String FederalEINnumber= "";
	private String filepath="";
	
	
	

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "CA_Feature_Sign Up_02";
		testDescription = "To validate without documentation the sign up process is completed or not";
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
				
				System.out.println(browser);
				
				FirstName = prop.getProperty("CHROME_BUYERWITHOUTDOC_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("CHROME_BUYERWITHOUTDOC_SIGNUPLASTNAME");
				Email = prop.getProperty("CHROME_BUYERWITHOUTDOC_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("CHROME_BUYERWITHOUTDOC_SIGNUPPHONENUMBER");
				CompanyName = prop.getProperty("CHROME_BUYERWITHOUTDOC_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("CHROME_BUYERWITHOUTDOC_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("CHROME_BUYERWITHOUTDOC_ADDRESSLINE1");
				City = prop.getProperty("CHROME_BUYERWITHOUTDOC_CITY");
				Zip = prop.getProperty("CHROME_BUYERWITHOUTDOC_ZIPCODE");
				Expirationdate=prop.getProperty("CHROME_BUYERWITHOUTDOC_EXPIRATIONDATE");
				FederalEINnumber=prop.getProperty("CHROME_BUYERWITHOUTDOC_FEDERALEIN");
				filepath=prop.getProperty("PATH_UPLOAD_FILE");
				
				
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
				
				.howDidYouHearAbout()
				.submitButton1()
				.GetCompanystatus_Withoutdocument("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Uploadmissingdocuments(Expirationdate,FederalEINnumber,filepath);
				
				
		
			}

			else if(browser.contains("firefox"))
				
			{
				System.out.println(browser);
				
				FirstName = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_SIGNUPLASTNAME");
				Email = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_SIGNUPPHONENUMBER");
				CompanyName = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_ADDRESSLINE1");
				City = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_CITY");
				Zip = prop.getProperty("FIREFOX_BUYERWITHOUTDOC_ZIPCODE");
				Expirationdate=prop.getProperty("FIREFOX_BUYERWITHOUTDOC_EXPIRATIONDATE");
				FederalEINnumber=prop.getProperty("FIREFOX_BUYERWITHOUTDOC_FEDERALEIN");
				filepath=prop.getProperty("PATH_UPLOAD_FILE");
				
				
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
				
				.howDidYouHearAbout()
				.submitButton1()
				.GetCompanystatus_Withoutdocument("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Uploadmissingdocuments(Expirationdate,FederalEINnumber,filepath);

			}

			else if(browser.contains("Safari"))
				
			{
				System.out.println(browser);
				
				FirstName = prop.getProperty("SAFARI_BUYERWITHOUTDOC_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("SAFARI_BUYERWITHOUTDOC_SIGNUPLASTNAME");
				Email = prop.getProperty("SAFARI_BUYERWITHOUTDOC_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("SAFARI_BUYERWITHOUTDOC_SIGNUPPHONENUMBER");
				CompanyName = prop.getProperty("SAFARI_BUYERWITHOUTDOC_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("SAFARI_BUYERWITHOUTDOC_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("SAFARI_BUYERWITHOUTDOC_ADDRESSLINE1");
				City = prop.getProperty("SAFARI_BUYERWITHOUTDOC_CITY");
				Zip = prop.getProperty("SAFARI_BUYERWITHOUTDOC_ZIPCODE");
				Expirationdate=prop.getProperty("SAFARI_BUYERWITHOUTDOC_EXPIRATIONDATE");
				FederalEINnumber=prop.getProperty("SAFARI_BUYERWITHOUTDOC_FEDERALEIN");
				filepath=prop.getProperty("PATH_UPLOAD_FILE");
				
				
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
				
				.howDidYouHearAbout()
				.submitButton1()
				.GetCompanystatus_Withoutdocument("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Uploadmissingdocuments(Expirationdate,FederalEINnumber,filepath);

				
			}
			
			else if(browser.contains("MicrosoftEdge")) 
			{
				
				System.out.println(browser);

				FirstName = prop.getProperty("EDGE_BUYERWITHOUTDOC_SIGNUPFIRSTNAME");
				LastName = prop.getProperty("EDGE_BUYERWITHOUTDOC_SIGNUPLASTNAME");
				Email = prop.getProperty("EDGE_BUYERWITHOUTDOC_SIGNUPEMAIL");
				PhoneNumber = prop.getProperty("EDGE_BUYERWITHOUTDOC_SIGNUPPHONENUMBER");
				CompanyName = prop.getProperty("EDGE_BUYERWITHOUTDOC_COMPANYNAME");
				CompanyPhoneNumber = prop.getProperty("EDGE_BUYERWITHOUTDOC_COMPANYPHONENUMBER");
				AddressLine1 = prop.getProperty("EDGE_BUYERWITHOUTDOC_ADDRESSLINE1");
				City = prop.getProperty("EDGE_BUYERWITHOUTDOC_CITY");
				Zip = prop.getProperty("EDGE_BUYERWITHOUTDOC_ZIPCODE");
				Expirationdate=prop.getProperty("EDGE_BUYERWITHOUTDOC_EXPIRATIONDATE");
				FederalEINnumber=prop.getProperty("EDGE_BUYERWITHOUTDOC_FEDERALEIN");
				filepath=prop.getProperty("PATH_UPLOAD_FILE");
				
				
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
				
				.howDidYouHearAbout()
				.submitButton1()
				.GetCompanystatus_Withoutdocument("arul.l@tringapps.com", "GeekyTringer2019", CompanyName)
				.Uploadmissingdocuments(Expirationdate,FederalEINnumber,filepath);
				
							}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
