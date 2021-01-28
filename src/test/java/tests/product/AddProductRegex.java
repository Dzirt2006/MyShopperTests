package tests.product;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductPageActions;

public class AddProductRegex extends ProductsBase {
	String product = "R!@e$#G%^e&*X()-=+,.<>\\/";
	String expected = product.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

	@Test
	public void addProductRegex() {
		boolean actualStatus = new ProductPageActions(driver).addProduct(product).getProduct(expected) != null;
		Assert.assertTrue(actualStatus);
	}
}
