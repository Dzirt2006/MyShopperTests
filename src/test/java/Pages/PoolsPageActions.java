package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.ElementSearcher;
import frameworks.Waiters;

public class PoolsPageActions extends PoolsPage implements ElementSearcher, Waiters {
	private String poolNamePath = "a";
	private String deleteButtonPath = "button";

	public PoolsPageActions(WebDriver driver) {
		super(driver);
	}

	public void addPool(String name) {
		inputField.sendKeys(name);
		addPoolButton.click();
	}

	public void goToPool(String name) {
		String xpath = "//a[contains(.,'" + name.toUpperCase() + "')]";
		explicitWaitClickableByXpath(xpath, driver).click();
	}

	public void deletePool(String name) {
		WebElement element = getPool(name.toUpperCase());
		System.out.println(element == null);
		getElementByTag(element, deleteButtonPath).click();
	}

	/**
	 * get exact pool with name from list of pools
	 * 
	 * @param name
	 * @return WebElement
	 */

	public WebElement getPool(String name) {
		WebElement res = null;
		for (WebElement element : pools) {
			String innerText = getPoolAnchor(element).getText();
			if (innerText.equals(name.toUpperCase())) {
				res = element;
				break;
			}
		}
		return res;
	}

	private WebElement getPoolAnchor(WebElement element) {
		return getElementByTag(element, poolNamePath);
	}
}
