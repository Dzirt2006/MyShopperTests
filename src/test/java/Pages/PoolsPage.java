package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoolsPage {
	WebDriver driver;

	public PoolsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[3]/center/div/form/div/div[2]/button")
	WebElement addPool;

	@FindBy(id = "formBasic")
	WebElement inputField;

	@FindBy(className = "poolList")
	List<WebElement> poolsList;

	public List<WebElement> getListOfElements() {
		return poolsList;
	}

}
