package frameworks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class Screenshot {

	private static String fileName(ITestContext iTestContext) {
		return iTestContext.getCurrentXmlTest().getClasses().stream().findFirst().get().getName()
				+ new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date().getTime());

	}

	public static void makeScreenshot(ITestContext obj, WebDriver driver) {
		String fileName = fileName(obj) + ".png";
		String direction = Paths.get(".").toAbsolutePath().normalize().toString() + "\\screenshots\\";
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(direction + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
