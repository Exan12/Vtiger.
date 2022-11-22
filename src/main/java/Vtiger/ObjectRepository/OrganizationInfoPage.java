package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	// Declaration
	@FindBy(xpath = "//span[@id=\"dtlview_Organization Name\"]")
	private WebElement OrganizationName;
	
	@FindBy(xpath = "//input[@title=\"Edit [Alt+E]\"]")
	private WebElement EditBtn;
	
	@FindBy(xpath = "//input[@title=\"Delete [Alt+D]\"]")
	private WebElement DeleteBtn;
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement Titleinfo;
	
	// Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
    
	// Utilization
	public WebElement getOrganizationName() 
	{
		return OrganizationName;
	}

	public WebElement getEditBtn()
	{
		return EditBtn;
	}

	public WebElement getDeleteBtn() 
	{
		return DeleteBtn;
	}
	
	public WebElement getTitleinfo()
	{
		return Titleinfo;
	}
	
	// Business Logic
	
	/**
	 * This Method is used to click on the Edit Button
	 */
	public void ClickOnEditBtn()
	{
		EditBtn.click();
	}
    
	/**
	 * This Method is used to Click on the Delete Button
	 */
	public void ClickOnDeleteBtn()
	{
		DeleteBtn.click();
	}
	
	/**
	 * This Method is used to Read the Organization Header
	 * @return 
	 * 
	 */
	public String OrganizationHeader()
	{
		String OrgHeader = Titleinfo.getText();
		System.out.println(OrgHeader);
		return OrgHeader;
	}
	
	/**
	 * This Method is used to Fetch the Text of Organization Field
	 * @return 
	 */
	public String OrganizationNameField()
	{
		 String OrgName = OrganizationName.getText();
		 System.out.println(OrgName);
		 return OrgName;
	}
}
