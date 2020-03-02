package iHTC_page;

import java.util.ArrayList;

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

public class IHTC_Gmailpage extends ProjectMethods {
	
	public IHTC_Gmailpage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}
	
	
	public IHTC_Gmailpage entergmailurl()
	{
		try {
			
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		sleep(3000);
		//driver.manage().deleteAllCookies();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this;
	}


	@FindBy(how = How.XPATH, using = "((.//input[@class='whsOnd zHQkBf'])[1])")
	private WebElement elegmailUserName;

	public IHTC_Gmailpage entergmailusername(String gmailusername)
	{
		sleep(3000);
		type(elegmailUserName, gmailusername);
		sleep(2000);
		
		return this;
	}

	
	@FindBy(how = How.XPATH, using = "(.//span[@class='CwaK9'])")
	private WebElement elenextButton;
	
	public IHTC_Gmailpage clicknextbutton()
	{
		sleep(2000);
		click(elenextButton);
		sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "((.//input[@class='whsOnd zHQkBf'])[1])")
	private WebElement elegmailpassword;
	
	public IHTC_Gmailpage entergmailpassword(String gmailpassword)
	{
		type(elegmailpassword, gmailpassword);
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "((.//span[@class='CwaK9'])[2])")
	private WebElement eledoneButton;
	

	/*@FindBy(how = How.XPATH, using = "((.//input[@class='gb_gf'])[1])")
	private WebElement elesearchfield;*/
	
	//@FindBy(how = How.XPATH, using = "//input[@name='q']")

	@FindBy(how = How.XPATH, using = "//div[@id='gs_lc50']/input[@aria-label='Search mail']")
    private WebElement eleSearch;
	
	public IHTC_Gmailpage searchEmail() {
		
		sleep(2000);
		eleSearch.click();
		type(eleSearch, "Slingr");
		eleSearch.sendKeys(Keys.ENTER);
		sleep(2000);
		reportStep("The Element"+eleSearch.getText()+"is clicked", "PASS", true);

		return this;
	}
	
	
/*	public IHTC_Gmailpage clickdonebutton()
	{
		try {
			sleep(2000);
			if(eledoneButton.isDisplayed())
			{
				eledoneButton.click();
				reportStep("The Element"+eledoneButton.getText()+"is clicked", "PASS");

				}
else if(elesearchfield.isDisplayed())
			{
				//eledoneButton.click();
				elesearchfield.click();
				type(elesearchfield, "Slingr");
				elesearchfield.sendKeys(Keys.ENTER);
				sleep(2000);
				reportStep("The Element"+elesearchfield.getText()+"is clicked", "PASS", true);

			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();

			sleep(1000);
			elesearchfield.click();
			//sleep(1000);
			type(elesearchfield, "Slingr");
			elesearchfield.sendKeys(Keys.ENTER);
			sleep(2000);

}

		return this;
	}
	*/
	
	
	
	@FindBy(how = How.XPATH, using = "((.//span[@name='HempTraderOnline'])[6]")
	private WebElement eleslignremail;
	
	public IHTC_Gmailpage clickslingremail()
	{
		sleep(2000);
	//	click(eleslignremail);
		
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("(.//span[@name='HempTraderOnline'])[6]"));
		actions.doubleClick(elementLocator).perform();
		
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", eleslignremail);*/
		sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='bqe' and text()='Your credentials have been changed'])[2]")
	private WebElement eleuserpage_Clickcredentialmail;
	
	public IHTC_Gmailpage clickcredentailsemail()
	{
		click(eleuserpage_Clickcredentialmail);
		sleep(3000);
		return this;
		
		}
	
	@FindBy(how = How.XPATH, using = "(.//span[contains(text(),'Welcome')])[2]")
	private WebElement eleuserpage_Clickwelcomemail;
	
	public IHTC_Gmailpage clickwelcomeemail()
	{
		click(eleuserpage_Clickwelcomemail);
		sleep(3000);
		return this;
		
		}
	
	
	
	//Inside email to click the given link to open it in a new tab for the user URL
	@FindBy(how = How.XPATH, using = "(.//div/p/a)[2]")
	private WebElement eleurlLink;
	
	public IHTC_Gmailpage clickurlLink()
	
	{
		try {
		click(eleurlLink);
		sleep(3000);
		//switch tab
		ArrayList<String> tab=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));

		sleep(5000);
		reportStep("Switched to the new tab successfully", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to switch to the new tab", "FAIL");
		}

		sleep(3000);

		return this;
	}
	
	@FindBy(how = How.XPATH, using = "((.//input[@class='form-control fullWidth'])[2])")
	private WebElement elesetpassword;
	
	@FindBy(how = How.XPATH, using = "((.//input[@class='form-control fullWidth'])[3])")
	private WebElement elesetconfirmpassword;
	
	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-primary btn-block  waves-effect waves-button'])")
	private WebElement elesetPasswordbutton;
	
	public IHTC_Gmailpage enternewpassword(String setpassword)
	{

try {
		sleep(2000);
		click(elesetpassword);
		type(elesetpassword, setpassword);
		sleep(2000);
		click(elesetconfirmpassword);
		type(elesetconfirmpassword, setpassword);
		sleep(1000);
		click(elesetPasswordbutton);
		reportStep("Setpassword successful", "PASS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There is a problem in clicking setpassword button", "FAIL");
		}
		
		return this;
		
	}

	

	
	
	

	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-primary btn-block  waves-effect waves-button'])")
	private WebElement elesetpasswordbutton;
	
	
	public IHTC_Gmailpage getredirectedportalUrl()
	{
		try {
			sleep(10000);
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		if(URL.equalsIgnoreCase("https://ihtc.slingrs.io/staging/runtime/login.html"))
		{

			reportStep("Redirected to login page is displayed", "PASS");
		}
		}catch(Exception e)
		{
			reportStep("The login page is not displayed", "FAIL");

		}
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
	private WebElement eleUserName;
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='password'])")
	private WebElement elePassword;
	
	@FindBy(how = How.XPATH, using = "(.//div[@data-bind='button: loginSection.loginButton'])")
	private WebElement eleLogin;
	
	public IHTC_Gmailpage CA_login(String Chrome_UserName, String Chrome_SetPassword) {

		waitForPageLoad(90);
		sleep(5000);

		iHTCcredentials(eleUserName, elePassword, eleLogin, Chrome_UserName, Chrome_SetPassword);
		waitForPageLoad(90);

		sleep(5000);
		return this;
	}

	
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Company'])[1]")
	private WebElement eleCompany;
	
	public IHTC_Company_Login_Page Company() {
		
		sleep(2000);
		click(eleCompany);
		return new IHTC_Company_Login_Page(driver, test);
	}
	
}
