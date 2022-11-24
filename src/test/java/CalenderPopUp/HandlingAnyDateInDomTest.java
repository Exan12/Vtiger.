package CalenderPopUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingAnyDateInDomTest {
	
	@Test
	public void handlingAnyDateInDomTest() throws InterruptedException
	{
		// Enter Into The Make My Trip
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		
		Actions act = new Actions(driver);
		act.moveByOffset(10,10).click().perform();
			
		// Navigate to From And To City
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dest = driver.findElement(By.xpath("//input[@id='toCity']"));
		
		Thread.sleep(2000);
		
		// Enter From City
		src.sendKeys("Benguluru");
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		// Enter To City
		dest.sendKeys("Hyderabad");
		driver.findElement(By.xpath("//p[text()='Hyderabad, India']")).click();
		
		Thread.sleep(2000);
		
		// Enter the Date
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(1000);
		WebElement date = driver.findElement(By.xpath("//div[@aria-label='Fri Nov 25 2022']"));
		date.click();
		
	}

}
