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


public class BootStrapDropdown {
	WebDriver driver;
	   @Before
	   public void setup() throws Exception{
		   System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		   driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	   }
	   
	   @Test
	   public void testBootstrap() throws Exception{
		   driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]")).click();
		   List<WebElement> li=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		   for(WebElement el:li) {
			   if(el.getText().contains("HTML") || el.getText().contains("CSS")) {
				   el.click();
			   }
		   }
		   
		   List<WebElement> liel=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		   for(WebElement el:liel) {
			   System.out.println(el.getText());
			   el.click();
		   }
		   
		   System.out.println("Elements Selected:"+driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]")).getText());
	   }
	   
	   @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}
