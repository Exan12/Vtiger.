package Vtiger.OpportunityModule;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Vtiger.GenericLibraries.PropertyFileLibrary;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunityTest {
	
	WebDriver driver;
	
	@Test
	public void createOpportunityTest() throws Throwable
	{
		// Write required Generic Libraries
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		
		// Read all the necessary Data
		String BROWSER = pLib.getpropertyfile("browser");
		String URL = pLib.getpropertyfile("url");
		
		// Launch The Browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("= = = The"+BROWSER+"Browser Launched Succesfully = = =");
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("= = = The"+BROWSER+"Browser Launched Succesfully = = =");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		// Login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin","admin");
	}

}
