package iHTC_Testcases;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IHTC_wdMethods.ProjectMethods;
import iHTC_page.IHTC_SignUp_Page;

public class TC_CA_Feature_SignUp_01 extends ProjectMethods{


	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void setData() {

		testCaseName = "CA_Feature_SignUp_01";
		testDescription = "To validate when the mandatory fields are not entered check whether the validation message is displayed or not";
		authors = "Rafi";
		browserName = "chrome";
		runGroup = "IHTC";
	}

	@Test(groups = { "Regression", "Sanity", "Smoke" }, priority = 1)
	public void IHTCPage() {

	
		try {
			
			String browser = driver.getCapabilities().getBrowserName();
			System.out.println(browser);

			if(browser.contains("chrome"))
				
			{
				System.out.println(browser);
				new IHTC_SignUp_Page (driver, test)
				
				.signupbuyer_Checklist()
				.alertcheck_Withoutdata();
				
			}

			else if(browser.contains("firefox"))
				
			{
				
				new IHTC_SignUp_Page (driver, test)
				
				.signupbuyer_Checklist()
				.submitButtonWithAlert();
			}

			else if(browser.contains("Safari"))
				
			{
				new IHTC_SignUp_Page (driver, test)
				
				.signupbuyer_Checklist()
				.submitButtonWithAlert();
			}
			
			else if(browser.contains("MicrosoftEdge"))
				
			{
				new IHTC_SignUp_Page (driver, test)
				
				.signupbuyer_Checklist()
				.submitButtonWithAlert();
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
