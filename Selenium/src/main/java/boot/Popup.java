package boot;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popup {
	WebDriver driver;
	   @Before
	   public void setup() throws Exception{
		   System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		   driver.get("http://popuptest.com/goodpopups.html");
	   }
	   
	   @Test
	   public void handelPopUp() throws Exception{
			   driver.findElement(By.linkText("Good PopUp #1")).click();
			   String MainWindow=driver.getWindowHandle();
			   Set<String> s1=driver.getWindowHandles();
			   Iterator<String> i1=s1.iterator();
			   while(i1.hasNext())			
			   {		
				   String ChildWindow=i1.next();		
	            		
				   if(!MainWindow.equalsIgnoreCase(ChildWindow))			
				   {    		
	                    // Switching to Child window
	                    driver.switchTo().window(ChildWindow);	
	                    System.out.println("Child Window Title: "+driver.getTitle());
	                    // Closing the Child Window.
	                    driver.close();		
	            }		
	        }
		   driver.switchTo().window(MainWindow);
		   System.out.println("Parent Window Title: "+driver.getTitle());
		   }
	   
	   @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}
