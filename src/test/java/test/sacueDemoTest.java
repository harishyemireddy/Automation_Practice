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

public class sacueDemoTest extends util {
	WebDriver driver;
	Reusable reUsable;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
	util Util = new util();
	String URL ="";

	@BeforeSuite
	public void suiteBegins() {
		System.out.println("Suite Started");
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReports/"+util.getFileName("Sauce_Demo_Test","html"));
		spark.config().setReportName("Sauce Demo Test");
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		driver=getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		reUsable = new Reusable(driver);
	}
	@Test
	public void sauceDemoTest() {
		System.out.println("Sauce Demo Test Begins");
		reUsable.sauceDemoLogin();
		extent.createTest("Login").log(Status.PASS, "Sauce Demo Logged In");
		URL = reUsable.URLCapture();
		System.out.println(URL.isEmpty());
		if(URL.isEmpty()) {
			extent.createTest("URL Capture").log(Status.FAIL, "URL Capture Failed");
		}
		else
		{
			extent.createTest(URL).log(Status.PASS, "URL Captured Successfully");

		}
		System.out.println(URL);
		reUsable.sauceDemoLogOut();
		extent.createTest("Logout").log(Status.PASS,"Sauce Demo Logged Out");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.close();
		driver.quit();
	}
	@AfterSuite
	public void suiteClosure() {
		System.out.println("Suite Completed");
		extent.flush();
	}


}
