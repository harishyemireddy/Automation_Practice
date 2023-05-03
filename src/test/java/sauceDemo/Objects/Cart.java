package sauceDemo.Objects;

import org.openqa.selenium.WebDriver;

import commonUtilities.UiTestHelper;

public class Cart {
	WebDriver driver;
	UiTestHelper uiTestHelper;

	public Cart(WebDriver driver) {
		this.driver = driver;
		uiTestHelper = new UiTestHelper(driver);
	}

}
