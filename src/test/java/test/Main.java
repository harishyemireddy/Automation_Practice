package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Main extends util{
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
		spark = new ExtentSparkReporter("ExtentReports/"+util.getFileName("Extent_Report","html"));
		spark.config().setReportName("Sauce Demo Test");
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
	}
	@BeforeTest
	public void test_Initialize() {
		System.out.println("Test Begins");
		driver=getDriver();
		driver.manage().window().maximize();
		driver.get(getURL());
		reUsable = new Reusable(driver);
	}
	@Test(enabled=false)
	public void test() {
		System.out.println("Test");
		reUsable.googleSearch();
	}
	@Test(enabled=false)
	public void sauceDemoTest() {
		//URL = null;
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
	@Test(enabled=false)
	public void toolsQaTest() {
		System.out.println("ToolsQa Automation Practice");
		driver.get("https://demoqa.com/browser-windows/");

		String mainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		for (String childWindow : s1) {
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of the child window is :" + text.getText());
				driver.close();
				System.out.println("Child window closed");
			}
		}
		driver.switchTo().window(mainWindow);
		driver.quit();
	}
	@Test(enabled=false)
	public void handlingWindows(){
		System.out.println("ToolsQa - Handling Windows 1");
		driver.get("https://demoqa.com/browser-windows/");
		reUsable.handlingWindow();
	}
	@Test(enabled=false)
	public void handlingLocatorinWindows() {
		System.out.println("ToolsQa - Handling Locator in Windows");
		driver.get("https://demoqa.com/browser-windows/");
		reUsable.handlinglocatorsinChildWindows();
	}
	@Test(enabled=false)
	public void clearChromeCookies() {
		driver.get("chrome://settings/clearBrowserData");
		reUsable.clearCookies();
	}
	@Test(enabled=false)
	public void uploadDownload(){
		driver.get("https://demoqa.com/upload-download");
		reUsable.uploadFile();
		reUsable.downloadFile();
		reUsable.verifyFileUpload();
	}
	@Test(enabled=true)
	public void handlingTables() {
		URL = "https://demo.guru99.com/test/web-table-element.php";
		driver.get(URL);
		System.out.println(driver.getCurrentUrl());
		reUsable.getDataFromTable();
		String data = reUsable.getDataFromTable();
		extent.createTest(URL).log(Status.INFO, URL);
		extent.createTest(data).log(Status.PASS, "Data Fetched Successfully");
	}
	@AfterTest
	public void test_closure() {
		System.out.println("Test Completed");
		driver.quit();
	}
	@AfterSuite
	public void suiteClosure() {
		System.out.println("Suite Completed");
		extent.flush();
	}
}
