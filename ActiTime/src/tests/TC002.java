package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibs.GenericExcelLibrary;
import pages.LoginPage;

public class TC002 extends BaseTest
{
	@Test
	public void invalidLogin()
	{
		LoginPage l = new LoginPage(driver);
		String username = GenericExcelLibrary.getValue(XL_PATH, "TC002", 1, 0);
		String password = GenericExcelLibrary.getValue(XL_PATH, "TC002", 1, 1);
		l.setUsername(username);
		l.setPassword(password);
		l.clickLogin();
		//Assert.assertTrue(l.verifyErrorMessage());
	}
}
