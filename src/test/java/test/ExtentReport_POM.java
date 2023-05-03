package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.ExtentReport;
import commonUtilities.util;

public class ExtentReport_POM extends util {
	WebDriver driver;
	Reusable reUsable;
	util Util;
	String URL = "";
	ExtentReport extentReport = new ExtentReport();

	@BeforeSuite
	public void suiteBegins() {
		System.out.println("Suite Started");
		extentReport.ExtentReports("Tracking_Number", "AWB Tracking Number Creation");
		extentReport.info("Before Suite", "Before Suite Passed");
	}

	@BeforeTest
	public void test_Initialize() {
		System.out.println("Before Test");
		extentReport.info("Before Test", "Before Test Passed");
	}

	@Test(enabled = true)
	public void test() {
		System.out.println("Test");
		extentReport.Pass("Extent Report Test", "Test Passed Passed");
		extentReport.Pass_With_Screenshot("Test Node", "Test Node Message");
	}

	@AfterTest
	public void test_closure() {
		System.out.println("Test Completed");
		extentReport.info("Afte test", "After Test Passed");
	}

	@AfterSuite
	public void suiteClosure() {
		System.out.println("Suite Completed");
		extentReport.info("After suite", "After Suite Passed");
		extentReport.Flush();
	}

}
