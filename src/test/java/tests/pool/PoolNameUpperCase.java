package tests.pool;

import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.PoolsPageActions;
import Pages.ProductPageActions;

public class PoolNameUpperCase extends PoolsBaseTest {
	String poolName = "poolname";
	String expected = poolName.toUpperCase();
	PoolsPageActions page;

	@Test
	public void poolNameisInUpperCase() {
		String actual = new ProductPageActions(driver).getPoolName();
		Assert.assertEquals(actual, expected);
	}

	@BeforeMethod
	public void pageIni() {
		try {
			page = new PoolsPageActions(driver).addPool(poolName);
		} catch (UnhandledAlertException err) {
			System.out.println("Alert not expected,delete the pool in the app");
		}
	}

	@AfterMethod
	public void afterPoolMethod() {
		page.goBack().deletePool(expected);
	}

}
