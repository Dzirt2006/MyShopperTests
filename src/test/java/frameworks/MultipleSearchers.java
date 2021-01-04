package frameworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface MultipleSearchers {

	default List<WebElement> getListByClassName(WebDriver driver, String className) {
		return driver.findElements(By.className(className));
	}

	default List<WebElement> getListByClassXpath(WebDriver driver, String xpath) {
		return driver.findElements(By.xpath(xpath));
	}
}
