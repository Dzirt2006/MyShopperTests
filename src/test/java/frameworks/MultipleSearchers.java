package frameworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface MultipleSearchers {

	default List<WebElement> getListByClassName(WebDriver driver, String className) {
		return driver.findElements(By.className(className));
	}

	default List<WebElement> getListByClassName(WebElement element, String className) {
		return element.findElements(By.className(className));
	}

	default List<WebElement> getListByClassXpath(WebDriver driver, String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	default List<WebElement> getListByTag(WebDriver driver, String tag) {
		return driver.findElements(By.tagName(tag));
	}

	default List<WebElement> getListByTag(WebElement element, String tag) {
		return element.findElements(By.tagName(tag));
	}
}
