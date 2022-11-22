package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericLibraries.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary {
	
	// Declaration
	@FindBy(name = "lastname")
	private WebElement LastnameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrganizationLookupImg;
	
	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement Leadsourcedropdown;
	
	@FindBy(id = "search_txt")
	private WebElement SearchEdit;
	
	@FindBy(name = "search")
	private WebElement SearchNowBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	// Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getLastnameEdt() {
		return LastnameEdt;
	}

	public WebElement getOrganizationLookupImg() {
		return OrganizationLookupImg;
	}

	public WebElement getLeadsourcedd() {
		return Leadsourcedropdown;
	}

	public WebElement getSearchEdit() {
		return SearchEdit;
	}

	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
// Business Library Logics
	
	/**
	 * This method is used to create the New contact
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		LastnameEdt.sendKeys(lastname);
		SaveBtn.click();
	}
	
	/**
	 * This method is used to Create New Contact with lead source
	 * @param lastname
	 * @param leadsourceType
	 * @return 
	 */
	public String createNewContact(String lastname,String LeadsourceType)
	{
		LastnameEdt.sendKeys(lastname);
		handleDropDown(LeadsourceType, Leadsourcedropdown);
		SaveBtn.click();
		return lastname;
	}
	
	/**
	 * This Method is used to create the Contacts with Organization
	 * @param organization
	 * @param lastname
	 * @param driver
	 */
	public String createNewContact(String organization,String lastname,WebDriver driver)
	{
		LastnameEdt.sendKeys(lastname);
		OrganizationLookupImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdit.sendKeys(organization);
		SearchNowBtn.click();
		
		//Dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+organization+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
		return lastname;
	}
}
