package test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.Logs;
import commonUtilities.util;

public class FolderHandling extends util {
	util Util = new util();
	static WebDriver driver;
	Logs logObject = new Logs();
	String Path = "";
	File file;

	@BeforeTest
	public void start() {
		System.out.println("Test Started");
		System.out.println("Test Begins");
		driver = getDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 0, enabled = true)
	public void folderHandling() {
		file = new File("./FolderHandling/" + getFolderName());
		createFolder();
	}

	@Test(priority = 1, enabled = false)
	public void FolderCreation() throws IOException, InterruptedException {
		driver.get("https://www.google.com/");
		util.screenShot("Screenshot");
		logObject.Log("This is my first log message");
	}

	@AfterTest
	public void close() {
		System.out.println("Test Completed");
		// driver.close();
		// driver.quit();
	}

	public String getFolderName() {
		return "Tracking-" + getDate();
	}

	// This method is used to return the date for the log file
	public static String getDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
		return dateFormat.format(date);
	}

	public static String timeStamp() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy h-m-s");
		return dateFormat.format(date);
	}

	public void createFolder() {
		boolean bool = file.mkdir();
		if (bool) {
			System.out.println("Directory created successfully");
		} else {
			System.out.println("Sorry couldn�t create specified directory");
		}
	}
}
