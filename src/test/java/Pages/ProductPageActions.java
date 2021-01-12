package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.PageActionable;

public class ProductPageActions extends ProductPage implements PageActionable {
	private String nameXpath = "//div[1]";
	private String deleteButtonPath = "button";

	public ProductPageActions(WebDriver driver) {
		super(driver);
	}

	public String getPoolName() {
		return getPoolNameElement().getText().substring(17);
	}

	public ProductPageActions addProduct(String name) {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(name);
		if (getPoolName() != null) {
//			explicitWaitVisibleByXpath(driver, "//input[@id='formBasic']").sendKeys(name);
			getInputField().sendKeys(name);
			getAddProductButton().click();
		}
		return this;
	}

	public ProductPageActions deleteProduct(String name) {
		try {
			WebElement element = getProduct(name.toLowerCase());
			getElementByTag(element, deleteButtonPath).click();
			waitInvisibility(element, driver);
		} catch (NullPointerException e) {
			System.err.println("Element for delete doesn't exist");
			e.printStackTrace();
		}
		return this;
	}

	public WebElement getProduct(String name) {
		WebElement product = null;
		for (WebElement element : getProducts()) {
			String productName = getElementByXpath(element, nameXpath).getText();
			if (productName.equals(name.toLowerCase())) {
				product = element;
			}
		}
		return product;
	}

}
