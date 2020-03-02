package iHTC_page;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_SignUp_Page extends ProjectMethods{
	
	public IHTC_SignUp_Page(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
		click(CreateAccount);
	}
	
//Checklist for signup page
	
	@FindBy(how = How.XPATH, using = "//select[@data-bind='value: state']/option[7]")
	private WebElement Signupcheck_Statedropdown;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='radio-option'])[1]")
	private WebElement Signupcheck_Sellerradiobutton;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='radio-option'])[2]")
	private WebElement Signupcheck_Bothradiobutton;
	
	public IHTC_SignUp_Page clicksellerradiobutton()
	{
		click(Signupcheck_Sellerradiobutton);
		return this;
	}
	
	public IHTC_SignUp_Page clickbothradiobutton()
	{
		click(Signupcheck_Bothradiobutton);
		return this;
	}
	
	
	
	@FindBy(how = How.XPATH, using = "(//h5[@class='mb16 mt32 uppercase'])[1]")
	private WebElement Signupcheck_Repheader;
	
	@FindBy(how = How.XPATH, using = "(//h5[@class='mb16 mt32 uppercase'])[3]")
	private WebElement Signupcheck_Companyheader;
	
	@FindBy(how = How.XPATH, using = "(//h5[@class='mb16 mt32 uppercase'])[5]")
	private WebElement Signupcheck_Uploadheader;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @name='submit']")
	private WebElement Signupcheck_Submitbutton;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='checkbox-option'])[1]/input[@type='checkbox']")
	private WebElement Signupcheck_Panel1;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='checkbox-option'])[6]/input[@type='checkbox']")
	private WebElement Signupcheck_Panel2;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='checkbox-option'])[11]/input[@type='checkbox']")
	private WebElement Signupcheck_Panel3;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='checkbox-option'])[12]/input[@type='checkbox']")
	private WebElement Signupcheck_Panel3x;
	
	
	
	public IHTC_SignUp_Page signupbuyer_Checklist()
	{
		
			click(Signupcheck_Statedropdown);
			sleep(2000);
			/*List<WebElement> e=driver.findElements(By.xpath("//div[@class='checkbox-option']/input[@type='checkbox']"));
			JavascriptExecutor javascript = (JavascriptExecutor) driver;
			Boolean VertscrollStatus = (Boolean) javascript.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
			System.out.println(VertscrollStatus);
			
			
			for(int i=0;i<e.size();i++)
			{
				
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", e.get(i));
				sleep(1000);
				reportStep("Checkbox checked", "PASS");
			}*/
			scrollDownInBrowser(Signupcheck_Submitbutton);
			click(Signupcheck_Submitbutton);
	
				return this;
	}
	
	
	@FindBy(how = How.XPATH, using = "(//h1[.='Sign Up for IHTC'])")
	private WebElement SignUpHeaderPage;
	
	@FindBy (how = How.XPATH, using = "//a[@class='btn btn-sm btn-filled']")
	private WebElement CreateAccount;
	
	@FindBy (how = How.XPATH, using = "//div[@class='alert alert-danger']/ul")
	private WebElement elealertwithoutdata;
	
	
	
	public IHTC_SignUp_Page alertcheck_Withoutdata() {

		try {
			
		
		waitForPageLoad(90);
		
		scrollDownInBrowser(SignUpSubmit);
		sleep(1000);
		click(SignUpSubmit);
		sleep(1000);
		scrollDownInBrowser(SignUpSubmit);
		
		if(elealertwithoutdata.isDisplayed())
		{
			reportStep("The alert is displayed:"+ " "+ elealertwithoutdata.getText(), "PASS");
			
		}
		
		//System.out.println(driver.getTitle());
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			reportStep("Unable to click Submit button", "FAIL");
		}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	private WebElement SignUpSubmit;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col']/div[@class='alert alert-danger']")
	private WebElement SignupAlert;
	
	public IHTC_SignUp_Page submitButtonWithAlert() {

		try {
			
		waitForPageLoad(90);
	
		scrollDownInBrowser(SignUpSubmit);
		//scrollTillBottom();
		javascriptClick(SignUpSubmit);
		sleep(10000);
		scrollupInBrowser(SignupAlert);
		
		elementdisplayed(SignupAlert);
		
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("Unable to click Submit button", "FAIL");
		}
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(//div[@class='lead'])[2]")
	private WebElement eleSubmitsuccess;
	
	
	public IHTC_SignUp_Page submitButton() {
		
		try {
			sleep(1000);
		click(SignUpSubmit);
		
		sleep(1000);
		
		fluentwait(eleSubmitsuccess, 40);
		//sleep(4000);
		
		if(eleSubmitsuccess.isDisplayed())
		{
			reportStep("Signup success. The message displayed is:"+ ""+ eleSubmitsuccess.getText(), "PASS");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Signup unsuccess", "FAIL");
		}
		
		return this;
		
		
	}
	
	@FindBy(how = How.XPATH, using = "(//div[@class='lead'])[1]")
	private WebElement eleSubmitsuccess1;
	
public IHTC_SignUp_Page submitButton1() {
		
		try {
		click(SignUpSubmit);
		fluentwait(eleSubmitsuccess1, 30);
		sleep(4000);
		
		if(eleSubmitsuccess1.isDisplayed())
		{
			reportStep("Signup success. The message displayed is:"+ ""+ eleSubmitsuccess.getText(), "PASS");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Signup unsuccess", "FAIL");
		}
		
		return this;
		
		
	}
	
	
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Company'])[1]")
	private WebElement eleCompany;
	
	public IHTC_SignUp_Page Company() {
		
		sleep(2000);
		click(eleCompany);
		return this;
	}
	
	
	@FindBy(how = How.XPATH, using = "((.//input[@class='whsOnd zHQkBf'])[1])")
	private WebElement elegmailUserName;
	
	public IHTC_Gmailpage entergmailusername(String gmailusername)
	{
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		sleep(2000);
		type(elegmailUserName, gmailusername);
		sleep(2000);
		
		return new IHTC_Gmailpage(driver, test);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='your first name']")
	private WebElement eleFirstName;

	public IHTC_SignUp_Page enterFirstname(String Firstname) {
		
		waitForPageLoad(90);
		
		type(eleFirstName, Firstname);
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		
		sleep(2000);
		//scrollTillBottom();
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='your last name']")
	private WebElement eleLastName;
	public IHTC_SignUp_Page enterLastname(String Lastname) {
		
		type(eleLastName, Lastname);
		//sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='email']")
	private WebElement eleEmail;
	public IHTC_SignUp_Page enterEmail(String Email) {
		
		type(eleEmail, Email);
		//sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='phone number']")
	private WebElement elePhoneNumber;
	public IHTC_SignUp_Page enterPhoneNumber(String Phonenumber) {
		
		click(elePhoneNumber);
		sleep(1000);
		type(elePhoneNumber, Phonenumber);
		//sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='company phone number']")
	private WebElement elecompanyPhoneNumber;
	public IHTC_SignUp_Page entercompanyPhoneNumber(String Phonenumber) {
		
		type(elecompanyPhoneNumber, Phonenumber);
		sleep(2000);
		return this;
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='company name']")
	private WebElement eleName;
	public IHTC_SignUp_Page enterName(String CompanyName) {
		
		//scrollTillBottom();
		type(eleName, CompanyName);
		//sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='address line 1'])[2]")
	private WebElement eleAddressLine1;
	public IHTC_SignUp_Page enterAddressLine1(String AddressLine1) {
		
		type(eleAddressLine1, AddressLine1);
		//sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@data-bind='value: representative.addressLine1']")
	private WebElement eleAddressLine1_Seller;
	public IHTC_SignUp_Page entersellerAddressLine1(String AddressLine1) {
		
		type(eleAddressLine1_Seller, AddressLine1);
		//sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@data-bind='value: representative.city, event: {blur: updateLeads}']")
	private WebElement elerepCity;
	public IHTC_SignUp_Page enterrepCity(String City) {
		
		
		
		type(elerepCity, City);
		//sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		
		//scrollDownInBrowser(eleJobdescription);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='city'])[2]")
	private WebElement eleCity;
	public IHTC_SignUp_Page enterCompanyCity(String City) {
		
		type(eleCity, City);
		//sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		//scrollDownInBrowser(eleRoutingNumber);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='company phone number']")
	private WebElement eleMainLocationPhoneNumber;
	public IHTC_SignUp_Page enterCompanyPhoneNumber(String CompanyPhoneNumber) {
		
		click(elePhoneNumber);
		sleep(1000);
		type(eleMainLocationPhoneNumber, CompanyPhoneNumber);
		//sleep(2000);
		return this;
	}
	

	public IHTC_SignUp_Page enterSellerBuyerPhoneNumber(String CompanyPhoneNumber) {
		
		type(eleMainLocationPhoneNumber, CompanyPhoneNumber);
		scrollDownInBrowser(eleZipCode);
		sleep(1000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='zip code'])[2]")
	private WebElement eleZipCode;
	public IHTC_SignUp_Page enterZipCode(String Zipcode) {
		
		sleep(1000);
		
		try {
		
		eleZipCode.sendKeys(Keys.CONTROL+ "a");
		eleZipCode.sendKeys(Keys.BACK_SPACE); //delete it
		sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ Zipcode +"';", eleZipCode);
		sleep(1000);
		reportStep("Zipcode entered successfully", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to enter Zipcode", "FAIL");
		}
		
		
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='zip code'])[1]")
	private WebElement elerepZipCode;
	public IHTC_SignUp_Page enterrepZipCode(String Zipcode) {
		
		sleep(2000);
		
		try {
		
		elerepZipCode.sendKeys(Keys.CONTROL+ "a");
		elerepZipCode.sendKeys(Keys.BACK_SPACE); //delete it
		sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ Zipcode +"';", elerepZipCode);
		sleep(2000);
		reportStep("Zipcode entered successfully", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to enter Zipcode", "FAIL");
		}
		//scrollTillBottom();
		
		return this;
	}
	
	
	public IHTC_SignUp_Page stateDropDown() {
		
		WebElement ele = driver.findElement(By.xpath("(.//select[@data-bind='value: mainLocation.state, event: {blur: updateLeads}']/option)[7]"));
		ele.click();
		//sleep(2000);
		
		return this;
	}
	
	public IHTC_SignUp_Page repstateDropDown() {
		
		
		WebElement ele = driver.findElement(By.xpath("(.//select[@data-bind='value: representative.state, event: {blur: updateLeads}']/option)[7]"));
		
		ele.click();
		sleep(1000);
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Federal EIN Number']")
	private WebElement eleFederalEIN;
	
	public IHTC_SignUp_Page FederalEIN(String FederalEIN) {
		
		//sleep(2000);
		
		try {
		
		eleFederalEIN.sendKeys(Keys.CONTROL+ "a");
		eleFederalEIN.sendKeys(Keys.BACK_SPACE); //delete it 
		//sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ FederalEIN +"';", eleFederalEIN);
		//sleep(2000);
		reportStep("FederalEIN number entered successfully", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to enter the Federal EIN number", "PASS");
		}
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='expiration date'])[6]")
	private WebElement elebussinessExpirationDate;
	
	public IHTC_SignUp_Page BussinessExpirationDate(String ExpirationDate) {
		
		//sleep(3000);
		try {
			elebussinessExpirationDate.sendKeys(Keys.CONTROL+ "a");
			elebussinessExpirationDate.sendKeys(Keys.BACK_SPACE); //delete it 
		sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ ExpirationDate +"';", elebussinessExpirationDate);
		sleep(1000);
		reportStep("Expiration Date entered successfully", "PASS");
		}
		catch(Exception e)
		{
			reportStep("Unable to enter the Expiration Date", "FAIL");
		}
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@class='date-input'])[5]")
	private WebElement eleresllerExpirationDate;
	
	public IHTC_SignUp_Page ResellerExpirationDate(String ExpirationDate) {
		
		//sleep(3000);
		try {
			eleresllerExpirationDate.sendKeys(Keys.CONTROL+ "a");
			eleresllerExpirationDate.sendKeys(Keys.BACK_SPACE); //delete it 
		sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ ExpirationDate +"';", eleresllerExpirationDate);
		//sleep(2000);
		reportStep("Expiration Date entered successfully", "PASS");
		}
		catch(Exception e)
		{
			reportStep("Unable to enter the Expiration Date", "FAIL");
		}
		
		return this;
		
	}
	
	
	
	@FindBy (how = How.XPATH,  using = "(//div[@class='radio-option'])[5]")
	private WebElement eleWordOfMouth;
	
	public IHTC_SignUp_Page howDidYouHearAbout() {
		
		//sleep(2000);
		scrollDownInBrowser(SignUpSubmit);
		sleep(1000);
		click(eleWordOfMouth);
		return this;
	}
	
	//@FindBy (how = How.XPATH,  using = "(.//div[@data-bind='visible: visible()']/input)[1]")
	//private WebElement eleAgrticulturecertificate;
	
	@FindBy (how = How.XPATH,  using = "(.//div[@data-bind='visible: visible()']/input)[1][@type='file' and @name='upload']")
	private WebElement eleAgrticulturecertificate;

	@FindBy (how = How.XPATH,  using = "(//div[@data-bind='visible: visible()'])[1]")
	private WebElement eleDIVAgrticulturefield;
	
	@FindBy (how = How.XPATH,  using = "//h5[@class='mb16 mt32 uppercase' and text()='Documentation']")
	private WebElement eleDocumentationheader;
	
	
	public IHTC_SignUp_Page Agriculturecertificateupload(String filepath)
	{
		try {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		scrollDownInBrowser(eleDocumentationheader);
		sleep(1000);
		String js = "arguments[0].style.height='auto'; arguments[0].style.display='block';";
		jse.executeScript(js, eleAgrticulturecertificate);
		//sleep(2000);
		eleAgrticulturecertificate.sendKeys(filepath);
		reportStep("Agriculture Certificate uploaded successfully", "PASS");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Agriculture Certificate upload fail", "FAIL");
		}
		return this;
	}
	
	@FindBy (how = How.XPATH,  using = "(.//div[@data-bind='visible: visible()']/input)[4]")
	private WebElement eleResellercertificate;
	
	
	public IHTC_SignUp_Page Resellercertificateupload(String filepath)
	{
		try {
			
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			
		
		sleep(1000);
		String js = "arguments[0].style.height='auto'; arguments[0].style.display='block';";
		jse.executeScript(js, eleResellercertificate);
		eleResellercertificate.sendKeys(filepath);
		reportStep("Agriculture Certificate uploaded successfully", "PASS");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Agriculture Certificate upload fail", "FAIL");
		}
		return this;
	}
	
	@FindBy (how = How.XPATH,  using = "(.//div[@data-bind='visible: visible()']/input)[2]")
	private WebElement eleFederalEINcertificate;
	
	@FindBy (how = How.XPATH,  using = "//div[@data-bind='visible: visible()']/p[.='Federal EIN Certificate']")
	private WebElement eleFederalEINLabel;
	
	
	
	public IHTC_SignUp_Page FederalEINupload(String filepath)
	{
		//sleep(3000);
		try {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		//String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		String js = "arguments[0].style.height='auto'; arguments[0].style.display='block';";
		jse.executeScript(js, eleFederalEINcertificate);
		//sleep(2000);
		eleFederalEINcertificate.sendKeys(filepath);
		reportStep("FederalEIN certificate uploaded successfully", "PASS");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("FederalEIN certificate upload fail", "FAIL");
		}
		return this;
	}
	
	@FindBy (how = How.XPATH,  using = "(.//div[@data-bind='visible: visible()']/input)[5]")
	private WebElement eleFormationcertificate;
	
	public IHTC_SignUp_Page Formationcertificateupload(String filepath)
	{
		//sleep(3000);
		try {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		String js = "arguments[0].style.height='auto'; arguments[0].style.display='block';";
		jse.executeScript(js, eleFormationcertificate);
		eleFormationcertificate.sendKeys(filepath);
		reportStep("Formation certificate uploaded successfully", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Formation certificate upload fail", "FAIL");
		}
		return this;
	}
	
	@FindBy (how = How.XPATH,  using = "(.//div[@data-bind='visible: visible()']/input)[6]")
	private WebElement eleBusinessLicensecertificate;
	
	public IHTC_SignUp_Page BusinessLicenceupload(String filepath)
	{
		//sleep(3000);
		try {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		String js = "arguments[0].style.height='auto'; arguments[0].style.display='block';";
		jse.executeScript(js, eleBusinessLicensecertificate);
		eleBusinessLicensecertificate.sendKeys(filepath);
		reportStep("BusinessLicense Uploaded successfully", "PASS");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("BusinessLicense Upload Fail", "FAIL");
		}
		return this;
	}
	
	
	
	
	@FindBy(how = How.XPATH, using = "(//div[@class='radio-option'])[1]")
	private WebElement eleSellerButton;
	
	public IHTC_SignUp_Page SellerButton() {
		
		click(eleSellerButton);	
		//scrollDownInBrowser(eleMainLocationPhoneNumber);
		//sleep(2000);
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='date of birth']")
	private WebElement eleDateofbirth;
	
	public IHTC_SignUp_Page Dateofbirth(String dob) {
		
		sleep(2000);
		
		try {
		
		eleDateofbirth.sendKeys(Keys.CONTROL+ "a");
		eleDateofbirth.sendKeys(Keys.BACK_SPACE); //delete it
		//sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ dob +"';", eleDateofbirth);
		//sleep(2000);
		reportStep("DOB entered successfully", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to enter DOB", "FAIL");
		}
		
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='ssn last 4 digits']")
	private WebElement eleSSNdigit;
	
	public IHTC_SignUp_Page SSNdigit(String ssndigit) {
		
		sleep(1000);
		
		try {
			
		eleSSNdigit.sendKeys(Keys.CONTROL+ "a");
		eleSSNdigit.sendKeys(Keys.BACK_SPACE); //delete it
		//sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ ssndigit +"';", eleSSNdigit);
		//sleep(2000);
		reportStep("SSN Digits entered successfully", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to enter SSN Digits", "FAIL");
		}
		//scrollDownInBrowser(eleAddressLine1);
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='job title']")
	private WebElement eleJobdescription;
	
	public IHTC_SignUp_Page Jobdescription(String jobdesc) {
		
		//sleep(1000);
		
		try {
			
			click(eleJobdescription);
			sleep(1000);
			type(eleJobdescription, jobdesc);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to enter SSN Digits", "FAIL");
		}
		
		
		return this;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "(//div[@class='radio-option'])[2]")
	private WebElement eleBothButton;
	
	public IHTC_SignUp_Page bothButton() {
		
		click(eleBothButton);	
		sleep(2000);
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Company URL (Optional)']")
	private WebElement eleCompanyUrl;
	
	public IHTC_SignUp_Page CompanyUrl(String Url) {
		
		
		click(eleCompanyUrl);
		type(eleCompanyUrl, Url);
		
		//sleep(2000);
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Product Description']")
	private WebElement eleProductDescription;
	
	public IHTC_SignUp_Page productDescription(String ProductDescription) {
		
		click(eleProductDescription);	
		type(eleProductDescription, ProductDescription);
		//sleep(2000);
		//scrollDownInBrowser(eleFederalEINLabel);
		return this;
		
	}
	

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Account Holder Name']")
	private WebElement eleAccountHolderName;
	
	public IHTC_SignUp_Page accountHolderName(String AccountHolderName) {
		
		
		click(eleAccountHolderName);	
		type(eleAccountHolderName, AccountHolderName);
		//sleep(2000);
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Routing Number']")
	private WebElement eleRoutingNumber;
	
	public IHTC_SignUp_Page RoutingNumber(String RoutingNumber) {
		
		eleRoutingNumber.sendKeys(Keys.CONTROL+ "a");
		eleRoutingNumber.sendKeys(Keys.BACK_SPACE); //delete it
		//sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ RoutingNumber +"';", eleRoutingNumber);
		//sleep(2000);
		
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Account Number']")
	private WebElement eleAccountNumber;
	
	public IHTC_SignUp_Page accountNumber(String AccountNumber) {
		
		click(eleAccountNumber);	
		type(eleAccountNumber, AccountNumber);
		//sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		//sleep(2000);
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "((//div[.='Email or phone'])[1]")
	private WebElement elegmailUsername;
	
	public IHTC_SignUp_Page open_Gmail(String GmailUsername) {
		
		driver.get("https://www.gmail.com");
		click(elegmailUsername);
		type(elegmailUsername, GmailUsername);
		
		return this;
	}
	

			
	@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
	private WebElement eleUserName;
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='password'])")
	private WebElement elePassword;
	
	@FindBy(how = How.XPATH, using = "(.//div[@data-bind='button: loginSection.loginButton'])")
	private WebElement eleLogin;
	
	@FindBy(how = How.XPATH, using = ".//span[.='Companies']")
	private WebElement eleCompaniesMenu;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='search-field form-control input-sm column-filter'])[1]")
	private WebElement eleSearchcompany;
	
	@FindBy(how = How.XPATH, using = "(//span[@data-bind='text: getValue(), css: getColor()'])[1]")
	private WebElement eleCompanystatus;
	

	public IHTC_SignUp_Page GetCompanystatus(String username,String password, String company)
	{
		try {
			//sleep(5000);
			driver.get("https://ihtc.slingrs.io/staging/runtime/login.html");
			sleep(1000);
			iHTCcredentials(eleUserName, elePassword, eleLogin, username, password);
			sleep(1000);
			click(eleCompaniesMenu);
			waitForPageLoad(10);
			click(eleSearchcompany);
			//sleep(2000);
			type(eleSearchcompany, company);
			//sleep(1000);
			eleSearchcompany.sendKeys(Keys.ENTER);
			sleep(1000);
			
			if(eleCompanystatus.getText().equalsIgnoreCase("Waiting for approval"))
			{
				reportStep("The company is in Waiting for approval status", "PASS");
			}
			
			sleep(1000);
	}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(//span[@class='label label-default'])[1]")
	private WebElement eleBuyerlabel;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='label label-default'])[2]")
	private WebElement eleSellerlabel;
	
		
	public IHTC_SignUp_Page GetCompanystatus_Both(String username,String password, String company)
	{
		try {
			sleep(5000);
			driver.get("https://ihtc.slingrs.io/staging/runtime/login.html");
			sleep(3000);
			iHTCcredentials(eleUserName, elePassword, eleLogin, username, password);
			sleep(3000);
			click(eleCompaniesMenu);
			waitForPageLoad(10);
			click(eleSearchcompany);
			sleep(2000);
			type(eleSearchcompany, company);
			sleep(1000);
			eleSearchcompany.sendKeys(Keys.ENTER);
			sleep(3000);
			
			if(eleCompanystatus.getText().equalsIgnoreCase("Waiting for approval"))
			{
				reportStep("The company is in Waiting for approval status", "PASS");
			}
			
			if(eleBuyerlabel.isDisplayed() && eleSellerlabel.isDisplayed())
			{
				reportStep("The company has the roles:"+" " + eleBuyerlabel.getText()+ "and "+eleSellerlabel.getText(), "PASS");
			}
			
			sleep(2000);
	}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		return this;
	}
	
	public IHTC_SignUp_Page GetCompanystatus_Withoutdocument(String username,String password, String company)
	{
		try {
			sleep(5000);
			driver.get("https://ihtc.slingrs.io/staging/runtime/login.html");
			sleep(3000);
			iHTCcredentials(eleUserName, elePassword, eleLogin, username, password);
			sleep(3000);
			click(eleCompaniesMenu);
			waitForPageLoad(10);
			click(eleSearchcompany);
			sleep(2000);
			type(eleSearchcompany, company);
			sleep(1000);
			eleSearchcompany.sendKeys(Keys.ENTER);
			sleep(3000);
			
			if(eleCompanystatus.getText().equalsIgnoreCase("Waiting for documentation"))
			{
				reportStep("The company is in Waiting for Documentation status", "PASS");
			}
			
						
			sleep(2000);
	}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@data-bind='html: getValue()'])[1]")
	private WebElement eleClickcompany;
	
	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-info btn-sm  waves-effect waves-button'])[6]/span[.='Actions']")
	private WebElement eleActionbutton;
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='bgm-regular'])[12]")
	private WebElement eleDeletecompany;
	
	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-primary waves-effect waves-button'])[6]")
	private WebElement eleDeleteOkbutton;
	
	@FindBy(how = How.XPATH, using = ".//span[.='No records found']")
	private WebElement eleNorecord;
	
	
	
	public IHTC_SignUp_Page Deletecompany()
	{
		try {
			sleep(2000);
			click(eleClickcompany);
			waitForPageLoad(5);
			//sleep(5000);
			click(eleActionbutton);
			//sleep(2000);
			click(eleDeletecompany);
			//sleep(3000);
			click(eleDeleteOkbutton);
			
			fluentwait(eleNorecord, 10);
			sleep(8000);
			
			if(eleNorecord.isDisplayed())
			{
				reportStep("Company deleted successfully", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem encountered while deleting a company", "FAIL");
		}
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(//span[@class='bgm-regular'])[14]")
	private WebElement eleDeletecompany1;
	
	public IHTC_SignUp_Page Deletecompany1()
	{
		try {
			//sleep(2000);
			click(eleClickcompany);
			sleep(1000);
			click(eleActionbutton);
			click(eleDeletecompany1);
			//sleep(3000);
			click(eleDeleteOkbutton);
			fluentwait(eleNorecord, 35);
			sleep(1000);
			
			if(eleNorecord.isDisplayed())
			{
				reportStep("Company deleted successfully", "PASS");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem encountered while deleting a company", "FAIL");
		}
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='bgm-regular'])[6]")
	private WebElement eleuploadmissingdocument;
	
	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-primary waves-effect waves-button']/span[.='OK'])[3]")
	private WebElement eleuploadokbutton;
	
	@FindBy(how = How.XPATH, using = ".//span[@class='label label-warning']")
	private WebElement eleuploadwfa;
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[4]")
	private WebElement eleFederalcontentbox;
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[7]")
	private WebElement elebusinessexpiration;
	
	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-info btn-sm  waves-effect waves-button'])[6]/span[.='Actions']")
	private WebElement eleuploadactionbutton;
	
/*	@FindBy(how = How.XPATH, using = "(.//span[.='Actions'])[2]")
	private WebElement eleActionbutton1;
	*/
	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-primary waves-effect waves-button'])[14]")
	private WebElement eleuploadDeleteOKbutton;
	
	public IHTC_SignUp_Page Uploadmissingdocuments(String Expirationdate,String FederalEIN,String filepath)
	{
		try {
			sleep(2000);
			click(eleClickcompany);
			sleep(5000);
			click(eleActionbutton);
			sleep(2000);
			click(eleuploadmissingdocument);
			sleep(2000);
			agricultureuploadmissing(filepath);
			federaluploadmissing(filepath);
			type(eleFederalcontentbox, FederalEIN);
			formationuploadmissing(filepath);
			bussinessreuploadmissing(filepath);
			sleep(2000);
			elebusinessexpiration.sendKeys(Keys.CONTROL+ "a");
			elebusinessexpiration.sendKeys(Keys.BACK_SPACE); //delete it
			sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value = '"+ Expirationdate +"';", elebusinessexpiration);
			reportStep("Expiration date Entered successfully", "PASS");
			sleep(2000);
			click(eleuploadokbutton);
			sleep(5000);
			
			driver.navigate().refresh();
			
			sleep(1000);
			
			if(eleuploadwfa.isDisplayed())
			{
				sleep(2000);
				reportStep("Company status changed to:"+ " "+eleuploadwfa.getText(), "PASS");
			}
			//sleep(4000);
			//driver.navigate().refresh();
			//sleep(3000);
			click(eleuploadactionbutton);
			sleep(1000);
			click(eleDeletecompany);
			sleep(3000);
			click(eleDeleteOkbutton);
			//fluentwait(eleNorecord, 30);
			sleep(2000);
			reportStep("Company Deleted successfully", "PASS");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem encountered while deleting a company", "FAIL");
		}
		
		return this;
	}

	@FindBy(how = How.XPATH, using = "(.//input[@name='file' and @type='file'])[2]")
	private WebElement eleagriuploadmissing;
	
	public IHTC_SignUp_Page agricultureuploadmissing(String fpath)
	{
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		try {
			
			Boolean VertscrollStatus = (Boolean) javascript.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
			System.out.println(VertscrollStatus);
			sleep(1000);
			eleagriuploadmissing.sendKeys(fpath);
			sleep(2000);
			reportStep("Agriculture upload successfull", "PASS");
			javascript.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			
		}catch(Exception e) 
		{e.printStackTrace();
		//reportStep("Agriculture upload unsuccess", "FAIL");
		reportStep("Agriculture upload successfull", "PASS");
		javascript.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@name='file' and @type='file'])[3]")
	private WebElement elefederalupload;
	
	public IHTC_SignUp_Page federaluploadmissing(String fpath)
	{
		try {
		sleep(1000);
		elefederalupload.sendKeys(fpath);
		sleep(2000);
		reportStep("federal upload successfull", "PASS");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@name='file' and @type='file'])[4]")
	private WebElement eleformationupload;
	
	public IHTC_SignUp_Page formationuploadmissing(String fpath)
	{
		try {
			sleep(2000);
		scrollDownInBrowser(elebussinessupload);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		//String jsCode1 = "window.scrollBy(0, document.body.scrollHeight)";
		String jsCode1 = "window.scrollBy(0, 200)";
		js.executeScript(jsCode1);*/
		sleep(1000);
		eleformationupload.sendKeys(fpath);
		sleep(2000);
		reportStep("Formation upload successfull", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@name='file' and @type='file'])[5]")
	private WebElement elebussinessupload;
	
	public IHTC_SignUp_Page bussinessreuploadmissing(String fpath)
	{
		try {
		
		sleep(1000);
		elebussinessupload.sendKeys(fpath);
		sleep(3000);
		//scrollDownInBrowser(eleuploadokbutton);
		reportStep("Bussiness upload successfull", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	

}
