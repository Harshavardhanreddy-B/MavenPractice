package dropdownhandling;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.Dropdowns_objects;
import resources.base;

public class bootstrapdd extends base {
	public static WebDriver driver;
	public Dropdowns_objects dd;

	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void MultipleDD() throws Exception {
		driver.get("https://www.hdfcbank.com/");
		dd = new Dropdowns_objects(driver);
		dd.BsProduct().click();
		bootstrapdropdownhandles(dd.BsProductList(), "Loans");
		dd.BsSelectProduct().click();
		bootstrapdropdownhandles(dd.BsSelectProductList(),"Recurring Deposit");
		Thread.sleep(5000);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	public static void bootstrapdropdownhandles(List<WebElement> element, String value) {

		for (WebElement option : element) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}
}
