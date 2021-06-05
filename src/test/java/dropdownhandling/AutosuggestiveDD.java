package dropdownhandling;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.Dropdowns_objects;
import resources.base;

public class AutosuggestiveDD extends base {
	public static WebDriver driver;
	public Dropdowns_objects dd;

	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void MultipleDD() throws Exception {
		driver.get("https://www.google.com/");
		dd = new Dropdowns_objects(driver);
		dd.Auto().sendKeys("Java");
		Thread.sleep(3000);
		List<WebElement> ops = dd.AutoList();
		System.out.println(ops.size());
		for(WebElement options:ops)
		{
			if(options.getText().contains("online"))
			{
				options.click();
				break;
			}
		}
		
		Thread.sleep(5000);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
