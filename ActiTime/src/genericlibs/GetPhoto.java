package genericlibs;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetPhoto 
{
	public static void getPhoto(WebDriver driver, String name)
	{
		LocalDateTime ldt = LocalDateTime.now();
		String date = ldt.toString().replace(":", "-");
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(IAutoConstants.IMAGE_PATH+date+name+".png");
		try
		{
			FileUtils.copyFile(src,dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
