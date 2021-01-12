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

	public PoolsPageActions addPool(String name) {
		inputField.sendKeys(name);
		addPoolButton.click();
		return this;
	}

	public PoolsPageActions goToPool(String name) {
		String xpath = "//a[contains(.,'" + name.toUpperCase() + "')]";
		explicitWaitClickableByXpath(xpath, driver).click();
		return this;
	}

	public PoolsPageActions deletePool(String name) {
		try {
			WebElement element = getPool(name.toUpperCase());
			getElementByTag(element, deleteButtonPath).click();
			waitInvisibility(element, driver);
		} catch (NullPointerException e) {
			System.err.println("Element for delete doesn't exist");
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * get exact pool with name from list of pools
	 * 
	 * @param name
	 * @return WebElement
	 */
	public WebElement getPool(String name) {
		explicitWaitVisibleList(pools, driver);
		WebElement res = null;
		for (WebElement element : pools) {
			String innerText = getPoolAnchor(element).getText();
			if (innerText.equals(name.toUpperCase())) {
				res = element;
				break;
			}
		}
		System.out.println(res == null);
		return res;
	}

	private WebElement getPoolAnchor(WebElement element) {
		return getElementByTag(element, poolNamePath);
	}

	public PoolsPageActions goBack() {
		driver.navigate().back();
		return this;
	}

	public PoolsPageActions refresh() {
		driver.navigate().refresh();
		return this;
	}

	public String getPoolNameFromAlert() {
		int beginIndx = 32;
		String alertPoolName = driver.switchTo().alert().getText().substring(beginIndx);
		dismissAlert();
		return alertPoolName;
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getAlert() {
		return driver.switchTo().alert().getText();
	}

}
