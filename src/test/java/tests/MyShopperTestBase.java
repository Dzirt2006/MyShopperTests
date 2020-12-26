package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import frameworks.Screenshot;
import frameworks.loadingConfig.TestLoadManager;

public class MyShopperTestBase {
	public WebDriver driver;
	protected String BaseUrl;// = "http://the-internet.herokuapp.com/";
	protected String user;
	protected String password;

	@BeforeMethod
	public void beforeMethod(ITestContext context) {
		TestLoadManager manager = new TestLoadManager();
		getConfig(manager);
		getUserPass(manager);// don't forget to create userData.properties with your Username and Pass (because it's added to .gitignore)
		context.setAttribute("driver", driver);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		driver.close();
	}

	private void getConfig(TestLoadManager manager) {
		manager.loadConfigurations("configTheInternet.properties");
		driver = manager.driver;
		BaseUrl = manager.baseUrl;
	}

	private void getUserPass(TestLoadManager manager) {
		manager.loadConfigurations("userData.properties");
		user = manager.username;
		password = manager.password;
	}
}
