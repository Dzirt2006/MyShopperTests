package frameworks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Waiters {

	default WebElement explicitWaitClickable(WebElement element, WebDriver driver) {
		return new WebDriverWait(driver, 3000).until(ExpectedConditions.elementToBeClickable(element));
	}

	default WebElement explicitWaitClickableByXpath(String xpath, WebDriver driver) {
		return new WebDriverWait(driver, 3000).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	default List<WebElement> explicitWaitVisibleList(List<WebElement> elements, WebDriver driver) {
		return new WebDriverWait(driver, 3000).until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	default void implicitWait(WebDriver driver, int ms) {
		driver.manage().timeouts().implicitlyWait(ms, TimeUnit.MILLISECONDS);
	}

	default void waitInvisibility(WebElement element, WebDriver driver) {
		new WebDriverWait(driver, 3000).until(ExpectedConditions.invisibilityOf(element));
	}
}
