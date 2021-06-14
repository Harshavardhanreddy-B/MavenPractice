package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.base;

public class InputFields extends base {
	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test(priority = 1, enabled = true)
	public void inputdata() throws Exception {
		driver.get("https://www.travolook.in/rescheduling");
		WebElement id = driver.findElement(By.xpath("//*[@id=\"txtbookingid\"]"));
		id.sendKeys("124578963");
		Thread.sleep(5000);
		id.clear();
		Thread.sleep(5000);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
