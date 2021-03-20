package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import frameworks.MultipleSearchers;
import frameworks.Waiters;

public class PoolsPage implements MultipleSearchers, Waiters {
	WebDriver driver;

	public PoolsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[3]/center/div/form/div/div[2]/button")
	WebElement addPoolButton;

	@FindBy(id = "formBasic")
	WebElement inputField;

	@FindBy(className = "list-group-item")
	List<WebElement> pools;

	/**
	 * use when we have to create one pool and want to delete it otherwise pools
	 * will contain deleted pool
		 * @return List<WebElement>
	 */
	public List<WebElement> getPoolsList() {
		List<WebElement> list = null;
		try {
			list = explicitWaitVisibleList(getListByClassName(driver, "list-group-item"), driver);
		} catch (org.openqa.selenium.TimeoutException err) {
			System.out.println("There is no any pools");
		}
		return list;
	}

}
