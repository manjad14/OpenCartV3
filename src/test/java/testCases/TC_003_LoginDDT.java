package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", groups= {"master"})
	public void test_loginDDT(String email, String pwd, String exp) {
		
		try {
			logger.info("TC_003 Login DDT TestCase  Started");
			driver.get(rb.getString("url"));

			HomePage hp2 = new HomePage(driver);
			hp2.clickMyacc();
			hp2.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			String bool = lp.isMyAccountExists();
			MyAccountPage mp = new MyAccountPage(driver);

			if (exp.equals("Valid")) {
				if (bool.equals("My Account")) {
					mp.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.fail();
				}
			}

			if (exp.equals("Invalid")) {
				if (bool.equals("My Account")) {
					mp.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			logger.fatal("Login failed in TC_003");
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\OpenCart_LoginData.xlsx";
		XLUtility XL = new XLUtility(path);

		int rows = XL.getRowCount("Sheet1");
		int cols = XL.getCellCount("Sheet1", 1);

		String[][] logindata = new String[rows][cols];

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				logindata[i - 1][j] = XL.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
}
