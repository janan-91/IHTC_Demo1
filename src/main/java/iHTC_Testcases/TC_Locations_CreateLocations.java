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

public class TC_Locations_CreateLocations extends ProjectMethods{
	
	private String UserName = "";
	private String Password = "";
	private String Chrome_LocationName = "";
	private String Chrome_PhoneLocation = "";
	private String Chrome_AddressLocation = "";
	private String Chrome_CityLocation = "";
	private String Chrome_ZipCodeLocation = "";
	
	private String Firefox_LocationName = "";
	private String Firefox_PhoneLocation = "";
	private String Firefox_AddressLocation = "";
	private String Firefox_CityLocation = "";
	private String Firefox_ZipCodeLocation = "";
	
	private String Safari_LocationName = "";
	private String Safari_PhoneLocation = "";
	private String Safari_AddressLocation = "";
	private String Safari_CityLocation = "";
	private String Safari_ZipCodeLocation = "";
	
	private String Edge_LocationName = "";
	private String Edge_PhoneLocation = "";
	private String Edge_AddressLocation = "";
	private String Edge_CityLocation = "";
	private String Edge_ZipCodeLocation = "";
	
	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	
	public void setData() {

		testCaseName = "Create Locations";
		testDescription = "Creating a new locations";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() {

		Properties prop = new Properties();
		
		try {
			
			
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD");
			Chrome_LocationName = prop.getProperty("CHROME_NAME_LOCATIONS");
			Chrome_PhoneLocation = prop.getProperty("CHROME_PHONENUMBER_LOCATIONS");
			Chrome_AddressLocation = prop.getProperty("CHROME_ADDRESS_LOCATIONS");
			Chrome_CityLocation = prop.getProperty("CHROME_CITY_LOCATIONS");
			Chrome_ZipCodeLocation = prop.getProperty("CHROME_ZIPCODE_LOCATIONS");
			
			UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD");
			Firefox_LocationName = prop.getProperty("FIREFOX_NAME_LOCATIONS");
			Firefox_PhoneLocation = prop.getProperty("FIREFOX_PHONENUMBER_LOCATIONS");
			Firefox_AddressLocation = prop.getProperty("FIREFOX_ADDRESS_LOCATIONS");
			Firefox_CityLocation = prop.getProperty("FIREFOX_CITY_LOCATIONS");
			Firefox_ZipCodeLocation = prop.getProperty("FIREFOX_ZIPCODE_LOCATIONS");
			
			UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");
			Safari_LocationName = prop.getProperty("SAFARI_NAME_LOCATIONS");
			Safari_PhoneLocation = prop.getProperty("SAFARI_PHONENUMBER_LOCATIONS");
			Safari_AddressLocation = prop.getProperty("SAFARI_ADDRESS_LOCATIONS");
			Safari_CityLocation = prop.getProperty("SAFARI_CITY_LOCATIONS");
			Safari_ZipCodeLocation = prop.getProperty("SAFARI_ZIPCODE_LOCATIONS");
			
			UserName = prop.getProperty("EDGE_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("EDGE_IHTC_COMPANY_PASSWORD");
			Edge_LocationName = prop.getProperty("EDGE_NAME_LOCATIONS");
			Edge_PhoneLocation = prop.getProperty("EDGE_PHONENUMBER_LOCATIONS");
			Edge_AddressLocation = prop.getProperty("EDGE_ADDRESS_LOCATIONS");
			Edge_CityLocation = prop.getProperty("EDGE_CITY_LOCATIONS");
			Edge_ZipCodeLocation = prop.getProperty("EDGE_ZIPCODE_LOCATIONS");
			
			String browser = driver.getCapabilities().getBrowserName();
		
			if(browser.contains("chrome"))
				
			{
				System.out.println(browser);
				System.out.println(Chrome_LocationName);
			new IHTC_Company_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickLocations()
			.CreateLocations()
			.NameLocation(Chrome_LocationName)
			.PhoneLocation(Chrome_PhoneLocation)
			.AddressLocation(Chrome_AddressLocation)
			.CityLocation(Chrome_CityLocation)
			.StateLocation()
			.ZipCodeLocation(Chrome_ZipCodeLocation)
			.FinalCreateLocation()
			.StatusLocation();
			
			}
			
			else if(browser.contains("firefox"))

			{
				
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickLocations()
				.CreateLocations()
				.NameLocation(Firefox_LocationName)
				.PhoneLocation(Firefox_PhoneLocation)
				.AddressLocation(Firefox_AddressLocation)
				.CityLocation(Firefox_CityLocation)
				.StateLocation()
				.ZipCodeLocation(Firefox_ZipCodeLocation)
				.FinalCreateLocation()
				.StatusLocation();
		
			}

			else if(browser.contains("MicrosoftEdge"))
				
			{
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickLocations()
				.CreateLocations()
				.NameLocation(Edge_LocationName)
				.PhoneLocation(Edge_PhoneLocation)
				.AddressLocation(Edge_AddressLocation)
				.CityLocation(Edge_CityLocation)
				.StateLocation()
				.ZipCodeLocation(Edge_ZipCodeLocation)
				.FinalCreateLocation()
				.StatusLocation();	
			}
			
			else if(browser.contains("Safari"))
				
			{
				
				System.out.println(browser);
				new IHTC_Company_Login_Page(driver, test)
				.enterCredentials(UserName, Password)
				.clickLocations()
				.CreateLocations()
				.NameLocation(Safari_LocationName)
				.PhoneLocation(Safari_PhoneLocation)
				.AddressLocation(Safari_AddressLocation)
				.CityLocation(Safari_CityLocation)
				.StateLocation()
				.ZipCodeLocation(Safari_ZipCodeLocation)
				.FinalCreateLocation()
				.StatusLocation();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
