package sauceDemo.Objects;

import org.openqa.selenium.WebDriver;

public class sd_Reusable {
	WebDriver driver;
	Cart cart;
	Inventory inventory;
	Login login;
	Menu menu;

	public sd_Reusable(WebDriver driver) {
		this.driver = driver;
		cart = new Cart(driver);
		inventory = new Inventory(driver);
		login = new Login(driver);
		menu = new Menu(driver);
	}

	public void sauceDemoLogin() {
		System.out.println("Sauce Demo Login");
		login.enterUsername();
		login.enterPassword();
		// login.clickSubmitButton();
		login.newclickSubmitButton();
	}

	public void sauceDemoLogOut() {
		System.out.println("Sauce Demo Logged Out");
		menu.clickMenuButton();
		menu.clickLogoutButton();
	}

}
