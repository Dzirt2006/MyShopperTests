package tests.pool;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import frameworks.FailListener;
import Pages.PoolsPageActions;

@Listeners(FailListener.class)
public class SpecCharsPoolName extends PoolsBaseTest {
	String poolName = "!@#$%^&*()+{}<>./";
	PoolsPageActions page;

	@Test
	public void onlySpecCharsPoolName() {
		String expected = "Please enter valid pool name.";
		String actual = page.addPool(poolName).getAlert();
		Assert.assertEquals(actual, expected);
	}

	@BeforeMethod
	public void pageIni() {
		page = new PoolsPageActions(driver);
	}

	@AfterMethod
	public void afterPoolMethod() {
		try {
			page.dismissAlert();
		} catch (NoAlertPresentException err) {
			page.goBack().deletePool("");
			System.out.println("Expected alert");
		}
	}
}
