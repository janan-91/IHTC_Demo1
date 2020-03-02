package iHTC_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Locations_Page extends ProjectMethods{

	public IHTC_Locations_Page (RemoteWebDriver driver, ExtentTest test) {
	this.driver = driver;
	this.test = test;

	PageFactory.initElements(driver, this);
}
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Create'])[2]")
	private WebElement eleCreatebutton;
	
	public IHTC_Locations_Page CreateLocations() {

		try {
			sleep(2000);
		click(eleCreatebutton);
		
		}
		catch (Exception e) {
			
			e.printStackTrace();
			reportStep("Unable to click Create button", "FAIL");
		}
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[1]")
	private WebElement eleNameButton;
	
	public IHTC_Locations_Page NameLocation(String LocationName) {
		
try {
	System.out.println(LocationName);
	
	sleep(2000);
		click(eleNameButton);
		type(eleNameButton, LocationName);
		
	} catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to enter Name", "FAIL");
	}
return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[2]")
	private WebElement elePhoneButton;
	
	public IHTC_Locations_Page PhoneLocation(String PhoneLocation) {
		
try {
	
	sleep(2000);
	click(elePhoneButton);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='984545452121';", elePhoneButton);

		//type(elePhoneButton, PhoneLocation);
		
	}catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to enter Phonenumber", "FAIL");
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[3]")
	private WebElement eleAddressButton;
	
	public IHTC_Locations_Page AddressLocation(String AddressLocation) {
		
try {
	
	sleep(2000);
		click(eleAddressButton);
		type(eleAddressButton, AddressLocation);
		
	}catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to Address", "FAIL");
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[5]")
	private WebElement eleCityButton;
	
	public IHTC_Locations_Page CityLocation(String CityLocation) {

		try {
			
			sleep(2000);
		click(eleCityButton);
		type(eleCityButton, CityLocation);
		
	}catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to enter City", "FAIL");
	}
		return this;
	}
	
	/*public IHTC_Locations_Page CountryLocation() {
		WebElement ele = driver.findElementByXPath("(.//span[@class='select2-selection__arrow'])[1]");
		Select drpCountry = new Select(ele);
		drpCountry.selectByVisibleText("Canada");
		sleep(5000);
		return this;
	}*/
	
	@FindBy(how = How.XPATH, using = "//li[.='Virginia']")
	private WebElement dropDownState;
	
	@FindBy(how = How.XPATH, using = "(.//span[@role='combobox'])[2]")
	private WebElement elestates;
	
	public IHTC_Locations_Page StateLocation() {
		try {
			
		sleep(3000);
		click(elestates);
		sleep(5000);
		click(dropDownState);
		
	}catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to select States", "FAIL");
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[6]")
	private WebElement eleZipCodeButton;
	
	public IHTC_Locations_Page ZipCodeLocation(String ZipCodeLocation) {

		try {
			sleep(2000);
		click(eleZipCodeButton);
		type(eleZipCodeButton, ZipCodeLocation);
		scrollTillBottom();
		
	}catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to enter Zipcode", "FAIL");
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Create'])[5]")
	private WebElement eleFinalCreatebutton;
	
	public IHTC_Locations_Page FinalCreateLocation() {
		
try {
	
	sleep(4000);
		click(eleFinalCreatebutton);
		
	}catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to click Create button at buttom", "FAIL");
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//span[.='Active']")
	private WebElement eleStatusbutton;
	
	@FindBy(how = How.XPATH, using = "(//a[.='Locations'])[2]")
	private WebElement eleLocation2;
	
	public IHTC_Locations_Page StatusLocation() {
		
try {
	
	sleep(5000);
	click(eleLocation2);
	sleep(2000);
	verifyText("Active", eleStatusbutton);

	}catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Status is not Active", "FAIL");
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//span[.='Active']")
	private WebElement eleActiveSelect;
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Actions'])[2]")
	private WebElement eleActionSelect;
	
	@FindBy(how = How.XPATH, using ="(.//span[@class='bgm-regular' and text()='Deactivate'])[2]")
	private WebElement eleDeactivateButton;
	
	@FindBy(how = How.XPATH, using = "(//span[.='OK'])[2]")
	private WebElement eleOkButtom;
	
	@FindBy(how = How.XPATH, using = "//span[.='Inactive']")
	private WebElement eleInactive;
	
	public IHTC_Locations_Page DeleteLocation() {
		
try {
		sleep(2000);
		click(eleActiveSelect);
		sleep(1000);
		click(eleActionSelect);
		sleep(1000);
		click(eleDeactivateButton);
		sleep(1000);
		click(eleOkButtom);
		sleep(7000);
		scrollTillBottom();
		verifyText("Inactive", eleInactive);
		
	} 	catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to Delete Location", "FAIL");
		
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//span[.='Inactive']")
	private WebElement eleInactiveToActivateChrome;
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Activate'])[2]")
	private WebElement eleClickToActivate;
	
	@FindBy(how = How.XPATH, using = "//span[.='Active']")
	private WebElement eleverifyActiveStatus;
	
	
	public IHTC_Locations_Page InactiveToActiveLocation_Chrome() {
		
try {
		sleep(2000);
		click(eleInactiveToActivateChrome);
		sleep(1000);
		click(eleActionSelect);
		sleep(1000);
		click(eleClickToActivate);
		sleep(1000);
		click(eleOkButtom);
		sleep(7000);
		scrollTillBottom();
		verifyText("Active", eleverifyActiveStatus);
		
	} 	catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to perform InactiveToActive", "FAIL");
		
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Inactive'])[2]")
	private WebElement eleInactiveToActivateFirefox;
	
	
	public IHTC_Locations_Page InactiveToActiveLocation_FireFox() {
		
try {
		sleep(2000);
		click(eleInactiveToActivateFirefox);
		sleep(1000);
		click(eleActionSelect);
		sleep(1000);
		click(eleClickToActivate);
		sleep(1000);
		click(eleOkButtom);
		sleep(7000);
		scrollTillBottom();
		verifyText("Active", eleverifyActiveStatus);
		
	} 	catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to perform InactiveToActive", "FAIL");
		
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Inactive'])[1]")
	private WebElement eleInactiveToActivateSafari;
	
	
	public IHTC_Locations_Page InactiveToActiveLocation_Safari() {
		
try {
		sleep(2000);
		click(eleInactiveToActivateSafari);
		sleep(1000);
		click(eleActionSelect);
		sleep(1000);
		click(eleClickToActivate);
		sleep(1000);
		click(eleOkButtom);
		sleep(7000);
		scrollTillBottom();
		verifyText("Active", eleverifyActiveStatus);
		
	} 	catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to perform InactiveToActive", "FAIL");
		
	}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Inactive'])[3]")
	private WebElement eleverifyActiveStatusEdge;
	
	
	public IHTC_Locations_Page InactiveToActiveLocation_Edge() {
		
try {
		sleep(2000);
		click(eleverifyActiveStatusEdge);
		sleep(1000);
		click(eleActionSelect);
		sleep(1000);
		click(eleClickToActivate);
		sleep(1000);
		click(eleOkButtom);
		sleep(7000);
		scrollTillBottom();
		verifyText("Active", eleverifyActiveStatus);
		
	} 	catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Unable to perform InactiveToActive", "FAIL");
		
	}
		return this;
	}
}
