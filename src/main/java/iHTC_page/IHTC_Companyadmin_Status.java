package iHTC_page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Companyadmin_Status extends ProjectMethods {
	
	public IHTC_Companyadmin_Status(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
		
	}
	
	String emailId;
	
	@FindBy(how=How.XPATH, using = "(.//div[@class='text-left'])[1]")
	public WebElement elecompanyname;
	
	@FindBy(how=How.XPATH, using = "(.//input[@class='search-field form-control input-sm column-filter'])[1]")
	public WebElement elecompanysearch;
	
	
	public IHTC_Companyadmin_Status clickCompany_Chrome(String Cname)
	{
		click(elecompanysearch);
		type(elecompanysearch, Cname);
		sleep(2000);
		elecompanysearch.sendKeys(Keys.ENTER);
		sleep(3000);
		click(elecompanyname);
		waitForPageLoad(20);
		return this;
	}
	
	@FindBy(how=How.XPATH, using = "(.//div[@class='text-left'])[1]")
	public WebElement elecompanyname1;
	
	public IHTC_Companyadmin_Status clickCompany_Firefox(String Cname)
	{
		click(elecompanysearch);
		type(elecompanysearch, Cname);
		sleep(2000);
		elecompanysearch.sendKeys(Keys.ENTER);
		sleep(3000);
		click(elecompanyname1);
		waitForPageLoad(20);
		
		return this;
	}
	
	@FindBy(how=How.XPATH, using = "(.//div[@class='text-left'])[1]")
	public WebElement elecompanyname2;
	
	public IHTC_Companyadmin_Status clickCompany_safari(String Cname) throws AWTException
	{
		click(elecompanysearch);
		type(elecompanysearch, Cname);
		sleep(2000);
		elecompanysearch.sendKeys(Keys.ENTER);
		/*Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER);*/
		sleep(3000);
		click(elecompanyname2);
		waitForPageLoad(20);
		return this;
	}
	
	@FindBy(how=How.XPATH, using = "(.//div[@class='text-left'])[1]")
	public WebElement elecompanyname3;
	
	public IHTC_Companyadmin_Status clickCompany_edge(String Cname)
	{
		click(elecompanysearch);
		type(elecompanysearch, Cname);
		sleep(2000);
		elecompanysearch.sendKeys(Keys.ENTER);
		sleep(3000);
		click(elecompanyname3);
		waitForPageLoad(20);
		return this;
	}
	
	@FindBy(how=How.XPATH, using = "(.//span[text()='Actions'])[2]")
	private WebElement eleActions;
	
	@FindBy(how=How.XPATH, using = "(.//ul[@class='dropdown-menu dropdown-menu-right'])[2]/li/a/span[.='Suspend']")
	private WebElement eleSuspendoption;
	@FindBy(how=How.XPATH, using = "(.//button[@class='btn btn-primary']/span[.='Documentation Expired'])")
	private WebElement eleDocumentExpired;
	@FindBy(how=How.XPATH, using = ".//div[@class='fg-line']/textarea[@class='form-control']")
	private WebElement eleEnterReason;
	@FindBy(how=How.XPATH, using = "(.//button[@class='btn btn-primary waves-effect waves-button']/span[.='OK'])[4]")
	private WebElement eleOkbutton;
	@FindBy(how=How.XPATH, using = "(.//div[@class='form-label-control text-left']/span)[3]")
	private WebElement eleCompanystatus;
	
	//To suspend a company which is in active status
	public IHTC_Companyadmin_Status Adminsuspendcompany()
	{
		
		String cname=elecompanyname.getText();
		
		try {
		waitForPageLoad(30);
		
		//System.out.println(cname);
		//click(elecompanyname);
		sleep(5000);
		
		if(eleCompanystatus.getText().equals("Active"))
		{
		//verifyText(compname, companyname);
			System.out.println(eleCompanystatus.getText());
			
			System.out.println(eleActions);
		
		click(eleActions);
		sleep(2000);
		click(eleSuspendoption);
		sleep(3000);
		if(eleEnterReason.isEnabled())
		{
		eleEnterReason.sendKeys("Testing");
		}
		sleep(5000);
		click(eleokrejectbutton);
		sleep(2000);
		System.out.println(eleCompanystatus.getText());
		reportStep("The company "+ cname + "has been suspended successfully", "PASS");
		}
		
		
			}
		
		catch(Throwable e)
		{
			e.printStackTrace();
			System.out.println(eleCompanystatus.getText());
			reportStep("The company"+ cname+ " is in " + eleCompanystatus.getText() + " status" + ". Unable to process this request" , "FAIL");
		}
		return this;
		
	}
	
	@FindBy(how=How.XPATH, using = "((.//span[.='Company'])[1])")
	public WebElement elecompanymenu;
	
	//Login as company admin which is in suspended status and check the status of the company is in suspended status or not	
	public IHTC_Companyadmin_Status getsuspendstatus(String password)
	{
		sleep(5000);
		
		String Comstatus="";
	
		try
		{
		click(eleviewmaincontact);
		sleep(3000);
		emailId= eleemailId.getText();
		emailId=emailId.replace('\u00A0', ' ').trim();
		System.out.println(emailId);
		sleep(1000);
		//Log out from admin portal
		click(eleadmin_hamburgericon);
		sleep(2000);
		click(eleadmin_Logout);
		sleep(5000);
		
		if(emailId!= null)
		{
			iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, password);
			sleep(3000);
			click(ele_CA_companymenu);
			sleep(3000);
			Comstatus=eleCompanystatus.getText();
			if(Comstatus.equalsIgnoreCase("Suspended"))
			{
				reportStep("The status of the company is in"+ " " +eleCompanystatus.getText(), "PASS");
			}
			else
			{
				reportStep("The status of the company is not in suspended status", "FAIL");
			}
			
			}
			else
			{
				reportStep("The Email Id is not available", "FAIL");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("The company status is:"+ Comstatus, "FAIL");
			
		}
		return this;
		
	}
	
	
	@FindBy(how=How.XPATH, using = "((.//ul[@class='dropdown-menu dropdown-menu-right'])[2]/li/a/span[text()='Reactivate'])")
	public WebElement Reactivateoption;
	@FindBy(how=How.XPATH, using = "((.//span[.='OK'])[4])")
	public WebElement OK;
	@FindBy(how=How.XPATH, using = "(.//span[.='Active'])")
	public WebElement Activestatus;
	@FindBy(how=How.XPATH, using = "(.//ul[@class='main-menu']/li[6])")
	public WebElement admin_companymenu;
	
	//To reactivate the company which is in suspended statusm in admin portal
	
	public IHTC_Companyadmin_Status adminreactivatecompany(String password)
	{
		
		try {
			
			//waitForPageLoad(50);
			sleep(3000);
			if(eleCompanystatus.getText().equalsIgnoreCase("Suspended"))
			{
			
			waitForPageLoad(30);
			sleep(2000);
			click(eleActions);
			sleep(1000);
			click(Reactivateoption);
			sleep(1000);
			click(OK);
					
			sleep(5000);
			
			if(eleCompanystatus.getText().equalsIgnoreCase("Active"))
			{
				reportStep("The company status is"+ eleCompanystatus.getText(),"PASS");
				sleep(2000);
				click(eleviewmaincontact);
				sleep(3000);
				emailId= eleemailId.getText();
				emailId=emailId.replace('\u00A0', ' ').trim();
				System.out.println(emailId);
				sleep(2000);
				logout();
				sleep(2000);
				iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, password);
				sleep(3000);
			
			}
			}
		
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			reportStep("Unable to process this request. The status of the company is"+eleCompanystatus.getText(), "FAIL");
			//reportStep("The company status is"+ eleCompanystatus.getText(),"FAIL");
		}
		return this;
		
	}
	
	//To check status of the company in company admin portal whether it is in active after reactivate
	
	public IHTC_Companyadmin_Status companyadmin_checkactivestatus()
	{
		String active_com_status = "";
			
		try
		{
			waitForPageLoad(30);
		//click(admin_companymenu);
			sleep(5000);
			active_com_status= eleCompanystatus.getText();
			System.out.println(active_com_status);
			sleep(2000);
			if(active_com_status.contains("Active"))
			{
				
				reportStep("The company is in " + ": " + active_com_status, "PASS");
				
				
			}
			else if(!active_com_status.contains("Active"))
			{
				reportStep("The company is in "+ ": "  + active_com_status, "FAIL");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("The company is in: "+active_com_status, "FAIL");
		}
	
	
	
		return this;
	}
	
	//Reject a company test scenario /////////
	
	//To click a company with Waiting for approval status for different browsers
	
	
	
	
	@FindBy(how=How.XPATH, using = "(.//input[@class='search-field form-control input-sm column-filter'])[4]")
	public WebElement elecompanystatussearch;		
			
	@FindBy(how=How.XPATH, using = "((.//span[@class='label label-warning' and text()='Waiting For Approval'])[2])")
	public WebElement elecompanychrome_WFAstatus;
	
	@FindBy(how=How.XPATH, using = "((.//div[@data-view='types/text/ReadOnly'])[1])")
	public WebElement eleadmincompanyname_Status;
	
	public IHTC_Companyadmin_Status clickcompany_Chrome_Waitingforapproval(String cname)
	{
		try {
			
		click(elecompanysearch);
		type(elecompanysearch, cname);
		elecompanysearch.sendKeys(Keys.ENTER);
		sleep(3000);
		click(elecompanyname);
		sleep(3000);
		if(eleActions.isDisplayed())
		{
			reportStep("The" + eleadmincompanyname_Status.getText() + "company detail page is displayed", "PASS");
			
		}
		}catch(Exception e)
		{
			reportStep("The selected company detail page is not displayed","FAIL");
		}
		return this;
	}
	
	public IHTC_Companyadmin_Status clickcompany_Firefox_Waitingforapproval(String cname)
	{
		try {
			click(elecompanysearch);
			type(elecompanysearch, cname);
			elecompanysearch.sendKeys(Keys.ENTER);	
			sleep(3000);
		click(elecompanyname1);
		sleep(2000);
		if(eleActions.isDisplayed())
		{
			reportStep("The" + eleadmincompanyname_Status.getText() + "company detail page is displayed", "PASS");
			
		}
		}catch(Exception e)
		{
			reportStep("The selected company detail page is not displayed","FAIL");
		}
		return this;
	}
	
	
	public IHTC_Companyadmin_Status clickcompany_Safari_Waitingforapproval(String cname)
	{
		try {
			click(elecompanysearch);
			type(elecompanysearch, cname);
			sleep(2000);
			elecompanysearch.sendKeys(Keys.ENTER);
			/*Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER); 
			robot.keyRelease(KeyEvent.VK_ENTER);*/
			sleep(3000);
			click(elecompanyname2);
		sleep(2000);
		if(eleActions.isDisplayed())
		{
			reportStep("The" + eleadmincompanyname_Status.getText() + "company detail page is displayed", "PASS");
			
		}
		}catch(Exception e)
		{
			reportStep("The selected company detail page is not displayed","FAIL");
		}
		return this;
	}
	
	
	public IHTC_Companyadmin_Status clickcompany_Edge_Waitingforapproval(String cname)
	{
		try {
			click(elecompanysearch);
			type(elecompanysearch, cname);
			elecompanysearch.sendKeys(Keys.ENTER);
			sleep(3000);
		click(elecompanyname3);
		sleep(2000);
		if(eleActions.isDisplayed())
		{
			reportStep("The" + eleadmincompanyname_Status.getText() + "company detail page is displayed", "PASS");
			
		}
		}catch(Exception e)
		{
			reportStep("The selected company detail page is not displayed","FAIL");
		}
		return this;
	}
	
	@FindBy(how=How.XPATH, using = "((.//li[@class='bgm-regular']/a)[8])")
	public WebElement eleRejectbutton;
	
	@FindBy(how=How.XPATH, using = "(.//textarea[@class='form-control'])")
	public WebElement eleReasontextbox;
	
	@FindBy(how=How.XPATH, using = "((.//div[@class='form-label-control text-left'])[4])")
	public WebElement eleemailId;
	
	@FindBy(how=How.XPATH, using = "(.//i[@class='zmdi zmdi-open-in-new'])")
	public WebElement eleviewmaincontact;
	
	@FindBy(how=How.XPATH, using = "(.//button[@class='btn btn-primary waves-effect waves-button']/span)[5][.='OK']")
	public WebElement eleokrejectbutton;
	
	
	
	//To reject a company with waiting for approval status
	public IHTC_Companyadmin_Status admin_RejectCompany()
	{
		sleep(3000);
		try {
			
			if(eleCompanystatus.getText().equalsIgnoreCase("Waiting For Approval"))
			{
							
				click(eleActions);
				sleep(1000);
				click(eleRejectbutton);
				sleep(1000);
				click(eleReasontextbox);
				sleep(1000);
				type(eleReasontextbox, "Documents Incorrect");
				sleep(3000);
				click(eleokrejectbutton);
				sleep(10000);
				if(eleCompanystatus.getText().equalsIgnoreCase("Rejected"))
				{
					reportStep("The company" + eleadmincompanyname_Status.getText() + " " +"has been rejected successfully", "PASS");
					
				}
				else
				{
					reportStep("The company" + eleadmincompanyname_Status.getText() + " " + "status is" + eleCompanystatus.getText()  + " " + 
							"Unable to process the reject action", "FAIL");
				}
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Due to some problem unable to reject the company. Please see the error log", "FAIL");
		}
		
		return this;
	}
	
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
	private WebElement eleUserName;
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='password'])")
	private WebElement elePassword;
	
	@FindBy(how = How.XPATH, using = "(.//div[@data-bind='button: loginSection.loginButton'])")
	private WebElement eleLogin;
	
	@FindBy(how = How.XPATH, using = ".//span[text()='Company']")
	private WebElement ele_CA_companymenu;
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-danger'])")
	private WebElement ele_CA_companystatus;
	
	@FindBy(how = How.XPATH, using=".//a[@class='tm-settings']")
	private WebElement eleadmin_hamburgericon;
	
	@FindBy(how = How.XPATH, using=".//span[.='Logout']")
	private WebElement eleadmin_Logout;
	
	//To verify the status of the Rejected company admin status in company admin portal
	
	public IHTC_Companyadmin_Status clickcompany_Chrome_Rejectedstatus(String cname)
	{
		try {
			click(elecompanysearch);
			type(elecompanysearch, cname);
			sleep(2000);
			elecompanysearch.sendKeys(Keys.ENTER);
			sleep(3000);
			click(elecompanyname);
			waitForPageLoad(20);
			sleep(3000);
		
		}catch(Exception e)
		{
			reportStep("The company detail page is not displayed","FAIL");
		}
		return this;
	}
	
	public IHTC_Companyadmin_Status clickcompany_Firefox_Rejectedstatus(String cname)
	{
		try {
			click(elecompanysearch);
			type(elecompanysearch, cname);
			sleep(2000);
			elecompanysearch.sendKeys(Keys.ENTER);
			sleep(3000);
			click(elecompanyname);
			waitForPageLoad(20);
			sleep(3000);
		}
		catch(Exception e)
		{
			reportStep("The company detail page is not displayed","FAIL");
		}
		return this;
	}
	
	
	public IHTC_Companyadmin_Status clickcompany_Safari_Rejectedstatus(String cname)
	{
		try {
			click(elecompanysearch);
			type(elecompanysearch, cname);
			sleep(2000);
			elecompanysearch.sendKeys(Keys.ENTER);
			/*Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER); 
			robot.keyRelease(KeyEvent.VK_ENTER);*/
			sleep(3000);
			click(elecompanyname);
			waitForPageLoad(20);
			sleep(3000);
		
		}catch(Exception e)
		{
			reportStep("The company detail page is not displayed","FAIL");
		}
		return this;
	}
	
	public IHTC_Companyadmin_Status clickcompany_Edge_Rejectedstatus(String cname)
	{
		try {
			click(elecompanysearch);
			type(elecompanysearch, cname);
			sleep(2000);
			elecompanysearch.sendKeys(Keys.ENTER);
			sleep(3000);
			click(elecompanyname);
			waitForPageLoad(20);
			sleep(3000);
		
		}catch(Exception e)
		{
			reportStep("The company detail page is not displayed","FAIL");
		}
		return this;
	}
	
	
			
	public IHTC_Companyadmin_Status check_CA_Status_Afterreject()
	{
		try {
			sleep(3000);
			//To view the email Id of the company admin's via main contact
			click(eleviewmaincontact);
			sleep(3000);
			emailId= eleemailId.getText().trim();
			emailId=emailId.replace('\u00A0', ' ').trim();
			System.out.println(emailId);
			sleep(1000);
			//Log out from admin portal
			click(eleadmin_hamburgericon);
			sleep(2000);
			click(eleadmin_Logout);
			sleep(5000);
			
			if(emailId!=null)
			{
				//Login as Rejected company admin
			iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, "welcome@123");
			sleep(3000);
			click(ele_CA_companymenu);
			sleep(3000);
			String CA_companystatus=ele_CA_companystatus.getText();
			if(CA_companystatus.equalsIgnoreCase("Rejected"))
			{
				reportStep("The status of the company is in Rejected status", "PASS");
			}
			else
			{
				reportStep("The status of the company is"+ele_CA_companystatus.getText(), "FAIL");
			}
			
			}
			else
			{
				reportStep("The Email Id is not available", "FAIL");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to fetch the company admin status", "FAIL");
		}
		
		
		return this;
	}
	
	@FindBy(how=How.XPATH, using = "(.//span[text()='Reactivate'])[2]")
	public WebElement eleReapprovebutton;
	
	@FindBy(how=How.XPATH, using = "(.//span[text()='Approve'])[2]")
	public WebElement eleapprovebutton;
	
	@FindBy(how=How.XPATH, using = "((.//div[@class='form-label-control text-left']/span)[3])")
	public WebElement eleActivestatus;
	
	

	//Reapprove a company with Rejected status and after approving it check the company admin status in company admin portal
	
	public IHTC_Companyadmin_Status reapproveCompanyandlogincheck()
	{
		try {
		sleep(3000);
		click(eleActions);
		sleep(1000);
		click(eleReapprovebutton);
		sleep(2000);
		click(eleOkbutton);
		sleep(3000);
		String activestatus=eleActivestatus.getText();
		System.out.println(activestatus);
		if(activestatus.equalsIgnoreCase("Active"))
		{
			reportStep("The status of the company is"+ " "+activestatus, "PASS");
		}
				
		sleep(3000);
		
		//To validate the approved company admin able to login to the portal
		click(eleviewmaincontact);
		sleep(3000);
		emailId= eleemailId.getText();
		emailId=emailId.replace('\u00A0', ' ').trim();
		System.out.println(emailId);
		sleep(1000);
		//Log out from admin portal
		click(eleadmin_hamburgericon);
		sleep(2000);
		click(eleadmin_Logout);
		sleep(5000);
		
		if(emailId!= null)
		{
			iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, "welcome@123");
			sleep(3000);
			click(ele_CA_companymenu);
			sleep(3000);
			String CA_companyactivestatus=eleActivestatus.getText();
			if(CA_companyactivestatus.equalsIgnoreCase("Active"))
			{
				reportStep("The status of the company is in"+ " " +eleActivestatus.getText(), "PASS");
			}
			else
			{
				reportStep("The status of the company is not in Active status", "FAIL");
			}
			
			}
			else
			{
				reportStep("The Email Id is not available", "FAIL");
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There is a problem while reapproving the company", "FAIL");
		}
			return this;
		
	}
	
	
	//Approve a company with Waiting for approval status and check the status of the company admin in portal
	
	
	public IHTC_Companyadmin_Status approveCompanyandlogincheck(String password)
	{
		try {
		sleep(3000);
		click(eleActions);
		sleep(2000);
		click(eleapprovebutton);
		sleep(2000);
		
		List<WebElement> verifiedbuttoncount=driver.findElements(By.xpath("(.//button[@class='btn btn-primary'])"));
		
		for(int i=1;i<=verifiedbuttoncount.size();i++)
		{
			WebElement verifiedbutton=driver.findElement(By.xpath("(.//button[@class='btn btn-primary'])["+ i +"]"));
			click(verifiedbutton);
			sleep(2000);
		}
		click(eleokrejectbutton);
		sleep(3000);
		String activestatus=eleActivestatus.getText();
		System.out.println(activestatus);
		if(activestatus.equalsIgnoreCase("Active"))
		{
			reportStep("The status of the company is"+ " "+activestatus, "PASS");
		}
				
		sleep(3000);
		
		//To validate the approved company admin able to login to the portal
		click(eleviewmaincontact);
		sleep(3000);
		emailId= eleemailId.getText();
		emailId=emailId.replace('\u00A0', ' ').trim();
		System.out.println(emailId);
		sleep(1000);
		//Log out from admin portal
		click(eleadmin_hamburgericon);
		sleep(2000);
		click(eleadmin_Logout);
		sleep(5000);
		
		if(emailId!= null)
		{
			iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, password);
			sleep(3000);
			click(ele_CA_companymenu);
			sleep(3000);
			String CA_companyactivestatus=eleActivestatus.getText();
			if(CA_companyactivestatus.equalsIgnoreCase("Active"))
			{
				reportStep("The status of the company is in"+ " " +eleActivestatus.getText(), "PASS");
			}
			else
			{
				reportStep("The status of the company is not in Active status", "FAIL");
			}
			
			}
			else
			{
				reportStep("The Email Id is not available", "FAIL");
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			
			reportStep("There is a problem while approving the company", "FAIL");
		}
		
			return this;
		
	}
	
	public IHTC_Companyadmin_Status logout()
	{
		sleep(5000);
		click(eleadmin_hamburgericon);
		sleep(2000);
		click(eleadmin_Logout);
		sleep(5000);
	
		return this;
	}
	
	
	//To get the email id of the company after rejection
	public IHTC_Companyadmin_Status getEmailId(String password)
	{
		click(eleviewmaincontact);
		sleep(3000);
		emailId= eleemailId.getText();
		emailId=emailId.replace('\u00A0', ' ').trim();
		System.out.println(emailId);
		sleep(1000);
		logout();
		iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, password);
		return this;
		
	}
	
	//To approve the company is in Waiting for approval status and get the email id of the company
	public IHTC_Companyadmin_Status approve_Message(String Upassword)
	{
		try {
			
			sleep(3000);
			click(eleActions);
			sleep(1000);
			click(eleapprovebutton);
			sleep(2000);
			
			List<WebElement> verifiedbuttoncount=driver.findElements(By.xpath("(.//button[@class='btn btn-primary'])"));
			
			for(int i=1;i<=verifiedbuttoncount.size();i++)
			{
				WebElement verifiedbutton=driver.findElement(By.xpath("(.//button[@class='btn btn-primary'])["+ i +"]"));
				click(verifiedbutton);
				sleep(2000);
			}
			click(eleokrejectbutton);
			sleep(5000);
			String activestatus=eleActivestatus.getText();
			System.out.println(activestatus);
			if(activestatus.equalsIgnoreCase("Active"))
			{
				reportStep("The status of the company is"+ " "+activestatus, "PASS");
			}
			sleep(3000);
	
	//To validate the approved company admin able to login to the portal
	click(eleviewmaincontact);
	sleep(3000);
	emailId= eleemailId.getText();
	emailId=emailId.replace('\u00A0', ' ').trim();
	System.out.println(emailId);
	sleep(1000);
	logout();
	sleep(2000);
	iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, Upassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem encountered when approving a company","FAIL");
		}
	return this;
	}
	
