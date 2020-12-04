package boot;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class ExtentReport {
	 WebDriver driver;
	 ExtentReports exe;
	 ExtentHtmlReporter extenth;
	 ExtentTest et;
	
	@Before
	   public void setup() throws Exception{			
		   extenth=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\extents.html");
		   exe=new ExtentReports();
		   exe.attachReporter(extenth);
		   et=exe.createTest("Google search test");
		   System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
	   }
	
	@Test
	 public  void extentReport() throws Exception{
			et.log(Status.INFO, "Starting test case");
		    driver.get("https://www.google.com/");
		    et.pass("Navigated to google.com");
		 	driver.findElement(By.name("q")).sendKeys("cricket");
			et.pass("Entered text in searchbox");
			driver.findElement(By.name("btnK")).submit();
			et.pass("pressed keyboard enter key");
	}
	  
		
	@After
	public  void tearDown() throws Exception{
		driver.quit();
		et.pass("closed the browser");
		et.info("Test completed");
		exe.flush();
	}
  
}
