package Vtiger.ProductsModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericLibraries.BaseClass;
import Vtiger.ObjectRepository.CreateNewProductPage;
import Vtiger.ObjectRepository.CreateNewVendorPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.ProductInfoPage;
import Vtiger.ObjectRepository.ProductsPage;
import Vtiger.ObjectRepository.VendorInfoPage;
import Vtiger.ObjectRepository.VendorsPage;

@Listeners(Vtiger.GenericLibraries.ListenersImplementationLibrary.class)
public class CreateProductWithVendorPomTest extends BaseClass {

	@Test
	public void createProductWithVendorPomTest() throws Throwable
	{

		// Read the Necessary Data from Excel File
		String PRODUCTNAME = eLib.readDataFromExcel("Products", 1, 2)+" "+jLib.getRandomNumber();
		String VENDORNAME = eLib.readDataFromExcel("Products", 4, 3)+" "+jLib.getRandomNumber();

		// Navigate to Vendors Module
		WebElement MORE = driver.findElement(By.linkText("More"));
		wLib.mouseHoverOn(driver, MORE);
		HomePage hp = new HomePage(driver);
		hp.clickOnVendors();
		System.out.println("Clicked on Vendors Module");
		
		// Navigate to the Vendor Module Lookup Icon Button
		VendorsPage vp = new VendorsPage(driver);
		vp.clickOnVendorsLookupImg();
		System.out.println("Clicked on Vendor Module Lookup Icon Button");

		// Enter the Mandatory Details in Vendors Module
		CreateNewVendorPage cnv = new CreateNewVendorPage(driver);
		cnv.createNewVendor(VENDORNAME);
		System.out.println("Mandatory Details are entered in Vendors Module");
		System.out.println("Saved the Vendor");

		// Validation
		VendorInfoPage vip = new VendorInfoPage(driver);
		String VENDORHEADER = vip.VendorHeader();
		if (VENDORHEADER.contains(VENDORNAME)) 
		{
			System.out.println("Vendor Created ----> PASS");
		} else 
		{
			System.out.println("Vendor Not Created ---- > FAIL");
		}

		// Navigate the Products Module Link
		hp.clickOnProducts();
		System.out.println("Navigated to the Products Module Link");

		// Navigate to the Products Module Lookup Icon Button
		ProductsPage po = new ProductsPage(driver);
		po.clickOnProductsLookupImg();
		System.out.println("Clicked on Products Module Lookup Icon Button");

		// Enter the Mandatory Details in Products Module
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.createNewProduct(PRODUCTNAME, VENDORNAME, driver);
		System.out.println("Mandatory Details are filled and Vendor is Added succesfully");

		// Validation
		ProductInfoPage pip = new ProductInfoPage(driver);
		String PRODUCTHEADER = pip.ProductHeader();
		if (PRODUCTHEADER.contains(PRODUCTNAME)) 
		{
			System.out.println("PASS");
		} else
		{
			System.out.println("FAIL");
			wLib.takeScreenshot(driver,"createProductWithVendorTest");
		}

	}

}
