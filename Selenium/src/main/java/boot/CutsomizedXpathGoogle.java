package boot;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CutsomizedXpathGoogle {
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
		 public void xpath() throws Exception{
		   WebElement element = driver.findElement(By.name("q"));
		   element.sendKeys("cricket");
		   List<WebElement> findElements = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		   for(WebElement i:findElements) {
			   String tex=i.getText();
			   if(tex.equals("cricket news")) {
				      i.click();
				      System.out.println("successfully executed");
				      Thread.sleep(3000);
				      break;
			   }
			   
		   } 
	   }
	   
	   @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}
