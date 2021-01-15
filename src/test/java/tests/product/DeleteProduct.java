package tests.product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ProductPageActions;

public class DeleteProduct extends ProductsBase {
	String product = "pineapple";
	ProductPageActions page;

	@Test
	public void delete_product() {
		boolean actual = page.deleteProduct(product).getProduct(product) == null;
		Assert.assertTrue(actual);
	}

	@BeforeMethod
	public void addproduct() {
		page = new ProductPageActions(driver).addProduct(product);
	}
}
