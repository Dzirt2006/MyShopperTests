package tests.pool;

import org.testng.annotations.Test;

import Pages.NavBar;
import Pages.PoolsPageActions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class DeletePool extends PoolsBaseTest {
	String poolName = "delete pool";
	PoolsPageActions page;

	@Test
	public void deletePool() {
		boolean actual = page.deletePool(poolName).getPoolsList() == null;
		Assert.assertTrue(actual);
	}

	@BeforeMethod
	public void pageIni() {
		page = new PoolsPageActions(driver).addPool(poolName);
		driver.navigate().back();
	}

}
