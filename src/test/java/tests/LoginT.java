package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LogInPage;

public class LoginT extends MyShopperTestBase {
	@Test
	public void login() {
		String expected = "MyShopper";
		String actual = new LogInPage(BaseUrl, user, password, driver).login().getTitle();
		Assert.assertEquals(expected, actual);
	}
}
