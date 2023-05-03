package sauceDemo.Objects;

import org.openqa.selenium.WebDriver;

import commonUtilities.UiTestHelper;

public class Inventory {
	WebDriver driver;
	UiTestHelper uiTestHelper;

	public Inventory(WebDriver driver) {
		this.driver = driver;
		uiTestHelper = new UiTestHelper(driver);
	}

}
