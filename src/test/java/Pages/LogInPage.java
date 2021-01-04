package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
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
		explicitWaitClickable(loginButton, driver).click();
		explicitWaitClickable(userNameField, driver).sendKeys(user);
		explicitWaitClickable(nextInEmailButton, driver).click();
		explicitWaitClickable(passField, driver).sendKeys(password);
		explicitWaitClickable(nextInPassButton, driver).click();
		return this;
	}

	public String getTitle() {
		if (driver.getTitle() != "MyShopper") {
			explicitWaitClickable(homeButton, driver);
		}
		return driver.getTitle();
	}

}
