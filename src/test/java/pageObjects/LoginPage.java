package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement input_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement input_password;
	@FindBy(xpath="//input[@value='Login']") WebElement login_btn;
	@FindBy(xpath="//h2[text()='My Account']") WebElement myAccount_Heading;
	
	public void setEmail(String email)
	{
		input_email.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		input_password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		login_btn.click();
	}
	
	public String isMyAccountExists()
	{
		try
		{
		return myAccount_Heading.getText();	
		}
		catch(Exception e)
		{
			return "ExceptionEntered";
		}
	}
}
