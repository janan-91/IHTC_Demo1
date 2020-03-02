package iHTC_page;
  
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.apache.poi.sl.extractor.SlideShowExtractor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Companyadmin_Listing extends ProjectMethods {
	
	
	public IHTC_Companyadmin_Listing(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
		
		/*if (!verifyTitle("www.HEMPTRADER.online | Dashboard")) {
			throw new RuntimeException();
		}*/
	}
	
	@FindBy(how=How.XPATH, using=("(.//span[text()='Create'])[2]"))
	public WebElement CA_createbutton;
	
	@FindBy(how=How.XPATH, using=("(.//span[text()='Refresh'])[2]"))
	public WebElement CA_Refreshbutton;
	
	@FindBy(how=How.XPATH, using=("(.//div[@data-bind='visible: !isLoading()']/ol)[1]/li[2]"))
	public WebElement Listingcreatebreadcrumb;
	
	public IHTC_Companyadmin_Listing verifybuttons()
	
	{
		waitForPageLoad(30);
		sleep(10);
		
		elementdisplayed(CA_createbutton);
		elementdisplayed(CA_Refreshbutton);
		return this;
	}
	
	public IHTC_Companyadmin_Listing createbutton()
	
	{
		waitForPageLoad(60);
		//sleep(15);
		click(CA_createbutton);
		sleep(5);
		elementdisplayed(Listingcreatebreadcrumb);
		sleep(15);
		return this;
	}
	
	
	@FindBy(how=How.XPATH, using= "((.//button[@class='btn btn-success btn-sm  waves-effect waves-button'])[1])")
	public WebElement Createlisting;
	
	
	@FindBy(how=How.XPATH, using= "(.//span[text()='This field is required'])")
	public WebElement Create_mandatoryfield;
	
	
	public IHTC_Companyadmin_Listing mandatorycheck()
	{
		waitForPageLoad(20);
		click(Createlisting);
		sleep(5);
		elementdisplayed(Create_mandatoryfield);
		sleep(5);
		return this;
		
	}

	@FindBy(how=How.XPATH, using= "((.//span[@class='label label-default relationship-label-pointer'])[1])")
	public WebElement Companyname;
	
	public IHTC_Companyadmin_Listing companyname()
	{
		
		waitForPageLoad(20);
		click(Companyname);
		sleep(5);
		verifyText("Tringapps company", Companyname);
		sleep(5);
		return this;
		
	}
	
	//// Click Listing /////
	
	@FindBy(how=How.XPATH, using= "(//span[.='Listings'])")
	public WebElement eleListing;
	
	public IHTC_Companyadmin_Listing clickListing() {
		
		waitForPageLoad(20);
		click(eleListing);
		
		return this;
	}
	
	@FindBy(how=How.XPATH, using= "(//span[.='Reebok'])")
	public WebElement eleSelectListing;
	
	public IHTC_Companyadmin_Listing SelectListing() {
		
		waitForPageLoad(20);
		click(eleSelectListing);
		
		return this;
	}
	
	
	//// Element Chrome Listing /////
	
	@FindBy(how=How.XPATH, using= "(//div[@class='text-left'])[1]")
	public WebElement eleNewListingChrome;
	
	public IHTC_Companyadmin_Listing SelectNewListingChrome() {
		
		waitForPageLoad(20);
		
		type(eleStatusSearch, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		
		sleep(2000);
		click(eleNewListingChrome);
		
		return this;
	}
	
	
	/// FireFox Listing ///
	
	@FindBy(how=How.XPATH, using= "(//div[@class='text-left'])[2]")
	public WebElement eleNewListingFireFox;
	
	public IHTC_Companyadmin_Listing SelectNewListingFireFox() {
		
		waitForPageLoad(20);
		
		type(eleStatusSearch, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		click(eleNewListingFireFox);
		
		return this;
	}
	
	/// Edge Listing ///
	
	@FindBy(how=How.XPATH, using= "(//div[@class='text-left'])[3]")
	public WebElement eleNewListingEdge;
	
	public IHTC_Companyadmin_Listing SelectNewListingEdge() {
		
		waitForPageLoad(20);
		
		type(eleStatusSearch, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		
		click(eleNewListingEdge);
		
		return this;
	}
	
	
	/// Safari Listing ///
	
	@FindBy(how=How.XPATH, using= "(//div[@class='text-left'])[4]")
	public WebElement eleNewListingSafari;
	
	public IHTC_Companyadmin_Listing SelectNewListingSafari() {
		
		waitForPageLoad(20);
		
		type(eleStatusSearch, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		
		
	click(eleNewListingSafari);
		
		return this;
	}
	
	//// Element Action Button /////
	
	@FindBy(how=How.XPATH, using= "((//span[.='Actions']))[2]")
	public WebElement eleAction;
	
	public IHTC_Companyadmin_Listing clickAction() {
		
		waitForPageLoad(20);
		click(eleAction);
		
		return this;
	}
	
	/// Make A Bid Button ////
	
	@FindBy(how=How.XPATH, using= "((.//span[.='Make a bid']))[2]")
	public WebElement eleMakeaBid;
	
	public IHTC_Companyadmin_Listing clickMakeaBid() {
		
		waitForPageLoad(20);
		click(eleMakeaBid);
		
		return this;
	}
	
	//// Amount Field //////
	
	@FindBy(how=How.XPATH, using= "((.//input[@class='form-control fullWidth'])[1])")
	public WebElement eleAmountUSD;
	//@FindBy(how=How.XPATH, using= "((.//span[.='OK'])[3])")
	
	@FindBy(how=How.XPATH, using= "((.//button[@class='btn btn-primary waves-effect waves-button']/span[.='OK'])[3])")
	public WebElement eleOkButton;
		
	public IHTC_Companyadmin_Listing clickAmountUSD(String LesserAmountUSD) {
		
		waitForPageLoad(20);
		
	String Amount = getText(eleAmountUSD);
	System.out.println(Amount);
	click(eleAmountUSD);
	eleAmountUSD.clear();

sleep (2000);

WebElement webl = driver.findElement(By.xpath("(.//input[@class='form-control fullWidth'])[1]"));
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].value='10';", webl);

sleep (2000);
//click(eleOkButton);
		
		return this;
	}
	
	//// Higher Bid Amount ///
	
	@FindBy(how=How.XPATH, using= "(//span[.='There is a higher bid already'])")
	public WebElement eleHigherBidAlert;
	
	
	public IHTC_Companyadmin_Listing readHigherBidAlert(String NeedHigherAmount) {
		
		waitForPageLoad(20);
		
	String Amount = getText(eleAmountUSD);
	System.out.println(Amount);
	click(eleAmountUSD);
	eleAmountUSD.clear();
	
	
	WebElement webl = driver.findElement(By.xpath("(.//input[@class='form-control fullWidth'])[1]"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='200';", webl);
	

	waitForPageLoad(20);
	sleep(2000);
	click(eleOkButton);
	sleep(5000);
	//click(eleHigherBidAlert);
	verifyText("There is a higher bid already", eleHigherBidAlert);
		
		return this;
	}
	
	 //// Bid Successful ///
	
	@FindBy(how=How.XPATH, using= "(//span[.='Action 'Make a bid' has been executed'])")
	public WebElement eleBidSuccessful;
	
	@FindBy(how=How.XPATH, using= "(//span[@title='Ascendas'])")
	public WebElement eleTitle;
	
	@FindBy (how=How.XPATH, using = "//h4[@class='modal-title'][.='Make a bid']")
	public WebElement eleM;
	
	public IHTC_Companyadmin_Listing bidSuccessfull(String HigherAmount) throws AWTException {
	
		try {
			
		
		waitForPageLoad(20);
	
		click(eleAmountUSD);
		eleAmountUSD.clear();
		sleep(5000);
		click(eleAmountUSD);
		WebElement webl = driver.findElement(By.xpath("(.//input[@class='form-control fullWidth'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='350';", webl);

	
	sleep(2000);
	click(eleOkButton);
	sleep(3000);
	click(eleOkButton);
	sleep(3000);
	
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return this;
	}
	
	/// Amount Validation ///
	
	@FindBy(how=How.XPATH, using= "(//input[@class='form-control fullWidth'])[1]")
	public WebElement elebidAmount;
	
	@FindBy (how=How.XPATH, using = "(//div[@class='text-left'])[4]")
	public WebElement eleAmountVerify;
	
	public IHTC_Companyadmin_Listing bidAmountValidation() {
	
		try {
		
		sleep(3000);
		scrollTillBottom();
		
		System.out.println("Amount verify is:"+eleAmountVerify.getText());
	
			//	String bidAmount1 = String.valueOf(bamount1);
				verifyText("$350.00 ", eleAmountVerify);
	    
		}
		
	catch(Exception e) {
		e.printStackTrace();
		reportStep("The Element is not displayed: ", "FAIL");
	}
		return this;
		}
	
	//// Verifying the text //////
	
	
	@FindBy(how=How.XPATH, using= "(//span[.='$200.00'])")
	public WebElement elebuyItbidAmount;
	
	public IHTC_Companyadmin_Listing buyITbidAmountValidation() {
		
		scrollTillBottom();
		verifyText("$200.00", elebuyItbidAmount);
		return this;
	}
	
	// ReadAmount Alert 
	
	@FindBy(how=How.XPATH, using= "(//span[.='The bid needs to be equals or higher than the base price'])")
	public WebElement eleAmountAlertMessage;
	
	public IHTC_Companyadmin_Listing readAmountAlertMessage() {
		
		sleep(5000);
		
		String alertMessage = getText(eleAmountAlertMessage);
		System.out.println(alertMessage);
		verifyText("The bid needs to be equals or higher than the base price", eleAmountAlertMessage);
		
		return this;
	}

	// Create a new Listing everytime after executing the old one:
	
	@FindBy(how=How.XPATH, using= "((.//label[@class='ts-helper'])[1])")
	public WebElement eleBuyItNow;	
	
	@FindBy(how=How.XPATH, using= "(//span[.='Transactions'])")
	public WebElement eleTranscation;	
	
	@FindBy(how=How.XPATH, using= "(//span[.='Paid'])")
	public WebElement elePaid;	
	
    public IHTC_Companyadmin_Listing buyItNow() {
		
		waitForPageLoad(20);
		click(eleBuyItNow);
		click(eleOkButton);
		sleep(2000);
		scrollTillBottom();
		sleep(2000);
		return this;
	}
    
    /// Login As Buyer ////
    
    @FindBy (how = How.XPATH, using = "//a[@class='tm-settings']")
    public WebElement ele3dotmenue;
    
   
    public IHTC_Companyadmin_Listing loginBuyer() {
    	
    	sleep(2000);
    	click(ele3dotmenue);
    	click(eleLogout);
    	
    	return this;
    }
    @FindBy(how=How.XPATH, using= "((//span[.='Purchases'])[1]")
	public WebElement eleShopping;	
    
    @FindBy(how=How.XPATH, using= ".//span[.='Product 122']")
	public WebElement eleVerifyListingChrome;	
    
    @FindBy(how=How.XPATH, using= "(.//span[.='Refresh'])[2]")
	public WebElement eleRefresh;	
	
    @FindBy (how = How.XPATH, using = "//a[@class='tm-settings']")
    public WebElement ele3dots;
    
    @FindBy (how = How.XPATH, using = "//span[.='Logout']")
    public WebElement eleLogout;
    
    public IHTC_Companyadmin_Listing purchaseChrome() {
		
	sleep(5000);
	click(ele3dots);
	click (eleLogout);
	sleep(3000);
		return this;
	}
    
    @FindBy(how=How.XPATH, using= ".//span[.='Product 25']")
   	public WebElement eleVerifyListingFireFox;	
    
    public IHTC_Companyadmin_Listing ShoppingFirefox() {
		
    	click(eleShopping);
    	sleep(3000);
    	click(eleRefresh);
    	sleep(5000);
    	
    	verifyText("Product 22",eleVerifyListingFireFox );
    		return this;
    	}
    
    @FindBy(how=How.XPATH, using= ".//span[.='Product 13']")
   	public WebElement eleVerifyListingSafari;	
    
    public IHTC_Companyadmin_Listing ShoppingSafari() {
		
    	click(eleShopping);
    	sleep(3000);
    	click(eleRefresh);
    	sleep(5000);
    	
    	verifyText("Product 13",eleVerifyListingSafari );
    		return this;
    	}
    
    @FindBy(how=How.XPATH, using= ".//span[.='Product 23']")
   	public WebElement eleVerifyListingEdge;	
    
    public IHTC_Companyadmin_Listing ShoppingEdge() {
		
    	click(eleShopping);
    	sleep(3000);
    	click(eleRefresh);
    	sleep(5000);
    	
    	verifyText("Product 23",eleVerifyListingEdge );
    		return this;
    	}
    
    @FindBy(how=How.XPATH, using= ".//span[.='Product 122']")
   	public WebElement eleVerifyListing;	
    
    @FindBy (how=How.XPATH, using = "//span[.='Payment Pending']")
    public WebElement elePartialPayment;
    
    
    public IHTC_Companyadmin_Listing acceptBidShoppingChrome() {
		
    	click(eleSales);
    	sleep(4000);
    	
    	type(eleTitle, "Product 124");
    	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
		Enter.sendKeys(Keys.ENTER);
		sleep(5000);
    	verifyText("Payment Pending", elePartialPayment);	
		
    		return this;
    	}
    
 public IHTC_Companyadmin_Listing acceptBidShoppingFirefox() {
		
    	click(eleShopping);
    	sleep(4000);
    	click(eleRefresh);
    	sleep(5000);
    	
    		
		verifyText("Product 25", eleVerifyListingFireFox);
		
    		return this;
    	}
 public IHTC_Companyadmin_Listing acceptBidShoppingSafari() {
		
 	click(eleShopping);
 	sleep(4000);
 	click(eleRefresh);
 	sleep(5000);
 	
 	
 	verifyText("Product 15", eleVerifyListingChrome);	
		verifyText("Product 16", eleVerifyListingFireFox);
		verifyText("Product 17", eleNewListingEdge);
		verifyText("Product 14", eleNewListingSafari);
 		return this;
 	}
 
 public IHTC_Companyadmin_Listing acceptBidShoppingEdge() {
		
 	click(eleShopping);
 	sleep(4000);
 	click(eleRefresh);
 	sleep(5000);
 	
		verifyText("Product 26", eleNewListingEdge);
		
 		return this;
 	}
 
    @FindBy(how=How.XPATH, using= "(//span[.='Product 124'])")
	public WebElement eleUserListingAcceptBidChrome;
	
    @FindBy (how = How.XPATH, using = "(.//span[@class='label label-success'][.='Active'])[1]")
    public WebElement eleListingfromSearch;
    
	public IHTC_Companyadmin_Listing userListingChrome() {
		
		sleep(2000);
		type(eleStatusSearch, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		
		sleep(5000);
		click(eleListingfromSearch);
		scrollTillBottom();
		sleep(3000);
		return this;
	}
	
	@FindBy(how=How.XPATH, using= "(//span[.='Product 25'])")
	public WebElement eleUserListingAcceptBidFirefox;
	
	public IHTC_Companyadmin_Listing userListingFirefox() {
		
		waitForPageLoad(20);
		click(eleUserListingAcceptBidFirefox);
		sleep(3000);
		scrollTillBottom();
		sleep(3000);
		return this;
	}
	
	@FindBy(how=How.XPATH, using= "(//span[.='Product 14'])")
	public WebElement eleUserListingAcceptBidSafari;
	
	public IHTC_Companyadmin_Listing userListingSafari() {
		
		waitForPageLoad(20);
		click(eleUserListingAcceptBidSafari);
		sleep(3000);
		scrollTillBottom();
		sleep(3000);
		return this;
	}
	
	@FindBy(how=How.XPATH, using= "(//span[.='Product 26'])")
	public WebElement eleUserListingAcceptBidEdge;
	
	public IHTC_Companyadmin_Listing userListingEdge() {
		
		waitForPageLoad(20);
		click(eleUserListingAcceptBidEdge);
		sleep(3000);
		scrollTillBottom();
		sleep(3000);
		return this;
	}
    
	@FindBy(how=How.XPATH, using= "//span[.='No']")
	public WebElement eleBids;
	
	@FindBy(how=How.XPATH, using= "(.//span[.='Actions'])[4]")
	public WebElement eleActionsBid;
	
	@FindBy(how=How.XPATH, using= "(//span[.='Accept bid'])[2]")
	public WebElement eleAcceptBid;
	
	@FindBy(how=How.XPATH, using= "(//span[.='OK'])[1]")
	public WebElement eleOKAcceptBid;
	
	public IHTC_Companyadmin_Listing acceptBid() {
		
		waitForPageLoad(20);
		click(eleBids);
		sleep(2000);
		click(eleActionsBid);
		click(eleAcceptBid);
		sleep(2000);
		click(eleOKAcceptBid);
		sleep(3000);
		return this;
	}
	
	@FindBy(how=How.XPATH, using= ("//div[@data-view='types/money/ReadOnly'])[2]"))
	public WebElement elehighestbidvalue;
	
	@FindBy(how=How.XPATH, using= "(.//span[.='$200.00'])[2]")
	public WebElement eleLowestAmount;
	
	@FindBy (how = How.XPATH, using = "//span[.='This is not the highest bid. Proceed anyway?']")
	public WebElement eleWarningMessage;
	
	public IHTC_Companyadmin_Listing getamountList() {
		
		click(eleLowestAmount);
		sleep(2000);
		click(eleActionsBid);
		click(eleAcceptBid);
		sleep(2000);
		
		click(eleWarningMessage);
		verifyText("This is not the highest bid. Proceed anyway?", eleWarningMessage);
		
		click(eleOKAcceptBid);
		sleep(3000);
		return this;
	}
	
	@FindBy(how=How.XPATH, using= "//a[@class='tm-settings']")
	public WebElement elethreedotbutton;
	
	@FindBy(how=How.XPATH, using= "//span[.='Logout']")
	public WebElement elelogout;
	
    @FindBy (how = How.XPATH, using = "(//input[@class='search-field form-control input-sm column-filter'])[5]")
    public WebElement eleSearchStatus;
    
    @FindBy (how = How.XPATH, using = "(//input[@class='search-field form-control input-sm column-filter'])[2]")
    public WebElement eleListingSearchStatus;
	
    @FindBy (how = How.XPATH, using = "(//span[.='Product 124'])[1]")
    public WebElement eleProductPresent;
    
    //////Change the verify Text for all the test run. Test case name Accept A Bid///////////
    
    
  public IHTC_Companyadmin_Listing clickSalesChrome() {
	
	  	sleep(2000);
		type(eleListingSearchStatus, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		
		sleep(5000);
		click(eleListingfromSearch);
		scrollTillBottom();
		sleep(3000);
	  
		waitForPageLoad(20);
		click(eleBids);
		sleep(2000);
		click(eleActionsBid);
		click(eleAcceptBid);
		sleep(2000);
		click(eleOKAcceptBid);
		sleep(3000);
		
		
		click(eleSales);
		type(eleSearchStatus, "Payment");
		//WebElement Enter1 = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[5]"));
		Enter.sendKeys(Keys.ENTER);
		sleep(5000);
	    
	
		return this;
	}
	
  @FindBy (how = How.XPATH, using = "(.//span[@class='label label-success'][.='Active'])[2]")
  public WebElement eleListingfromSearch2;
  
  public IHTC_Companyadmin_Listing clickSalesFireFox() {
		
	  	sleep(2000);
		type(eleListingSearchStatus, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		
		sleep(5000);
		click(eleListingfromSearch2);
		scrollTillBottom();
		sleep(3000);
	  
		waitForPageLoad(20);
		click(eleBids);
		sleep(2000);
		click(eleActionsBid);
		click(eleAcceptBid);
		sleep(2000);
		click(eleOKAcceptBid);
		sleep(3000);
	 
		sleep(2000);
		click(eleSales);
		type(eleSearchStatus, "Payment");
		//WebElement Enter2 = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[5]"));
		Enter.sendKeys(Keys.ENTER);
		sleep(5000);

		
		return this;
	}
  
  @FindBy (how = How.XPATH, using = "(.//span[@class='label label-success'][.='Active'])[3]")
  public WebElement eleListingfromSearch3;
  
  public IHTC_Companyadmin_Listing clickSalesEdge() {
		
	
	  	sleep(2000);
		type(eleListingSearchStatus, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		sleep(5000);
		click(eleListingfromSearch3);
		scrollTillBottom();
		sleep(3000);
	  
		waitForPageLoad(20);
		click(eleBids);
		sleep(2000);
		click(eleActionsBid);
		click(eleAcceptBid);
		sleep(2000);
		click(eleOKAcceptBid);
		sleep(3000);
	  
		sleep(2000);
		click(eleSales);
		type(eleSearchStatus, "Payment");
		//WebElement Enter2 = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[5]"));
		Enter.sendKeys(Keys.ENTER);
		sleep(5000);
	    
		return this;
	}
  
  @FindBy (how = How.XPATH, using = "(.//span[@class='label label-success'][.='Active'])[3]")
  public WebElement eleListingfromSearch4;
  
  public IHTC_Companyadmin_Listing clickSalesSafari() {
		
	  	sleep(2000);
		type(eleListingSearchStatus, "Active");
		WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[2]"));
		Enter.sendKeys(Keys.ENTER);
		sleep(5000);
		click(eleListingfromSearch4);
		scrollTillBottom();
		sleep(3000);
	  
		waitForPageLoad(20);
		click(eleBids);
		sleep(2000);
		click(eleActionsBid);
		click(eleAcceptBid);
		sleep(2000);
		click(eleOKAcceptBid);
		sleep(2000);
		click(eleSales);
		
		type(eleSearchStatus, "Payment");
		//WebElement Enter2 = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[5]"));
		Enter.sendKeys(Keys.ENTER);
		sleep(5000);
	    
		return this;
		
	}
  
  
  public IHTC_Companyadmin_Listing warningLowerBidAmount() {
	  
	  sleep(2000);
	  return this;
  }
	
	// Change the eleNewListing for everyrun
	@FindBy(how=How.XPATH, using= "//span[.='Sales']")
	public WebElement eleSales;
	
	@FindBy(how=How.XPATH, using= "(//span[.='Product 13'])")
	public WebElement eleNewListing;
	
	public IHTC_Companyadmin_Listing verifyAcceptBid() {
		
		try 
		
		{
			
		waitForPageLoad(20);
		click(eleSales);
		sleep(3000);
		click(eleRefresh);
		sleep(3000);
			
		verifyText("Product 19", eleVerifyListingFireFox);
		
	} 
		catch (Exception e) {
		e.printStackTrace();
		reportStep("The Element is not displayed: ", "FAIL");	
	}
		return this;
	}
	
	
	/// Accept Bid Chrome ////
	
	@FindBy (how = How.XPATH, using ="(//input[@class='search-field form-control input-sm column-filter'])[1]")
	private WebElement eleTitleSearch;
	
	@FindBy (how = How.XPATH, using ="(//input[@class='search-field form-control input-sm column-filter'])[2]")
	private WebElement eleStatusSearch;
	
	@FindBy (how = How.XPATH, using = "(//span[.='Sold'])[1]")
	private WebElement eleSold;
	
public IHTC_Companyadmin_Listing verifyAcceptBid_Chrome() {
		
		try 
		
		{
			
			waitForPageLoad(20);
			click(eleListing);
			sleep(3000);
			type(eleTitleSearch, "Product 123");
			WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
			Enter.sendKeys(Keys.ENTER);
			sleep(5000);
			verifyText("Sold", eleSold);
	} 
		catch (Exception e) {
		e.printStackTrace();
		reportStep("The Element is not displayed: ", "FAIL");	
	}
		return this;
	}


/// Accept Bid Firefox /// 

public IHTC_Companyadmin_Listing verifyAcceptBid_Firefox() {
	
	try 
	
	{
		
	waitForPageLoad(20);
	click(eleListing);
	sleep(3000);
	
} 
	catch (Exception e) {
	e.printStackTrace();
	reportStep("The Element is not displayed: ", "FAIL");	
}
	return this;
}

/// Accept Bid Safari ///

public IHTC_Companyadmin_Listing verifyAcceptBid_Safari() {
	
	try 
	
	{
		
	waitForPageLoad(20);
	click(eleSales);
	sleep(3000);
	click(eleRefresh);
	sleep(3000);

	verifyText("Product 14", eleNewListingSafari);
} 
	catch (Exception e) {
	e.printStackTrace();
	reportStep("The Element is not displayed: ", "FAIL");	
}
	return this;
}

// Accept Bid Edge ///

public IHTC_Companyadmin_Listing verifyAcceptBid_Edge() {
	
	try 
	
	{
		
	waitForPageLoad(20);
	click(eleSales);
	sleep(3000);
	click(eleRefresh);
	sleep(3000);
	verifyText("Product 26", eleNewListingEdge);

} 
	catch (Exception e) {
	e.printStackTrace();
	reportStep("The Element is not displayed: ", "FAIL");	
}
	return this;
}
	
    //////////////////////////////////       NAVEEN              ////////////////////////////////
    
    @FindBy(how=How.XPATH, using= "(.//span[.='Create'])[2]")
	public WebElement eleclickCreateListings;
	
	public IHTC_Companyadmin_Listing clickCreateListings()
	{
		
		waitForPageLoad(20);
		click(eleclickCreateListings);
		sleep(2000);
		return this;	
	}
	
	
	@FindBy(how=How.XPATH, using= "(.//input[@class='form-control fullWidth'])[1]")
	public WebElement eleenterTitleListings;
	
	public IHTC_Companyadmin_Listing enterTitleListings(String Title)
	{
		
		waitForPageLoad(20);
		type(eleenterTitleListings,Title);
		sleep(2000);
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using= "(.//span[@class='select2-selection select2-selection--single'])[1]")
	public WebElement eleselectLocation;
	@FindBy(how=How.XPATH, using= "(.//ul[@class='select2-results__options']/li)[1]")
	public WebElement eleselectLocations;
	
	public IHTC_Companyadmin_Listing selectLocation()
	{
		
		waitForPageLoad(20);
		click(eleselectLocation);
		sleep(2000);
		click(eleselectLocations);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[@class='select2-selection select2-selection--single'])[2]")
	public WebElement eleselectCategory;
	
	@FindBy(how=How.XPATH, using= "(.//li[@class='select2-results__option'])[1]")
	public WebElement eleselectFirstCategory;
	
	public IHTC_Companyadmin_Listing selectCategory()
	{
		
		waitForPageLoad(20);
		click(eleselectCategory);
		sleep(2000);
		click(eleselectFirstCategory);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//input[@class='form-control fullWidth'])[2]")
	public WebElement eleenterWeight;
	
	public IHTC_Companyadmin_Listing enterWeight(String weight)
	{
		
		waitForPageLoad(20);
		type(eleenterWeight,weight);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//input[@class='form-control fullWidth'])[3]")
	public WebElement eleenterBatchNo;
	
	public IHTC_Companyadmin_Listing enterBatchNo(String batchno)
	{
		
		waitForPageLoad(20);
		type(eleenterBatchNo,batchno);
		sleep(2000);
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using= "(.//input[@class='form-control fullWidth'])[4]")
	public WebElement eleenterBaseprice;
	
	public IHTC_Companyadmin_Listing enterBaseprice(String baseprice)
	{
		
		waitForPageLoad(20);
		sleep(2000);
		eleenterBaseprice.sendKeys(Keys.CONTROL+ "a");
		eleenterBaseprice.sendKeys(Keys.BACK_SPACE); //delete it
		sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ baseprice +"';", eleenterBaseprice);
		sleep(2000);
		reportStep("Base price entered successfully", "PASS");
		//eleenterBaseprice.sendKeys(baseprice);
		//type(eleenterBaseprice,baseprice);
		sleep(5000);
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using= "(.//input[@class='form-control fullWidth'])[5]")
	public WebElement eleenterBuyitnowprice;
	
	public IHTC_Companyadmin_Listing enterBuyitnowprice(String butitnowprice)
	{
		
		waitForPageLoad(20);
		sleep(2000);
		eleenterBuyitnowprice.sendKeys(Keys.CONTROL+ "a");
		eleenterBuyitnowprice.sendKeys(Keys.BACK_SPACE); //delete it
		sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ butitnowprice +"';", eleenterBuyitnowprice);
		reportStep("Buy It now price entered successfully", "PASS");
		//eleenterBuyitnowprice.sendKeys(butitnowprice);
		//type(eleenterBuyitnowprice,butitnowprice);
		sleep(5000);
		return this;
		
	}
	
	
	
	@FindBy(how=How.XPATH, using= "(.//span[.='Create'])[5]")
	public WebElement elescrollDown;
	
	public IHTC_Companyadmin_Listing scrollDown()
	{
		
		waitForPageLoad(20);
		scrollDownRandom();
		sleep(4000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//input[@class='form-control date-picker fullWidth'])[1]")
	public WebElement eleenterEndOfListing;
	
	public IHTC_Companyadmin_Listing enterEndOfListing(String endoflistings)
	{
		
		waitForPageLoad(20);
		
		
		eleenterEndOfListing.sendKeys(Keys.CONTROL+ "a");
		eleenterEndOfListing.sendKeys(Keys.BACK_SPACE); //delete it 
		sleep(2000);
		eleenterEndOfListing.sendKeys(endoflistings); //enter new text
		sleep(5000);
		
		return this;
		
	}
	    @FindBy(how=How.XPATH, using= "//input[@name='file' and @type='file']")
		public WebElement eleuploadImageInCertificateOfAnalysis;
		
		public IHTC_Companyadmin_Listing uploadImageInCertificateOfAnalysis()
		{
			//driver.setFileDetector(new LocalFileDetector());		
			Actions actions = new Actions(driver);
		   actions.moveToElement(eleuploadImageInCertificateOfAnalysis).click().build().perform();			
		    sleep(5000);
		    
		    try {
		    	//driver.setFileDetector(new LocalFileDetector());
		    	//DesiredCapabilities capabilities = super.loadInternetExplorerDesiredCaps();
		    	DesiredCapabilities capabilities = new DesiredCapabilities();
    		    org.json.JSONObject mainObj = new org.json.JSONObject();
    		    
    		    mainObj.put("executable", "sauce-storage:Fileupload.exe");
    		    mainObj.put("background", true);
    		    mainObj.put("args", "[--silent,'-a', '-q']");
    		   // capabilities.setCapability("prerun",mainObj)
    		    capabilities.setCapability("prerun", mainObj);
		
		    	
		    	
		    	//eleuploadImageInCertificateOfAnalysis.sendKeys("C:\\Users\\Administrator\\final_output_ts.txt" );
				//Runtime.getRuntime().exec("sauce-storage:Fileupload.exe");
				  sleep(70000); 
				  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("uploaded");
			
			
			//JavascriptExecutor js = (JavascriptExecutor) driver; 
			//js.executeScript("arguments[0].setAttribute('style', arguments[1])", driver.findElement(By.xpath("//input[@type='file']")), "0");
			//js.executeScript("arguments[0].setAttribute('class', arguments[1])", driver.findElement(By.xpath("//input[@type='file']/../../div[2]")), "a");
			//driver.findElement(By.xpath("//div[@class='btn btn-primary waves-effect waves-button upload-button qq-upload-button-selector']")).sendKeys("/Users/naveenkumarthiyagarajan/Desktop/SS.png");
			//uploadImageInCertificateOfAnalysis.sendKeys("/Users/naveenkumarthiyagarajan/Desktop/SS1.png");
			return this;
			
		}
		
		@FindBy(how=How.XPATH, using= "(.//span[@id='uploadButton'])[1]")
		public WebElement eleupload;
		
		
		public IHTC_Companyadmin_Listing uploadImageInCertificateOfAnalysis1()
		{
	
			
	   try {
			  WebElement e=driver.findElement(By.xpath("//input[@name='file' and @type='file']"));
			  sleep(2000);
			  eleuploadImageInCertificateOfAnalysis.sendKeys("C:\\Users\\tring\\OneDrive\\Desktop\\Sikuli\\IHTC_DOC.pdf");
			   sleep(3000);
			   reportStep("File uploaded successfully", "PASS");
			   sleep(5000);
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   
			System.out.println("uploaded");
			return this;
			
		}
		
	@FindBy(how=How.XPATH, using= "(.//span[@class='select2-selection select2-selection--single'])[3]")
	public WebElement eleselectLaboratory;
	@FindBy(how=How.XPATH, using= "(.//li[@class='select2-results__option'])[1]")
	public WebElement eleselectFirstLaboratory;
	
	public IHTC_Companyadmin_Listing selectLaboratory()
	{
		
		waitForPageLoad(20);
		click(eleselectLaboratory);
		sleep(2000);
		click(eleselectFirstLaboratory);
		sleep(2000);
		
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//input[@class='form-control date-picker fullWidth'])[2]")
	public WebElement eleenterDateOfAnalysis;
	
	public IHTC_Companyadmin_Listing enterDateOfAnalysis(String dateofanalysis)
	{
		
		waitForPageLoad(20);
		
		eleenterDateOfAnalysis.sendKeys(Keys.CONTROL+ "a");
		eleenterDateOfAnalysis.sendKeys(Keys.BACK_SPACE); //delete it 
		sleep(2000);
		eleenterDateOfAnalysis.sendKeys(dateofanalysis);
		
		sleep(5000);
		
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Create'])[2]")
	public WebElement eleclickCreate;
	
	public IHTC_Companyadmin_Listing clickCreate()
	{
		try {
		waitForPageLoad(20);
		sleep(2000);
		click(eleclickCreate);
		sleep(5000);
		}
		catch(Exception e)
		{e.printStackTrace();}
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Draft'])")
	public WebElement elevalidateDraftStatus;
	
	public IHTC_Companyadmin_Listing validateDraftStatus()
	{
		try {
		waitForPageLoad(20);
		elementdisplayed(elevalidateDraftStatus);
		sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Create'])[5]")
	public WebElement elescrollup;
	
	public IHTC_Companyadmin_Listing scrollUp()
	{
		
		
		scrollUpRandom();
		
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "//span[.='Permission denied to create [listings] records']")
	public WebElement eleverifyErrorMsgBuyer;
	
	public IHTC_Companyadmin_Listing verifyErrorMsgBuyer()
	{
		
		reportStep("Unable to create a Listings since it a buyer account: ", "PASS");	
		
    	return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Actions'])[2]")
	public WebElement eleclickActions;
	
	public IHTC_Companyadmin_Listing clickActions()
	{
		
		waitForPageLoad(20);
		click(eleclickActions);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Publish'])[2]")
	public WebElement eleclickPublish;
	
	public IHTC_Companyadmin_Listing clickPublish()
	{
		
		waitForPageLoad(20);
		click(eleclickPublish);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='OK'])[3]")
	public WebElement eleclickOkPublish;
	
	public IHTC_Companyadmin_Listing clickOkPublish()
	{
		
		waitForPageLoad(20);
		click(eleclickOkPublish);
		sleep(5000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Active'])")
	public WebElement elevalidateActiveStatus;
	
	public IHTC_Companyadmin_Listing validateActiveStatus()
	{
		
		waitForPageLoad(20);
		elementdisplayed(elevalidateActiveStatus);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "//span[.='Date of Analysis should be a past date']")
	public WebElement elevalidateDOAAndEOL;
	
	public IHTC_Companyadmin_Listing validateDOAAndEOL()
	{
		
		waitForPageLoad(20);
		sleep(5000);
		elementdisplayed(elevalidateDOAAndEOL);
		sleep(2000);
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using= "//span[.='This field is required']")
	public WebElement elevalidateEmptyfield;
	public IHTC_Companyadmin_Listing validateEmptyfield()
	{
		
		waitForPageLoad(20);
		elementdisplayed(elevalidateEmptyfield);
		sleep(2000);
		return this;
		
	}
@FindBy(how=How.XPATH, using= "(.//span[.='Inactive'])[1]")
	
	//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
	public WebElement eleclickParticularListInactiveChrome;
	
	public IHTC_Companyadmin_Listing clickParticularListInactiveChrome()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListInactiveChrome);
		sleep(2000);
		return this;
		
	}
@FindBy(how=How.XPATH, using= "(.//span[.='Inactive'])[2]")
	
	//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
	public WebElement eleclickParticularListInactiveFirefox;
	
	public IHTC_Companyadmin_Listing clickParticularListInactiveFirefox()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListInactiveFirefox);
		sleep(2000);
		return this;
		
	}
@FindBy(how=How.XPATH, using= "(.//span[.='Inactive'])[1]")
	
	//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
	public WebElement eleclickParticularListInactiveEdge;
	
	public IHTC_Companyadmin_Listing clickParticularListInactiveEdge()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListInactiveEdge);
		sleep(2000);
		return this;
		
	}
@FindBy(how=How.XPATH, using= "(.//span[.='Inactive'])[2]")
	
	//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
	public WebElement eleclickParticularListInactiveSafari;
	
	public IHTC_Companyadmin_Listing clickParticularListInactiveSafari()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListInactiveSafari);
		sleep(2000);
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using= "(.//span[.='Active'])[1]")
	
	//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
	public WebElement eleclickParticularListChrome;
	
	public IHTC_Companyadmin_Listing clickParticularListActiveChrome()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListChrome);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Active'])[2]")
	public WebElement eleclickParticularListFirefox;
	
	public IHTC_Companyadmin_Listing clickParticularListActiveFirefox()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListFirefox);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Active'])[1]")
	public WebElement eleclickParticularListEdge;
	
	public IHTC_Companyadmin_Listing clickParticularListActiveEdge()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListEdge);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Active'])[2]")
	public WebElement eleclickParticularListSafari;
	
	public IHTC_Companyadmin_Listing clickParticularListActiveSafari()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListSafari);
		sleep(2000);
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using= "(.//span[.='Draft'])[1]") 
	
	
	//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
	public WebElement eleclickParticularListDraftChrome;
	
	public IHTC_Companyadmin_Listing clickParticularListDraftChrome()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListDraftChrome);
		sleep(2000);
		return this;
		
	}
	
	//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
	@FindBy(how=How.XPATH, using= "(.//span[.='Draft'])[2]")
	public WebElement eleclickParticularListDraftFirefox;
	
	public IHTC_Companyadmin_Listing clickParticularListDraftFirefox()
	{
		
		waitForPageLoad(20);
		click(eleclickParticularListDraftFirefox);
		sleep(2000);
		return this;
		
	}
	//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
		@FindBy(how=How.XPATH, using= "(.//span[.='Draft'])[1]")
		public WebElement eleclickParticularListDraftEdge;
		
		public IHTC_Companyadmin_Listing clickParticularListDraftEdge()
		{
			
			waitForPageLoad(20);
			click(eleclickParticularListDraftEdge);
			sleep(2000);
			return this;
			
		}
		//@FindBy(how=How.XPATH, using= "//span[.='Dora']")
		@FindBy(how=How.XPATH, using= "(.//span[.='Draft'])[2]")
		public WebElement eleclickParticularListDraftSafari;
		
		public IHTC_Companyadmin_Listing clickParticularListDraftSafari()
		{
			
			waitForPageLoad(20);
			click(eleclickParticularListDraftSafari);
			sleep(2000);
			return this;
			
		}
	@FindBy(how=How.XPATH, using= "(.//span[.='Clone'])[2]")
	public WebElement eleclickClone;
	
	public IHTC_Companyadmin_Listing clickClone()
	{
		
		waitForPageLoad(20);
		click(eleclickClone);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='OK'])[4]")
	public WebElement eleclickOkClone;
	
	@FindBy(how=How.XPATH, using= "//span[.='Sales']")
	public WebElement eleclicksalesmenu;
	
	@FindBy(how=How.XPATH, using= "(//span[.='Listings'])[1]")
	public WebElement eleclicklistingmenu;
	
	@FindBy(how=How.XPATH, using= "(.//input[@class='search-field form-control input-sm column-filter'])[1]")
	public WebElement eleclicklistingsearch;
	
	@FindBy(how=How.XPATH, using= "(//span[@data-bind='html: getValue()'])[1]")
	public WebElement elegetlistingname;
	
	@FindBy(how=How.XPATH, using= "(//button[@class='btn btn-danger btn-sm  waves-effect waves-button'])[2]")
	public WebElement eledeletebutton;
	
	public IHTC_Companyadmin_Listing clickOkClone()
	{
		
		try {
		waitForPageLoad(20);
		
		click(eleclickOkClone);
		sleep(5000);
		String listingname=elegetlistingname.getText();
		sleep(1000);
		click(eleclicksalesmenu);
		sleep(1000);
		click(eleclicklistingmenu);
		waitForPageLoad(30);
		click(eleclicklistingsearch);
		sleep(1000);
		type(eleclicklistingsearch, listingname);
		eleclicklistingsearch.sendKeys(Keys.ENTER);
		sleep(3000);
			
		if(listingname.contains("Clone"))
		{
			reportStep("Listing clone created successfully", "PASS");
		}
		
		click(elegetlistingname);
		waitForPageLoad(40);
		click(eledeletebutton);
		sleep(1000);
		click(elesuperadmin_Yesdelete);
		sleep(1000);
		reportStep("Clone listing deleted successfully", "PASS");
		}catch(Exception e)
		{e.printStackTrace();}
		
		
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Cancel'])[2]")
	public WebElement eleclickCancel;
	
	public IHTC_Companyadmin_Listing clickCancel()
	{
		
		waitForPageLoad(20);
		click(eleclickCancel);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='OK'])[4]")
	public WebElement eleclickOKCancel;
	
	public IHTC_Companyadmin_Listing clickOkCancel()
	{
		
		waitForPageLoad(20);
		click(eleclickOKCancel);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Inactive'])")
	public WebElement elevalidateInactiveStatus;
	
	public IHTC_Companyadmin_Listing validateInactiveStatus()
	{
		
		waitForPageLoad(20);
		elementdisplayed(elevalidateInactiveStatus);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Republish'])[2]")
	public WebElement eleclickRepublish;
	
	public IHTC_Companyadmin_Listing clickRepublish()
	{
		
		waitForPageLoad(20);
		click(eleclickRepublish);
		sleep(5000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//input[@class='form-control fullWidth'])[1]")
	public WebElement eleenterBasePriceInRepublish;
	
	public IHTC_Companyadmin_Listing enterendflistingInRepublish(String baseprice)
	{
		try {
		waitForPageLoad(20);
		sleep(2000);
		
		eleenterEndOfListing.sendKeys(Keys.CONTROL+ "a");
		eleenterEndOfListing.sendKeys(Keys.BACK_SPACE); //delete it 
		sleep(2000);
		eleenterEndOfListing.sendKeys(baseprice); //enter new text
		sleep(5000);
		reportStep("End of listing date entered entered successfully", "PASS");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		/*eleenterBasePriceInRepublish.sendKeys(Keys.CONTROL+ "a");
		eleenterBasePriceInRepublish.sendKeys(Keys.BACK_SPACE); //delete it
		sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ baseprice +"';", eleenterBasePriceInRepublish);
		sleep(2000);
		eleenterBasePriceInRepublish.sendKeys(Keys.TAB);
		reportStep("Base price entered successfully", "PASS");
		sleep(2000);*/
		
		
		//type(eleenterBasePriceInRepublish,baseprice);
		//sleep(2000);
		return this;
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='OK'])[3]")
	public WebElement eleclickOkRepublish;
	
	public IHTC_Companyadmin_Listing clickOkRepublish()
	{
		try {
		waitForPageLoad(20);
		sleep(3000);
		click(eleclickOkRepublish);
		sleep(2000);
		}catch(Exception e)
		{
			sleep(3000);
			click(eleclickOkRepublish);
		}
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Active'])")
	public WebElement elevalidateRepublishToActiveStatus;
	
	public IHTC_Companyadmin_Listing validateRepublishToActiveStatus()
	{
		
		waitForPageLoad(20);
		sleep(5000);
		elementdisplayed(elevalidateRepublishToActiveStatus);
		sleep(2000);
		return this;
		
	}
	@FindBy(how=How.XPATH, using= "(.//span[.='Active'])")
	public WebElement eleexplicitlyWaiting;
	
	public IHTC_Companyadmin_Listing explicitlyWaiting()
	{
		sleep(60000);
		
		driver.navigate().refresh();
		return this;
		
	}
    
	@FindBy(how=How.XPATH, using= "(.//span[.='No records found'])")
	public WebElement elevalidateDraftStatusBuyer;
	
	@FindBy(how=How.XPATH, using= ".//input[@class='search-field form-control input-sm column-filter']")
	public WebElement eleSearchbylistingname;
	
		
	public IHTC_Companyadmin_Listing validateDraftStatusBuyer(String title)
	{
		sleep(3000);
		click(eleSearchbylistingname);
		sleep(2000);
		type(eleSearchbylistingname, title);
		eleSearchbylistingname.sendKeys(Keys.ENTER);
		sleep(3000);
	try {
		if(elevalidateDraftStatusBuyer.isDisplayed()) {
			
			reportStep("created list with draft status is not visible to buyer", "PASS");
		}
		sleep(2000);
		}catch(Exception e) {
			reportStep("created list with draft status is visible to buyer", "FAIL");
		}
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using= "//a[@class='tm-settings']")
	public WebElement eleMenu;
	
	@FindBy(how=How.XPATH, using= "//span[.='Logout']")
	public WebElement eleLogOut;
	
	public IHTC_Companyadmin_Listing clickLogout()
	{
		click(eleMenu);
		sleep(3000);
		
		click(eleLogOut);
		sleep(3000);
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using= "(.//span[.='Active'])")
	public WebElement elevalidateDraftToActiveStatusTime;

	public IHTC_Companyadmin_Listing validateDraftToActiveStatusTime()
	{
	try {
	if(elevalidateDraftToActiveStatusTime.isDisplayed()) {
	reportStep("List should not changes to active status", "FAIL");
	}
	}catch(Exception e) {
	reportStep("List is in draft status" , "PASS");
	}
	sleep(2000);

	return this;

	}
	
	@FindBy(how=How.XPATH, using= ".//span[@data-notify='message']")
	public WebElement elevalidateSuspendedCompanyStatus;

	public IHTC_Companyadmin_Listing validateSuspendedCompanyStatus()
	{
		try {
	waitForPageLoad(20);
	//elementdisplayed(elevalidateSuspendedCompanyStatus);
	
	fluentwait(elevalidateSuspendedCompanyStatus, 90);
	
	if(elevalidateSuspendedCompanyStatus.isDisplayed())
	{
		
		reportStep("The alert message is displayed", "PASS");
	}
	
	}catch(Exception e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	
	//Delete listing in super admin
	
		@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
		private WebElement eleUserName;
	
		@FindBy(how = How.XPATH, using = "(.//input[@id='password'])")
		private WebElement elePassword;
	
		@FindBy(how = How.XPATH, using = "(.//div[@data-bind='button: loginSection.loginButton'])")
		private WebElement eleLogin;
	
	
		@FindBy(how = How.XPATH, using = "(//span[.='All Listings'])[1]")
		private WebElement elesuperadmin_All_listing ;
		
		@FindBy(how = How.XPATH, using = "(//input[@class='search-field form-control input-sm column-filter'])[1]")
		private WebElement elesuperadmin_productname;
		
		@FindBy(how = How.XPATH, using = "(//div[@class='text-left'])[1]")
		private WebElement elesuperadmin_selectlisting;
		
		@FindBy(how = How.XPATH, using = "(//span[.='Delete'])[2]")
		private WebElement elesuperadmin_Deleteaction;
		
		@FindBy(how = How.XPATH, using = "//span[.='Yes, delete it!']")
		private WebElement elesuperadmin_Yesdelete;
		
		@FindBy(how = How.XPATH, using="(.//a[@class='tm-settings'])")
		private WebElement eleuserpage_hamburgericon;
		
		@FindBy(how = How.XPATH, using="(.//span[.='Logout'])")
		private WebElement eleuserpage_Logout;
		
		@FindBy(how = How.XPATH, using = ".//span[.='No records found']")
		private WebElement eleNorecord;
		
		public IHTC_Companyadmin_Listing Deletelisting(String emailid,String password,String productname)
		{
			try {
				
			sleep(2000);
			click(eleuserpage_hamburgericon);
			sleep(1000);
			click(eleuserpage_Logout);
			sleep(3000);
			waitForPageLoad(60);
			iHTCcredentials(eleUserName, elePassword, eleLogin, emailid, password);
			sleep(3000);
			waitForPageLoad(60);
			sleep(3000);
			click(elesuperadmin_All_listing);
			click(elesuperadmin_productname);
			type(elesuperadmin_productname, productname);
			elesuperadmin_productname.sendKeys(Keys.ENTER);
			sleep(2000);
			click(elesuperadmin_selectlisting);
			fluentwait(elesuperadmin_Deleteaction, 30);
			click(elesuperadmin_Deleteaction);
			sleep(3000);
			click(elesuperadmin_Yesdelete);
			sleep(5000);
			
			if(eleNorecord.isDisplayed())
			{
				reportStep("Listing deleted successfully", "PASS");
			}
			
			
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				reportStep("There was a problem while deleting the Listing", "FAIL");
			}
			
			return this;
		}
		
    
    
}
