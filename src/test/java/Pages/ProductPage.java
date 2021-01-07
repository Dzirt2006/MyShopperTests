package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import frameworks.ElementSearcher;
import frameworks.Waiters;

public abstract class ProductPage implements Waiters, ElementSearcher {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3000), this);
	}

	@FindBy(xpath = "//div[@id='root']//h4")
	private WebElement poolNameElement;

	@FindBy(xpath = "/html//div[@id='root']/div[3]/div[2]/form//button[@type='submit']")
	private WebElement addProductButton;

	@FindBy(id = "formBasic")
	private WebElement inputField;

	@FindBy(className = "list-group list-group-flush")
	private List<WebElement> products;

	public WebElement getPoolNameElement() {
		return poolNameElement;
	}

	public WebElement getAddProductButton() {
		return addProductButton;
	}

	public WebElement getInputField() {
		return inputField;
	}

	public List<WebElement> getProducts() {
		return products;
	}

}
