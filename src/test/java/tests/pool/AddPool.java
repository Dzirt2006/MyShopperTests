package tests.pool;

import org.testng.annotations.Test;

import Pages.PoolsPageActions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AddPool extends PoolsBaseTest {
	String poolName = "Add pool";
	PoolsPageActions page;

	@BeforeMethod
	public void pageIni() {
		page = new PoolsPageActions(driver);
	}

	@Test
	public void addPool() {
		boolean actual = page.addPool(poolName).goBack().getPool(poolName) != null;
		Assert.assertTrue(actual);
	}

	@AfterMethod
	public void afterPoolMethod() {
		page.deletePool(poolName);
	}

}
