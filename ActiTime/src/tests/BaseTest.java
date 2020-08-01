package tests;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import genericlibs.GenericPropertyLib;
import genericlibs.GetPhoto;
import genericlibs.IAutoConstants;

public abstract class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException
	{
		String appUrl = GenericPropertyLib.getValue(CONFIG_PATH, "url");
		long ito = Long.parseLong(ITO);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);
		driver.get(appUrl);
	}
	
	@AfterMethod
	public void closeApp(ITestResult result)
	{
		int status = result.getStatus();
		String name = result.getName();
		if(status ==1)
		{
			Reporter.log("PASSED"+name, true);
		}
		else
		{
			Reporter.log("FAILED"+name, true);
			GetPhoto.getPhoto(driver, name);
		}
		driver.quit();
	}
	
}
