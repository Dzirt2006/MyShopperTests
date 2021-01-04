package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworks.Waiters;

public class LogInPage implements Waiters {

	private String url;
	private String user;
	private String password;
	WebDriver driver;

	public LogInPage(String url, String user, String password, WebDriver driver) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/form/center/button")
	WebElement loginButton;

	@FindBy(id = "identifierId")
	WebElement userNameField;

	@FindBy(xpath = "//*[@id='identifierNext']/div/button")
	WebElement nextInEmailButton;

	@FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	WebElement passField;

	@FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button")
	WebElement nextInPassButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[1]/button")
	WebElement homeButton;

	public LogInPage login() {
		driver.get(url);
		explicitWait(loginButton, driver).click();
		explicitWait(userNameField, driver).sendKeys(user);
		explicitWait(nextInEmailButton, driver).click();
		explicitWait(passField, driver).sendKeys(password);
		explicitWait(nextInPassButton, driver).click();
		return this;
	}

	public String getTitle() {
		if (driver.getTitle() != "MyShopper") {
			explicitWait(homeButton, driver);
		}
		return driver.getTitle();
	}

}
