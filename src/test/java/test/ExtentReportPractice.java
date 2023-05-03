package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commonUtilities.util;


public class ExtentReportPractice extends util{
	WebDriver driver;
	Reusable reUsable;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
	util Util;

	String URL = "";
	@BeforeSuite
	public void suiteBegins() {
		System.out.println("Suite Started");
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReports/"+util.getFileName("ExtentReportCheck","html"));
		spark.config().setReportName("Extent Reprot Demo Test");
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
		extent.createTest("After Suite").log(Status.INFO,"After Suite Passed");
	}
	@BeforeTest
	public void test_Initialize() {
		System.out.println("Before Test");
		extent.createTest("Before Test").log(Status.INFO,"Before Test Passed");
	}
	@Test(enabled=true)
	public void test() {
		System.out.println("Test");
		extent.createTest("Test").log(Status.PASS,"This is for Extent Report Check");
	}
	@AfterTest
	public void test_closure() {
		System.out.println("Test Completed");
		extent.createTest("After Test").log(Status.INFO,"After Test Passed");
	}
	@AfterSuite
	public void suiteClosure() {
		System.out.println("Suite Completed");
		extent.createTest("After Suite").log(Status.INFO,"After Suite Passed");
		extent.flush();
	}

}
