package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {
	
	WebDriver driver;
	/*This is a Parent Constructor. Instead of writing one for all, we can have one constructor for reusability.*/
	
	public BaseClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
