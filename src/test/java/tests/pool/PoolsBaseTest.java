package tests.pool;

import org.testng.annotations.BeforeMethod;

import Pages.LogInPage;
import tests.MyShopperTestBase;

public class PoolsBaseTest extends MyShopperTestBase {

	@BeforeMethod
	public void beforePoolMethod() {
		new LogInPage(BaseUrl, user, password, driver).login();
	}

}
