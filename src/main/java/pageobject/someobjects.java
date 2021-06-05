package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class someobjects {
	public WebDriver driver;
	
	private By links = By.tagName("a");
	
	public someobjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> Links()
	{
		return driver.findElements(links);
	}
}
