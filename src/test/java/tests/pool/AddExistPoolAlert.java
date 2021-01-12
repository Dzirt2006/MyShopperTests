package tests.pool;

import org.testng.annotations.Test;

import Pages.PoolsPageActions;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AddExistPoolAlert extends PoolsBaseTest {
	String poolName = "Add existed pool";
	PoolsPageActions page;

	@BeforeMethod
	public void pageIni() {
		page = new PoolsPageActions(driver).addPool(poolName).goBack();
	}

	@Test
	public void checkAlertOnAddingPool() {
		String actual = page.addPool(poolName).goBack().getPoolNameFromAlert();
		Assert.assertEquals(actual, poolName.toUpperCase());
	}

	@AfterMethod
	public void afterPoolMethod() {
		page.deletePool(poolName);
	}

}
