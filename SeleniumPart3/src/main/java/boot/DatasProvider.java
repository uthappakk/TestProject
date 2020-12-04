package boot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DatasProvider {
		WebDriver driver;
		
		@org.testng.annotations.DataProvider(name="DP")
		public Object[][] function(){
			Object[][] data = new Object[2][1];
			data[0][0]="Selenium";
			data[1][0]="java";
			return data;
		}
		
		 @BeforeTest
		    public void setup(){
			 System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			   driver=new ChromeDriver();
			   driver.manage().window().maximize();
			   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			   driver.get("https://google.com");
		    }
		
		 @Test(dataProvider = "DP")
			public void testData(String value) {
				WebElement r = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
				r.sendKeys(value);
				Reporter.log("Value entered is:"+value);
				r.sendKeys(Keys.ENTER);
				Reporter.log("Searched results are displayed");
				System.out.println("Success:"+value);

			}
		    
		 
		 @AfterTest
			public void tearDown() {
				driver.quit();
			}
		
}
