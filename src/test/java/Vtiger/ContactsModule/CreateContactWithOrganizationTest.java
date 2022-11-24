package Vtiger.ContactsModule;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericLibraries.BaseClass;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;

/**
 * 
 * @author Kiran
 *
 */

@Listeners(Vtiger.GenericLibraries.ListenersImplementationLibrary.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = {"smokeSuite","regressionSuite"})
	public void createContactWithOrganizationTest() throws Throwable, IOException
	{
		String ORGNAME = eLib.readDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		Reporter.log(ORGNAME);
		
		String LASTNAME = eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
		Reporter.log(LASTNAME);

		// Navigate to Organization Module
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		Reporter.log("Navigated to Organization Module",true);

		// Click on the Organization Lookup Icon Button
		OrganizationPage op = new OrganizationPage(driver);
		op.ClickOnOrganizationLookUpBtn();
		Reporter.log("Clicked on Organization Lookup Icon Button",true);

		// Create new Organization
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.CreateNewOrganization(ORGNAME);
		Reporter.log("Created New Organization With Mandatory Details",true);

		// Validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ORGHEADER = oip.OrganizationHeader();
		System.out.println(ORGHEADER);
		Reporter.log("Organization Validation Done Succesfully",true);

		Assert.assertEquals(ORGHEADER.contains(ORGNAME),true);
		Reporter.log("Organization Created Succesfully",true);

		//Navigate to Contacts Link
		hp.clickOnContacts();
		Reporter.log("Clicked On Contacts Module",true);

		//Navigate to create Contact Look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactsLookupImg();
		Reporter.log("Clicked on contacts Lookup Icon Image",true);

		// Create contact with mandatory details and save
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createNewContact(ORGNAME,LASTNAME,driver);
		Reporter.log("Entered Mandatory Detalis of Create Contact",true);

		// Step 8: Validate
		String CONTACTHEADER = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(CONTACTHEADER);
		Assert.assertEquals(CONTACTHEADER.contains(LASTNAME),true);
		Reporter.log("Contact Created Succesfully");


	}

}
