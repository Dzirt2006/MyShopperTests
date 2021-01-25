package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.AlertsWorkable;
import frameworks.PageActionable;
import frameworks.Waiters;

public class ProductPageActions extends ProductPage implements PageActionable, AlertsWorkable, Waiters {
	private String nameXpath = "//div/div[1]";
	private String deleteButtonPath = "button";

	public ProductPageActions(WebDriver driver) {
		super(driver);
	}

	public String getPoolName() {
		return getPoolNameElement().getText().substring(17);
	}

	public ProductPageActions addProduct(String name) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (getPoolName() != null) {
			getInputField().sendKeys(name);
			getAddProductButton().click();
			waitCompletePageLoad(driver);
		}
		return this;
	}

	public ProductPageActions deleteProduct(String name) {
		try {
			WebElement element = getProduct(name.toLowerCase());
			System.out.println(getElementByTag(element, deleteButtonPath));
			getElementByTag(element, deleteButtonPath).click();
			waitInvisibility(element, driver);
		} catch (NullPointerException e) {
			System.err.println("Element for delete doesn't exist");
			e.printStackTrace();
		}
		return this;
	}

	//*[@id="root"]/div[3]/div[2]/div/div[1]/form/div/div[1]
	
	public WebElement getProduct(String name) {
		explicitWaitVisibleList(getProducts(), driver);
		System.out.println(getProducts().size());
		WebElement product = null;
		for (WebElement element : getProducts()) {
			String productName = getElementByXpath(element, nameXpath).getText(); // wrong locator, takes not from element,takes from whole page
			System.out.println(element.getTagName());
			if (productName.equals(name.toLowerCase())) {
				product = element;
			}
		}
		return product;
	}

	public String getProductNameFromAlert(String productName) {
		int lastIndx = productName.length();
		return getNameFromAlert(driver, 0, lastIndx);
	}

	public String getAlert() {
		return getAlert(driver);
	}

	public void dismissAlert() {
		dismissAlert(driver);
	}

}
