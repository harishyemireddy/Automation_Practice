package sauceDemo.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonUtilities.UiTestHelper;

public class Login {
	WebDriver driver;
	UiTestHelper uiTestHelper;

	By username = By.id("user-name");
	By password = By.id("password");
	By submitButton = By.id("login-button");

	public Login(WebDriver driver) {
		this.driver=driver;
		uiTestHelper = new UiTestHelper(driver);
	}
	public void enterUsername() {
		uiTestHelper.zoomOut();
		WebElement uName = uiTestHelper.waitForObject(username);
		uName.sendKeys("standard_user");
	}
	public void enterPassword() {
		WebElement pwd = uiTestHelper.waitForObject(password);
		pwd.sendKeys("secret_sauce");
	}
	public void clickSubmitButton() {
		WebElement submitBtn = uiTestHelper.waitForObject(submitButton);
		submitBtn.click();
	}
	public void newclickSubmitButton() {
		//uiTestHelper.waitForObjectToBeClickable(submitButton);
		//WebElement submitBtn = uiTestHelper.waitForObject(submitButton);
		//submitBtn.click();
		WebElement submitBtn = uiTestHelper.waitForObject(submitButton);
		uiTestHelper.clickJS(submitBtn);
	}

}
