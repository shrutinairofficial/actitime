package tests;

import org.testng.annotations.Test;

import genericlibs.GenericExcelLibrary;
import pages.HomePage;
import pages.LoginPage;

public class TC003 extends BaseTest
{
	@Test
	public void HomePageTest()
	{
		LoginPage l = new LoginPage(driver);
		String username = GenericExcelLibrary.getValue(XL_PATH, "TC001", 1, 0);
		String password = GenericExcelLibrary.getValue(XL_PATH, "TC001", 1, 1);
		l.setUsername(username);
		l.setPassword(password);
		l.clickLogin();
		
		HomePage h = new HomePage(driver);
		h.clickRadio();
	}
}
