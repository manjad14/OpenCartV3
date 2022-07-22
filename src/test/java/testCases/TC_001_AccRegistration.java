package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_AccRegistration extends BaseClass
{
	
	@Test(groups= {"regression", "master"})
	public void test_acc_reg() throws IOException
	{
		try {
		logger.info("Registration Test Case started.....");
		driver.get(rb.getString("url"));
		
		HomePage hp=new HomePage(driver);
		
		hp.clickMyacc();
		hp.clickRegister();
		
		RegisterPage rp=new RegisterPage(driver);
		
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString()+"@gmail.com");
		//rp.setEmail("WrongGmail.com");
		rp.setTelephone();
		rp.setPassword("abcxyz");
		rp.setPasswordConfirm("abcxyz");
		rp.clickYes();
		rp.clickPrivacy();
		rp.clickContinue();
		//Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");
		if(driver.getTitle().equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "test_acc_reg");
			Assert.fail();
		}
		}
		catch (Exception e)
		{
			captureScreen(driver, "test_acc_reg");
			Assert.fail();
		}
		logger.info("Registration Test Case completed.....");
	}
	
}
