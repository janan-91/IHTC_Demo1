package iHTC_page;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_User_Page extends ProjectMethods {
	
	public IHTC_User_Page(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}
	//Clicking create button in company admin login to create a user in home page
	@FindBy(how = How.XPATH, using="(.//span[.='Create'])[2]")
	private WebElement eleuserhome_Createbutton;
	
	public IHTC_User_Page userhome_Clickcreatebutton()
	{
		click(eleuserhome_Createbutton);
		sleep(2000);
		
		return this;
	}
	
	
	@FindBy(how = How.XPATH, using="((.//input[@class='form-control fullWidth'])[1])")
	private WebElement eleuserenter_Firstname;
	
	public IHTC_User_Page enteruser_firstname(String Firstname)
	{
		type(eleuserenter_Firstname,Firstname);
		return this;
	}
	
	@FindBy(how = How.XPATH, using="((.//input[@class='form-control fullWidth'])[2])")
	private WebElement eleuserenter_Lastname;
	
	public IHTC_User_Page enteruser_Lastname(String Lastname)
	{
		type(eleuserenter_Lastname,Lastname);
		return this;
	}
	
	@FindBy(how = How.XPATH, using="((.//input[@class='form-control fullWidth'])[3])")
	private WebElement eleuserenter_Emailid;
	
	public IHTC_User_Page enteruser_Emailid(String Emailid)
	{
		type(eleuserenter_Emailid,Emailid);
		return this;
	}
	
	@FindBy(how = How.XPATH, using="((.//input[@class='form-control fullWidth'])[4])")
	private WebElement eleuserenter_Phonenumber;
	
	public IHTC_User_Page enteruser_Phonenumber(String Phonenumber)
	{
		
		eleuserenter_Phonenumber.sendKeys(Keys.CONTROL+ "a");
		eleuserenter_Phonenumber.sendKeys(Keys.BACK_SPACE); //delete it
		sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+ Phonenumber +"';", eleuserenter_Phonenumber);
		//type(eleuserenter_Phonenumber,Phonenumber);
		return this;
	}
	
	// Click a create button in user create page to create a user in company admin
	@FindBy(how = How.XPATH, using="((.//span[.='Create'])[2])")
	private WebElement eleuserpage_Createbutton;
	
	@FindBy(how = How.XPATH, using="(.//span[@class='label label-success'])")
	private WebElement eleuser_Activestatus;
	
	
	
	public IHTC_User_Page userclick_Createbutton()
	{
		sleep(2000);
		click(eleuserpage_Createbutton);
		sleep(7000);
		try {
			
			while(true)
			{
				if(eleuser_Activestatus.isDisplayed()==true)
				{
					reportStep("The user has been created succcessfully", "PASS");
					break;
				}
			}
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There is a problem encountered while creating the user", "FAIL");
		}
		
		return this;
	}
	
	//user will be created successfully till this step
	
	//The active user will be selected from the grid and deactivate the user
	
	@FindBy(how = How.XPATH, using="((.//span[text()='Active'])[1])")
	private WebElement chrome_eleuserhome_Clickactiveuser;
	
	@FindBy(how = How.XPATH, using="((.//span[text()='Active'])[2])")
	private WebElement firefox_eleuserhome_Clickactiveuser;
	
	@FindBy(how = How.XPATH, using="((.//span[text()='Active'])[1])")
	private WebElement safari_eleuserhome_Clickactiveuser;
	
	@FindBy(how = How.XPATH, using="((.//span[text()='Active'])[2])")
	private WebElement edge_eleuserhome_Clickactiveuser;
	
	
	// when in parallel run it will automatically click different active status user
	public IHTC_User_Page chrome_click_Activeuser()
	{
		click(chrome_eleuserhome_Clickactiveuser);
		
		sleep(2000);
		return this;
	}
	
	public IHTC_User_Page firefox_click_Activeuser()
	{
		click(firefox_eleuserhome_Clickactiveuser);
		
		sleep(2000);
		return this;
	}
	
	public IHTC_User_Page safari_click_Activeuser()
	{
		click(safari_eleuserhome_Clickactiveuser);
		
		sleep(2000);
		return this;
	}
	
	public IHTC_User_Page edge_click_Activeuser()
	{
		click(edge_eleuserhome_Clickactiveuser);
		
		sleep(2000);
		return this;
	}
	
	@FindBy(how = How.XPATH, using="((.//span[text()='Actions'])[2])")
	private WebElement eleuserpage_Clickactionsbutton;
	
	public IHTC_User_Page click_Actionbutton()
	{
		click(eleuserpage_Clickactionsbutton);
		sleep(2000);
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using="((.//span[text()='Deactivate'])[2])")
	private WebElement eleuserpage_Clickdeactivateoption;
	
	public IHTC_User_Page click_Deactivateoption()
	{
		click(eleuserpage_Clickdeactivateoption);
		sleep(2000);
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using="((.//span[.='OK'])[2])")
	private WebElement eleuserpage_Clickokbutton;
	
	public IHTC_User_Page click_Okbutton()
	{
		try {
		click(eleuserpage_Clickokbutton);
		sleep(5000);
		
		if(eleuserpage_Userstatus.getText().equalsIgnoreCase("Inactive"))
		{
			sleep(3000);
			reportStep("The user has been inactivated successfully", "PASS");
		}
		}
		catch(Exception e)
		{
			reportStep("The user status is in"+" "+eleuserpage_Userstatus.getText(), "FAIL");
		}
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using="((.//div[@class='form-label-control text-left'])[6])")
	private WebElement eleuserpage_Userstatus;
	
	@FindBy(how = How.XPATH, using="((.//div[@class='form-label-control text-left'])[3])")
	private WebElement eleuserpage_getemailid;
	
	@FindBy(how = How.XPATH, using="(.//a[@class='tm-settings'])")
	private WebElement eleuserpage_hamburgericon;
	
	@FindBy(how = How.XPATH, using="(.//span[.='Logout'])")
	private WebElement eleuserpage_Logout;
	
	
	
	//After deactivating the user, in the same page the status is changed or not
	
	public IHTC_User_Page user_Statuscheckafterdeactivate()
	{
		try {
		sleep(3000);
		
		String Emailid=getText(eleuserpage_getemailid);
		System.out.println(Emailid);
		String status=getText(eleuserpage_Userstatus);
		System.out.println(status);
		//String status1="Inactive";
		
		if(status!="active")
		{
			reportStep("The user has been deactivated successfully", "PASS");
			
			sleep(2000);
			
			click(eleuserpage_hamburgericon);
			sleep(1000);
			click(eleuserpage_Logout);
			sleep(5000);
			
			userlogin_checkafterdeactivate(Emailid);
		}
		else
		{
			System.out.println(status);
		}
		}
		catch(Exception E)
		{
			E.printStackTrace();
			reportStep("The status of the user is:"+eleuserpage_Userstatus.getText(), "FAIL");
		}
		
		
		
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='email'])")
	private WebElement eleUserName;
	
	@FindBy(how = How.XPATH, using = "(.//input[@id='password'])")
	private WebElement elePassword;
	
	@FindBy(how = How.XPATH, using = "(.//div[@data-bind='button: loginSection.loginButton'])")
	private WebElement eleLogin;
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Your user is inactive. Please contact support.'])")
	private WebElement elealertfordeactivateduser;
	
	@FindBy(how = How.XPATH, using = "((.//small[@class='help-block'])[1])")
	private WebElement elealertfordeactivateduser1;
	
	
	
	

	// This method is used to check the deactivated user able to login or not
	public IHTC_User_Page userlogin_checkafterdeactivate(String Emailid)
	{
		try {
			sleep(2000);
			
		//driver.get("https://ihtc.slingrs.io/staging/runtime/login.html");
		iHTCcredentials(eleUserName, elePassword, eleLogin, Emailid, "welcome@123");
		sleep(5000);
		System.out.println(elealertfordeactivateduser1.getText());
		if(elealertfordeactivateduser1.getText().equalsIgnoreCase("Your user is inactive. Please contact support."))
		{
			reportStep("The alert message is displayed and the reason is:" +" " +elealertfordeactivateduser1.getText(), "PASS");
		}
		else {
			reportStep("The validation message is not displayed:" +" " +elealertfordeactivateduser1.getText(), "FAIL");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Due to some reason unable to login. The reason is:" +" " +elealertfordeactivateduser1.getText(), "FAIL");
		}
		
		
		return this ;
	}
	
	@FindBy(how = How.XPATH, using = "((.//span[.='Inactive'])[1])")
	private WebElement chrome_eleclickinactiveuser;
	
	@FindBy(how = How.XPATH, using = "((.//span[.='Inactive'])[2])")
	private WebElement firefox_eleclickinactiveuser;
	
	@FindBy(how = How.XPATH, using = "((.//span[.='Inactive'])[1])")
	private WebElement safari_eleclickinactiveuser;
	
	@FindBy(how = How.XPATH, using = "((.//span[.='Inactive'])[2])")
	private WebElement edge_eleclickinactiveuser;
	
	String chromecompany="";
	String firefoxcompany="";
	String safaricompany="";
	String edgecompany="";
	
	public IHTC_User_Page chrome_clickinactiveuser()
	{
		
		click(chrome_eleclickinactiveuser);
		
		return this;
		
	}
	
	public IHTC_User_Page firefox_clickinactiveuser()
	{
		
		click(firefox_eleclickinactiveuser);
		
		
		return this;
		
	}
	
	public IHTC_User_Page safari_clickinactiveuser()
	{
		
		click(safari_eleclickinactiveuser);
		
		return this;
		
	}
	
	public IHTC_User_Page edge_clickinactiveuser()
	{
		
		click(edge_eleclickinactiveuser);
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = "((.//span[.='Activate'])[2])")
	private WebElement eleuserpage_clickactivatebutton;
	
	//This method is used to activate the user
	public IHTC_User_Page user_activateuser()
	{
		try {
		waitForPageLoad(30);
		sleep(2000);
		String Emailid1=eleuserpage_getemailid.getText();
		click(eleuserpage_Clickactionsbutton);
		sleep(1000);
		click(eleuserpage_clickactivatebutton);
		sleep(3000);
		click(eleuserpage_Clickokbutton);
		sleep(5000);
		String status=eleuserpage_Userstatus.getText();
		System.out.println(status);
		sleep(2000);
		if(status.contains("Active"))
		
		{
			//System.out.println("The user status is:"+eleuserpage_Userstatus.getText());
			reportStep("The user has been activated successfully"+eleuserpage_Userstatus.getText(), "PASS");
			
			sleep(3000);
			click(eleuserpage_hamburgericon);
			sleep(1000);
			click(eleuserpage_Logout);
			sleep(3000);
			//user_activateduserlogin(Emailid1);
		}
		else
		{
			reportStep("The user status is:"+eleuserpage_Userstatus.getText(), "FAIL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to activate the user", "FAIL");
		}
	
		return this;
		
	}
	
	
	@FindBy(how = How.XPATH, using = ".//span[text()='Dashboard']")
	private WebElement eleuserpage_Dashboardmenu;
	
	
	//This method is used to check whether the activated user able to login into the application or not
	
	public IHTC_User_Page user_activateduserlogin(String emailid)
	{
		try {
				
		iHTCcredentials(eleUserName, elePassword, eleLogin, emailid, "welcome@123");
		sleep(10000);
		waitForPageLoad(60);
		
		if(eleuserpage_Dashboardmenu.isDisplayed())
		{
			System.out.println("Login success");
			reportStep("The login is success for the activated user", "PASS");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("The login is unsuccess for the user", "FAIL");
		}
		
		return this;
	}
	
	
	@FindBy(how = How.XPATH, using = "((.//span[text()='Reset password'])[2])")
	private WebElement eleuserpage_Resetpassword;
	
	public IHTC_User_Page user_clickresetpassword()
	{
		try {
				
		click(eleuserpage_Resetpassword);
		sleep(3000);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return this;
	}
	
	
	
	//Delete user in super admin
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Users'])[1]")
	private WebElement elesuperadmin_Usermenu;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='search-field form-control input-sm column-filter'])[2]")
	private WebElement elesuperadmin_Lastname;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='text-left'])[1]")
	private WebElement elesuperadmin_selectuser;
	
	@FindBy(how = How.XPATH, using = "(//span[.='Actions'])[2]")
	private WebElement elesuperadmin_Actions;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='bgm-regular'])[6]")
	private WebElement elesuperadmin_Delete;
	
	@FindBy(how = How.XPATH, using = "(.//span[.='OK'])[2]")
	private WebElement elesuperadmin_DeleteOkbutton;
	

	public IHTC_User_Page Deleteuser(String emailid,String password,String username)
	{
		try {
				
		iHTCcredentials(eleUserName, elePassword, eleLogin, emailid, password);
		sleep(3000);
		waitForPageLoad(60);
		
		sleep(3000);
		
		click(elesuperadmin_Usermenu);
		click(elesuperadmin_Lastname);
		type(elesuperadmin_Lastname, username);
		elesuperadmin_Lastname.sendKeys(Keys.ENTER);
		sleep(2000);
		click(elesuperadmin_selectuser);
		fluentwait(elesuperadmin_Actions, 30);
		click(elesuperadmin_Actions);
		sleep(1000);
		click(elesuperadmin_Delete);
		click(elesuperadmin_DeleteOkbutton);
		sleep(3000);
		
		reportStep("User deleted successfully", "PASS");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("There was a problem while deleting the user", "FAIL");
		}
		
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
					

	
	
	

