package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdowns_objects {
	
	public WebDriver driver;
	
	private By noofemployess = By.xpath("//select[@id = 'Form_submitForm_NoOfEmployees']");
	private By industries = By.xpath("//select[@id = 'Form_submitForm_Industry']");
	private By country = By.xpath("//select[@id = 'Form_submitForm_Country']");
	private By bsproduct = By.xpath("(//a[@class='btn-primary dropdown-toggle btn-block'])[1]");
	private By bsproductlist = By.xpath("//ul[@class='dropdown1 dropdown-menu']//li");
	private By bsselectproduct = By.xpath("(//a[@class='btn-primary dropdown-toggle btn-block'])[2]");
	private By bsselectproductlist = By.xpath("//ul[@class='dropdown2 dropdown-menu']//li");
	private By jqueryDD = By.xpath("//input[@id = 'justAnInputBox']");
	private By jqueryDDlist = By.xpath("//li//span[@class='comboTreeItemTitle']");
	private By auto1 = By.xpath("//input[@class='gLFyf gsfi']");
	private By autolist = By.xpath("//li[@class='sbct']");
	private By autolocation = By.xpath("//input[@id='autocomplete']");
	public Dropdowns_objects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement NoOfEmployees()
	{
		return driver.findElement(noofemployess);
	}
	public WebElement Industries()
	{
		return driver.findElement(industries);
	}
	public WebElement Country()
	{
		return driver.findElement(country);
	}
	public WebElement BsProduct()
	{
		return driver.findElement(bsproduct);
	}
	public List<WebElement> BsProductList()
	{
		return driver.findElements(bsproductlist);
	}
	public WebElement BsSelectProduct()
	{
		return driver.findElement(bsselectproduct);
	}
	public List<WebElement> BsSelectProductList()
	{
		return driver.findElements(bsselectproductlist);
	}
	public WebElement JqueryDD()
	{
		return driver.findElement(jqueryDD);
	}
	public List<WebElement> JqueryDDlist()
	{
		return driver.findElements(jqueryDDlist);
	}
	public WebElement Auto()
	{
		return driver.findElement(auto1);
	}
	public List<WebElement> AutoList()
	{
		return driver.findElements(autolist);
	}
	public WebElement AutoLocation()
	{
		return driver.findElement(autolocation);
	}
	
}
