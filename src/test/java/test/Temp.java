package test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Temp{
	//Logs log;

	@BeforeTest
	public void start() {
		System.out.println("Test Started");
		//log = new Logs();
	}
	@Test(priority=0,enabled=false)
	public void test() throws IOException, InterruptedException {
		System.out.println("Hello world");
		//log.Log("This is my first message to log");
	}
	@AfterTest
	public void close() {
		System.out.println("Test Completed");
	}
}
