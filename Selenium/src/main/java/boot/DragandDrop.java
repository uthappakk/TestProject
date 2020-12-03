package boot;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {
	WebDriver driver;
	   @Before
	   public void setup() throws Exception{
		   System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		   driver.get("https://jqueryui.com/droppable/");
	   }
	   
	   
	   @Test
	   public void testDragDrop() throws Exception{
		   driver.switchTo().frame(0);
		   WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
		   WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
		   Actions act=new Actions(driver);
		   act.dragAndDrop(drag, drop).build().perform();
		   String afterDrag=driver.findElement(By.xpath(".//*[@id='droppable']")).getText();
		   if(afterDrag.equals("Dropped!")) {
			   System.out.println("PASS: file is dropped");
		   }
		   else {
			   System.out.println("PASS: file failed to drop");
		   }
			   
	   }
	   
	   
	   @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}
