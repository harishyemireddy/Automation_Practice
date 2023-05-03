package objectManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonUtilities.UiTestHelper;

public class practiceClass {
	WebDriver driver;
	UiTestHelper uiTestHelper;

	By clearButton = By.id("clearBrowsingDataConfirm");

	public practiceClass(WebDriver driver) {
		this.driver=driver;
		uiTestHelper = new UiTestHelper(driver);
	}
	public void clearCookies() {
		WebElement clearBtn = uiTestHelper.waitForObject(clearButton);
		uiTestHelper.clickJS(clearBtn);
	}

}
