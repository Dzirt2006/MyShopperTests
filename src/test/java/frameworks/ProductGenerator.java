package frameworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGenerator implements INameGeneratable {

	@Override
	public String generateName(int strLength) {
		StringBuilder temp = new StringBuilder(strLength);
		for (int i = 0; i < strLength; i++) {
			char c = salt.charAt(new Random().nextInt(strLength));
			temp.append(c);

		}
		return temp.toString();
	}

	@Override
	public List<String> fillUpList(int amount) {
		List<String> listOfproducts = new ArrayList<String>();
		for (int i = 0; i < amount; i++) {
			int nameLength = getRandomInteger(3, 10);
			String generatedStr = generateName(nameLength);
			listOfproducts.add(generatedStr);
		}
		return listOfproducts;
	}

	public static int getRandomInteger(int min, int max) {
		return ((int) (Math.random() * (max - min))) + min;
	}

}
