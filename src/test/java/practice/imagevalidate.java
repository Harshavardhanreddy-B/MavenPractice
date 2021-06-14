package practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.someobjects;
import resources.base;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class imagevalidate extends base {
	public static WebDriver driver;
	public someobjects s;

	@BeforeClass
	public void start() throws Exception {
		driver = initializeDriver();
	}

	@Test
	public void img() throws Exception {
		driver.get("https://nextmegait.com/");
		Thread.sleep(5000);
		imageComparisonProcessing(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/a[1]/img[1]")));
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void imageComparisonProcessing(WebElement logoElement) throws IOException, InterruptedException {

		// Capture and store logo image
		Screenshot shot = new AShot().takeScreenshot(driver, logoElement);
		File file = new File(System.getProperty("user.dir") + "\\ImageFolder\\logo.png");
		System.out.println(file);
		ImageIO.write(shot.getImage(), "PNG", file);

		// Getting Expected Image
		BufferedImage expectedImg = ImageIO.read(file);

		// Getting Actual Image
		BufferedImage actualImg = shot.getImage();

		// Image Comparison
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff dif = imgDiff.makeDiff(actualImg, expectedImg);
		Assert.assertFalse(dif.hasDiff());
		/*if (dif.hasDiff()) {
			System.out.println("Both images are different");
		} else {
			System.out.println("Both images are same");
		}*/
	}

}
