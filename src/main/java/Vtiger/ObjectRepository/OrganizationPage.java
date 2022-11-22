package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	// Declaration 
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateOrganizationLookUpBtn;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Search.gif\"]")
	private WebElement SearchInOrganizationLookUpBtn;
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement SearchboxEdt;
	
	@FindBy(xpath = "//input[@name=\"submit\"]")
	private WebElement SearchNowBtn;
	
	// Initilization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
    
	// Utilization
	public WebElement getCreateOrganizationLookUpBtn() 
	{
		return CreateOrganizationLookUpBtn;
	}

	public WebElement getSearchInOrganizationLookUpBtn()
	{
		return SearchInOrganizationLookUpBtn;
	}

	public WebElement getSearchboxEdt() 
	{
		return SearchboxEdt;
	}

	public WebElement getSearchNowBtn() 
	{
		return SearchNowBtn;
	}
	
	// Business Logic
	
	/**
	 * This Method is used to click on the create Organization Lookup Button
	 */
	public void ClickOnOrganizationLookUpBtn()
	{
		CreateOrganizationLookUpBtn.click();
	}
	
	/**
	 * This Method is used to click on the Search In Organization Lookup Button
	 */
    public void ClickOnSearchInOrganizationLookUpBtn()
    {
    	SearchInOrganizationLookUpBtn.click();
    }
	
    /**
     * This Method is Used to Enter the Organization Name in Search box Field
     * @param OrgName
     */
	public void EnterSearchBoxEdt(String OrgName)
	{
		SearchboxEdt.sendKeys(OrgName);
	}
	
	/**
	 * This Method is used to Click on the Search Now button.
	 */
    public void ClickOnSearchNowBtn()
	 {
    	SearchNowBtn.click();
	 }

}
