package tests.pool;

import org.testng.annotations.Test;

import Pages.PoolsPageActions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AddEpmtyNamePool extends PoolsBaseTest {
	String poolName = "";
	PoolsPageActions page;

	@Test
	public void emptyNamePool() {
		String expected = "Please enter valid pool name.";
		String actual = page.addPool(poolName).getAlert();
		Assert.assertEquals(actual, expected);
	}

	@BeforeMethod
	public void pageIni() {
		page = new PoolsPageActions(driver);
	}

	@AfterMethod
	public void afterMethod() {
		page.dismissAlert();
	}

}
