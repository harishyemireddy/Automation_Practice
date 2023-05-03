package sauceDemo.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonUtilities.UiTestHelper;

public class Menu {
	WebDriver driver;
	UiTestHelper uiTestHelper;

	By listMenuButton = By.id("react-burger-menu-btn");
	By logoutButton = By.id("logout_sidebar_link");

	public Menu(WebDriver driver) {
		this.driver = driver;
		uiTestHelper = new UiTestHelper(driver);
	}

	public void clickMenuButton() {
		WebElement listBtn = uiTestHelper.waitForObject(listMenuButton);
		listBtn.click();
	}

	public void clickLogoutButton() {
		WebElement logoutBtn = uiTestHelper.waitForObject(logoutButton);
		uiTestHelper.clickJS(logoutBtn);
	}

}
