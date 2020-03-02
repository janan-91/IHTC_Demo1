package IHTC_wdMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.net.MalformedURLException;
import java.net.URL;
//import java.security.DrbgParameters.Capability;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.base.Function;

import IHTC_Reports.Reporter;
//import iHTC_page.JSONObject;

public class Selenium_Methods1 extends Reporter implements IHTC_Interface {

	public String URL;
	public DesiredCapabilities dc;
	public RemoteWebDriver driver;
	public String client;
	public String result;
	public String jobId;
	private Logger log = Logger.getLogger(this.getClass().getName());
	public String iHTCUserName, iHTCPassword, sHubUrl, sHubPort, name, USERNAME, ACCESS_KEY, iHTCUrl;

	public Selenium_Methods1() {

		Properties prop = new Properties();

		try {

			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));

 			name = prop.getProperty("NAME");
			//iHTCUrl = prop.getProperty("URL");
			USERNAME = prop.getProperty("USERNAME");
			ACCESS_KEY = prop.getProperty("ACCESS_KEY");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private DesiredCapabilities getBrowser(String browser) {
		DesiredCapabilities dc = new DesiredCapabilities();
		String version = "";
		switch (browser) {
		case "chrome":
			version = "77.0";
			dc = DesiredCapabilities.chrome();
			break;

		case "Firefox":
			version = "69.0";
			dc = DesiredCapabilities.firefox();
			break;

		case "Edge":
			//version = "18.17763";
			version= "17.17134";
			dc = DesiredCapabilities.edge();
			break;

		case "InternetExplorer":
			version = "11.285";
			dc = DesiredCapabilities.internetExplorer();
			break;

		case "Safari":
			//version = "11.1";
			version = "12.1";
			dc = DesiredCapabilities.safari();
			break;
		}
		dc.setCapability("version", version);
		return dc;
	}

	private String getPlatform(String platform) {
		return platform.equalsIgnoreCase("Win10") ? "Windows 10" : "macOS 10.13";
	}


	public void startApp(String browser, String platform, String applicationUrl, String tcname) throws MalformedURLException {

		URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		
		System.out.println(URL);

		System.out.println("_______Sauce Login Owned By_______:"+USERNAME);

		try {
			
			
			DesiredCapabilities dc = getBrowser(browser);
			log.warning(tcname);
			dc.setCapability("platform", getPlatform(platform));
			System.out.println(browser);
			System.out.println(getPlatform(platform));
			dc.setCapability("screenResolution", "1280x960");
			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			dc.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			dc.setCapability("avoidProxy", true);
			dc.setCapability("name", browser+":"+tcname);
			
			
			driver = new RemoteWebDriver(new URL(URL), dc);
			driver.setFileDetector(new LocalFileDetector());
			
			
			
			sleep(2000);
			//System.out.println(applicationUrl);
			driver.get(applicationUrl);
			driver.manage().window().maximize();
			reportStep("[" + browser + "] launched successfully", "INFO");
		} catch (WebDriverException e) {
			reportStep("[" + browser + "]: could not be launched", "FAIL");

		}

	}
	

	public void type(WebElement ele, String data) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.clear();
			ele.click();
			sleep(1000);
			//System.out.println("data before::"+data+"::");
			ele.sendKeys(data);
			sleep(1000);
		
