package frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface PageActionable extends JSExecutor {

	default void waitCompletePageLoad(WebDriver driver) {
		String script = "return document.readyState";
		new WebDriverWait(driver, 3000).until(func->jsExec(driver, script).equals("complete"));
	}

}
