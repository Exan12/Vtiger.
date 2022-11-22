package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductInfoPage { 
	
	// Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProductHeader;

	// Initialization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	// Utilization
	public WebElement getProductHeader() {
		return ProductHeader;
	}

// Business Library Logic
	
	/**
	 * This Method is used to get the Text of Product Header element
	 * @return
	 */
	public String ProductHeader()
	{
		String PRODUCTHEADER = ProductHeader.getText();
		return PRODUCTHEADER;
	}
}
