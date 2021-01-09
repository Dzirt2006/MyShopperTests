package tests.product;

import Pages.LogInPage;
import Pages.PoolsPageActions;
import tests.MyShopperTestBase;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class ProductsBase extends MyShopperTestBase {
	PoolsPageActions poolPage;
	String poolName = "product testing pool";

	@BeforeClass
	public void beforeClass() {
		new LogInPage(BaseUrl, user, password, driver).login();
		poolPage = new PoolsPageActions(driver);
		try {
			poolPage.addPool(poolName);
		} catch (UnhandledAlertException e) {
			poolPage.dismissAlert();
			poolPage.goToPool(poolName);
		}
	}

	@AfterMethod
	public void afterM() {
		poolPage.goBack().deletePool(poolName);
	}

}