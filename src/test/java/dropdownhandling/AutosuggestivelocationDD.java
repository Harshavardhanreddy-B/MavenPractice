package dropdownhandling;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.Dropdowns_objects;
import resources.base;

public class AutosuggestivelocationDD extends base {
	public static WebDriver driver;
	public Dropdowns_objects dd;

	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void MultipleDD() throws Exception {
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		dd = new Dropdowns_objects(driver);
		dd.AutoLocation().clear();
		dd.AutoLocation().sendKeys("Toronto");
		Thread.sleep(3000);
		String text;
		do {
			dd.AutoLocation().sendKeys(Keys.ARROW_DOWN);
			text = dd.AutoLocation().getAttribute("value");
			if(text.equals("Toronto, KS, USA"))
			{
				dd.AutoLocation().sendKeys(Keys.ENTER);
				break;
			}
		}while(!text.isEmpty());
		
		Thread.sleep(5000);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
