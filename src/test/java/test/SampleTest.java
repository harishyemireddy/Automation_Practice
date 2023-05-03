package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.util;
import objectManager.Google;

public class SampleTest extends util{
	WebDriver driver;
	util utilObject;
	Google googleObject;

	@BeforeTest
	public void test_Initialize() {
		System.out.println("Test Begins");
		driver=getDriver();
		driver.manage().window().maximize();
		driver.get(getURL());
		System.out.println(getURL());

		googleObject = new Google(driver);
	}
	@Test
	public void test() {
		System.out.println("Test");
		googleObject.gSearch();
		//driver.findElement(By.name("q")).sendKeys("Automation Testing",Keys.ENTER);
	}
	@AfterTest
	public void test_closure() {
		System.out.println("Test Completed");
	}

}
