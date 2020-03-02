package iHTC_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Company_Page extends ProjectMethods{

	public IHTC_Company_Page(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//span[.='Waiting For Documentation']")
	private WebElement CompanyStatus;
	
	public IHTC_Company_Page CompanyStatus() {

		waitForPageLoad(90);

		sleep(5000);
		click(CompanyStatus);
		
		verifyText("Waiting For Documentation", CompanyStatus);

		return this;
	}
	
}
