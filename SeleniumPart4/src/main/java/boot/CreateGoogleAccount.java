package boot;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateGoogleAccount {
WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signup");
	}
	
	@Test
	public void testCreatingAccout() throws InterruptedException  {
		
		WebElement f_name = driver.findElement(By.id("firstName"));
		f_name.sendKeys("karshan");	
		String firstname = f_name.getAttribute("value");
		System.out.println("First name is:"+firstname);
		
		WebElement l_name = driver.findElement(By.id("lastName"));
		l_name.sendKeys("uthappa");	
		String lastname = l_name.getAttribute("value");
		System.out.println("Last name is:"+lastname);
		
		WebElement user_name = driver.findElement(By.id("username"));
		user_name.sendKeys("karshan123u");	
		String userName = user_name.getAttribute("value");
		System.out.println("Username is:"+userName);
		
		WebElement password = driver.findElement(By.name("Passwd"));
		password.sendKeys("utha_567");	
		String psswd = password.getAttribute("value");
		System.out.println("Password is:"+psswd);
		
		WebElement confirmPassword = driver.findElement(By.name("ConfirmPasswd"));
		confirmPassword.sendKeys("utha_567");	
		String cpsswd = confirmPassword.getAttribute("value");
		System.out.println("Password is:"+cpsswd);
		
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
		System.out.println("Account created successfully");
		
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}



