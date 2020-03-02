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


public class TC_Companyadmin_Login extends ProjectMethods {
	
	private String UserName = "";
	private String Password = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Company Admin login";
		testDescription = "This is the common method to login as company admin";
		authors = "Prabu";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
			{
			UserName = prop.getProperty("CHROME_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("CHROME_IHTC_COMPANY_PASSWORD");
			//setData(browser);
			new IHTC_Company_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickIhtcLogo();
			}

			else if(browser.contains("firefox"))
			{
			UserName = prop.getProperty("FIREFOX_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("FIREFOX_IHTC_COMPANY_PASSWORD");
			//setData(browser);
			new IHTC_Company_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickIhtcLogo();
			}

			else if(browser.contains("safari"))
			{
			UserName = prop.getProperty("SAFARI_IHTC_COMPANY_USERNAME");
			Password = prop.getProperty("SAFARI_IHTC_COMPANY_PASSWORD");
			//setData(browser);
			new IHTC_Company_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickIhtcLogo();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
