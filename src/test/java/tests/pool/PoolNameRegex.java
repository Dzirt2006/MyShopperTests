package tests.pool;

import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.PoolsPageActions;
import Pages.ProductPageActions;

public class PoolNameRegex extends PoolsBaseTest {
	String poolName = "R!@e$#G%^e&*X()-=+,.<>\\/";
	String expected = poolName.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
	PoolsPageActions page;

	@Test
	public void RegexPoolName() {
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
	public void afterMethod() {
		page.goBack().deletePool(expected);
	}
}
