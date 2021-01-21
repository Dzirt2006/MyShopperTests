package tests.api;

import org.testng.annotations.BeforeMethod;

import frameworks.loadingConfig.TestLoadManager;



public class APITestBase {

	protected String ROOT_URI;// = "https://reqres.in/";

	@BeforeMethod
	public void beforeMethod() {
		TestLoadManager manager = new TestLoadManager();
		manager.loadConfigurations("config.properties");
		ROOT_URI = manager.baseUrl;
	}
}
