package test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.util;

public class Screenshot{
	util Util = new util();

	@BeforeTest
	public void start() {
		System.out.println("Test Started");
	}
	@Test(priority=0,enabled=true)
	public void test() throws IOException, InterruptedException {
		System.out.println("Hello world");
		util.screenShot("Sample Screenshot");
	}
	@AfterTest
	public void close() {
		System.out.println("Test Completed");
	}

}
