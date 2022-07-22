package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
  
	@Test(groups= {"sanity", "master"})
	public void test_login() throws IOException
	{
		logger.info("Login TestCase Started");
		driver.get(rb.getString("url"));
		
		HomePage hp2=new HomePage(driver);
		hp2.clickMyacc();
		hp2.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		String bool=lp.isMyAccountExists();
		
		if(bool.equals("My Account"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"test_login");
			Assert.fail();
		}
		logger.info("Login_Test case completed");
	}
	
}
