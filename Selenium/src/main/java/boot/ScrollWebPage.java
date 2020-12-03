package boot;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollWebPage {
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
	   public void scrollPage() throws Exception{
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		   Thread.sleep(5000);
		   System.out.println("Web page scrolled successfully");
	   }
	   
	   @After
	   public void tearDown() throws Exception{
		   driver.quit();
	   }
}
