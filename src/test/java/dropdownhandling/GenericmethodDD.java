package dropdownhandling;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.Dropdowns_objects;
import resources.base;

public class GenericmethodDD extends base {

	public static WebDriver driver;
	public Dropdowns_objects dd;

	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test(dataProvider = "DDdata")
	public void MultipleDD(String data1, String data2, String data3) throws Exception {
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		dd = new Dropdowns_objects(driver);
		dropdownhandles(dd.NoOfEmployees(), data1);
		dropdownhandles(dd.Industries(), data2);
		dropdownhandles(dd.Country(), data3);
		Thread.sleep(5000);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public static void dropdownhandles(WebElement element, String value) {
		Select sec = new Select(element);

		List<WebElement> options = sec.getOptions();
		for (WebElement option : options) {
			if (option.getText().contains(value)) {
				option.click();
				break;
			}
		}
	}

	@DataProvider(name = "DDdata")
	public Object[][] DDdata() {
		return new Object[][] { { "451 - 500", "Education", "Bahamas" }, { "801 - 900", "Healthcare", "Bolivia" } };
	}
}
