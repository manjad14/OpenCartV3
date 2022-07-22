package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	String pwd;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement first_name;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement last_name;
	@FindBy(css="input[name='email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement passwd;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement passwd_confirm;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement news_yes;
	@FindBy(xpath="//input[@value='Continue']") WebElement continue_btn;
	@FindBy(xpath="//input[@name='agree']") WebElement privacy_box;

	public void setFirstName(String fname)
	{
		first_name.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		last_name.sendKeys(lname);
	}
	
	public void setEmail(String useremail)
	{
		email.sendKeys(useremail);
	}
	
	public void setTelephone()
	{
		telephone.sendKeys("1234567890");
	}
	

	public void setPassword(String pwd)
	{
		passwd.sendKeys(pwd);
	}
	
	public void setPasswordConfirm(String pwdc)
	{
		passwd_confirm.sendKeys(pwdc);
	}
	
	public void clickYes()
	{
		news_yes.click();
	}
	
	public void clickContinue()
	{
		continue_btn.click();
	}
	
	public void clickPrivacy()
	{
		privacy_box.click();
	}
}
