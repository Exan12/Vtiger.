package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Declaration
	@FindBy(name = "user_name") private 
	WebElement UserNameEdt;
	
	@FindBy(name = "user_password") private 
	WebElement PasswordEdt;
	
	@FindBy(id = "submitButton") private 
	WebElement SubmitBtn;
	
	@FindAll({@FindBy(name = "user_password"),@FindBy(xpath = "//input[@name='user_password']")}) private
	WebElement PasswordEdit;
	
	// Initilization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	} 
	
	// Utilization
	public WebElement getUserNameEdt() 
	{
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() 
	{
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() 
	{
		return SubmitBtn;
	}
	

//  Business Logics
	/**
	 * This Business Logics are used to Login the Application
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		UserNameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}

}