//Upgrade to Buyer test case
	
	@FindBy(how=How.XPATH, using = ".//span[@class='label label-default' and text()='Seller']")
	public WebElement elesellerlabel;
	
	@FindBy(how=How.XPATH, using = "(.//span[@class='bgm-regular'])[4]")
	public WebElement eleupgradetobuyer;
	
	@FindBy(how=How.XPATH, using = ".//span[@class='label label-default' and text()='Buyer']")
	public WebElement elebuyerlabel;

	public IHTC_Companyadmin_Status click_Company_seller_Chrome(String companyseller)
	{
		sleep(3000);
		click(elecompanysearch);
		sleep(1000);
		type(elecompanysearch, companyseller);
		sleep(2000);
		elecompanysearch.sendKeys(Keys.ENTER);
		sleep(4000);
		click(elecompanyname);
		
		return this;
	}
	
	public IHTC_Companyadmin_Status click_Company_seller_Firefox(String companyseller)
	{
		sleep(3000);
		click(elecompanysearch);
		sleep(1000);
		type(elecompanysearch, companyseller);
		sleep(2000);
		elecompanysearch.sendKeys(Keys.ENTER);
		sleep(4000);
		click(elecompanyname);
		
		return this;
	}
	
	public IHTC_Companyadmin_Status click_Company_seller_Safari(String companyseller) throws AWTException
	{
		sleep(3000);
		click(elecompanysearch);
		sleep(1000);
		type(elecompanysearch, companyseller);
		sleep(2000);
		try {
		elecompanysearch.sendKeys(Keys.ENTER);}
		catch(Exception e)
		{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER); 
		sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		sleep(4000);
		}
		click(elecompanyname);
		
		return this;
	}
	
	public IHTC_Companyadmin_Status click_Company_seller_Edge(String companyseller)
	{
		sleep(3000);
		click(elecompanysearch);
		sleep(1000);
		type(elecompanysearch, companyseller);
		sleep(2000);
		elecompanysearch.sendKeys(Keys.ENTER);
		sleep(4000);
		click(elecompanyname);
		
		return this;
	}
	
	public IHTC_Companyadmin_Status upgradetobuyer()
	{
		try {
		
		sleep(3000);
		
		//System.out.println(elesellerlabel.getText());
		
		if(elesellerlabel.getText().equalsIgnoreCase("Seller"))
		{
			click(eleActions);
			sleep(2000);
			click(eleupgradetobuyer);
			sleep(3000);
			click(eleupgradeokbutton);
			sleep(5000);
			
		}
		else
		{
			reportStep("The Role of the company is in"+" "+elesellerlabel.getText()+" "+"status.Unable to process this request", "FAIL");
		}
		
		//driver.navigate().refresh();
		sleep(9000);
		
		//System.out.println(elebuyerlabel.getText());
		
		if(elebuyerlabel.isDisplayed())
		{
			reportStep("The Role of the seller is changed to buyer successfully", "PASS");
			
		}
	
		}catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Upgrade to Buyer process failed! Due to some reason", "FAIL");
		}
		
		return this;
	}
	
