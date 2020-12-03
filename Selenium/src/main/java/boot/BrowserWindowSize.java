package boot;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowSize {
	WebDriver driver;
	 @Before
	   public void setup() throws Exception{
		 	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		 	driver=new ChromeDriver();
		 	driver.manage().window().maximize();
		 	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 	driver.get("https://www.google.com");
	 }
	 
	 @Test
	 public void setBrowserSize() throws Exception{
		 Dimension dim=new Dimension(600,720);
		 driver.manage().window().setSize(dim);
		 Thread.sleep(3000);
		 System.out.println("Browser size set successfully");
	 }
	 
	 @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}
