package iHTC_page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_Shipment extends ProjectMethods {
	
	private String listingname="";
	String liststat="";
	String liststat1="";
	
	public IHTC_Shipment(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='search-field form-control input-sm column-filter'])[5]")
	private WebElement elepaymentstatus_search;		
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-info'])[1]")
	private WebElement elepaidstatuslisting_Chrome;
	
	public IHTC_Shipment click_paidlisting_Chrome()
	{
		sleep(2000);
		click(elepaidstatuslisting_Chrome);
		reportStep("Listing is selected from Sales page","PASS");
		sleep(1000);
		reportStep("The selected Listing is:"+ " " + eleListingname.getText() + " " +"and the transaction number is" + " " + eletransactionnumber.getText(),"PASS");
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-info'])[2]")
	private WebElement elepaidstatuslisting_Firefox;
	
	public IHTC_Shipment click_paidlisting_firefox()
	{
		sleep(2000);
		click(elepaidstatuslisting_Firefox);
		reportStep("Listing is selected from Sales page","PASS");
		sleep(1000);
		reportStep("The selected Listing is:"+ " " + eleListingname.getText() + " " +"and the transaction number is" + " " + eletransactionnumber.getText(),"PASS");
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-info'])[1]")
	private WebElement elepaidstatuslisting_Safari;
	
	public IHTC_Shipment click_paidlisting_Safari()
	{
		sleep(2000);
		click(elepaidstatuslisting_Safari);
		reportStep("Listing is selected from Sales page","PASS");
		sleep(1000);
		reportStep("The selected Listing is:"+ " " + eleListingname.getText() + " " +"and the transaction number is" + " " + eletransactionnumber.getText(),"PASS");
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-info'])[2]")
	private WebElement elepaidstatuslisting_Edge;
	
	public IHTC_Shipment click_paidlisting_Edge()
	{
		click(elepaidstatuslisting_Edge);
		reportStep("Listing is selected from Sales page","PASS");
		sleep(1000);
		reportStep("The selected Listing is:"+ " " + eleListingname.getText() + " " +"and the transaction number is" + " " + eletransactionnumber.getText(),"PASS");
		
		return this;
	}
	
	//fedex paid listing select
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-info'])[1]")
	private WebElement elepaidstatuslisting_FedexChrome;
	
	public IHTC_Shipment click_paidlisting_FedexChrome()
	{
		sleep(2000);
		click(elepaidstatuslisting_FedexChrome);
		reportStep("Listing is selected from Sales page","PASS");
		sleep(1000);
		reportStep("The selected Listing is:"+ " " + eleListingname.getText() + " " +"and the transaction number is" + " " + eletransactionnumber.getText(),"PASS");
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-info'])[2]")
	private WebElement elepaidstatuslisting_Fedexfirefox;
	
	public IHTC_Shipment click_paidlisting_FedexFirefox()
	{
		sleep(2000);
		click(elepaidstatuslisting_Fedexfirefox);
		reportStep("Listing is selected from Sales page","PASS");
		sleep(1000);
		reportStep("The selected Listing is:"+ " " + eleListingname.getText() + " " +"and the transaction number is" + " " + eletransactionnumber.getText(),"PASS");
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-info'])[1]")
	private WebElement elepaidstatuslisting_Fedexsafari;
	
	public IHTC_Shipment click_paidlisting_FedexSafari()
	{
		sleep(2000);
		click(elepaidstatuslisting_Fedexsafari);
		reportStep("Listing is selected from Sales page","PASS");
		sleep(1000);
		reportStep("The selected Listing is:"+ " " + eleListingname.getText() + " " +"and the transaction number is" + " " + eletransactionnumber.getText(),"PASS");
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-info'])[2]")
	private WebElement elepaidstatuslisting_Fedexedge;
	
	public IHTC_Shipment click_paidlisting_FedexEdge()
	{
		click(elepaidstatuslisting_Fedexedge);
		reportStep("Listing is selected from Sales page","PASS");
		sleep(1000);
		reportStep("The selected Listing is:"+ " " + eleListingname.getText() + " " +"and the transaction number is" + " " + eletransactionnumber.getText(),"PASS");
		
		return this;
	}
	
	//fedex
	
	
	@FindBy(how = How.XPATH, using = "(.//div[@class='form-field-value col-sm-10'])[1]")
	private WebElement eletransactionnumber;
	
	@FindBy(how = How.XPATH, using = "(.//div[@class='form-field-value col-sm-10'])[2]")
	private WebElement eleListingname;
	
			
			
	
	public IHTC_Shipment searchlisting_Salespage() throws AWTException
	{
		sleep(2000);
		type(elepaymentstatus_search, "Paid");
		//elepaymentstatus_search.sendKeys(Keys.ENTER);
		try {
			
			elepaymentstatus_search.sendKeys(Keys.ENTER);
			sleep(3000);
			
		}catch(Exception e) {
			Robot robot = new Robot(); sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
			sleep(1000);	
			
		}
		
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Actions'])[2]")
	private WebElement eleactionbutton;
	
	@FindBy(how = How.XPATH, using = "(.//span[.='Set Up Shipment'])[2]")
	private WebElement eleSetupshipmentoption;
	
	@FindBy(how = How.XPATH, using = ".//h4[@class='modal-title' and text()='Set up shipment']")
	private WebElement eleSetupshipmentpage;
	
	
	
	public IHTC_Shipment click_action_shipment()
	{
		sleep(3000);
		try {
		click(eleactionbutton);
		
		sleep(2000);
		click(eleSetupshipmentoption);
		try {
			sleep(7000);
		if(eleSetupshipmentpage.isDisplayed())
		{
			reportStep("Setupshipment page is displayed","PASS");
		}
		}catch(Exception e){
			e.printStackTrace();
			reportStep("Setupshipment page is not displayed","FAIL");
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return this;
	}
	
	
	
			
	@FindBy(how = How.XPATH, using = "(.//span[@class='label label-default relationship-label-pointer'])[1]")
	private WebElement elelistingname;		
	
	@FindBy(how = How.XPATH, using = "(.//span[@class='select2-selection__arrow'])[1]")
	private WebElement elecarrierdropdown;
	
	@FindBy(how = How.XPATH, using = ".//ul[@class='select2-results__options']/li[1]")
	private WebElement elecarrierselect;
	
	@FindBy(how = How.XPATH, using = ".//ul[@class='select2-results__options']/li[2]")
	private WebElement elecarrierselect1;

	@FindBy(how = How.XPATH, using = "(.//span[@class='select2-selection__arrow'])[2]")
	private WebElement eleservicedropdown;
	
	@FindBy(how = How.XPATH, using = ".//ul[@class='select2-results__options']/li[2]")
	private WebElement eleserviceselect;
	
	@FindBy(how = How.XPATH, using = ".//ul[@class='select2-results__options']/li[9]")
	private WebElement eleserviceselect1;
	
	//selecting the values from carrier and services drop down
	public IHTC_Shipment click_Carriernservice_dropdown()
	{
		sleep(3000);
		
		try {
			
		listingname=elelistingname.getText();	
			
		scrollDownInBrowser(elecarrierdropdown);
		
		sleep(2000);
		
		click(elecarrierdropdown);
		sleep(1000);
		click(elecarrierselect);
		sleep(3000);
		click(eleservicedropdown);
		reportStep("Service dropdown has been clicked","PASS");
		sleep(1000);
		String ser=eleserviceselect.getText();
		click(eleserviceselect);
		reportStep("Service has been selected"+ser,"PASS");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to select the dropdown values", "FAIL");
		}
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = ".//ul[@class='select2-results__options']/li")
	private WebElement eleserviceselect2;
	
	public IHTC_Shipment click_Service_Fedexdropdown()
	{
		List<WebElement> drpdwn=driver.findElements(By.xpath(".//ul[@class='select2-results__options']/li"));
		
		System.out.println(drpdwn.size());
		
		for(int i=1;i<=drpdwn.size();i++)
		{
			if(drpdwn.get(i).getText().equalsIgnoreCase("FedEx First Overnight®"))
			{
				click(drpdwn.get(i));
				break;
			}
		}
		
		return this;
	}
	
	public IHTC_Shipment click_Carriernservice1_dropdown()
	{
		sleep(3000);
		
		try {
			
		listingname=elelistingname.getText();	
			
		scrollDownInBrowser(elecarrierdropdown);
		
		sleep(2000);
		
		click(elecarrierdropdown);
		sleep(1000);
		click(elecarrierselect1);
		sleep(3000);
		click(eleservicedropdown);
		reportStep("Service dropdown has been clicked","PASS");
		sleep(1000);
		String ser=eleserviceselect.getText();
		//click(eleserviceselect1);
		click_Service_Fedexdropdown();
		sleep(5000);
		reportStep("Service has been selected"+ser,"PASS");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to select the dropdown values", "FAIL");
		}
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = ".//span[.='Add']")
	private WebElement elepackageaddbutton;
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[1]")
	private WebElement eleweighttextbox;
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[2]")
	private WebElement elelengthtextbox;
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[3]")
	private WebElement elewidthtextbox;
	
	@FindBy(how = How.XPATH, using = "(.//input[@class='form-control fullWidth'])[4]")
	private WebElement eleheighttextbox;
	
	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-primary waves-effect waves-button']/span[.='OK'])[1]")
	private WebElement eleokbutton;
	
	@FindBy(how = How.XPATH, using = "(.//button[@class='btn btn-primary waves-effect waves-button']/span[.='OK'])[3]")
	private WebElement eleokbutton1;
	
	@FindBy(how = How.XPATH, using = "(.//div[@class='form-label-control']/span)[6]")
	private WebElement elerate;
	
	@FindBy(how = How.XPATH, using = ".//span[.='Label PDF']")
	private WebElement elelabelpdf;
	
	@FindBy(how = How.XPATH, using = ".//h4[@class='modal-title' and text()='Print label']")
	private WebElement eleprintlabelmodal;
	
	@FindBy(how = How.XPATH, using = ".//label[@class='control-label col-sm-2']/span[.='Packages']")
	private WebElement elepackagelabel;
	
	
	
	
	// Enter the package details and create a label
	public IHTC_Shipment add_shipment()
	{
		sleep(3000);
		
		try {
			
			click(elepackageaddbutton);
			sleep(2000);
			type(eleweighttextbox, "20");
			sleep(1000);
			type(elelengthtextbox, "10");
			sleep(1000);
			type(elewidthtextbox, "10");
			sleep(1000);
			type(eleheighttextbox, "10");
			sleep(1000);
			scrollDownInBrowser(elepackageaddbutton);
			reportStep("package added successfully","PASS");
			sleep(7000);
			reportStep("The rate is:"+elerate.getText(), "PASS");
			click(eleokbutton);
 			
			fluentwait(eleprintlabelmodal, 60);
			
			if(eleprintlabelmodal.isDisplayed())
			{
				System.out.println("Print label screen is displayed");
				sleep(3000);
				click(eleokbutton1);
				
				reportStep("OK button is clicked in Print Label modal pop up", "PASS");
			}
		
			sleep(10000);
			
			scrollDownInBrowser(elepackagelabel);
			
			fluentwait(elelabelpdf, 60);
			
			if(elelabelpdf.isDisplayed())
			{
				reportStep("Label has been created for the listing", "PASS");
				reportStep("Waiting for next action....", "PASS");
			}
			
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
			
			reportStep("There was a problem encountered while setup the shipment!","FAIL");
		}
		
		return this;
		
	}
	
	@FindBy(how = How.XPATH, using = ".//span[@class='label label-info']")
	private WebElement elestatus_Listing;
	
	@FindBy(how=How.XPATH, using = "((.//span[text()='Sales'])[1])")
	public WebElement elesalesmenu;
	
	@FindBy(how=How.XPATH, using = "(.//input[@class='search-field form-control input-sm column-filter'])[2]")
	public WebElement elesearchlisting;
	
	@FindBy(how=How.XPATH, using = "(.//span[@class='label label-success'])[1]")
	public WebElement eleliststatus;
	

	// Get status from the listing detail page and sales page about the listing
	public IHTC_Shipment getstatus_Aftershipment()
	{
		
		try {
			reportStep("Waiting for next action...", "PASS");
			sleep(50000);
			reportStep("Waiting for page to refresh..", "PASS");
			driver.navigate().refresh();
			sleep(8000);
			
			System.out.println(elestatus_Listing.getText());

		if(elestatus_Listing.getText().equalsIgnoreCase("Sent")			
				||elestatus_Listing.getText().equalsIgnoreCase("PAID") )
		{
				
				
					click(elesalesmenu);
					reportStep("Waiting for next action..", "PASS");
					sleep(70000);
					reportStep("Waiting for page to refresh..", "PASS");
					driver.navigate().refresh();
					sleep(8000);
					click(elesearchlisting);
					type(elesearchlisting, listingname);
					try {
						elesearchlisting.sendKeys(Keys.ENTER);
					}catch(Exception  e)
					{
						e.printStackTrace();
					Robot robot = new Robot(); sleep(2000);
					robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
					sleep(2000);
					}
					try {
					liststat1=elestatus_Listing.getText();
					}catch(Exception e) {e.printStackTrace();}
					
					try {
					liststat=eleliststatus.getText();
					}catch(Exception f) {f.printStackTrace();}
					
					System.out.println(liststat);
					System.out.println(liststat1);
					
					if(liststat.equalsIgnoreCase("Delivered"))
					{
						reportStep("The listing has been shipped successfully"+liststat, "PASS");
					}
					else if(liststat1.equalsIgnoreCase("Sent"))
					{
						reportStep("The listing has been shipped successfully"+liststat1, "PASS");
					}
						
		}
			
		else
		{
			reportStep("The status of the listing is in:"+ " "+elestatus_Listing.getText(), "FAIL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to fetch the status of the listing", "FAIL");
		}
		
		return this;
	}
	
	
	
	@FindBy(how=How.XPATH, using = ".//span[.='Messages']")
	public WebElement eleMessagemenu;
	
	@FindBy(how=How.XPATH, using = "(.//input[@class='search-field form-control input-sm column-filter'])[1]")
	public WebElement eletitlesearchfield;
	
	@FindBy(how=How.XPATH, using = "(.//span[contains(text(),'Transaction')])[1]")
	public WebElement eletransactionmessage;
	
	@FindBy(how=How.XPATH, using = "//span[contains(text(),'The package has been shipped')]")
	public WebElement eleshippedmessage;
	
	@FindBy(how=How.XPATH, using = ".//span[@class='htmlWidget']/p[contains(text(),'The package has been delivered to the buyer!')]")
	public WebElement eledeliveredmessage;
	
	public IHTC_Shipment checkmessage_Packagestatus() throws AWTException
	{
		try {
			Robot robot = new Robot();
			
			driver.navigate().refresh();
			sleep(10000);
			driver.navigate().refresh();
			sleep(3000);
			
			click(elesalesmenu);
			sleep(5000);
			click(elesearchlisting);
			type(elesearchlisting, listingname);
			sleep(2000);
			try {
				elesearchlisting.sendKeys(Keys.ENTER);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
				sleep(2000);
			}
			
			try {
				liststat1=elestatus_Listing.getText();
				}catch(Exception e) {e.printStackTrace();}
				
				try {
				liststat=eleliststatus.getText();
				}catch(Exception e) {e.printStackTrace();}
				
				System.out.println(liststat);
				System.out.println(liststat1);
				
				if(liststat.equalsIgnoreCase("Delivered"))
				{
					sleep(5000);
					click(eleMessagemenu);
					sleep(5000);
					click(eletitlesearchfield);
					type(eletitlesearchfield, listingname);
					sleep(2000);
					try {
						eletitlesearchfield.sendKeys(Keys.ENTER);
					}
					catch(Exception e)
					{
					robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
					sleep(2000);
					}
					click(eletransactionmessage);
					sleep(3000);
					//scrollDownInBrowser(eledeliveredmessage);
					
					if(eledeliveredmessage.isDisplayed())
					{
						reportStep("The message is displayed"+ " "+ eledeliveredmessage.getText(), "PASS");
					}
					
					/*scrollDownInBrowser(eleshippedmessage);
					
					if(eleshippedmessage.isDisplayed())
					{
						reportStep("The message is displayed"+ " "+ eleshippedmessage.getText(), "PASS");
						
					}*/
				}
				else if(liststat1.equalsIgnoreCase("Sent"))
				{
					sleep(5000);
					click(eleMessagemenu);
					sleep(5000);
					click(eletitlesearchfield);
					type(eletitlesearchfield, listingname);
					sleep(2000);
					try {
						eletitlesearchfield.sendKeys(Keys.ENTER);
						
					}catch(Exception e)
					{
					robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
					sleep(2000);
					}
					click(eletransactionmessage);
					sleep(3000);
					scrollDownInBrowser(eleshippedmessage);
					
					if(eleshippedmessage.isDisplayed())
					{
						reportStep("The message is displayed"+ " "+ eleshippedmessage.getText(), "PASS");
					}
					
					
				}	
	}
		catch(Exception e)
		{
			e.printStackTrace();
			reportStep("Unable to find the message for package shipped", "FAIL");
		}
		
	return this;
	}

	//Messaging_shipping instructions
	

	String paidlistingname_Chrome="";
	String paidlistingname_Firefox="";
	String paidlistingname_Edge="";
	String paidlistingname_Safari="";
	
	@FindBy(how=How.XPATH, using = ".//tbody[@data-bind='visible: !$loadingContent()']/tr[1]/td[3]/div/div/div/div/div/span")
	public WebElement eleselectpaidlistingname_Chrome;
	
	public IHTC_Shipment click_Shippinginstruct_Paidchrome()
	{
		sleep(3000);
		type(elepaymentstatus_search, "Paid");
		elepaymentstatus_search.sendKeys(Keys.ENTER);
		sleep(1000);
		paidlistingname_Chrome=eleselectpaidlistingname_Chrome.getText();
		System.out.println(paidlistingname_Chrome);
		checkmessage_Shippinginstructions(paidlistingname_Chrome);
		
		return this;
	}
	
	@FindBy(how=How.XPATH, using = ".//tbody[@data-bind='visible: !$loadingContent()']/tr[2]/td[3]/div/div/div/div/div/span")
	public WebElement eleselectpaidlistingname_Firefox;
	
	public IHTC_Shipment click_Shippinginstruct_Paidfirefox()
	{
		
		sleep(3000);
		type(elepaymentstatus_search, "Paid");
		elepaymentstatus_search.sendKeys(Keys.ENTER);
		sleep(1000);
		paidlistingname_Firefox=eleselectpaidlistingname_Firefox.getText();
		System.out.println(paidlistingname_Firefox);
		checkmessage_Shippinginstructions(paidlistingname_Firefox);
		
		return this;
	}
	
	@FindBy(how=How.XPATH, using = ".//tbody[@data-bind='visible: !$loadingContent()']/tr[1]/td[3]/div/div/div/div/div/span")
	public WebElement eleselectpaidlistingname_Safari;
	
	public IHTC_Shipment click_Shippinginstruct_Paidsafari() throws AWTException
	{
		
		sleep(3000);
		type(elepaymentstatus_search, "Paid");
		Robot robot = new Robot(); sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		sleep(1000);
		paidlistingname_Safari=eleselectpaidlistingname_Safari.getText();
		System.out.println(paidlistingname_Safari);
		checkmessage_Shippinginstructions(paidlistingname_Safari);
		
		return this;
	}
	
	@FindBy(how=How.XPATH, using = ".//tbody[@data-bind='visible: !$loadingContent()']/tr[3]/td[3]/div/div/div/div/div/span")
	public WebElement eleselectpaidlistingname_Edge;
	
	public IHTC_Shipment click_Shippinginstruct_Paidedge()
	{
		
		sleep(3000);
		type(elepaymentstatus_search, "Paid");
		elepaymentstatus_search.sendKeys(Keys.ENTER);
		sleep(1000);
		paidlistingname_Edge=eleselectpaidlistingname_Edge.getText();
		System.out.println(paidlistingname_Edge);
		checkmessage_Shippinginstructions(paidlistingname_Edge);
		
		return this;
	}
	
	
	
	
	@FindBy(how=How.XPATH, using = "(.//span[@class='htmlWidget']/p[contains(text(),'Please remember to start the shipping process')])[1]")
	public WebElement eleshippinginstruction_Message;

	public IHTC_Shipment checkmessage_Shippinginstructions(String paidlisting)
	{
		sleep(3000);
		
		try {
			
			System.out.println(paidlisting);
			click(eleMessagemenu);
			sleep(3000);
			click(eletitlesearchfield);
			sleep(1000);
			type(eletitlesearchfield, paidlisting);
			sleep(1000);
			try {
			eletitlesearchfield.sendKeys(Keys.ENTER);
			}catch(Exception e)
			{
				Robot robot = new Robot(); sleep(2000);
				robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
				sleep(1000);
		}
			sleep(3000);
			click(eletransactionmessage);
			sleep(5000);
			if(eleshippinginstruction_Message.isDisplayed())
			{
			
				reportStep("The message is dispayed for the shipping instructions:"+""+eleshippinginstruction_Message.getText(), "PASS");
			}
			
			sleep(5000);
			
		}
		catch(Exception e)
		{
			reportStep("Unable to fetch the message for shipping instructions", "FAIL");
			
		}
		
		
		return this;
	}
	
	//Messaging_shipping instructions
	
	
	
	
	
	
	
	
	
	
	
	
}
