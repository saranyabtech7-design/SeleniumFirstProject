package pageObjects;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FactorialPage extends BaseClass {

	public FactorialPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	WebDriver driver;
	public @FindBy (xpath="//input[@id='number']") WebElement inputbox;
	public @FindBy (xpath="//button[@id='getFactorial']") WebElement calcbutton;
	public @FindBy (xpath="//*[text()='About']") WebElement aboutlink;
	public @FindBy (xpath="//*[text()='Terms and Conditions']") WebElement termslink;
	public @FindBy (xpath="//*[text()='Privacy']") WebElement privacylink;
	public @FindBy (xpath="//*[@class='text-center top-space-20']") WebElement message;
	public @FindBy (xpath="//*[@class='icon-arrow-right']") WebElement arrow;

	
	//Action Methods for all the Web Elements
	public void enterNumber(String num)
	{
	inputbox.sendKeys(num);
	}
	public void clickcalculate()
	{
		calcbutton.click();	
	}
	public String messageRead()
	{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.textToBePresentInElement(message, "The factorial of"));
			System.out.println("Confirmation message is: "+message.getText());
			return message.getText();
	}	
	
	public void aboutLink()
	{
		aboutlink.click();
	}
	public void termsLink()
	{
		termslink.click();
	}
	public void privacyLink()
	{
		privacylink.click();
	}
	public void searchArrow()
	{
		arrow.click();
	}
	
}
