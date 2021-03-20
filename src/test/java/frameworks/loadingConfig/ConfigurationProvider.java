package frameworks.loadingConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigurationProvider {

	public HashMap<String, String> getDataFromTheFile(String fileName) throws IOException {
		InputStream inputStream = null;
		Properties props = new Properties();
		try {
			// against ConfigurationProvider.class can use gelClass()
			inputStream = ConfigurationProvider.class.getClassLoader().getResourceAsStream(fileName);
			if (inputStream == null) {
				System.out.println("FILE NOT FOUND! " + fileName);
				throw new FileNotFoundException(fileName + " not found");
			}
			props.load(inputStream);
		} finally {
			inputStream.close();
		}

		HashMap<String, String> dataMap = new HashMap<String, String>();

		for (String key : props.stringPropertyNames()) {
			dataMap.put(key, props.getProperty(key));
		}

		return dataMap;
	}
}
