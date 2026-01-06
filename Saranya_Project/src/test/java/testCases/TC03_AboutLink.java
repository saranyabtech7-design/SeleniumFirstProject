package testCases;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.FactorialPage;

public class TC03_AboutLink extends BaseClassMethod {

	
	@Test (description="Verify the total number of link is Greater than 5 and print the link name", priority=3)
	public void abtLink()
	{
		logger.info("****Executing TC03_AboutLink****");
		FactorialPage fp=new FactorialPage(driver);
		fp.aboutLink();
		takeScreenshot("Checking AboutLink", "Pass");
		System.out.println(driver.getTitle());
		
		WebDriverWait webwait=new WebDriverWait(driver, Duration.ofSeconds(6));
		List<WebElement> links=webwait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("a"), 5));
		System.out.println("Total No. of link is "+links.size()+" which is greater than 5 in About Link page");
		System.out.println("Link Names are as follows: ");
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
		}
		driver.navigate().back();
		
		logger.info("****Finished TC03_AboutLink****");
	}
	
}
