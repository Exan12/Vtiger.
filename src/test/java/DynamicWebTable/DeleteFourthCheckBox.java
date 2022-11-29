package DynamicWebTable;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DeleteFourthCheckBox {

	@Test
	public void deleteFourthheckBox()
	{
		// Login To The Application
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// Navigate To Organization Module
		driver.findElement(By.linkText("Organizations")).click();

		// Delete The Fourth Checkbox Organization
		driver.findElement(By.xpath("//table[@class='lvt small']//tbody[1]/tr[5]//input[@type='checkbox']")).click();
		driver.findElement(By.linkText("del")).click();
		Alert al = driver.switchTo().alert();
		al.accept();
		System.out.println("Successfully Deleted Fourth Checkbox ---> PASS");
		
		
		// LogOut From The Applicaion
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();

		driver.findElement(By.linkText("Sign Out")).click();

		// Closing The Browser Window
		driver.quit();
	}

}

