package iHTC_page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Purchase extends ProjectMethods{
	
	public IHTC_Purchase(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy (how = How.XPATH, using = "//span[.='New Product 12']")
	private WebElement eleProductName;
	
	@FindBy (how = How.XPATH, using = "//span[@class='label label-warning']")
	private WebElement elePaymentStatus;
	
	@FindBy (how = How.XPATH, using = "//span[.='Fully Paid']")
	private WebElement eleAmountPaid;
	
	@FindBy (how = How.XPATH, using = "//span[.='$10']")
	private WebElement eleAmountPartial;
	
	public IHTC_Purchase clickProduct() {
		
		try {
			
		sleep(2000);
		click(eleProductName);
		sleep(3000);
		if(elePaymentStatus.isDisplayed()) {
			
		String text = elePaymentStatus.getText();
		System.out.println(text);
		verifyText("Partial", elePaymentStatus);
		verifyText("$10", eleAmountPartial);
		
		}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			reportStep("Payment Status is not Partial", "FAIL");
		}
		
		return this;
	}

	@FindBy (how = How.XPATH, using = ("(.//input[@class='search-field form-control input-sm column-filter'])[5]"))
	private WebElement eleSearch;
	
	public IHTC_Purchase clickSearch() throws AWTException {
		
		sleep(2000);
		click(eleSearch);
		type(eleSearch, "Payment");
		sleep(2000);
		
		Robot robot = new Robot(); sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		
		//eleSearch.sendKeys(Keys.RETURN);
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-primary'])[1]")
	private WebElement chromeListing;
	
	public IHTC_Purchase selectListingForchrome() {
		
		sleep (2000);
		click(chromeListing);
		
		partialPayment();
		sleep (5000);
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-primary'])[2]")
	private WebElement fireFoxListing;
	
	public IHTC_Purchase selectListingForFireFox() {
		
		sleep (2000);
		click(fireFoxListing);
		sleep (5000);
		partialPayment();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-primary'])[3]")
	private WebElement SafariListing;
	
	public IHTC_Purchase selectListingForSafari() {
		sleep (2000);
		click(SafariListing);
		sleep (5000);
		partialPayment();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-primary'])[4]")
	private WebElement EdgeListing;
	
	public IHTC_Purchase selectListingForEdge() {
		sleep (2000);
		click(EdgeListing);
		sleep (5000);
		partialPayment();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(.//span[.='Actions'])[2]")
	private WebElement eleAction;
	
	@FindBy (how = How.XPATH, using = "(//span[@class='bgm-regular'])[2]")
	private WebElement eleMakePayment;
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[1]")
	private WebElement eleAmountPartPay;
	
	@FindBy (how = How.XPATH, using = "(//span[.='OK'])[1]")
	private WebElement eleOkbutton;
	
	@FindBy (how = How.XPATH, using = "//span[.='$210']")
	private WebElement eleAmountPartialUpdate;
	
	@FindBy (how = How.XPATH, using = "(//div[@class='form-label-control text-left'])[9]")
	private WebElement eleAmountPaidDefault;
	
	public IHTC_Purchase partialPayment() {
		
		try {
			
			sleep(3000);
			
			click(eleAmountPaidDefault);
			String text = eleAmountPaidDefault.getText();
			System.out.println(text);
			
			sleep(2000);
			click(eleAction);
			click(eleMakePayment);
			sleep(3000);
			
			driver.findElement(By.xpath("(.//input[@class='form-control fullWidth'])[1]")).clear();
			click(eleAmountPartPay);
			sleep(5000);
			
			WebElement webl = driver.findElement(By.xpath("(.//input[@class='form-control fullWidth'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='10';", webl);
			sleep(3000);
			click(eleOkbutton);
			
			sleep(20000);
			driver.navigate().refresh();
			sleep(10000);
			scrollTillBottom();
			verifyText("$210", eleAmountPartialUpdate);
	
		}
			catch (Exception e) {
				
				e.printStackTrace();
				reportStep("Payment Status is not Partial", "FAIL");
			}
			
			return this;
		}
	
	
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-primary'])[1]")
	private WebElement ChromeListingFullPayment;
	
	public IHTC_Purchase selectListingForChromeFullPayment() {
		sleep (2000);
		click(ChromeListingFullPayment);
		sleep (5000);
		FullPayments();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-primary'])[2]")
	private WebElement FireFoxListingFullPayment;
	
	public IHTC_Purchase selectListingForFirefoxFullPayment() {
		sleep (2000);
		click(FireFoxListingFullPayment);
		sleep (5000);
		FullPayments();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-primary'])[3]")
	private WebElement SafariListingFullPayment;
	
	public IHTC_Purchase selectListingForSafariFullPayment() {
		sleep (2000);
		click(SafariListingFullPayment);
		sleep (5000);
		FullPayments();
		return this;
	}
	
	@FindBy (how = How.XPATH, using = "(//span[@class='label label-primary'])[4]")
	private WebElement EdgeListingFullPayment;
	
	public IHTC_Purchase selectListingForEdgeFullPayment() {
		sleep (2000);
		click(EdgeListingFullPayment);
		sleep (5000);
		FullPayments();
		return this;
	}

	
	public IHTC_Purchase FullPayments() {
		
		sleep(2000);
	
		click(eleAction);
		click(eleMakePayment);
		sleep(3000);
		click(eleOkbutton);
		
		sleep(10000);
		driver.navigate().refresh();
		sleep(8000);
		scrollTillBottom();
		sleep(2000);
		driver.navigate().refresh();
		sleep(10000);
		
		verifyText("Fully Paid", eleAmountPaid);
		return this;
	}
	

	
}