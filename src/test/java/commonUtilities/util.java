package commonUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class util {
	static WebDriver driver;
	Properties prop;
	public static File file;

	// This method with return the website URL
	public String getURL() {
		// String URL = "https://www.saucedemo.com/";
		String URL = "https://demoqa.com/upload-download";
		return URL;
	}

	// This method with return the driver instance
	public WebDriver getDriver() {
		//System.setProperty("webdriver.chrome.driver",
		//		"C:\\Users\\a828440\\Automation Testing\\Automation\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	// This method is used to capture the screenshot
	public static String screenShot(String fileName) throws IOException, InterruptedException {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File srcFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Screenshots/" + fileName + "-" + timeStamp() + ".png");
		String absolutePath_screen = destinationFile.getAbsolutePath();
		FileUtils.copyFile(srcFile, destinationFile);
		return absolutePath_screen;
	}

	// This method is used to return the timeStamp in "dd-M-yyyy h-m-s"" format
	public static String timestamp() {
		return new SimpleDateFormat("dd-M-yyyy h-m-s").format(new Date());
	}

	// This method is used to return the timeStamp in "dd-M-yyyy h-m-s" format
	public static String timeStamp() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy h-m-s");
		return dateFormat.format(date);
	}

	// This method is used to get date
	public static String getDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
		return dateFormat.format(date);
	}

	// This method with return the file name including timestamp and extension
	public static String getFileName(String fileName, String extension) {
		String fName = fileName + "-" + timeStamp() + "." + extension;
		return fName;
	}

	// This method with write a default file
	public void writeToDefaultFile(String logInfo) throws IOException {
		File file = new File("C:\\Users\\a828440\\Automation Testing\\Automation\\Logs\\Logs.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		bw.write(timeStamp() + "=" + logInfo);
		pw.println();
		bw.close();
	}

	// This method with write a custom file
	public void writeToFile(String fileName, String logInfo) throws IOException {
		// File file = new File("C:\\Users\\a828440\\Automation
		// Testing\\Automation\\Logs\\Logs_10-01-2023.txt");
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		bw.write(timeStamp() + "=" + logInfo);
		pw.println();
		bw.close();
	}

	public void saveToFile(String info) throws IOException {
		File file = new File("C:\\Users\\a828440\\Automation Testing\\Automation\\Logs\\Logs.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		bw.write(timeStamp() + "-" + info);
		pw.println();
		bw.close();
	}

	public boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void Success(String methodName) {
		System.out.println(methodName + "Passed");
	}

	public void Failure(String methodName) {
		System.out.println(methodName + "Failed");

	}
}
