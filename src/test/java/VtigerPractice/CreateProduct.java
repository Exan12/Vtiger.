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

public class CreateProduct {

	public static void main(String[] args) throws Throwable 
	{
		 //Random number
		 Random r = new Random();
		 int num = r.nextInt(150);
		 System.out.println(num);
		
		 //Launching chrome browser
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
		
		//Navigate to the Products Module
		driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
		
		//Click on Product Lookup Icon Button
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		
		//Enter Product details
		driver.findElement(By.name("productname")).sendKeys("XIAOMI LAPTOPS - HYDERABAD"+" "+num);
		
		//Save the Product details
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//Logout
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(mouseHover).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		
	}

}
