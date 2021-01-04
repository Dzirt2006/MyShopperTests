package frameworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Searchers {
	default WebElement getElementXpath(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	default WebElement getElementXpath(WebElement element, String xpath) {
		return element.findElement(By.xpath(xpath));
	}
}
