package tests.pool;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.PoolsPageActions;

public class SpaseAsAName extends PoolsBaseTest {
	String poolName = " ";
	PoolsPageActions page;

	@Test
	public void onlySpaceAsAPoolName() {
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
		try {
			page.dismissAlert();
		} catch (NoAlertPresentException err) {
			System.out.println("Expected alert");
		}
	}
}
