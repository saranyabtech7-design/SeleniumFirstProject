package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC02_URLTitlePlaceHolder extends BaseClassMethod  {
	

@Test (description = "Verify the Placeholder value, Page Title, URL value in Factorial Page",priority=2)
	public void verifyTest()
	{
	try
	{
		logger.info("****Executing TC02_URLTitlePlaceHolder****");
		SoftAssert soft=new SoftAssert();
		System.out.println("Checking PlaceHolder of an inputbox...");
		String placevalue=driver.findElement(By.xpath("//input[@id='number']")).getDomAttribute("placeholder");
		String expected="Enter an integer";
		logger.info("Checking PlaceHolder of an Inputbox....");
		if(placevalue.equals(expected))
		{
			System.out.println("PASS: PlaceHolder value is correct - "+placevalue);
			takeScreenshot(placevalue, "Pass");
		}
		else
		{
			System.out.println("FAIL: PlaceHolder value found mismatch - Assertion Error lists below ");
		}
		soft.assertEquals(placevalue, expected , "FAIL: Provided placeholder value does not match with actual one." );
		System.out.println();
		System.out.println("Checking if Page Title contains Factorial...");
		String AppTitle=driver.getTitle();
		String verifytext="Factorial";
		logger.info("Checking Application Title contains Factorial....");
		if(AppTitle.contains(verifytext))
		{
			System.out.println("PASS: Application Title contains 'Factorial'");
			takeScreenshot(AppTitle, "Pass");
		}
		else
		{
			System.out.println("FAIL: Application Title does not contain Factorial - Assertion Error lists below ");
		}
		soft.assertTrue(AppTitle.contains(verifytext), "Title does not contain'Factorial'");
		System.out.println();
		
		System.out.println("Checking Page URL...");
		String AppURL=driver.getCurrentUrl(); 
		String verifyPart="https"; //Purposedly failed the test case to verify logger.error part
		logger.info("Checking Application URL contains https....");
		if(AppURL.contains(verifyPart))
		{
			System.out.println("PASS: Application URL Contains 'https'");
			/*For Log4j/Log4j2 this overload treats the second argument as a parameter object but needs a {} 
			placeholder in the message to print it; without that, it logs only the message part.*/
			
			logger.info("Application URL is: {}", AppURL); 
		}
		else
		{
			System.out.println("FAIL: Application URL does not contain 'https'");
			/*Here,we cannot take Screenshot of Application URL.Hence, added the URL value in Logs
			i.e. Webdriver's Screenshots API works only on the Browser context not thr browser chrome*/
			logger.error("FAIL: Application URL does not contain 'https'");
		}
		soft.assertTrue(AppURL.contains(verifyPart), "URL does not contain 'https'");
		
		soft.assertAll();
		
	}
	catch(Exception e)
	{
		logger.error("Test Failed...");
		logger.debug("Debug logs..");
		Assert.fail();
	}
	logger.info("****Finished TC02_URLTitlePlaceHolder****");
	}
}
