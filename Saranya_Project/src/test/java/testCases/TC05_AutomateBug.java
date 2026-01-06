package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FactorialPage;

public class TC05_AutomateBug extends BaseClassMethod{

	@Test (description = "Verify the scenario automated for a detected bug, Terms and Condition Page points to a Privacy content")
	public void bugFlow()
	{
		try
		{
		FactorialPage fp=new FactorialPage(driver);
		fp.termsLink();
		String AppTitle=driver.getTitle();
		if(AppTitle.contains("terms"))
		{
			Assert.assertTrue(true, "Application Title contains Terms");
		}
		else
		{
			Assert.assertTrue(false, "Application Title does not contains Terms");
		}
		}
		catch(Exception e)
		{
			logger.error("Test Failed..Application Title does not contains Terms");
		}
	}
}
