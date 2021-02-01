package tests.product;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.ProductPageActions;

public class ProductNameRegex extends ProductsBase {
	String product = "R!@e$#G%^e&*X()-=+,.<>\\/";
	String expected = product.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	ProductPageActions page;

	@Test
	public void productNameRegex() {
		boolean actual = page.getProduct(expected) != null;
		
		Assert.assertTrue(actual);
	}

	@BeforeMethod
	public void addproduct() {
		page = new ProductPageActions(driver).addProduct(product);
	}
}
