package boot;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextwithoutSendkeys {
	WebDriver driver;
	 @Before
	   public void setup() throws Exception{
		 	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		 	driver=new ChromeDriver();
		 	driver.manage().window().maximize();
		 	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 	driver.get("https://login.yahoo.com/");
	 }
	 
	 @Test
	 public void setTextWithoutSendKeys() throws Exception{
		 //driver.findElement(By.name("username")).sendKeys("random@gmail.com");
		 //Thread.sleep(1000);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 WebElement usrnm_email_phone=driver.findElement(By.name("username"));
		 js.executeScript("arguments[0].value='random@gmail.com'", usrnm_email_phone);
		 Thread.sleep(3000);
	 }
	 
	 @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}
