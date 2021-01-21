package API.OAUTh2;


import org.testng.annotations.Test;

import frameworks.loadingConfig.TestLoadManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NewTest {
	protected String BaseUrl;// = "http://the-internet.herokuapp.com/";
	protected String user;
	protected String password;
	private String clientId ;
	private String clientSecret ;

	@Test
	public void f() {
		TestLoadManager manager = new TestLoadManager();
		getConfig(manager);
		getUserPass(manager);
		RestAssured.baseURI="https://my-shopper.herokuapp.com/auth/";
		RestAssured.authentication=RestAssured.preemptive().basic(user, password);
		Response resp=RestAssured.given()
				.formParam("clientID",
						"")
				.formParam("clientSecret", "")
				.get("https://my-shopper.herokuapp.com/auth/me");
	
		System.out.println(resp.jsonPath().prettify());
	}

	private void getConfig(TestLoadManager manager) {
		manager.loadConfigurations("config.properties");
		BaseUrl = manager.baseUrl;
	}

	private void getUserPass(TestLoadManager manager) {
		manager.loadConfigurations("userData.properties");
		user = manager.username;
		password = manager.password;
	}
}
