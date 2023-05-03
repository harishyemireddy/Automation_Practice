package objectManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonUtilities.UiTestHelper;
import commonUtilities.util;

public class sauceDemo {
	WebDriver driver;
	UiTestHelper uiTestHelper;
	util Util;

	By username = By.id("user-name");
	By password = By.id("password");
	By submitButton = By.id("login-button");

	By listMenuButton = By.id("react-burger-menu-btn");
	By logoutButton = By.id("logout_sidebar_link");

	public sauceDemo(WebDriver driver) {
		this.driver=driver;
		uiTestHelper = new UiTestHelper(driver);
		Util = new util();
	}
	public void enterUsername() {
		try {
		uiTestHelper.zoomOut();
		WebElement uName = uiTestHelper.waitForObject(username);
		uName.sendKeys("standard_user");
		Util.Success("enterUsername");
		}catch(Exception e){
			System.out.println(e);
			Util.Failure("enterUsername");
		}
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
	public String getURL(){
		return driver.getCurrentUrl();
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
