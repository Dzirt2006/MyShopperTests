package tests.pool;

import org.testng.annotations.Test;

import Pages.NavBar;
import Pages.PoolsPageActions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class DeletePool extends PoolsBaseTest {
	String poolName = "delete pool";

	@Test
	public void deletePool() {
		boolean actual = new PoolsPageActions(driver).deletePool(poolName).getPool(poolName) == null;
		Assert.assertTrue(actual);
	}

	@BeforeMethod
	public void pageIni() {
		new PoolsPageActions(driver).addPool(poolName);
		driver.navigate().back();
	}

}
