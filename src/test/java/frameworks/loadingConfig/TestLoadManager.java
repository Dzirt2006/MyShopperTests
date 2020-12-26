package frameworks.loadingConfig;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class TestLoadManager {
	public WebDriver driver;
	public String baseUrl;
	private String driverName;
	public String dbName;
	public String username;
	public String password;
	public String query;

	public void loadConfigurations(String fileName) {
		HashMap<String, String> configs = null;
		try {
			configs = new ConfigurationProvider().getDataFromTheFile(fileName);
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}
		baseUrl = configs.get(ConfigurationParameters.Url);
		driverName = configs.get(ConfigurationParameters.Driver);
		if(driverName!=null) {
			driver = new DriverManager(driverName).getDriver();
		}
		username = configs.get(ConfigurationParameters.username);
		password = configs.get(ConfigurationParameters.password);
	}

}
