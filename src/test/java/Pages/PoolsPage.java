package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import frameworks.ElementSearcher;
import frameworks.Searchers;

public class PoolsPage implements ElementSearcher {
	WebDriver driver;

	public PoolsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3000), this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[3]/center/div/form/div/div[2]/button")
	WebElement addPoolButton;

	@FindBy(id = "formBasic")
	WebElement inputField;

	@FindBy(className = "list-group-item")
	List<WebElement> pools;

}
