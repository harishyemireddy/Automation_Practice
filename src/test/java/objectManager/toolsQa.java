package objectManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonUtilities.UiTestHelper;

public class toolsQa {
	WebDriver driver;
	UiTestHelper uiTestHelper;

	//https://demoqa.com/ = Object Manager
	By newTab = By.id("tabButton");
	By newWindow = By.id("windowButton");
	By newWindowMessage = By.id("messageWindowButton");
	By contentMessage = By.id("sampleHeading");

	By downloadButton = By.id("downloadButton");
	By chooseFileButton = By.id("uploadFile");

	public toolsQa(WebDriver driver) {
		this.driver=driver;
		uiTestHelper = new UiTestHelper(driver);
	}
	public void clickNewTab() {
		WebElement newTabBtn = uiTestHelper.waitForObject(newTab);
		uiTestHelper.clickJS(newTabBtn);
	}
	public void clickNewWindow() {
		WebElement newWindowBtn = uiTestHelper.waitForObject(newWindow);
		uiTestHelper.clickJS(newWindowBtn);
	}
	public void clickNewWindowMessage() {
		WebElement newWindowMessageBtn = uiTestHelper.waitForObject(newWindowMessage);
		uiTestHelper.clickJS(newWindowMessageBtn);
	}
	public String newWindowMessageChild() {
		//WebElement handleChildWindow = uiTestHelper.handlingWindow(contentMessage);
		return uiTestHelper.handlingWindowPart1();
		//return handleChildWindow.getText();
	}
	public String handlingLocatorsInChildWindows() {
		WebElement handleLocator = uiTestHelper.handlingLocatorsInWindowMethod(contentMessage);
		return handleLocator.getText();
	}
	public void clickUploadFileButton() {
		WebElement uploadBtn = uiTestHelper.waitForObject(chooseFileButton);
		uploadBtn.sendKeys("C:\\Users\\a828440\\Downloads\\sampleFile.jpeg");
	}
	public void clickChooseFileButton() {
		WebElement chooseFileBtn = uiTestHelper.waitForObject(downloadButton);
		chooseFileBtn.click();
	}
	public String verifyUploadedFile(){
		WebElement verifyFileUpload = uiTestHelper.waitForObject(chooseFileButton);
		return verifyFileUpload.getText();
	}
}
