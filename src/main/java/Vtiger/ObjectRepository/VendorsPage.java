package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
	// Declaration
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement VendorLookupImg;
	
	// Initialization
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getVendorLookupImg() {
		return VendorLookupImg;
	}
	
// Business Logics
	
	/**
	 * This Method is used to Click on the Vendors Lookup Icon in Vendors module
	 */
	public void clickOnVendorsLookupImg()
	{
		VendorLookupImg.click();
	}
    
}
