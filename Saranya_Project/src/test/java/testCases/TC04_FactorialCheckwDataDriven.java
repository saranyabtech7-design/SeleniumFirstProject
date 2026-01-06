package testCases;
import org.testng.annotations.Test;

import pageObjects.FactorialPage;
import utilities.ExcelUtils;
import utilities.TestDataProvider;

public class TC04_FactorialCheckwDataDriven extends BaseClassMethod {
		
	/*Here, TestNG automatically maps each inner array from Object[][] data to the parameters of this factorialCheck(String num) method, in order.*/
	@Test (dataProvider="factorialcheckdata", dataProviderClass=TestDataProvider.class,description="Verify the result for few input's through Data Driven Testing", priority=4)
	public void factorialCheck(String num,String expectedResult,int excelRowValue) throws Exception
	{
		FactorialPage fp=new FactorialPage(driver);
		fp.enterNumber(num);
		fp.clickcalculate();
	 //Column C
		String actualResult=fp.messageRead();
		takeScreenshot("After Clicking Calculate", "Pass");
		//System.out.println("Writing to row: " + excelRow);
		//boolean status=actualResult.contains(expectedResult);
		ExcelUtils.writeData(excelPath,"Data",excelRowValue,3,actualResult);
		if(actualResult.contains(expectedResult))
		{
			System.out.println("PASS : Expected Result Found");
			ExcelUtils.writeData(excelPath,"Data",excelRowValue,4,"PASS");
		}
		else
		{
			System.out.println("FAIL: Expected result not found");
			ExcelUtils.writeData(excelPath,"Data",excelRowValue,4,"FAIL");
		}
		driver.navigate().refresh();
	}
	
}
