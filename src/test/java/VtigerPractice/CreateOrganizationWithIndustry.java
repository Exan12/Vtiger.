package VtigerPractice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws Throwable 
	{
		//Random number
		Random r = new Random();
		int num = r.nextInt(150);
		System.out.println(num);
		
	     // Step - 1 : Launch the browser
		 WebDriver driver = new ChromeDriver();
		
		 //Read the data from propertyfile
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		 Properties prop = new Properties();
		 prop.load(fis);
		 String BROWSER = prop.getProperty("browser");
		 System.out.println(BROWSER);
		 
		 String URL = prop.getProperty("url");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(URL);
		 
		 // Login to the Application
		 String USERNAME = prop.getProperty("username");
		 String PASSWORD = prop.getProperty("password");
		 
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
				
		// Step - 3 : Navigate to the Organization Link
		driver.findElement(By.linkText("Organizations")).click();
				
		// Step - 4 : Click on the create Organization Lookup image
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
				
		// Step - 5 : Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("BUNGE INDIA PVT LTD 1"+" "+num);
		
		// Step - 6 : Select Health care in Industry Drop down
		WebElement ddAddr = driver.findElement(By.name("industry"));
	    Select sel = new Select(ddAddr);
	    sel.selectByVisibleText("Healthcare");
				
		// Step - 7 : Save
		driver.findElement(By.name("button")).click();
				
		// Step - 8 : Logout
		Actions ac = new Actions(driver);
		WebElement x = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		ac.moveToElement(x).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
	}

}