//Upgrade to Seller test case
	

	@FindBy(how=How.XPATH, using = "(.//span[@class='bgm-regular'])[2]")
	public WebElement eleupgradetoseller;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[1]")
	public WebElement eleupgradeDOB;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[2]")
	public WebElement eleupgradeAddressline1;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[4]")
	public WebElement eleupgradeCity;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[5]")
	public WebElement eleupgradeZipcode;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[6]")
	public WebElement eleupgradeSSNdigit;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[7]")
	public WebElement eleupgradeJobtitle;
	
	@FindBy(how=How.XPATH, using = "//span[.='Owner']")
	public WebElement eleupgradeRole;
		
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[8]")
	public WebElement eleupgradecompanyURL;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[9]")
	public WebElement eleupgradeproddescription;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[10]")
	public WebElement eleupgradeaccholdername;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[11]")
	public WebElement eleupgraderoutingnumber;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[12]")
	public WebElement eleupgradeaccnumber;
	
	@FindBy(how=How.XPATH, using = "(//input[@class='form-control fullWidth'])[14]")
	public WebElement eleupgardeexpdate;
	
	@FindBy(how=How.XPATH, using = "(//input[@name='file' and @type='file'])[1]")
	public WebElement eleupgraderesellercert;
	
	@FindBy(how=How.XPATH, using = "(//span[.='OK'])[1]")
	public WebElement eleupgradeokbutton;
	
	@FindBy(how=How.XPATH, using = "(//span[@class='select2-selection select2-selection--single'])[1]")
	public WebElement eleupgradeStatedropdownclick;
	
	@FindBy(how=How.XPATH, using = "//input[@class='select2-search__field']")
	public WebElement eleupgradeStatesearch;
	
	@FindBy(how=How.XPATH, using = "//li[@class='select2-results__option select2-results__option--highlighted']")
	public WebElement eleupgradeselectstate;
	

	
	public IHTC_Companyadmin_Status statedropdownselect()
	{
		try {
		click(eleupgradeStatedropdownclick);
		sleep(2000);
		type(eleupgradeStatesearch, "Colorado");
		sleep(2000);
		click(eleupgradeselectstate);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return this;
	}
	
	public IHTC_Companyadmin_Status upgradetoseller(Map<String, String> map)
	{
		try {
			if(elebuyerlabel.getText().equalsIgnoreCase("Buyer"))
			{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		click(eleActions);
		sleep(1000);
		click(eleupgradetoseller);
		sleep(3000);
		click(eleupgradeDOB);
		eleupgradeDOB.sendKeys(Keys.CONTROL+ "a");
		eleupgradeDOB.sendKeys(Keys.BACK_SPACE); //delete it
		js.executeScript("arguments[0].value = '"+ map.get("DOB") +"';", eleupgradeDOB);
		//sleep(2000);
		type(eleupgradeAddressline1, map.get("Addressline1"));
		//sleep(1000);
		type(eleupgradeCity, map.get("City"));
		//sleep(1000);
		statedropdownselect();
		//sleep(1000);
		type(eleupgradeZipcode, map.get("Zipcode"));
		//sleep(1000);
		type(eleupgradeSSNdigit, map.get("SSN"));
		//sleep(1000);
		click(eleupgradeRole);
		//sleep(1000);
		type(eleupgradeJobtitle, map.get("Jobtitle"));
		//sleep(1000);
		type(eleupgradecompanyURL, map.get("URL"));
		//sleep(1000);
		type(eleupgradeproddescription, map.get("productdescription"));
		//sleep(1000);
		type(eleupgradeaccholdername, map.get("accountholdername"));
		//sleep(1000);
		type(eleupgraderoutingnumber, map.get("routingnumber"));
		//sleep(1000);
		type(eleupgradeaccnumber, map.get("accountnumber"));
		sleep(1000);
		scrollDownInBrowser(eleupgardeexpdate);
		sleep(1000);
		try {
		eleupgraderesellercert.sendKeys(map.get("FPATH"));}
		catch(Exception e) {e.printStackTrace();}
		sleep(1000);
		eleupgardeexpdate.click();
		eleupgardeexpdate.sendKeys(Keys.CONTROL+ "a");
		eleupgardeexpdate.sendKeys(Keys.BACK_SPACE); //delete it
		js.executeScript("arguments[0].value = '"+ map.get("resellerexpdate") +"';", eleupgardeexpdate);
		reportStep("Expiration date Entered successfully", "PASS");
		if(eleupgradeokbutton.isEnabled())
		{
		click(eleupgradeokbutton);
		sleep(2000);
		}
			}
			else
			{
				reportStep("The Role of the company is in"+" "+elesellerlabel.getText()+" "+"status.Unable to process this request", "FAIL");
			}
			
			sleep(4000);
			
			System.out.println(elesellerlabel.getText());
			
			if(elesellerlabel.isDisplayed())
			{
				reportStep("The Role of the buyer is upgraded to Seller successfully", "PASS");
				
			}
		}catch(Exception e )
		{
			e.printStackTrace();
			reportStep("Upgrade to Seller process failed! Due to some reason", "FAIL");
		}
		
		
		return this;
		
	}

	
//Upgrade to buyer message check
	

	public IHTC_Companyadmin_Status upgradetobuyer_Logout()
	{
		sleep(3000);
	
		try {
			
			click(eleviewmaincontact);
			sleep(3000);
			emailId= eleemailId.getText();
			emailId=emailId.replace('\u00A0', ' ').trim();
			System.out.println(emailId);
			sleep(1000);
			//Log out from admin portal
			click(eleadmin_hamburgericon);
			sleep(2000);
			click(eleadmin_Logout);
			sleep(5000);
			
			if(emailId!= null)
			{
				iHTCcredentials(eleUserName, elePassword, eleLogin, emailId, "welcome@123");
				sleep(3000);
				reportStep("Login is success!", "PASS");
				
			
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Login is unsuccessful", "Pass");
		}
		
		
	
	return this;
	}
	
	
	
	
//Upgrade to buyer message check
	
	
	


}
