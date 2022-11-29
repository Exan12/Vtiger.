package DynamicWebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CaptureOrganizationNames {

	@Test
	public void captureOrganizationNames()
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

		// Print the All Organization Names In the Console
		List<WebElement> Allorg = driver.findElements(By.xpath("//table[@class='lvt small']//tbody[1]//tr[*]//td[3]"));
		for(WebElement Oneorg : Allorg)
		{
			String OrganizationNames = Oneorg.getText();
			System.out.println(OrganizationNames);
		}
		// LogOut From The Applicaion
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();

		driver.findElement(By.linkText("Sign Out")).click();

		// Closing The Browser Window
		driver.quit();

	}

}
