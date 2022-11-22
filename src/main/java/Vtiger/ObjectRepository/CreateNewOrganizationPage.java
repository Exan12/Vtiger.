package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericLibraries.WebDriverLibrary;

public class CreateNewOrganizationPage extends WebDriverLibrary{ 
	
	// Declaration
	@FindBy(xpath = "//input[@name=\"accountname\"]")
	private WebElement OrganizationNameEdt;
	
	@FindBy(xpath = "//input[@type=\"radio\"]")
	private WebElement AssignedToBtn;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	// Initilazation
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	// Utilization
	public WebElement getOrganizationNameEdt() 
	{
		return OrganizationNameEdt;
	}

	public WebElement getAssignedToBtn() 
	{
		return AssignedToBtn;
	}

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}
	
	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}
	
	// Business Logic
	
	/**
	 * This Method is used to enter the Organization Name
	 * @param OrgName
	 */
	public void EnterOrganizationName(String OrgName)
	{
		OrganizationNameEdt.sendKeys(OrgName);
	}
	
	/**
	 * This Method is Used to Click On the Assigned To Button
	 */
	public void ClickOnAssignedToBtn()
	{
		AssignedToBtn.click();
	}
	
	/**
	 * This Method is used to Click on the save button
	 */
	public void ClickOnSaveBtn()
	{
		SaveBtn.click();
	}
//Business Logics
	/**
	 * This Method is used to Create Organizzation with Industry Type
	 * @param Orgname
	 * @param Industype
	 */
	public void CreateOrganizationWithIndustry(String Orgname ,String Industype)
	{
		OrganizationNameEdt.sendKeys(Orgname);
		handleDropDown(Industype, IndustryDropDown);
		SaveBtn.click();
	}
	
	/**
	 * This Method is used to create the New Organizattion
	 * @param orgname
	 * @return 
	 */
	public String CreateNewOrganization(String orgname)
	{
		OrganizationNameEdt.sendKeys(orgname);
		SaveBtn.click();
		return orgname;
	}
}
