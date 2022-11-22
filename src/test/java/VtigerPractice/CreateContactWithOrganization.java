package VtigerPractice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Vtiger.GenericLibraries.PropertyFileLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable 
	{
		// Create Random Number
		Random ran = new Random();
		int num = ran.nextInt(1000);
		System.out.println(num);
		
		// Read the data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
	    prop.load(fis);
		String BROWSER = prop.getProperty("browser");
	    WebDriver driver = null;
	    
		// Launching the Browser 
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	System.out.println("==="+BROWSER+" is Launched === ");
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    	System.out.println("==="+BROWSER+" is Launched === ");
	    }
	    else
	    {
	    	System.out.println("Inavali browser launched");
	    }
	    
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Using Property file Utilty
		PropertyFileLibrary pUtil = new PropertyFileLibrary();
		String URL = pUtil.getpropertyfile("url");
		driver.get(URL);
		
		// Login to the Application
		String USERNAME = pUtil.getpropertyfile("username");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		String PASSWORD = pUtil.getpropertyfile("password");
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		driver.findElement(By.id("submitButton")).click();
		
		// Click on the Organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		// Click on the Organization Lookup Button
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		// Create the Organization
		driver.findElement(By.name("accountname")).sendKeys("ACCENTURE"+" "+num);
		
		// Save
		driver.findElement(By.name("button")).click();
		
		// Verification
	    String ORGNAME = driver.findElement(By.id("dtlview_Organization Name")).getText();
		System.out.println(ORGNAME);
		String ORGHEADER = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		System.out.println(ORGHEADER);
		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println("New ORGANIZATION Created ---> PASS");
		}
		else
		{
			System.out.println("New ORGANIZATION not created ----> FAIL");
		}
		
		// Click on Contacts Link
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		
		// Click on Contacts Lookup Button
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		// Create the Contact
		driver.findElement(By.name("lastname")).sendKeys("AUTOMATION TESTER"+" "+num);
		
		// Click on the organization Name (Organization Lookup button)
		driver.findElement(By.xpath("//tbody/tr[5]/td[2]/img[1]")).click();
		
		// Navigate from parennt to child Window
		Set<String> allwhs = driver.getWindowHandles();
		for(String wh:allwhs)
		{
			String title = driver.switchTo().window(wh).getTitle();
			if(title.contains("=Accounts&"))
			{
				Thread.sleep(1000);
				System.out.println("Entered into child window");
			}
		}
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).click();
		
		driver.findElement(By.linkText(ORGNAME)).click();
		
		// Naviagate from Child to Parent Window
		Set<String> allwhss = driver.getWindowHandles();
		for(String x:allwhss)
		{
			String mainTitle = driver.switchTo().window(x).getTitle();
			if(mainTitle.contains("Contacts"))
			{
				
				Thread.sleep(1000);
				System.out.println("Entered to parent window");
			}
		}
		
		// Save
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		// Contacts Module Verification
		String CONNAME = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		System.out.println(CONNAME);
		String CONHEADER = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
		System.out.println(CONHEADER);
		if(CONHEADER.contains(CONNAME))
		{
				System.out.println("New CONTACT created ---> PASS");
		}
		else
		{
				System.out.println("New CONTACT not created ----> FAIL");
		}
		
		//Logout
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(mouseHover).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
				
	}

}
