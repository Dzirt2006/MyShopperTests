package tests.product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.ProductPageActions;
import frameworks.FailListener;

//@Listeners(FailListener.class)
public class AddDublicateProduct extends ProductsBase {
	String product = "pineapple";
	ProductPageActions page;

	@Test(invocationCount = 1)
	public void addDublicateProduct() {
		String actual = page.addProduct(product).getProductNameFromAlert(product);
		Assert.assertEquals(actual, product);
	}

	@BeforeMethod
	public void addProduct() {
		page = new ProductPageActions(driver).addProduct(product);
	}

}
