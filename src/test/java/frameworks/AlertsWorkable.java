package frameworks;

import org.openqa.selenium.WebDriver;

public interface AlertsWorkable {

	default String getNameFromAlert(WebDriver driver, int beginIndx) {
		String alertPoolName = driver.switchTo().alert().getText().substring(beginIndx);
		dismissAlert(driver);
		return alertPoolName;
	}
	default String getNameFromAlert(WebDriver driver, int beginIndx,int endIndx) {
		String alertPoolName = driver.switchTo().alert().getText().substring(beginIndx,endIndx);
		dismissAlert(driver);
		return alertPoolName;
	}

	default void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	default String getAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
}
