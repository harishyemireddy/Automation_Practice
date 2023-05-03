package objectManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Google {
	WebDriver driver;

	public Google(WebDriver driver) {
		this.driver=driver;
	}

	By googleSearch = By.name("q");

	public void gSearch() {
		System.out.println("Google Search");
		driver.findElement(googleSearch).sendKeys("Automation Testing",Keys.ENTER);
	}

}
