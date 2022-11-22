package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	
	// Declaration
	@FindBy(xpath = "//span[@class ='lvtHeaderText']")
	private WebElement VendorHeader;
	
	// Initialization
	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getVendorHeader() {
		return VendorHeader;
	}
	
// Business Library Logics
	
	/**
	 * This Method is used to get Text of the Vendors Header Element
	 * @return 
	 */
	public String VendorHeader()
	{
		String VENDORHEADER = VendorHeader.getText();
		return VENDORHEADER;
	}

}
