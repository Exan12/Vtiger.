package Vtiger.ContactsModule;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericLibraries.BaseClass;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.HomePage;

@Listeners(Vtiger.GenericLibraries.ListenersImplementationLibrary.class)
public class CreateContactTest extends BaseClass{
	
	@Test(groups = "smokeSuite")
	public void createContactTest() throws Throwable
	{
		
		String LASTNAME = eLib.readDataFromExcel("Contacts", 1, 2) + jLib.getRandomNumber();
		
		// Step 5: Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		
		// Step 6: Navigate to create Contact Look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactsLookupImg();
		
		// Step 7: create contact with mandatory details and save
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createNewContact(LASTNAME);

		// Step 8: Validate
		String CONTACTHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(CONTACTHEADER);
		Assert.assertEquals(CONTACTHEADER.contains(LASTNAME),true);
		System.out.println("Contact Created Succesfully");

	}
	
	@Test(groups = {"smokeSuite","regressionSuite"})
	public void CreateContactDemoTest()
	{
		Reporter.log("Demo Test",true);
	}
	
	@Test
	public void CreateContactwithLeadSource()
	{
		System.out.println("Lead Source");
	}
	
	@Test
	public void createContactWithLeadSourceAndOrganization()
	{
		System.out.println("Lead sorce With Organization");
	}

}
