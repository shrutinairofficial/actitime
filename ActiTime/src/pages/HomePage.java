package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	@FindBy(className = "switcherBackground")
	private WebElement readyRadio;
	
	@FindBy(id= "taskSearchControl_field")
	private WebElement taskSearchField;
	
	@FindBy(id="ext-gen23")
	private WebElement calender;
	
	@FindBy(id="ext-gen44")
	private WebElement calenderBox;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickLogout()
	{
		logout.click();
	}
	public void selectDay(String month, String day)
	{
		calender.click();
		calenderBox.findElement(By.xpath("//button[.='"+month+"']/../../../../../../../..//span[.='"+day+"']")).click();
	}
	public void clickRadio()
	{
		readyRadio.click();
	}
	public void searchTask(String text)
	{
		taskSearchField.sendKeys(text);
	}
	
	/*verify title method*/
}
