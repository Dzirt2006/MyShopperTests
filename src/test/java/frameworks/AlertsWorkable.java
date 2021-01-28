package frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface AlertsWorkable  {

	default String getNameFromAlert(WebDriver driver, int beginIndx) {
		waitAlertPresent(driver);
		String alertPoolName = driver.switchTo().alert().getText().substring(beginIndx);
		dismissAlert(driver);
		return alertPoolName;
	}

	default String getNameFromAlert(WebDriver driver, int beginIndx, int endIndx) {
		waitAlertPresent(driver);
		String alertPoolName = driver.switchTo().alert().getText().substring(beginIndx, endIndx);
		dismissAlert(driver);
		return alertPoolName;
	}

	default void dismissAlert(WebDriver driver) {
//		waitAlertPresent(driver);
		driver.switchTo().alert().dismiss();
	}

	default String getAlert(WebDriver driver) {
//		waitAlertPresent(driver);
		return driver.switchTo().alert().getText();
	}
	
	default void waitAlertPresent(WebDriver driver) {
		new WebDriverWait(driver, 3000).until(ExpectedConditions.alertIsPresent());
	}
}
