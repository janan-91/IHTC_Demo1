package iHTC_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Login_Page extends ProjectMethods {

	public IHTC_Login_Page(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
	private WebElement eleUserName;

	public IHTC_Login_Page enterCredentials(String UserName, String Password) {

		waitForPageLoad(90);

		sleep(5000);

		iHTCcredentials(eleUserName, elePassword, eleLogin, UserName, Password);

		return this;
	}

	@FindBy(how = How.XPATH, using = "(.//input[@id='password'])")
	private WebElement elePassword;

	public IHTC_Login_Page enterPassword(String Password) {
		type(elePassword, Password);
		return this;
	}

	@FindBy(how = How.XPATH, using = "(.//div[@data-bind='button: loginSection.loginButton'])")
	private WebElement eleLogin;

	public IHTC_Login_Page clickLogin() {
		click(eleLogin);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//span[.='Waiting For Documentation']")
	private WebElement CompanyStatus;
	
	public IHTC_Login_Page CompanyStatus() {

		waitForPageLoad(90);

		sleep(5000);
		click(CompanyStatus);
		
		verifyText("Waiting For Documentation", CompanyStatus);

		return this;
	}

	@FindBy(how = How.XPATH, using = "(//span[.='www.HEMPTRADER.online'])")
	private WebElement eleIhtcLogo;

	public IHTC_All_Listings_Page clickIhtcLogo() {
		click(eleIhtcLogo);
		String title = driver.getTitle();
		System.out.println(title);
		return new IHTC_All_Listings_Page(driver, test);
	}
	
	@FindBy(how=How.XPATH, using = "((.//span[.='Listings'])[1])")
	public WebElement listingmenu;
	
	public IHTC_Companyadmin_Listing getlistingmenuname()
	{
		waitForPageLoad(90);

		sleep(5000);
		
		verifyText("Listings", listingmenu);
		click(listingmenu);
		return new IHTC_Companyadmin_Listing(driver,test);
		
	}
	
	@FindBy(how=How.XPATH, using=".//span[.='Companies']")
	private WebElement eleadmincompanymenu;
	
	public IHTC_Companyadmin_Status clickadmincompanymenu()
	{
		waitForPageLoad(20);
		click(eleadmincompanymenu);
		sleep(2000);
		return new IHTC_Companyadmin_Status(driver, test);
		
	}
	
	@FindBy(how=How.XPATH, using = "((.//span[.='Company'])[1])")
	public WebElement Companymenu;
	
	
	public IHTC_Companyadmin_Status clickcompany()
	{
		waitForPageLoad(60);
		sleep(3000);
		click(Companymenu);
		
		return new IHTC_Companyadmin_Status(driver,test);
		
	}
	
	
	
}
