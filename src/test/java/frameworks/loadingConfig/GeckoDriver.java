package frameworks.loadingConfig;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// on linux better sudo apt-get install firefox-geckodriver

public class GeckoDriver implements LinuxChecker {
	protected WebDriver getPureGeckoDriver() {
		if (!isLinux()) {
			URL url = ClassLoader.getSystemResource("geckodriverWindows.exe");
			System.setProperty("webdriver.gecko.driver", url.getFile());
		}
		return new FirefoxDriver();
	}
}
