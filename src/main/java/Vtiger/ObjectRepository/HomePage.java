package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericLibraries.WebDriverLibrary;

public class HomePage extends WebDriverLibrary{
	
	// Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private  WebElement OppurtunitesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText = "Vendors")
	private WebElement VendorsLnk;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SignoutLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministrationImg;
	
	// Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOppurtunitesLnk() {
		return OppurtunitesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getVendorsLnk() {
		return VendorsLnk;
	}

	public WebElement getAdministrationImg() {
		return AdministrationImg;
	}

	public WebElement getSignoutLnk() {
		return SignoutLnk;
	}
	
// Business Library Logic
	
	/**
	 * This method is used to click on the Organization Link
	 */
	public void clickOnOrganization()
	{
		OrganizationLnk.click();
	}
	
	/**
	 * This method is used to click on the Contacts Link
	 */
	public void clickOnContacts()
	{
		ContactsLnk.click();
	}
	
	/**
	 * This method is used to click o the Oppurtunites Link
	 */
	public void clickOnOppurtunites()
	{
		OppurtunitesLnk.click();
	}
	
	/**
	 * This method is used to click on the Products Link
	 */
	public void clickOnProducts()
	{
		ProductsLnk.click();
	}
	
	
	/**
	 * This method is used to click on the Vendors Link
	 */
	public void clickOnVendors()
	{
		VendorsLnk.click();
	}
	
	/**
	 * This method is used to Signout from the Application
	 * @param driver
	 */
	public void SignOutLnk(WebDriver driver)
	{
		mouseHoverOn(driver,AdministrationImg);
		SignoutLnk.click();
	}

}
