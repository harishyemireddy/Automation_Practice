package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.util;

public class Holding_Driver extends util {
	WebDriver driver;
	Reusable reUsable;
	util Util = new util();
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		driver=getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		reUsable = new Reusable(driver);
	}
	@Test(enabled = true, priority = 0)
	public void holding_The_Driver() throws InterruptedException {
		Thread.sleep(60000);
		System.out.println("Test Completed");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.close();
		driver.quit();
	}
}
