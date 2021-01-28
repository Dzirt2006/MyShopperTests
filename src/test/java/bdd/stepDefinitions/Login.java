package bdd.stepDefinitions;

import Pages.LogInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseHook {
	LogInPage page;

	@Before()
	public void getDataFromProps() {
		System.out.println("AUCHTUNG!");
		before();
	}

	@Given("I am on home page")
	public void i_am_on_home_page() {
		page = new LogInPage(BaseUrl, user, password, driver);
	}

	@When("I am loggining using my credentials")
	public void i_am_loggining_using_my_credentials() {
		page.login();
	}

	@Then("I will redirect to home page")
	public void i_will_redirect_to_home_page() {
		page.getTitle();
	}

	@After
	public void afterScenario() {
		after();
	}

}
