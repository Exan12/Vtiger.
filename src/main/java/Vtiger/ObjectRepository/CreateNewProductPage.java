package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericLibraries.WebDriverLibrary;

public class CreateNewProductPage extends WebDriverLibrary {
	
	// Declaration
	@FindBy(name = "productname")
	private WebElement ProductName;
	
	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement VendorsLookupImg;
	
	@FindBy(id = "search_txt")
	private WebElement SearchEdit;
	
	@FindBy(name = "search")
	private WebElement SearchNowBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	// Initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getProductModule() {
		return ProductName;
	}

	public WebElement getVendorsLookupImg() {
		return VendorsLookupImg;
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
// Business Library Logic
	
	/**
	 * This Method is used to Create The New Product
	 * @param productname
	 */
	public void createNewProduct(String productname)
	{
		ProductName.sendKeys(productname);
		SaveBtn.click();
	}
	
	/**
	 * This Method is used to create the New Products with Vendor
	 * @param productname
	 * @param vendorname
	 * @param driver
	 */
	public void createNewProduct(String productname, String vendorname , WebDriver driver) 
	{
		ProductName.sendKeys(productname);
		VendorsLookupImg.click();
		switchToWindow(driver, "Vendors");
		SearchEdit.sendKeys(vendorname);
		SearchNowBtn.click();
		
		// Dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+vendorname+"']")).click();
		switchToWindow(driver, "Products");
		SaveBtn.click();
	}
	
}
