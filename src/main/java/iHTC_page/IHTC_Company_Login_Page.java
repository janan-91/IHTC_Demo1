package iHTC_page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Company_Login_Page extends ProjectMethods {

	public IHTC_Company_Login_Page(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	//// Click SignIn /////
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-sm '] ")
	private WebElement SignIn;
	
	public IHTC_Company_Login_Page clickSignIn() {
		
		sleep(2000);
		click(SignIn);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
	private WebElement eleUserName;

	public IHTC_Company_Login_Page enterCredentials(String UserName, String Password) {

		waitForPageLoad(90);

		sleep(5000);

		iHTCcredentials(eleUserName, elePassword, eleLogin, UserName, Password);

		return this;
	}

	@FindBy(how = How.XPATH, using = "(.//input[@id='password'])")
	private WebElement elePassword;

	public IHTC_Company_Login_Page enterPassword(String Password) {
		type(elePassword, Password);
		return this;
	}

	@FindBy(how = How.XPATH, using = "(.//div[@data-bind='button: loginSection.loginButton'])")
	private WebElement eleLogin;

	public IHTC_Company_Login_Page clickLogin() {
		click(eleLogin);
		sleep(5000);
		return this;
	}

	/// IHTC Logo ////
	@FindBy(how = How.XPATH, using = "(//span[.='www.HEMPTRADER.online'])")
	private WebElement eleIhtcLogo;

	public IHTC_Companyadmin_Listing clickIhtcLogo() {
		click(eleIhtcLogo);
		String title = driver.getTitle();
		System.out.println(title);
		return new IHTC_Companyadmin_Listing(driver, test);
	}
	
	
	
	@FindBy (how=How.XPATH, using = "//span[.='Locations']" )
	private  WebElement eleLocations;
	
    public IHTC_Locations_Page clickLocations() {
    	
    	waitForPageLoad(90);
    	//verifyText("Locations", eleLocations);
    	click(eleLocations);
    	sleep(2000);
		return new IHTC_Locations_Page(driver,test);
   
    }

	
	@FindBy(how = How.XPATH, using = "//span[.='Waiting For Documentation']")
	private WebElement CompanyStatus;
	
	public IHTC_Company_Login_Page CompanyStatus() {

		waitForPageLoad(90);

		sleep(5000);
		click(CompanyStatus);
		
		verifyText("Waiting For Documentation", CompanyStatus);

		return new IHTC_Company_Login_Page (driver, test);
	}
	
	@FindBy(how=How.XPATH, using = "(.//span[.='Listings'])[1]")
	public WebElement listingmenu;

	public IHTC_Companyadmin_Listing getlistingmenuname()
	
	{
		waitForPageLoad(90);

		sleep(5000);

		verifyText("Listings", listingmenu);
		click(listingmenu);
		return new IHTC_Companyadmin_Listing(driver,test);

	}

	@FindBy(how=How.XPATH, using = "((.//span[.='Company'])[1])")
	public WebElement companymenu;

	public IHTC_Companyadmin_Status companyadmin_clickcompany()
	
	{
		waitForPageLoad(90);

		sleep(5000);

		//verifyText("Listings", listingmenu);
		click(companymenu);
		return new IHTC_Companyadmin_Status(driver,test);

	}

	@FindBy(how=How.XPATH, using = "(.//span[.='Users'])[1]")
	public WebElement eleusermenu;

	public IHTC_User_Page companyadmin_clickusermenu()
	
	{

		waitForPageLoad(60);
		sleep(2000);
		click(eleusermenu);

		return new IHTC_User_Page(driver,test);

	}

	public IHTC_User_Page user_verifylistingmenu()
	
	{
		waitForPageLoad(90);
		
		sleep(5000);
		
		try
		{
				if(listingmenu.isDisplayed())
				{
					reportStep("The login after password reset is success", "PASS");
					
				}
				//driver.navigate().refresh();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Login unsuccess after password reset", "FAIL");
		}
		return new IHTC_User_Page(driver,test);
	}


@FindBy (how=How.XPATH, using = "//span[.='Purchases']")
private WebElement elePurchase;

public IHTC_Purchase clickPurchase() {

	sleep(6000);
	click(elePurchase);
	return new IHTC_Purchase(driver,test);
	
}


///////////// Prabu 7th Jan///////////////////////////////////////////

@FindBy(how=How.XPATH, using = "((.//span[text()='Sales'])[1])")
public WebElement elesalesmenu;

@FindBy(how=How.XPATH, using = "((.//span[@data-bind='text: label'])[2])")
public WebElement elesalespageheader;



public IHTC_Shipment click_sales_menu()
{
	try
	{
		waitForPageLoad(90);
		sleep(2000);
		
		click(elesalesmenu);
		sleep(5000);
		reportStep("Sales menu has been clicked successfully","PASS");
		
		if(elesalespageheader.isDisplayed())
		{
			reportStep("Sales page is displayed","PASS");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		reportStep("There was some problem when loading the sales page","FAIL");
	}
	
	return new IHTC_Shipment(driver,test);
}

@FindBy(how=How.XPATH, using = ".//span[.='Companies']")
public WebElement elesuperadmincompanies;

public IHTC_Messaging click_Superadmin_Companiesmenu()
{
	sleep(3000);
	click(elesuperadmincompanies);
	
	return new IHTC_Messaging(driver,test);
	

}


/////////////////////////Rafi/////////////////////////


public WebElement eleclickListingsForMessaging;

public IHTC_MessagingNotification clickListingsforMessage()
{

waitForPageLoad(20);
click(eleclickListings);
sleep(2000);
return new IHTC_MessagingNotification(driver,test);
}


	
	///////////////////////////    naveen    //////////////////
	@FindBy(how=How.XPATH, using= "//span[.='Listings']")
	public WebElement eleclickListings;

	public IHTC_Companyadmin_Listing clickListings()
	{

	waitForPageLoad(20);
	click(eleclickListings);
	sleep(2000);
	return new IHTC_Companyadmin_Listing(driver,test);
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
	private WebElement elelaunchIhtcAsCompanyAdmin;

	public IHTC_Company_Login_Page launchIhtcAsCompanyAdmin() {

		waitForPageLoad(10);
        driver.get("https://ihtc.slingrs.io/staging/runtime/login.html");
        
		return this;
	}



}
