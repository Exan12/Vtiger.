package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	// Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement ContactsLookupImg;
	
	// Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getContactsLookupImg() {
		return ContactsLookupImg;
	}
	
// Business Library Logic
	
	/**
	 * This method is used to click on the Contacts Lookup Image
	 */
	public void clickOnContactsLookupImg()
	{
		ContactsLookupImg.click();
	}
	
	

}
