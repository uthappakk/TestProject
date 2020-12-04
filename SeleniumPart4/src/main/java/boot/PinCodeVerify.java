package boot;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PinCodeVerify {
	WebDriver driver;
	 @Before
	   public void setup() throws Exception{
		   System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		   driver.get("http://chennaiiq.com/chennai/pincode-by-name.php");
	   }
	 
	 @Test
	  public void verifyPin() throws InterruptedException  {
		 WebElement firstloc=driver.findElement(By.xpath("//table[@class='TBox']//tbody//tr[4]//td[2]"));
		 WebElement firstlocpin=driver.findElement(By.xpath("//table[@class='TBox']//tbody//tr[4]//td[3]"));
		 WebElement secondloc=driver.findElement(By.xpath("//table[@class='TBox']//tbody//tr[5]//td[2]"));
		 WebElement secondlocpin=driver.findElement(By.xpath("//table[@class='TBox']//tbody//tr[5]//td[3]"));
		 Assert.assertNotEquals(firstlocpin.getText().toString().trim(),secondlocpin.getText().toString().trim());
		 System.out.println("Pin code of "+firstloc.getText().toString().trim()+"is : "+firstlocpin.getText().toString().trim());
		 System.out.println("Pin code of "+secondloc.getText().toString().trim()+"is : "+secondlocpin.getText().toString().trim());
		 System.out.println("So the pin code of 2 different locations are different,unique,and not same");
	 }
	 
	 
	 @After
	 public void tearDown() throws Exception{
		  driver.quit();
	 }
}

