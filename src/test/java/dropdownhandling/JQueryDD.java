package dropdownhandling;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.Dropdowns_objects;
import resources.base;

public class JQueryDD extends base {
	public static WebDriver driver;
	public Dropdowns_objects dd;

	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void MultipleDD() throws Exception {
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		dd = new Dropdowns_objects(driver);
		dd.JqueryDD().click();
		// selectchoices(driver, "choice 2");
		// Thread.sleep(5000);
		// selectchoices(driver, "choice 6", "choice 7", "choice 4");
		// Thread.sleep(5000);
		selectchoices(driver, "all");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void selectchoices(WebDriver driver, String... value) {

		List<WebElement> options = dd.JqueryDDlist();
		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement item : options) {
				String text = item.getText();
				for (String val : value) {
					if (text.equals(val)) {
						item.click();
						break;
					}
				}
			}
		} else {
			try {
				for (WebElement item : options) {
					item.click();
				}
			} catch (Exception e) {
			}

		}
	}

}
