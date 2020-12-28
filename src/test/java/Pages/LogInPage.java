package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.MyShopperTestBase;

public class LogInPage {

	private String url;
	private String user;
	private String password;
	WebDriver driver;
	WebDriverWait wait;

	public LogInPage(String url, String user, String password, WebDriver driver) {
		super();
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
		w8(loginButton).click();
		w8(userNameField).sendKeys(user);
		w8(nextInEmailButton).click();
		w8(passField).sendKeys(password);
		w8(nextInPassButton).click();
		return this;
	}

	public String getTitle() {
		if (driver.getTitle() != "MyShopper") {
//			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			w8(homeButton);
		}
		return driver.getTitle();
	}

	private WebElement w8(WebElement element) {
		if (wait == null) {
			wait = new WebDriverWait(driver, 3000);
		}
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

}
