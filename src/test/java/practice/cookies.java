package practice;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.base;

public class cookies extends base {
	public static WebDriver driver;

	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void MultipleDD() throws Exception {
		driver.get("https://www.google.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "  " + cookie.getValue());
		}
		Cookie cokobj = new Cookie("Harsha", "6385");
		driver.manage().addCookie(cokobj);
		System.out.println(cookies.size());
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "  " + cookie.getValue());
		}
		driver.manage().deleteCookie(cokobj);
		System.out.println(cookies.size());
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "  " + cookie.getValue());
		}

		driver.manage().deleteAllCookies();
		System.out.println(cookies.size());
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "  " + cookie.getValue());
		}

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
