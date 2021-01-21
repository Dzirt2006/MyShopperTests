package tests.product;

import Pages.LogInPage;
import Pages.PoolsPageActions;
import tests.MyShopperTestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class ProductsBase extends MyShopperTestBase {
	PoolsPageActions poolPage;
	String poolName = "product testing pool";

	@BeforeMethod
	public void pageIni() {
		new LogInPage(BaseUrl, user, password, driver).login();
		poolPage = new PoolsPageActions(driver);
		try {
			poolPage.addPool(poolName);
		} catch (UnhandledAlertException err) {
			poolPage.dismissAlert();
			poolPage.goToPool(poolName);
		}
	}

	@AfterMethod
	public void afterProductMethod() {
		deletePool();
	}

	private void deletePool() {
		poolPage.goBack();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		poolPage.deletePool(poolName);
	}

}
