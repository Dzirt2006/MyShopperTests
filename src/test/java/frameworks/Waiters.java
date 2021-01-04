package frameworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Waiters {

	default WebElement explicitWait(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	default void implicitWait(WebDriver driver, int ms) {
		driver.manage().timeouts().implicitlyWait(ms, TimeUnit.MILLISECONDS);
	}
}
