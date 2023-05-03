package test;

import org.openqa.selenium.WebDriver;

import objectManager.Google;
import objectManager.guru99;
import objectManager.practiceClass;
import objectManager.sauceDemo;
import objectManager.toolsQa;

public class Reusable {
	WebDriver driver;
	Google googleObject;
	sauceDemo sauceDemoObject;
	toolsQa toolsqaObject;
	practiceClass practiceObject;
	guru99 guru99Object;

	public Reusable(WebDriver driver) {
		this.driver=driver;
		googleObject = new Google(driver);
		sauceDemoObject = new sauceDemo(driver);
		toolsqaObject = new toolsQa(driver);
		practiceObject = new practiceClass(driver);
		guru99Object = new guru99(driver);
	}

	public  void googleSearch() {
		System.out.println("Google Search ReUsable Method");
		googleObject.gSearch();
	}
	public void sauceDemoLogin() {
		System.out.println("Sauce Demo Login Method");
		sauceDemoObject.enterUsername();
		sauceDemoObject.enterPassword();
		//sauceDemoObject.clickSubmitButton();
		sauceDemoObject.newclickSubmitButton();
	}
	public void sauceDemoLogOut() {
		sauceDemoObject.clickMenuButton();
		sauceDemoObject.clickLogoutButton();
	}
	public String URLCapture() {
		return sauceDemoObject.getURL();
	}
	public void handlingWindow() {
		toolsqaObject.clickNewWindow();
		System.out.println("ReUsable Method = " + toolsqaObject.newWindowMessageChild());
	}
	public void handlinglocatorsinChildWindows() {
		System.out.println(toolsqaObject.handlingLocatorsInChildWindows());
	}
	public void clearCookies() {
		practiceObject.clearCookies();
	}
	public void downloadFile() {
		toolsqaObject.clickChooseFileButton();
	}
	public void uploadFile() {
		toolsqaObject.clickUploadFileButton();
	}
	public void verifyFileUpload() {
		System.out.println(toolsqaObject.verifyUploadedFile());
	}
	public String getDataFromTable() {
			System.out.println(guru99Object.getDataFromTable());
			return guru99Object.getDataFromTable();
	}
}
