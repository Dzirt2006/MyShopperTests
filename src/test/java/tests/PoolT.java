package tests;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.PoolsPageActions;

import org.testng.annotations.BeforeMethod;


public class PoolT extends MyShopperTestBase {
	
	@Test
	public void addPool() {
		String delete="bbk";
		new PoolsPageActions(driver).addPool(delete);
	}
	
	@Test
	public void deletePool() {
		String delete="bbk";
		new PoolsPageActions(driver).deletePool(delete);
	}
	
	@BeforeMethod
	public void beforeClass() {
		new LogInPage(BaseUrl, user, password, driver).login();
	}

}
