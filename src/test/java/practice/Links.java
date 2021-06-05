package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.someobjects;
import resources.base;

public class Links extends base {
	public static WebDriver driver;
	public someobjects s;

	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void MultipleDD() throws Exception {
		driver.get("https://www.hottohire.com/");
		s = new someobjects(driver);
		List<WebElement> links = s.Links();
		int brokenlinks = 0;
		int Validlinks = 0;
		for (WebElement Element : links) {
			String url = Element.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("Url is Empty");
				continue;
			}
			URL link = new URL(url);
			HttpURLConnection con = (HttpURLConnection) link.openConnection();
			con.connect();
			if (con.getResponseCode() >= 400) {
				System.out.println(con.getResponseCode() + " " + url + " " + "is" + "Broken Link");
				brokenlinks++;
			}else
			{
				System.out.println(con.getResponseCode() + " " + url + " " + "is" + "Valid Link");
				Validlinks++;
			}
		}
			System.out.println(brokenlinks);
			System.out.println(Validlinks);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
