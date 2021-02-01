package frameworks.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworks.ProductGenerator;

public class generateListOfNames {
	final int listSize = 4;
	ProductGenerator gen;
	List<String> listOfName;

	@Test
	public void generated_list_size() {
		int actualSize = listOfName.size();
		Assert.assertEquals(actualSize, listSize);
	}

	@Test
	public void dublicates_in_list() {
		Set<String> setOfNames = new HashSet<String>(listOfName);
		Assert.assertEquals(setOfNames.size(), listOfName.size());
	}

	@BeforeMethod
	public void generateList() {
		gen = new ProductGenerator();
		listOfName = gen.fillUpList(listSize);
	}
}
