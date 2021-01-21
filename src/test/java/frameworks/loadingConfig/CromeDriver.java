package frameworks.loadingConfig;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CromeDriver implements LinuxChecker {

	public WebDriver getPureChromeDriver() {
		if (!isLinux()) {
			URL url = ClassLoader.getSystemResource("chromedriver.exe");
			System.out.println(url);
			System.setProperty("webdriver.chrome.driver", url.getFile());
		}
		WebDriver chrome=new ChromeDriver();
		return chrome;
	}

}
