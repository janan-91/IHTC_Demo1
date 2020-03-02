package iHTC_page;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.varia.ReloadingPropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ReportStatusStats;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Messaging extends ProjectMethods {
	
	public IHTC_Messaging(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="(.//span[.='Messages'])")
	private WebElement elemesssagemenu;
	
	@FindBy(how = How.XPATH, using="(.//span[contains(text(),'Suspension of company')])[1]")
	private WebElement elesuspendupdatestatus;

	public IHTC_Messaging click_Messagemenu_suspend()
	{
		try {
			sleep(5000);
		click(elemesssagemenu);
		sleep(5000);
		//driver.navigate().refresh();
		//sleep(5000);
		if(elesuspendupdatestatus.isDisplayed())
		{
			click(elesuspendupdatestatus);
			sleep(5000);
			reportStep("The notification for suspension has been received from admin", "PASS");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("The notification is not received","FAIL");
		}
		
		return this;
		
	}
	
	
	@FindBy(how = How.XPATH, using="(.//span[contains(text(),'Reactivation of company')])[1]")
	private WebElement elereactivatestatus;
	
	@FindBy(how = How.XPATH, using=".//span[@class='htmlWidget']/p[1][contains(text(),' has been reactivated')]")
	private WebElement elereactivatedmessage1;
	
	public IHTC_Messaging click_Messagemenu_Reactivate()
	{
		try {
			sleep(5000);
		click(elemesssagemenu);
		sleep(5000);
		//driver.navigate().refresh();
		//sleep(5000);
		if(elereactivatestatus.isDisplayed())
		{
			reportStep("The notification for reactivation has been received from admin", "PASS");
			click(elereactivatestatus);
			sleep(5000);
			if(elereactivatedmessage1.isDisplayed())
			{
				reportStep("Company reactivated message is displayed", "PASS");
				
			}
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("The notification is not received","FAIL");
		}
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using="(.//span[contains(text(),'Sign-up request for company')])[1]")
	private WebElement elerejectednotification;
	
	@FindBy(how = How.XPATH, using=".//span[@class='htmlWidget']/p[1][contains(text(),'rejected')]")
	private WebElement elerejectedmessage;
	
	
	
	public IHTC_Messaging click_Messagemenu_Rejected()
	{
		try {
			sleep(5000);
		click(elemesssagemenu);
		sleep(5000);
		//driver.navigate().refresh();
		//sleep(5000);
		if(elerejectednotification.isDisplayed())
		{
			reportStep("The notification for reactivation has been received from admin", "PASS");
			sleep(3000);
			click(elerejectednotification);
			scrollDownInBrowser(elerejectedmessage);
			if(elerejectedmessage.isDisplayed())
			{
				
				reportStep("The Rejection message is displayed", "PASS");
			}
			sleep(5000);
			
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("The notification is not received","FAIL");
		}
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using="(.//span[contains(text(),'Sign-up request for company')])[1]")
	private WebElement eleapprovenotification;
	
	@FindBy(how = How.XPATH, using=".//span[@class='htmlWidget']/p[1][contains(text(),' has been approved')]")
	private WebElement eleapprovedmessage;
	
	public IHTC_Messaging click_Messagemenu_approve()
	{
		try {
			sleep(5000);
		click(elemesssagemenu);
		sleep(3000);
		//driver.navigate().refresh();
		//sleep(5000);
		if(eleapprovenotification.isDisplayed())
		{
			reportStep("The notification for reactivation has been received from admin", "PASS");
			sleep(3000);
			click(eleapprovenotification);
			sleep(3000);
			scrollDownInBrowser(eleapprovedmessage);
			if(eleapprovedmessage.isDisplayed())
			{
				
				reportStep("Company approved message is displayed", "PASS");
			}
			//sleep(5000);
			
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("The notification is not received","FAIL");
		}
		
		return this;
		
	}
		
	@FindBy(how = How.XPATH, using="(.//input[@class='search-field form-control input-sm column-filter'])[4]")
	private WebElement elesearchcomstatus;

	public IHTC_Messaging searchcompany_Waitingforapproval()
	{
		
		try {
			
		sleep(3000);
		type(elesearchcomstatus, "Waiting For Approval");
		sleep(1000);
		elesearchcomstatus.sendKeys(Keys.ENTER);
		sleep(3000);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return this;
	}
	
	public IHTC_Messaging searchcompany_Safari_Waitingforapproval()
	{
		
		try {
			
		sleep(3000);
		type(elesearchcomstatus, "Waiting For Approval");
		sleep(2000);
		elesearchcomstatus.sendKeys(Keys.ENTER);
		/*Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER);*/
		sleep(3000);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return this;
	}
	
	public IHTC_Messaging searchcompany_Waitingfordocument()
	{
		
		try {
			
		sleep(2000);
		click(elesearchcomstatus);
		type(elesearchcomstatus, "Waiting For Document");
		sleep(2000);
		elesearchcomstatus.sendKeys(Keys.ENTER);
		sleep(2000);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return this;
	}
	
	public IHTC_Messaging searchcompany_Safari_Waitingfordocument()
	{
		
		try {
			
		sleep(2000);
		click(elesearchcomstatus);
		type(elesearchcomstatus, "Waiting For Document");
		sleep(2000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER);
		sleep(3000);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return this;
	}
	
	
	
	@FindBy(how = How.XPATH, using="(.//span[@class='label label-warning'])[1]")
	private WebElement eleclickcompany_Chrome;
	
	@FindBy(how = How.XPATH, using="(.//span[@data-bind='html: getValue()'])[1]")
	private WebElement elegetcompanyname_Chrome;
	
	@FindBy(how = How.XPATH, using="(.//i[@class='zmdi zmdi-open-in-new'])")
	private WebElement elemaincontact;
	
	
	public IHTC_Messaging click_Company_Chrome()
	{
		sleep(2000);
		click(eleclickcompany_Chrome);
		reportStep("Company is selected"+elegetcompanyname_Chrome.getText(),"PASS");
		sleep(2000);
		click(elemaincontact);
		sleep(3000);
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using="(.//span[@class='label label-warning'])[1]")
	private WebElement eleclickcompany_Firefox;
	
	@FindBy(how = How.XPATH, using="(.//span[@data-bind='html: getValue()'])[1]")
	private WebElement elegetcompanyname_Firefox;
	
	public IHTC_Messaging click_Company_firefox()
	{
		sleep(2000);
		click(eleclickcompany_Firefox);
		reportStep("Company is selected"+elegetcompanyname_Firefox.getText(),"PASS");
		sleep(3000);
		click(elemaincontact);
		sleep(3000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using="(.//span[@class='label label-warning'])[1]")
	private WebElement eleclickcompany_Safari;
	
	@FindBy(how = How.XPATH, using="(.//span[@data-bind='html: getValue()'])[1]")
	private WebElement elegetcompanyname_Safari;
	
	public IHTC_Messaging click_Company_Safari()
	{
		sleep(2000);
		click(eleclickcompany_Safari);
		reportStep("Company is selected"+elegetcompanyname_Safari.getText(),"PASS");
		sleep(1000);
		click(elemaincontact);
		sleep(3000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using="(.//span[@class='label label-warning'])[1]")
	private WebElement eleclickcompany_Edge;
	
	@FindBy(how = How.XPATH, using="(.//span[@data-bind='html: getValue()'])[1]")
	private WebElement elegetcompanyname_Edge;
	
	public IHTC_Messaging click_Company_Edge()
	{
		sleep(2000);
		click(eleclickcompany_Edge);
		reportStep("Company is selected"+elegetcompanyname_Edge.getText(),"PASS");
		sleep(1000);
		click(elemaincontact);
		sleep(3000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using="(.//div[@class='form-label-control text-left'])[4]/a")
	private WebElement elegetEmailId;
	
	@FindBy(how = How.XPATH, using=".//a[@class='tm-settings']")
	private WebElement eleadmin_hamburgericon;
	
	@FindBy(how = How.XPATH, using=".//span[.='Logout']")
	private WebElement eleadmin_Logout;
	
	
	private String emailId="";
	
	public IHTC_Messaging getemailId()
	{
		sleep(3000);
		
		try {
			emailId=elegetEmailId.getText();
			System.out.println(emailId);
			sleep(5000);
			click(eleadmin_hamburgericon);
			sleep(2000);
			click(eleadmin_Logout);
			sleep(5000);
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
	private WebElement eleUserName;
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='password'])")
	private WebElement elePassword;
	
	@FindBy(how = How.XPATH, using = "(.//div[@data-bind='button: loginSection.loginButton'])")
	private WebElement eleLogin;

	@FindBy(how = How.XPATH, using = ".//span[@data-bind='html: getValue()']")
	private WebElement elesignuptitle;
	
	@FindBy(how = How.XPATH, using = ".//span[@class='htmlWidget']")
	private WebElement eledocumentreceivedmessage;
	

	public IHTC_Messaging doucments_Receivedcheck(String password)
	{
		sleep(3000);
		try
		{
		
		iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, password);
		sleep(5000);
		click(elemesssagemenu);
		sleep(2000);
		System.out.println(elesignuptitle.getText());
		if(elesignuptitle.getText().contains("Sign-up request for company"))
		{
			reportStep("Signup request is displayed for the company", "PASS");
			click(elesignuptitle);
			sleep(3000);
			if(eledocumentreceivedmessage.getText().contains("We received all the documentation for your company"))
			{
				reportStep("The message is displayed as "+" "+eledocumentreceivedmessage.getText(), "PASS");
			}
			else
			{
				reportStep("The message is not displayed", "FAIL");
			}
		}
		else
		{
			reportStep("The message for signup request for the company is not present", "FAIL");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem while fetching the message details", "FAIL");
		}
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = ".//span[@class='htmlWidget']")
	private WebElement eledocumentpendingmessage;
	
	
	public IHTC_Messaging documents_Pendingcheck(String password)
	{
		
		sleep(3000);
		try
		{
		
		iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, password);
		sleep(5000);
		click(elemesssagemenu);
		sleep(2000);
		System.out.println(elesignuptitle.getText());
		if(elesignuptitle.getText().contains("Sign-up request for company"))
		{
			reportStep("Signup request is displayed for the company", "PASS");
			click(elesignuptitle);
			sleep(3000);
			if(eledocumentpendingmessage.getText().contains(" because your documentation is incomplete"))
			{
				reportStep("The message is displayed as "+" "+eledocumentpendingmessage.getText(), "PASS");
			}
			else
			{
				reportStep("The message is not displayed", "FAIL");
			}
		}
		else
		{
			reportStep("The message for signup request for the company is not present", "FAIL");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem while fetching the message details", "FAIL");
		}
		return this;
		
	}

	
	@FindBy(how = How.XPATH, using = ".//span[@data-bind='html: getValue()' and contains(text(),'Upgrade request for company')]")
	private WebElement eleupgraderequest;
	
	@FindBy(how = How.XPATH, using = ".//span[@data-bind='html: $htmlValue']/p[contains(text(),'We have received your petition to become a buyer')]")
	private WebElement eleupgradetobuyer_Message;
	
	public IHTC_Messaging Upgradetobuyer_Messagecheck()
	{
		sleep(4000);
		try {
			
			click(elemesssagemenu);
			sleep(3000);
			if(eleupgraderequest.isDisplayed())
			{
				click(eleupgraderequest);
				
				sleep(3000);
				
				if(eleupgradetobuyer_Message.isDisplayed())
				{
					reportStep("The message is displayed as:"+" "+eleupgradetobuyer_Message.getText(), "PASS");
				}
				
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem encountered while getting the message", "FAIL");
			
		}
		return this;
	}
	
	@FindBy(how=How.XPATH, using = "((.//div[@class='form-label-control text-left'])[4])")
	public WebElement eleemailId;
	
	@FindBy(how=How.XPATH, using = "(.//i[@class='zmdi zmdi-open-in-new'])")
	public WebElement eleviewmaincontact;
	
	@FindBy(how = How.XPATH, using = ".//span[@data-bind='html: $htmlValue']/p[contains(text(),'We have received your petition to become a seller')]")
	private WebElement eleupgradetoseller_Message;
	
	public IHTC_Messaging Upgradetoseller_Messagecheck()
	{
		sleep(4000);
		try {
			
			/*click(eleviewmaincontact);
			sleep(3000);
			emailId= eleemailId.getText();
			System.out.println(emailId);
			sleep(1000);
			click(eleadmin_hamburgericon);
			sleep(2000);
			click(eleadmin_Logout);
			sleep(3000);
			iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, Upassword);
			sleep(5000);*/
			click(elemesssagemenu);
			sleep(2000);
			System.out.println(elesignuptitle.getText());
			
			click(elemesssagemenu);
			sleep(3000);
			if(eleupgraderequest.isDisplayed())
			{
				click(eleupgraderequest);
				
				sleep(3000);
				
				if(eleupgradetoseller_Message.isDisplayed())
				{
					reportStep("The message is displayed as:"+" "+eleupgradetoseller_Message.getText(), "PASS");
				}
				
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem encountered while getting the message", "FAIL");
			
		}
		return this;
	}
	
	


		
}