			if (data.matches("^[\\w_*^)!]*$")) {
				data = "****";
			}
			reportStep("The data" + data + "entered successfully in field :" + "", "PASS");
		} catch (InvalidElementStateException e) {
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "INFO");
		}
	}

	public String getTitle() {
		String bReturn = "";
		try {
			bReturn = driver.getTitle();
			log.warning("Current Title:" + bReturn);
			reportStep("Current Title is:" + bReturn, "PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "WARNING");
		}
		return bReturn;
	}

	public boolean verifyTitle(String expectedTitle) {
		boolean bReturn = false;
		try {
			if (getTitle().equals(expectedTitle)) {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.titleContains(expectedTitle));
				reportStep("The expected title matches the actual " + expectedTitle, "PASS");
				bReturn = true;
			} else {
				reportStep(getTitle() + " The expected title doesn't matches the actual " + expectedTitle, "INFO");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : " + e.getMessage(), "INFO");
		}
		return bReturn;
	}

	public String getText(WebElement gettext) {
		String bReturn = "";
		try {
			bReturn = gettext.getText();
			log.warning("Current Text:" + bReturn);
			reportStep("Current Text is:" + bReturn, "PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "WARNING");
		}
		return bReturn;
	}


	public boolean verifyText(String expectedText,WebElement actualtext) {
		boolean bReturn = false;
		String textgettext=getText(actualtext);
		try {
			if (textgettext.equals(expectedText)) {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(actualtext));
				reportStep("The expected text matches the actual " + expectedText, "PASS");
				bReturn = true;
			} else {
				reportStep(textgettext + " The expected text doesn't matches the actual "+ expectedText, "INFO");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : " + e.getMessage(), "INFO");
		}
		return bReturn;
	}

	public void click(WebElement ele) {

		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The element : " + text + " is clicked ", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: " + ele + " is not interactable", "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
		}
	}


	public boolean elementdisplayed(WebElement ele1)

	{
		boolean eledisplay=false;

		try {
			if(ele1.isDisplayed())
			{
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(ele1));
				reportStep("The Element is displayed: " + ele1.getText(), "PASS");
				eledisplay = true;
			}

		}
		catch (Exception e) {
			reportStep("Exception : " + e.getMessage(), "FAIL");
		}
		return eledisplay;
	}

	public void scrollTillBottom() 

	{

		try {
			JavascriptExecutor jse =  (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			reportStep("The Browser scrolling down","INFO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("The Browser is not scrolling down","WARNING");
		}
	}

	@Override
	public long takeScreenShot() {

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFiler,
					new File(System.getProperty("user.dir") + "/reports/images/" + number + ".png"));
		} catch (WebDriverException e) {
			log.warning("The snapshot has been taken.");
		} catch (IOException e) {
			log.warning("The snapshot has't been taken");
		}
		return number;
	}

	public void iHTCcredentials(WebElement username, WebElement password, WebElement login, String usr, String pass) {

		try {

			log.fine("Username is present on the dom page:");

			//System.out.println(username);
			type(username, usr);

			log.fine("Password is present on the dom page:");

			type(password, pass);

			log.fine("Login is present on the dom page:");
			click(login);
			log.finest("Logged in Successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForPageLoad(long timeOutInSeconds) {

		try {
			System.out.println("Waiting for page to load.......");
			Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(new Function<WebDriver, Boolean>() {


				public Boolean apply(WebDriver driver) {
					System.out.println("Current Window State___________: " + String
							.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
					return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
							.equals("complete");
				}
			});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean scrollDownInBrowser(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int second = 0;; second++) {
				if (second >= 30) {
					break;
				}
				js.executeScript("arguments[0].scrollIntoView(true);", ele);
			}
			reportStep("The browser scrolling down","INFO", false);
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser is not scrolling down","WARNING", false);
		}
		return true;
	}

	// rafi 
	public boolean scrollupInBrowser(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int second = 0;; second++) {
				if (second >= 30) {
					break;
				}
				js.executeScript("arguments[0].scrollIntoView(true);", ele);
			}
			reportStep("The browser scrolling Up","INFO", false);
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser is not scrolling down","WARNING", false);
		}
		return true;
	}

	public void closeAllBrowsers() {
		try {
			if (driver == null) {
				return;
			}
			driver.quit();
			driver = null;
			reportStep("The opened browsers are closed", "PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser: \n Error: " + e.getMessage(), "INFO", false);
		}
	}

	public static void sleep(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollUpRandom() {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1000)");
			reportStep("The Browser scrolling up","PASS");
		}catch(Exception e) {
			e.printStackTrace();
			reportStep("The Browser is not scrolling up","WARNING");
		}
	}

	public void fluentwait(WebElement ele,int seconds)
	{
		WebDriverWait Wait=new WebDriverWait(driver,seconds);

		Wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void javascriptClick(WebElement ele) {

		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			text = ele.getText();

			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
			reportStep("The element : " + text + " is clicked ", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: " + ele + " is not interactable", "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
		}
	}



	public void scrollDownRandom() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			reportStep("The Browser scrolling down","PASS");
		}catch(Exception e) {
			e.printStackTrace();
			reportStep("The Browser is not scrolling down","WARNING");
		}
	}

	public void javascripttype(WebElement ele,String data) {
		try {

			JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].setAttribute('value','"+data+"')", ele);

			js.executeScript("arguments[0].value='12-12-2019 12:12';", ele);
			//js.executeScript("document.getElementById(" + ele + ").value=" + data + ";");

			reportStep("The data: " + ele.getText() + " entered successfully in field :" + "", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: " + ele + " is not interactable", "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
		}
	}

	public void javascripttype1(WebElement ele, String data) {

		try {

			JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].setAttribute('value','"+data+"')", ele);

			js.executeScript("arguments[0].value='11-10-2019';", ele);
			//js.executeScript("document.getElementById(" + ele + ").value=" + data + ";");

			reportStep("The data: " + ele.getText() + " entered successfully in field :" + "", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: " + ele + " is not interactable", "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException" + e.getMessage(), "FAIL");
		}
	}
	
	
	
}
