package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\data\\data.properties");
		prop.load(fis);
		// String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String Testcasename, WebDriver driver) throws IOException {
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + Testcasename
				+ formatter.format(calender.getTime()) + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

	public void highlightElement(WebElement ele) throws InterruptedException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// use executeScript() method and pass the arguments
			// Here i pass values based on css style. Yellow background color with solid red
			// color border.
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);

		} catch (Exception e) {
			System.out.println("Exception - " + e.getMessage());
		}
	}

}
