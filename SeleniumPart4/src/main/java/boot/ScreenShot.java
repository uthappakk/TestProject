package boot;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ScreenShot {
	WebDriver driver;
	   @Before
	   public void setup() throws Exception{
		   System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		   driver.get("https://api.jquery.com/dblclick/");
	   }
	   
	   @Test
	   public  void clickButton() throws IOException,InterruptedException{
		   File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(SrcFile,new File("D:\\test.png"));
	   }
	   
	   @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}

