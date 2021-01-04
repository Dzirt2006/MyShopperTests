package frameworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Waiters {

	default WebElement explicitWaitClickable(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	default WebElement explicitWaitClickableByXpath(String xpath, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	default void implicitWait(WebDriver driver, int ms) {
		driver.manage().timeouts().implicitlyWait(ms, TimeUnit.MILLISECONDS);
	}
}
