package testCases;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClassMethod {
	
	protected static WebDriver driver;
    protected static String excelPath = ".\\testData\\InputDataFactorialCheck - 1.xlsx";
    protected static String sheetName = "Data";
	  //This is for Logger files. Whatever a test case or an error gets triggered, all the info will be recorded in Automation Logs.
	public static Logger logger=LogManager.getLogger(BaseClassMethod.class); 
	public Properties p;
	  
	@BeforeClass
	@Parameters ({"browser"})
	public void launchApp(String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);		
		
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();
		break;
		case "edge": driver=new EdgeDriver();
		break;
		case "firefox": driver=new FirefoxDriver();
		break;
		default: System.out.println("Invalid Browser");
		return; /*This keyword will completely exit from the test. If we dont give this in block, the remaining line of code will get executed
		and it throws an exception that driver is needed.*/
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get(p.getProperty("appURL")); //Reading URL from properties file
	}
	public static void takeScreenshot(String stepName, String status) {
		try 
        {
	    	TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
	        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	        File destFile = null;
	        if(status.equalsIgnoreCase("PASS"))
	        {
	        	 destFile= new File(".\\screenshots\\Pass\\" + stepName + "_" + System.currentTimeMillis() + ".png");
	        }
	        else
	        {
	        	if(status.equalsIgnoreCase("FAIL"))
	        	 destFile= new File(".\\screenshots\\Fail\\" + stepName + "_" + System.currentTimeMillis() + ".png");
	        }
	        
	        
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("Screenshot saved successfully"+destFile.getAbsolutePath());
	        }	
	        catch (Exception e) 
	        {
	        System.out.println("Unable to capture screenshot: " + e.getMessage());
	        }
	        
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}

}
