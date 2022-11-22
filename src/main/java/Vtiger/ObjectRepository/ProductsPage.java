package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	// Declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement ProductsLookupImg;
	
	// Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getProductsLookupImg() {
		return ProductsLookupImg;
	}
	
// Business Library Logic
	
	/**
	 * This Method is used to click on the Products Lookup Icon
	 */
	public void clickOnProductsLookupImg()
	{
		ProductsLookupImg.click();
	}
	
}
