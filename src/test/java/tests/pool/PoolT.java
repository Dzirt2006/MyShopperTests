package tests.pool;

import org.testng.annotations.Test;

import Pages.NavBar;
import Pages.PoolsPageActions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class PoolT extends PoolsBaseTest {
	String poolName = "bbk";

	@Test
	public void deletePool() {
		boolean actual = new PoolsPageActions(driver).deletePool(poolName).getPool(poolName) == null;
		Assert.assertTrue(actual);
	}

	@BeforeMethod
	public void beforeClass() {
		new PoolsPageActions(driver).addPool(poolName);
		driver.navigate().back();
	}

}
