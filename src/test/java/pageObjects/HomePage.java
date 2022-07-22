package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']") WebElement My_acc;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement login;
	
	public void clickMyacc()
	{
		My_acc.click();
	}
	
	public void clickRegister()
	{
		register.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
}
