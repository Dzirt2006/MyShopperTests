package tests.product;

import org.testng.annotations.Test;

import Pages.ProductPageActions;

public class AddOneProduct extends ProductsBase {
	String product = "pineapple";

	@Test(invocationCount = 1)
	public void addOneProduct() {
		ProductPageActions page = new ProductPageActions(driver).addProduct(product);
	}
}
