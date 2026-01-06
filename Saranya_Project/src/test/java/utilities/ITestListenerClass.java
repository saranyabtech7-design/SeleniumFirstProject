package utilities;


import org.testng.ITestListener;
import org.testng.ITestResult;

import testCases.BaseClassMethod;

public class ITestListenerClass extends BaseClassMethod implements ITestListener{
	

	
	 public void onTestFailure(ITestResult result) {
		 
		 takeScreenshot(result.getName()+".png", "Fail"); 	   
	}
}


