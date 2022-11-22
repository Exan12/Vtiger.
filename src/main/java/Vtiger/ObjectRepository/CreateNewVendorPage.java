package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	
	// Declaration
	@FindBy(name = "vendorname")
	private WebElement VendorName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	// Initialization
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	// Utilization
	public WebElement getVendorName() {
		return VendorName;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
// Business Logics
	
	/**
	 * This Method is used to create the New Vendor
	 * @param vendorname
	 */
	public void createNewVendor(String vendorname)
	{
		VendorName.sendKeys(vendorname);
		SaveBtn.click();
	}
}
