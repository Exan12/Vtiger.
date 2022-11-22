package Vtiger.OrganizationModule;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Vtiger.GenericLibraries.BaseClass;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;

public class multipleOrganizationVthIndustryTest extends BaseClass {
	
	@Test(dataProvider = "MultipleOrganizations")
	public void MultipleOrganizationTestVthIndustryTest()
	{	
		// Navigate to the Oganization Module
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		
		// Click on the Organization Lookup Icon Button
		OrganizationPage op = new OrganizationPage(driver);
		op.ClickOnSearchInOrganizationLookUpBtn();
		
		// Create New Organization with Multiple Industry
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver); 
		cno.CreateOrganizationWithIndustry("Kiran"+jLib.getRandomNumber(),"Chemichals");
		
		// Validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.OrganizationHeader();
		Assert.assertEquals("Organizzation Created", oip.OrganizationHeader().contains(oip.OrganizationNameField()));
		
	}
	
	@DataProvider(name = "MultipleOrganizations")
     public Object[][] getdata() throws Throwable {
			
			Object[][] data = eLib.readMultipleDataToExcel("MultipleOrganization");
			return data;
		}
	}

