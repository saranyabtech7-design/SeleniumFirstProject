package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AboutPage extends BaseClass {

	//Calling Parent Constructor for initiating the driver instance
	public AboutPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy (xpath="//*[text()='Home']") WebElement homelink;

	
	//Page Actions
	public void homeLink()
	{
		homelink.click();
	}
}
