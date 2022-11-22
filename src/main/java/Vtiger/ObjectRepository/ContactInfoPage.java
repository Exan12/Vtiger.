package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	// Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeader;
	
	// Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	// Utilization
	public WebElement getContactHeader() 
	{
		return ContactHeader;
	}
	
// Business Library Logics
	
	/**
	 * This Method is used to print the Contact Header text
	 * @return 
	 */
	public String contactHeader()
	{
		 String CONTACTHEADER = ContactHeader.getText();
		 return CONTACTHEADER;
	}
	

}
