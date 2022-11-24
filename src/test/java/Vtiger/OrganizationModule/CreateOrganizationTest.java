package Vtiger.OrganizationModule;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger.GenericLibraries.BaseClass;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{

	@Test(groups = "regressionSuite")
	public void createOrganizationTest()
	{
		// Step - 1 : Click On the Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		
		// Step - 2 : Click On the Organization Lookup Button
		OrganizationPage op = new OrganizationPage(driver);
		op.ClickOnOrganizationLookUpBtn();

		// Step - 3 : Create the New Organization
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		String ORGNAME = cno.CreateNewOrganization("Naveen"+jLib.getRandomNumber());
		System.out.println(ORGNAME);
		
		// Step - 4 : Read the Organization Name and Header
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ORGHEADER = oip.OrganizationHeader();
		System.out.println(ORGHEADER);

		// Step - 5 : Verfication
		Assert.assertEquals(ORGHEADER.contains(ORGNAME),true);
		System.out.println("New Organization Created Succesfully ---> PASS");
		
	}

}
