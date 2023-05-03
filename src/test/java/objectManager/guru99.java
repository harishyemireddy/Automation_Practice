package objectManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonUtilities.UiTestHelper;

public class guru99 {
	WebDriver driver;
	UiTestHelper uiTestHelper;

	By tableElement = By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[1]");

	public guru99(WebDriver driver) {
		this.driver=driver;
		uiTestHelper = new UiTestHelper(driver);
	}

	public String getDataFromTable() {
		WebElement tableEle = uiTestHelper.waitForObject(tableElement);
		return tableEle.getText();
	}

}
