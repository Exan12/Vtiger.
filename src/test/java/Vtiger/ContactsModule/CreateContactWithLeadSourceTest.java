package Vtiger.ContactsModule;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Vtiger.GenericLibraries.BaseClass;
import Vtiger.ObjectRepository.ContactInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.HomePage;

public class CreateContactWithLeadSourceTest extends BaseClass {

	@Test
	public void createContactWithLeadSourceTest() throws Throwable
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
	cnc.createNewContact(LASTNAME ,"Direct Mail");
	System.out.println(LASTNAME);

	// Step 8: Validate
	ContactInfoPage cip = new ContactInfoPage(driver);
	String CONTACTHEADER = cip.contactHeader();
	Assert.assertEquals(CONTACTHEADER.contains(LASTNAME),true);
	Reporter.log("Contact Created Succesfully");
	
	
	}
}

