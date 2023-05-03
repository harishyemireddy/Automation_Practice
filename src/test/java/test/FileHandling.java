package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.Logs;
import commonUtilities.util;

public class FileHandling extends util {
	util Util = new util();
	static WebDriver driver;
	Logs logObject = new Logs();
	String Path= "";

	@BeforeTest
	public void start() {
		System.out.println("Test Started");
		System.out.println("Test Begins");
		driver=getDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=0,enabled=false)
	public void test() throws IOException, InterruptedException {
		System.out.println("Hello world");
		//saveToFile("Hello world");
		File file = new File("temp.txt");
		if(file.createNewFile()) {
			System.out.println("File Created ::");
			System.out.println("Name = " + file.getName());
			System.out.println("Path of the File =" + file.getAbsolutePath());
		}
	}
	@Test(priority=1,enabled=false)
	public void fileCreaiton() throws IOException{
		//Path = createNewFile("temp.txt");
		Path = createNewFile(getFileName());
		System.out.println("Test:: Path of the file is = " + Path);
	}
	@Test(priority=2,enabled=false)
	public void logFileCreation() throws IOException {
		Log("Hello world");
	}
	@Test(priority=3,enabled=true)
	public void logging() throws IOException, InterruptedException {
		driver.get("https://www.google.com/");
		util.screenShot("Screenshot");
		logObject.Log("This is my first log message");
	}
	@AfterTest
	public void close() {
		System.out.println("Test Completed");
		//driver.close();
		//driver.quit();
	}
	public String createNewFile(String fileName) throws IOException {
		File file = new File("./Logs/"+fileName);
		if(file.createNewFile()) {
			System.out.println("File Created ::");
			System.out.println("Name = " + file.getName());
			System.out.println("Path of the File =" + file.getAbsolutePath());
		}
		else {
			System.out.println("File already exists");
		}
		return file.getAbsolutePath();
	}

	public String getFileName() {
		return "Log-"+localTimeStamp()+".txt";
	}

	public String localTimeStamp() {
		Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
        return dateFormat.format(date);

	}
	@Override
	public void writeToFile(String filePath, String fileInfo) throws IOException {
		File file = new File(filePath);
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        bw.write(localTimeStamp()+"-"+fileInfo);
        pw.println();
        bw.close();
	}
	public void Log(String logMessage) throws IOException {
		Path = createNewFile(getFileName());
		writeToFile(Path,logMessage);
	}

}
