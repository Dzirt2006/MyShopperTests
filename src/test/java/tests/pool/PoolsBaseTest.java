package tests.pool;

import org.testng.annotations.BeforeClass;


import Pages.LogInPage;
import tests.MyShopperTestBase;

public class PoolsBaseTest extends MyShopperTestBase {

	@BeforeClass
	public void beforeMethod() {
		new LogInPage(BaseUrl, user, password, driver).login();
	}

}
