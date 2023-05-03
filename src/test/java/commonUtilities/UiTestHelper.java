package commonUtilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UiTestHelper extends util{
	WebDriver driver;
	JavascriptExecutor js;

	public UiTestHelper(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement waitForObject(By by) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			//element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			System.out.println(element);
			System.out.println("Element not Found: " + by + e);
		}
		return element;
	}
	public WebElement waitForObjectToBeClickable(By by) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println(element);
			System.out.println("Element not Found: " + by + e);
		}
		Assert.assertNotNull(element);
		return element;
	}

	public void zoomOut() {
		js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom = '0.75'");
	}
	public void clickJS(WebElement ele) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", ele);
		} catch (Exception e) {
			System.out.println("Element not found: " + e);
		}
	}

	public WebElement handlingWindow(By by) {
		WebElement element = null;
		String mainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		for (String childWindow : s1) {
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				try {
					WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
					//element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
				} catch (Exception e) {
					System.out.println(element);
					System.out.println("Element not Found: " + by + e);
				}
				driver.close();
				System.out.println("Child window closed");
			}
		}
		driver.switchTo().window(mainWindow);
		return element;
	}
	public String handlingWindowPart1(){
		String message = "";
		String mainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		for (String childWindow : s1) {
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of the child window is :(UITESTHELPER)" + text.getText());
				message = text.getText();
				driver.close();
				System.out.println("Child window closed");
			}
		}
		driver.switchTo().window(mainWindow);
		return message;
	}
	public WebElement handlingLocatorsInWindowMethod(By by) {
		WebElement element = null;
		String mainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		for (String childWindow : s1) {
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				try {
					WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
					//element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
				} catch (Exception e) {
					System.out.println(element);
					System.out.println("Element not Found: " + by + e);
				}
				driver.close();
				System.out.println("Child window closed");
			}
		}
		driver.switchTo().window(mainWindow);
		return element;
	}
}
