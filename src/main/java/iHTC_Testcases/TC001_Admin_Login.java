package iHTC_Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IHTC_wdMethods.ProjectMethods;
import iHTC_page.IHTC_Login_Page;

public class TC001_Admin_Login extends ProjectMethods {

	private String UserName = "";
	private String Password = "";

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "Admin logo clickable";
		testDescription = "Ensure the Admin logo exists and the page refreshes once clicked.";
		authors = "Vinoth";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

			UserName = prop.getProperty("IHTC_USERNAME");
			Password = prop.getProperty("IHTC_PASSWORD");

			String browser = driver.getCapabilities().getBrowserName();

			if(browser.contains("chrome"))
			{
				System.out.println(browser);
			new IHTC_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickIhtcLogo();
			}

			else if(browser.contains("firefox"))
			{
			new IHTC_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickIhtcLogo();
			}

			else if(browser.contains("safari"))
			{
			new IHTC_Login_Page(driver, test)
			.enterCredentials(UserName, Password)
			.clickIhtcLogo();
			}
			
			else if(browser.contains("edge"))
			{
			new IHTC_Login_Page(driver, test)
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