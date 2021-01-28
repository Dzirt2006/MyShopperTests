package bdd.stepDefinitions;

import org.openqa.selenium.WebDriver;
import frameworks.loadingConfig.TestLoadManager;

public class BaseHook {
	public WebDriver driver;
	protected String BaseUrl;// = "http://the-internet.herokuapp.com/";
	protected String user;
	protected String password;

	public void before() {
		TestLoadManager manager = new TestLoadManager();
		getConfig(manager);
		getUserPass(manager);// don't forget to create userData.properties with your Username and Pass
								// (because it's added to .gitignore)
	}

	public void after() {
		driver.close();
	}

	private void getConfig(TestLoadManager manager) {
		manager.loadConfigurations("config.properties");
		driver = manager.driver;
		BaseUrl = manager.baseUrl;
	}

	private void getUserPass(TestLoadManager manager) {
		manager.loadConfigurations("userData.properties");
		user = manager.username;
		password = manager.password;
	}
}
