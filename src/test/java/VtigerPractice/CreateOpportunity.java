package VtigerPractice;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOpportunity {

	public static void main(String[] args) throws InterruptedException 
	{
		// Create Random Method
		Random ran = new Random();
		int num = ran.nextInt(1000);
		System.out.println(num);
		
		// Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		// Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Validation of Login Page
		String actualTitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Login done Successfully -----> PASS");
		}
		else
		{
			System.out.println("Login not done Successfully -----> FAIL");
		}
		
		// Navigate to the Contacts Module
		driver.findElement(By.linkText("Contacts")).click();
		System.out.println("Clicked on Contacts Module");
		
		// Click on the Contacts Lookup Icon Buttton
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		System.out.println("Clicked on Contacts Lookup Icon Buttton");
		
		// Enter the LastName
		driver.findElement(By.name("lastname")).sendKeys("ANMOL"+" "+num);
		System.out.println("Entered the LastName");
		
		// Click on Save Button
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		System.out.println("Clicked on Save Button");
		
		// Validation of Contacts Module
		String CONNAME = driver.findElement(By.id("dtlview_Last Name")).getText();
		String CONHEADER = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(CONHEADER.contains(CONNAME))
		{
			System.out.println("Contact is Created ----> PASS");
		}
		else
		{
			System.out.println("Contact is not Created ----> FAIL");
		} 
		
		// Navigate to Campaigns Module
		WebElement more = driver.findElement(By.linkText("More"));
		Actions ac = new Actions(driver);
		ac.moveToElement(more).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		System.out.println("Clicked on Campaigns Module");
		
		// Click on Campaigns Lookup Icon Button
		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		System.out.println("Clicked on Campaigns Lookup Icon Button");
		
		// Enter Campaign Name
		driver.findElement(By.name("campaignname")).sendKeys("PAPER ADD"+" "+num);
		System.out.println("Entered Campaign Name");
		
		// Click on Save Button
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		System.out.println("Clicked on Save Button");
		
		// Validation of Campaign Module
		String CMPNAME = driver.findElement(By.id("mouseArea_Campaign Name")).getText();
		System.out.println(CMPNAME);
		String CMPHEADER = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		System.out.println(CMPHEADER);
		
		Thread.sleep(10000);
		if(CMPHEADER.contains(CMPNAME))
		{
			Thread.sleep(10000);
			System.out.println("Campaign is Created ----> PASS");
		}
		else
		{
			System.out.println("Campaign is not Created ----> FAIL");
		} 
		
		// Navigate to the Opportunities Module
		driver.findElement(By.linkText("Opportunities")).click();
		System.out.println("Clicked on Opportunities Module");
		
		// Click on Opportunities Lookup Icon Button
		driver.findElement(By.xpath("//img[@alt=\"Create Opportunity...\"]")).click();
		System.out.println("Clicked on Opportunities Lookup Icon Button");
		
		//Enter the Opportunity Name
		driver.findElement(By.name("potentialname")).sendKeys("GLOBAL SECURITY AGENCY"+" "+num);
		System.out.println("Entered Opportunity Name");
		
		// Select Related To
		WebElement ddAddr = driver.findElement(By.id("related_to_type"));
		Select sel = new Select(ddAddr);
		sel.selectByVisibleText("Contacts");
		System.out.println("selected Contacts Related To"); 
		
		// Adding Contact Name
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		// Traversing from Parent to Contacts Module Child Window
		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh)
		{
			String Title = driver.switchTo().window(wh).getTitle();
			if(Title.contains("Accounts"))
			{
				System.out.println("Traversed to Contacts Child Window");
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(CONNAME);
		System.out.println("Entered the contact name into Search box");
		driver.findElement(By.name("search")).click();
		System.out.println("Clicked the search Now Button");
		driver.findElement(By.xpath("//a[text()=' "+CONNAME+"']")).click();
		
		//Traversing Contacts child window to Parent Window
		Set<String> allwhs = driver.getWindowHandles();
		for(String wh1:allwhs)
		{
			String Title = driver.switchTo().window(wh1).getTitle();
			if(Title.contains("Potentials"))
			{
				System.out.println("Traversed to Parent Window");
			}
		} 
		
		System.out.println("Contact name is Added to the Related to field in Opportunites Module");
		
		// Adding Type
		WebElement ddAddr1 = driver.findElement(By.name("opportunity_type"));
		Select sel1 = new Select(ddAddr1);
		sel1 .selectByVisibleText("Existing Business");
		System.out.println("Type Added Succesfully");
		
		// Adding Lead Source
	    WebElement ddAddr2 = driver.findElement(By.name("leadsource"));
	    Select sel2 = new Select(ddAddr2);
	    sel2.selectByVisibleText("Employee");
	    System.out.println("Lead source is added succesfully");
	    
		// Adding Campaign Source
	    driver.findElement(By.xpath("//tbody/tr[8]/td[2]/img[1]")).click();
	    
	    // Traversing from parent to Campaigns child module
	    Set<String> allwhs1 = driver.getWindowHandles();
	    for(String wh:allwhs1)
	    {
	    	String Title = driver.switchTo().window(wh).getTitle();
	    	if(Title.contains("Campaigns"))
	    	{
	    		System.out.println("Entered into Campaigns child module");
	    		
	    	}
	    }
	    
	    driver.findElement(By.name("search_text")).sendKeys(CMPNAME);
		System.out.println("Entered the contact name into Search box");
		driver.findElement(By.name("search")).click();
		System.out.println("Clicked the search Now Button");
		
		driver.findElement(By.linkText(CMPNAME)).click();
		
		// Traversing Campaign child module to Parent module
		Set<String> allwhs2 = driver.getWindowHandles();
		for(String wh2:allwhs2)
		{
			String Title = driver.switchTo().window(wh2).getTitle();
			if(Title.contains("Potentials"))
			{
				System.out.println("Traversed to Parent Window");
			}
		} 
		
System.out.println("Campaign source is successfully added to Opportunity Module");
		
		// Adding Amount
		driver.findElement(By.name("amount")).sendKeys("1000");
		System.out.println("Amount is added succesfully");
		
		// Adding sales stage
		WebElement ddaddr3 = driver.findElement(By.name("sales_stage"));
		Select sel3 = new Select(ddaddr3);
		sel3.selectByVisibleText("Qualification");
		System.out.println("Sales Stage is added Succesfully");
		
		// Adding Propability
		driver.findElement(By.xpath("//input[@id='probability']")).sendKeys("98.42");
		System.out.println("Probability is added Succesfully");
		
		// Adding Description
		driver.findElement(By.name("description")).sendKeys("THE NEW OPPORTUNITY-1 IS CREATED");
		System.out.println("Description is added succesfully");
		
		// Save 
		driver.findElement(By.name("button")).click();
		System.out.println("The new Opportunity is saved Succcesfully");
		
		// Signout
		WebElement Signout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions ac2 = new Actions(driver);
		ac2.moveToElement(Signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Signed-Out from the vtiger Application Successfully");
		
		// Close the Browser
		driver.close();
		System.out.println("Browser has closed Succesfully");
		
		}
		
	}

