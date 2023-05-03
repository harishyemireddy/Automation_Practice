package sauceDemo.Objects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.ExtentReport;
import commonUtilities.util;

public class sacueDemoTest3 extends util {
	WebDriver driver;
	sd_Reusable reUsable;
	ExtentReport extentReport = new ExtentReport();
	util Util = new util();
	String URL ="";

	@BeforeSuite
	public void suiteBegins() {
		System.out.println("Suite Started");
		extentReport.ExtentReports("Sauce Demo","Sauce Demo Test");
		extentReport.info("Before Suite","Before Suite Passed");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		extentReport.info("Before Test","Before Test Passed");
		driver=getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		reUsable = new sd_Reusable(driver);
	}
	@Test
	public void sauceDemoTest() {
		System.out.println("Sauce Demo Test Begins");
		reUsable.sauceDemoLogin();
		extentReport.Pass("Login", "Sauce Demo Logged In Successfully");
		URL = driver.getCurrentUrl();
		System.out.println(URL.isEmpty());
		if(URL.isEmpty()) {
			extentReport.Fail(URL, "URL Capture Failed");
		}
		else
		{
			extentReport.Pass_With_Screenshot("URL Captured Successfully",URL);

		}
		System.out.println(URL);
		reUsable.sauceDemoLogOut();
		extentReport.Pass("Logout", "Sauce Demo logged out successfully");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		extentReport.info("Afte test","After Test Passed");
		driver.close();
		driver.quit();
	}
	@AfterSuite
	public void suiteClosure() {
		System.out.println("Suite Completed");
		extentReport.info("After suite","After Suite Passed");
		extentReport.Flush();
	}


}
