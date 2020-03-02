package iHTC_page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_MessagingNotification extends ProjectMethods{

	public IHTC_MessagingNotification(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (how = How.XPATH, using = "//span[.='Listings']")
	private WebElement eleListing;
	
	public IHTC_MessagingNotification clickListing() {
		
		try {
			
			sleep(2000);
			click(eleListing);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			reportStep("Listing element was not clickable", "FAIL");
		}
		
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//input[@class='search-field form-control input-sm column-filter'])[2]")
	private WebElement eleStatus;
	
	public IHTC_MessagingNotification searchStatus() throws AWTException {
		
		sleep(2000);
		click(eleStatus);
		
		type(eleStatus, "Active");
		Robot robot = new Robot(); sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		

		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-success'])[1]")
	private WebElement eleActiveChrome;
	
	public IHTC_MessagingNotification eleActiveForChrome() {
		
		sleep(2000);
		click(eleActiveChrome);
		click(eleAction);
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-success'])[2]")
	private WebElement eleActiveFirefox;
	
	public IHTC_MessagingNotification eleActiveFirefox() {
		
		sleep(3000);
		click(eleActiveFirefox);
		click(eleAction);
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-success'])[4]")
	private WebElement eleActiveSafari;
	
	public IHTC_MessagingNotification eleActiveSafari() {
		
		sleep(2000);
		click(eleActiveSafari);
		click(eleAction);
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-success'])[3]")
	private WebElement eleActiveEdge;
	
	public IHTC_MessagingNotification eleActiveEdge() {
		
		sleep(2000);
		click(eleActiveEdge);
		click(eleAction);
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='eleStatus'])[1]")
	private WebElement eleChrome;
	
	public IHTC_MessagingNotification eleForChrome() throws AWTException {
		
		sleep(2000);
		//click(eleChrome);
		askAQuestionListingChrome();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='eleStatus'])[2]")
	private WebElement eleFireFox;
	
	public IHTC_MessagingNotification eleForFireFox() throws AWTException {
		
		sleep(2000);
		//click(eleFireFox);
		askAQuestionListingFireFox();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='eleStatus'])[3]")
	private WebElement eleSafari;
	
	public IHTC_MessagingNotification eleForSafari() throws AWTException {
		
		sleep(2000);
		//click(eleSafari);
		askAQuestionListingSafari();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='eleStatus'])[4]")
	private WebElement eleEdge;
	
	public IHTC_MessagingNotification eleForEdge() throws AWTException {
		
		sleep(2000);
		//click(eleEdge);
		askAQuestionListingEdge();
		return this;
	}
	
	
	@FindBy( how = How.XPATH, using = "(//span[.='Actions'])[2]")
    private WebElement eleAction;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='bgm-regular'])[4]")
	private WebElement eleAskAQuestion;
	
	@FindBy (how = How.XPATH, using = "//div[@class='note-editable']")
	private WebElement eleAddMessage;
	
	@FindBy (how = How.XPATH, using = "(//span[.='OK'])[3]")
	private WebElement eleOK;
	
	@FindBy (how = How.XPATH, using = "//span[.='Messages']")
	private WebElement eleMessage;
	
	@FindBy (how = How.XPATH, using = "(.//input[@class='search-field form-control input-sm column-filter'])[1]")
	private WebElement eleTitleSearch;
	
	

	@FindBy (how = How.XPATH, using = "//span[.='Message Information']")
	private WebElement eleReadMessage;
	
	@FindBy (how = How.XPATH, using = "(//span[@style='white-space: normal;'])[1]")
	private WebElement clickMessageNotificationChrome;
	
	@FindBy (how = How.XPATH, using = "(//span[@style='white-space: normal;'])[2]")
	private WebElement clickMessageNotificationFirefox;
	
	@FindBy (how = How.XPATH, using = "(//span[@style='white-space: normal;'])[3]")
	private WebElement clickMessageNotificationSafari;
	
	@FindBy (how = How.XPATH, using = "(//span[@style='white-space: normal;'])[4]")
	private WebElement clickMessageNotificationEdge;
	
	public IHTC_MessagingNotification askAQuestionListingChrome() throws AWTException {
		
		try {
		
		sleep(2000);
		
		click(eleAskAQuestion);
		sleep(3000);
		
		type(eleAddMessage, "Message Information");
		click(eleOK);
		sleep(10000);
		
		click(eleMessage);
		sleep(5000);
		
		if(eleTitleSearch.isDisplayed()) {
	
		type(eleTitleSearch, "Question");
		Robot robot = new Robot(); sleep(5000);
		
		robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		sleep(5000);
		
		click(clickMessageNotificationChrome);
		sleep(2000);
		
		click(eleReadMessage);
		verifyText("Message Information", eleReadMessage);
		
		}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			reportStep("Added Message was not read", "FAIL");
		}
		return this;
	}
	

public IHTC_MessagingNotification askAQuestionListingFireFox() throws AWTException {
		
		try {
		
		sleep(2000);
		
		click(eleAskAQuestion);
		sleep(3000);
		
		type(eleAddMessage, "Message Information");
		click(eleOK);
		sleep(10000);
		
		click(eleMessage);
		sleep(5000);
		
		if(eleTitleSearch.isDisplayed()) {
	
		type(eleTitleSearch, "Question");
		Robot robot = new Robot(); sleep(5000);
		
		robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		sleep(5000);
		
		click(clickMessageNotificationChrome);
		sleep(5000);
		
		click(eleReadMessage);
		verifyText("Message Information", eleReadMessage);
		
		}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			reportStep("Added Message was not read", "FAIL");
		}
		return this;
	}
	
	
public IHTC_MessagingNotification askAQuestionListingSafari() throws AWTException {
	
	try {
	
	sleep(2000);
	
	click(eleAskAQuestion);
	sleep(3000);
	
	type(eleAddMessage, "Message Information");
	click(eleOK);
	sleep(10000);
	
	click(eleMessage);
	sleep(5000);
	
	if(eleTitleSearch.isDisplayed()) {

	type(eleTitleSearch, "Question");
	Robot robot = new Robot(); sleep(2000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click(clickMessageNotificationChrome);
	sleep(2000);
	click(eleReadMessage);
	verifyText("Message Information", eleReadMessage);
	
	}
	
	} catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Added Message was not read", "FAIL");
	}
	return this;
}

public IHTC_MessagingNotification askAQuestionListingEdge() throws AWTException {
	
	try {
	
	sleep(2000);
	
	click(eleAskAQuestion);
	sleep(3000);
	
	type(eleAddMessage, "Message Information");
	click(eleOK);
	sleep(10000);
	
	click(eleMessage);
	sleep(5000);
	
	if(eleTitleSearch.isDisplayed()) {

	type(eleTitleSearch, "Question");
	Robot robot = new Robot(); sleep(5000);
	
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(5000);
	click(clickMessageNotificationChrome);
	sleep(5000);
	click(eleReadMessage);
	verifyText("Message Information", eleReadMessage);
	
	}
	
	} catch (Exception e) {
		
		e.printStackTrace();
		reportStep("Added Message was not read", "FAIL");
	}
	return this;
}
	
@FindBy (how = How.XPATH, using = "(//input[@class='search-field form-control input-sm column-filter'])[2]")
private WebElement eleSearchDraft;

@FindBy (how = How.XPATH, using = "(//span[@class='label label-default'])[1]")
private WebElement eleDraftclick;

@FindBy (how = How.XPATH, using = "(//span[@class='bgm-regular'])[1]")
private WebElement elePublish;

@FindBy (how = How.XPATH, using = "(//span[.='OK'])[4]")
private WebElement eleOKPublish;

public IHTC_MessagingNotification searchStatusDraftChrome() throws AWTException {
	
	sleep (2000);
	click(eleSearchDraft);
	type (eleSearchDraft, "Draft");
	Robot robot = new Robot(); sleep(2000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click(eleDraftclick);
	sleep(2000);
	
	click(eleAction);
	click(elePublish);
	
	sleep(3000);
	click(eleOKPublish);
	
	click(eleMessage);
	return this;
}

 ///////////// Notification After Seller Accept Bid ///////////////////////

@FindBy (how = How.XPATH, using = "(//span[@class='label label-default'])[1]")
private WebElement eleListingSelect;

@FindBy (how = How.XPATH, using = "(//span[.='Actions'])[4]")
private WebElement eleActionBid;

@FindBy (how = How.XPATH, using = "(//span[.='Accept bid'])[2]")
private WebElement eleAcceptBid;

@FindBy (how = How.XPATH, using = "(//span[.='OK'])[1]")
private WebElement eleOKBid;

@FindBy (how = How.XPATH, using = "(//input[@type='text'])[2]")
private WebElement eleTypeSearch;

@FindBy (how = How.XPATH, using = "(//span[@class='label label-default'])[1]")
private WebElement eleTranscation;

@FindBy (how = How.XPATH, using = "(//form[@class='form-horizontal'])[2]")
private WebElement eleMessageinfo;

@FindBy (how = How.XPATH, using = "(//span[.='Make a bid'])[2]")
private WebElement eleMakeABid;

@FindBy (how = How.XPATH, using = "//span[.='Transaction HEMP-TR-50053 - Product 121']")
private WebElement eleAfterSellerAcceptBid;

@FindBy (how = How.XPATH, using = "(//div[@class='form-label-control'])[3]")
private WebElement eleFullPaymentDetails;

@FindBy (how = How.XPATH, using = "(//span[@class='htmlWidget']/p['In order to complete the payment, the buyer needs to make the following bank transfer:'])[8]")
private WebElement eleverify;

public IHTC_MessagingNotification AcceptABidNotification() throws AWTException {
	
sleep (2000);
click(eleMessage);
type(eleTitleSearch, "Product 121");
Robot robot = new Robot(); sleep(5000);
robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
sleep(3000);
click(eleAfterSellerAcceptBid);
sleep(5000);

click(eleFullPaymentDetails);
verifyText("In order to complete the payment, the buyer needs to make the following bank transfer:", eleverify);

	
	return this;
}



/////////// Notification After Buy It Now option //////////////////


@FindBy (how = How.XPATH, using = "(//span[@class='bgm-regular'])[1]")
private WebElement eleMakeABidNotifi;

@FindBy (how = How.XPATH, using = "(.//div[@class='toggle-switch']//label[@class='ts-helper'])[1]")
private WebElement eleBuyITNow;

@FindBy (how = How.XPATH, using = "(//div[@class='form-label-control'])[3]")
private WebElement elePartialPaymentMessage;

@FindBy (how = How.XPATH, using = "(//span[.='Make a bid'])[2]")
private WebElement eleActionMessage;

@FindBy (how = How.XPATH, using = "//span[@id='select2-mvyc-container']")
private WebElement eleAmountclick;

public IHTC_MessagingNotification BuyItNowChrome() throws AWTException {

	
	click(eleListing);
	sleep(3000);
	
	click(eleStatus);
	type(eleStatus, "Active");
	Robot robot = new Robot(); sleep(5000);
	
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click (eleActiveChrome);
	sleep(3000);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", eleActionMessage);
	//click(eleActionMessage);
	click(eleMakeABidNotifi);
	sleep(3000);
	
	js.executeScript("arguments[0].click();", eleAmountclick);
	/*Actions actions = new Actions(driver);
	WebElement elementLocator = driver.findElement(By.xpath("//span[@id='select2-mvyc-container']"));
	actions.doubleClick(elementLocator).perform();*/
	sleep(2000);
	click(eleBuyITNow);
	
	sleep(2000);
	
	js.executeScript("arguments[0].click();", eleOK);
	//click(eleOK);
	sleep(5000);
	
	click(eleMessage); 
	sleep(5000);
	
	type(eleTypeSearch, "Transactions");
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click(eleTranscation);
	sleep(6000);
	
	click(elePartialPaymentMessage);
	String text = elePartialPaymentMessage.getText();
	System.out.println(text);
	return this;
}

public IHTC_MessagingNotification BuyItNowFirefox() throws AWTException {

	
	click(eleListing);
	sleep(3000);
	
	click(eleStatus);
	type(eleStatus, "Active");
	Robot robot = new Robot(); sleep(5000);
	
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click (eleActiveFirefox);
	sleep(3000);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", eleActionMessage);
	//click(eleActionMessage);
	click(eleMakeABidNotifi);
	sleep(3000);
	
	js.executeScript("arguments[0].click();", eleAmountclick);
	/*Actions actions = new Actions(driver);
	WebElement elementLocator = driver.findElement(By.xpath("//span[@id='select2-mvyc-container']"));
	actions.doubleClick(elementLocator).perform();*/
	sleep(2000);
	click(eleBuyITNow);
	
	sleep(2000);
	
	js.executeScript("arguments[0].click();", eleOK);
	//click(eleOK);
	sleep(5000);
	
	click(eleMessage); 
	sleep(5000);
	
	type(eleTypeSearch, "Transactions");
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click(eleTranscation);
	sleep(6000);
	
	click(elePartialPaymentMessage);
	String text = elePartialPaymentMessage.getText();
	System.out.println(text);
	return this;
}

public IHTC_MessagingNotification BuyItNowEdge() throws AWTException {

	
	click(eleListing);
	sleep(3000);
	
	click(eleStatus);
	type(eleStatus, "Active");
	Robot robot = new Robot(); sleep(5000);
	
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click (eleActiveEdge);
	sleep(3000);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", eleActionMessage);
	//click(eleActionMessage);
	click(eleMakeABidNotifi);
	sleep(3000);
	
	js.executeScript("arguments[0].click();", eleAmountclick);
	/*Actions actions = new Actions(driver);
	WebElement elementLocator = driver.findElement(By.xpath("//span[@id='select2-mvyc-container']"));
	actions.doubleClick(elementLocator).perform();*/
	sleep(2000);
	click(eleBuyITNow);
	
	sleep(2000);
	
	js.executeScript("arguments[0].click();", eleOK);
	//click(eleOK);
	sleep(5000);
	
	click(eleMessage); 
	sleep(5000);
	
	type(eleTypeSearch, "Transactions");
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click(eleTranscation);
	sleep(6000);
	
	click(elePartialPaymentMessage);
	String text = elePartialPaymentMessage.getText();
	System.out.println(text);
	return this;
}

public IHTC_MessagingNotification BuyItNowSafari() throws AWTException {

	
	click(eleListing);
	sleep(3000);
	
	click(eleStatus);
	type(eleStatus, "Active");
	Robot robot = new Robot(); sleep(5000);
	
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click (eleActiveSafari);
	sleep(3000);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", eleActionMessage);
	//click(eleActionMessage);
	click(eleMakeABidNotifi);
	sleep(3000);
	
	js.executeScript("arguments[0].click();", eleAmountclick);
	/*Actions actions = new Actions(driver);
	WebElement elementLocator = driver.findElement(By.xpath("//span[@id='select2-mvyc-container']"));
	actions.doubleClick(elementLocator).perform();*/
	sleep(2000);
	click(eleBuyITNow);
	
	sleep(2000);
	
	js.executeScript("arguments[0].click();", eleOK);
	//click(eleOK);
	sleep(5000);
	
	click(eleMessage); 
	sleep(5000);
	
	type(eleTypeSearch, "Transactions");
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);
	click(eleTranscation);
	sleep(6000);
	
	click(elePartialPaymentMessage);
	String text = elePartialPaymentMessage.getText();
	System.out.println(text);
	return this;
}


@FindBy (how = How.XPATH, using = "(//span[.='OK'])[3]")
private WebElement eleMakeaBidOKButton;

@FindBy (how = How.XPATH, using = "//span[.='Listing Product 119']")
private WebElement eleMakeABidMessage;

@FindBy (how = How.XPATH, using = "//span[@class='htmlWidget']/p['You have a new bid from company IT Product for $200']")
private WebElement eleMessageMakeABid;

public IHTC_MessagingNotification makeABidMessage() throws AWTException {

	sleep(3000);
	
	sleep(2000);
	click(eleMessage);
	type(eleTitleSearch, "Product 119");
	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
	Enter.sendKeys(Keys.ENTER);
	sleep(5000);
	/*Robot robot = new Robot(); sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);*/
	click(eleMakeABidMessage);
	sleep(5000);
	
	click(eleMessageMakeABid);
	verifyText("You have a new bid from company IT Product for $200", eleMessageMakeABid);
	
	return this;
}

///////////////////////// Transaction Cancelled ////////////////////////////////

@FindBy(how = How.XPATH, using = "(//div[@class='text-left'])[1]")
private WebElement eleProductTranscationCancelled;

@FindBy (how = How.XPATH, using = "(//span[@class='htmlWidget']/p['Your transaction has been canceled due to inactivity.'])[1]")
private WebElement elecancelledMessage;

public IHTC_MessagingNotification transactionCancelled() throws AWTException {

	try {
		
	
	sleep(2000);
	click(eleMessage);
	type(eleTitleSearch, "Product 04");
	
	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
	Enter.sendKeys(Keys.ENTER);
	sleep(5000);
	
	/*Robot robot = new Robot(); sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(5000);*/
	click(eleProductTranscationCancelled);
	sleep(5000);
	
	click(elecancelledMessage);
	verifyText("Your transaction has been canceled due to inactivity.", elecancelledMessage);
	}
	catch(Exception e) {
		e.printStackTrace();
		reportStep("The Transcation cancelled message Testcase: ", "FAIL");
	}
	return this;
	
}

///////////////////////// Payment Reminder Hours ////////////////////////////////
@FindBy (how = How.XPATH, using = "(.//span[@class='htmlWidget']/p[' Please remember to start the payment process. You have 72 hours left before the transaction gets canceled.'])[1]")
private WebElement elePaymentMessage;

@FindBy (how = How.XPATH, using = "//span[.='Transaction HEMP-TR-50039 - Product 112']")
private WebElement elePaymentReminder;

public IHTC_MessagingNotification paymentReminderHours() throws AWTException{
	
	sleep(2000);
	click(eleMessage);
	type(eleTitleSearch, "Product 112");
	
	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
	Enter.sendKeys(Keys.ENTER);
	sleep(5000);
	
	/*Robot robot = new Robot(); sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(3000);*/
	click(elePaymentReminder);
	sleep(5000);
	
	click(elePaymentMessage);
	verifyText("Please remember to start the payment process. You have 72 hours left before the transaction gets canceled.", elePaymentMessage);
	
	return this;
}

///////////////////////// Shipping Reminder  ////////////////////////////////


@FindBy (how = How.XPATH, using = "(.//span[@class='htmlWidget']/p['We received the payment from the buyer!'])[1]")
private WebElement eleshipmentMessage1;

@FindBy (how = How.XPATH, using = "(.//span[@class='htmlWidget']/p['Now, the seller needs to ship the product by executing the action Set Up Shipment on the transaction HEMP-TR-50039'])[2]")
private WebElement eleshipmentMessage2;

public IHTC_MessagingNotification shippmentReminderHours() throws AWTException{
	
	sleep(2000);
	click(eleMessage);
	type(eleTitleSearch, "Product 112");
	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
	Enter.sendKeys(Keys.ENTER);
	sleep(5000);
	

	click(elePaymentReminder);
	sleep(5000);
	
	click(eleshipmentMessage1);
	verifyText("We received the payment from the buyer!", eleshipmentMessage1);
	sleep(2000);
	click(eleshipmentMessage2);
	verifyText("Now, the seller needs to ship the product by executing the action Set Up Shipment on the transaction HEMP-TR-50039", eleshipmentMessage2);
	
	return this;
}

//////////////////////// Refund Alert /////////////////////////////////

@FindBy (how = How.XPATH, using = "(.//span[@class='htmlWidget']/p[' Your money will be refunded... '])[3]")
private WebElement eleRefundMessage;

@FindBy (how = How.XPATH, using = "//span[.='Transaction HEMP-TR-49980 - New Product 14']")
private WebElement eleclickProduct14;

public IHTC_MessagingNotification refundAlert() throws AWTException{
	
	sleep(2000);
	click(eleMessage);
	type(eleTitleSearch, "New Product 14");
	sleep(2000);
	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
	Enter.sendKeys(Keys.ENTER);
	sleep(5000);
	/*Robot robot = new Robot(); sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(5000);*/
	click(eleclickProduct14);
	sleep(5000);
	
	click(eleRefundMessage);
	verifyText("Your money will be refunded...", eleRefundMessage);
	sleep(2000);
	
	return this;
}

////////////////// After Seller Accept A Bid ////////////////////////

@FindBy (how = How.XPATH, using ="//span[.='Transaction HEMP-TR-50043 - Product 116']")
private WebElement eleSellerAcceptABid;

@FindBy (how = How.XPATH, using = "(//div[@class='form-label-control'])[3]")
private WebElement eleMessageInfo;

public IHTC_MessagingNotification sellerAcceptABidMessaging() throws AWTException {
	
	try {

	click(eleMessage);
	type(eleTitleSearch, "Product 116");
	sleep(2000);
	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
	Enter.sendKeys(Keys.ENTER);
	sleep(5000);
	/*Robot robot = new Robot(); sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(5000);*/
	click(eleSellerAcceptABid);
	sleep(5000);
	
	click(eleMessageInfo);
	sleep (2000);
	}
	
	catch(Exception e) {
		e.printStackTrace();
		reportStep("The Seller Accept A Bid Messaging Testcase: ", "FAIL");
	}
		
	
	return this;
	
}

////////////////// Buy It Now ///////////////////////////////////////

@FindBy (how = How.XPATH, using = "//span[@class='htmlWidget']/p[.=' Please remember to start the payment process. You have 120 hours left before the transaction gets canceled.']")
private WebElement eleBuyItNowMessage;

public IHTC_MessagingNotification BuyItNowMessage() throws AWTException {
	
	click(eleMessage);
	type(eleTitleSearch, "Product 116");
	sleep(2000);
	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
	Enter.sendKeys(Keys.ENTER);
	sleep(5000);
	/*Robot robot = new Robot(); sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(5000);*/
	click(eleSellerAcceptABid);
	sleep(5000);
	
	click(eleBuyItNowMessage);
	verifyText("Please remember to start the payment process. You have 120 hours left before the transaction gets canceled.", eleBuyItNowMessage);
	sleep (2000);
	
	return this;
	
}

/////////////// Make A Bid Action //////////////////////

@FindBy (how = How.XPATH, using = "//span[.='Listing Product 17']")
private WebElement elenewBid;

@FindBy (how = How.XPATH, using = "//span[@class='htmlWidget']/p['You have a new bid from company IT Product for $200']")
private WebElement eleNewBidMessage;

public IHTC_MessagingNotification makeABid() throws AWTException {
	
	click(eleMessage);
	type(eleTitleSearch, "Product 17");
	sleep(2000);
	WebElement Enter = driver.findElement(By.xpath("(.//input[@class='search-field form-control input-sm column-filter'])[1]"));
	Enter.sendKeys(Keys.ENTER);
	sleep(5000);
	/*Robot robot = new Robot(); sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	sleep(5000);*/
	click(elenewBid);
	sleep(5000);
	
	click(eleNewBidMessage);
	verifyText("You have a new bid from company IT Product for $200", eleNewBidMessage);
	sleep (2000);
	
	return this;
	
}


}
