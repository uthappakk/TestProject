package boot;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchTab {
	WebDriver driver;
	   @Before
	   public void setup() throws Exception{
		   System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		   driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	   }
	   
	   @Test
	   public void clickButton() throws Exception{
		   driver.findElement(By.linkText("Medical Records")).click();
		   driver.findElement(By.linkText("Search Patient")).click();
		   Select fruits = new Select(driver.findElement(By.id("search_type")));
		   fruits.selectByIndex(2);
		   driver.findElement(By.name("search_patient")).click();
		   Thread.sleep(30000);
	   }
	   
	   @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}

