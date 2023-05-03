package Temp;

import java.io.IOException;
import org.testng.annotations.*;

public class Temp {
	int ActualCount = 5;
	int eCount = 0;

	@BeforeTest
	public void start() {
		System.out.println("Test Started");
	}

	@Test(priority = 0, enabled = true)
	public void test() throws IOException, InterruptedException {
		while (eCount != ActualCount) {
			System.out.println("Hello world");
			eCount++;
		}
	}

	@AfterTest
	public void close() {
		System.out.println("Test Completed");
	}
}
