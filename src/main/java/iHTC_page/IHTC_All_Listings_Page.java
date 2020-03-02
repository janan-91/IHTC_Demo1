package iHTC_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import IHTC_wdMethods.ProjectMethods;

public class IHTC_All_Listings_Page extends ProjectMethods {

	public IHTC_All_Listings_Page(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

		if (!verifyTitle("www.HEMPTRADER.online | Dashboard")) {
			throw new RuntimeException();
		}
	}
}
