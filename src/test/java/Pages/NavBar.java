package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworks.ElementSearcher;
import frameworks.Waiters;

public class NavBar implements Waiters, ElementSearcher {
	private WebDriver driver;
	private String homeXpath = "//div[@id='root']//div[@class='col-9']/button[@type='button']";
	private String logoutXpath = "//div[@id='root']/div[@class='container']/div[@class='row']//div[@class='container']/div[@class='row']/div[@class='col']/button[@type='button']";

	public NavBar(WebDriver driver) {
		this.driver = driver;
	}

	public void pressHome() {
		getHome().click();
//		getElementBylinkText(driver, "Home").click();
	}

	public void pressLogout() {
		getLogout().click();
	}

	public WebElement getHome() {
		return explicitWaitClickableByXpath(homeXpath, driver);
	}

	public WebElement getLogout() {
		return explicitWaitClickableByXpath(logoutXpath, driver);
	}
}
