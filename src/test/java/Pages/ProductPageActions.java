package Pages;

import org.openqa.selenium.WebDriver;

public class ProductPageActions extends ProductPage {

	public ProductPageActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getPoolName() {
		return getPoolNameElement().getText().substring(17);
	}

}
