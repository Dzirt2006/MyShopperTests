package frameworks;

import java.util.List;

public interface INameGeneratable {
	static final String salt = "abcdefghijklmnopqrstuvxyz";

	String generateName(int strLength);

	List<String> fillUpList(int amount);
}
