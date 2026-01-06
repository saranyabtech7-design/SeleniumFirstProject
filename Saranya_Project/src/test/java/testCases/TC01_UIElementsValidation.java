package testCases;



import java.time.Duration;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AboutPage;
import pageObjects.FactorialPage;

public class TC01_UIElementsValidation extends BaseClassMethod {

	@Test  (description = "Validation All the necessary UI Elements are Present and Clickable", priority=1)
	public void loginToApplication() throws Exception
	{
		try
		{

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		FactorialPage fp=new FactorialPage(driver);
		AboutPage ap=new AboutPage(driver);
		SoftAssert soft=new SoftAssert();
		logger.info("****Executing TC01_UIElementsValidation****");
		logger.info("Vefiying InputBox....");
		boolean inpbox=fp.inputbox.isEnabled();
		System.out.println("Input Box is present and it is enabled: "+inpbox);
		soft.assertEquals(inpbox, true, "InputBox element is not identifiable");
		logger.info("Verifying CalculateButton....");
		boolean calculate=fp.calcbutton.isEnabled();
		System.out.println("Calculate Button is present and it is enabled: "+calculate);
		logger.info("Veifying About Link....");
		boolean abtlink=fp.aboutlink.isEnabled();
		System.out.println("About Link is present and it is enabled: "+abtlink);
		logger.info("Vefiying Terms and Conditions Link....");
		boolean tlink=fp.termslink.isEnabled();
		System.out.println("Terms Link is present and it is enabled: "+tlink);
		logger.info("Vefiying Terms and Conditions Link....");
		boolean plink=fp.privacylink.isEnabled();
		System.out.println("Privacy Link is present and it is enabled: "+plink);
		logger.info("***Vefiying the Factorial Value of an input no***");
		fp.enterNumber("5");
		fp.clickcalculate();
		fp.messageRead();
		takeScreenshot("After Clicking Calculate", "Pass");
		//takeScreenshot(fp.messageRead(), "Pass"); //Screenshot cannot be captured for Action Methods. Hence, the screenshot is not captured for this step.
		fp.aboutLink();
		Thread.sleep(2000);
		ap.homeLink();
		fp.privacyLink();
		Thread.sleep(2000);
		driver.navigate().back();
		fp.termsLink();
		Thread.sleep(2000);
		driver.navigate().back();
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
		}
		logger.info("**** Finished TC01_UIElementsValidation****");
	}
	
	
}
