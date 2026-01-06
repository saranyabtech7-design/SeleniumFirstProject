package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider (name="factorialcheckdata")
	public Object[][] excelData() throws IOException
	{
		String path=".\\testData\\InputDataFactorialCheck - 1.xlsx";
		String sheet="Data";
		return ExcelUtils.getData(path,sheet);
		
	}
}
