package Vtiger.ProductsModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Vtiger.GenericLibraries.ExcelFileLibrary;
import Vtiger.GenericLibraries.JavaLibrary;
import Vtiger.GenericLibraries.PropertyFileLibrary;
import Vtiger.GenericLibraries.WebDriverLibrary;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductWithVendorTest {

	@Test
	public void createProductWithVendorTest() throws Throwable {

		WebDriver driver = null;

		// Create an Object for all Generic Libraries
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();

		// Read all the necessary data from Property File
		String BROWSER = pLib.getpropertyfile("browser");
		String URL = pLib.getpropertyfile("url");

		// Read the Necessary Data from Excel File
		String PRODUCTNAME = eLib.readDataFromExcel("Products", 1, 2)+" "+jLib.getRandomNumber();
		String VENDORNAME = eLib.readDataFromExcel("Products", 4, 3)+" "+jLib.getRandomNumber();

		// Launch The Browser
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("= = = The " + BROWSER + " has launched Succesfully = = =");
		} else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("= = = The " + BROWSER + " Has Launched Succesfully = = =");
		} else 
		{
			System.out.println("= = = INVALID BROWSER NAME = = =");
		}

		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);

		// Login to the application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		System.out.println("Logged in to the application");

		// Navigate to Vendors Module
		WebElement MORE = driver.findElement(By.linkText("More"));
		wLib.mouseHoverOn(driver, MORE);

		driver.findElement(By.linkText("Vendors")).click();
		System.out.println("Navigated to Vendors Module");
		
		// Navigate to the Vendor Module Lookup Icon Button
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		System.out.println("Clicked on Vendor Module Lookup Icon Button");

		// Enter the Mandatory Details in Vendors Module
		driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
		System.out.println("Mandatory Details are entered in Vendors Module");
		
		// Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println("Saved the Vendor");

		// Validation
		String VENDORHEADER = driver.findElement(By.xpath("//span[@class ='lvtHeaderText']")).getText();
		if (VENDORHEADER.contains(VENDORNAME)) 
		{
			System.out.println("Vendor Created ----> PASS");
		} else 
		{
			System.out.println("Vendor Not Created ---- > FAIL");
		}

		// Navigate the Products Module Link
		driver.findElement(By.linkText("Products")).click();
		System.out.println("Navigated to the Products Module Link");
		
		// Navigate to the Products Module Lookup Icon Button
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		System.out.println("Clicked on Products Module Lookup Icon Button");
		
		// Enter the Mandatory Details in Products Module
		driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
		System.out.println("Mandatory Details are entered Products Module");
		
		// Adding Vendor Name into Product Module
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		// Traverse from parent to Child
		wLib.switchToWindow(driver, "Vendors");
		System.out.println("Switched to child window (VENDOR)");
		driver.findElement(By.name("search_text")).sendKeys(VENDORNAME);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.linkText(VENDORNAME)).click();
		
		// Traverse from child to parent Window
		wLib.switchToWindow(driver, "Products");
		System.out.println("Switched to Parent window (PRODUCTS)");
		
		System.out.println("Added Vendor Name into Product Module");
		
		// Save Button
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		System.out.println("Saved the Product");
		
		// Validation
		String PRODUCTHEADER = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (PRODUCTHEADER.contains(PRODUCTNAME)) 
		{
			System.out.println("PASS");
		} else
		{
			System.out.println("FAIL");
			wLib.takeScreenshot(driver,"createProductWithVendorTest");
		}
		
		// Close the browser
		driver.close();
		System.out.println("Browser has closed Succesfully");

	}

}
