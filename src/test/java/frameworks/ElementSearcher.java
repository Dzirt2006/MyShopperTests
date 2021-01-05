package frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ElementSearcher {

	default WebElement getElementByXpath(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	default WebElement getElementByXpath(WebElement element, String xpath) {
		return element.findElement(By.xpath(xpath));
	}

	default WebElement getElementByTag(WebElement element, String tag) {
		return element.findElement(By.tagName(tag));
	}

	default WebElement getElementBylinkText(WebDriver driver, String text) {
		return driver.findElement(By.linkText(text));
	}
}
