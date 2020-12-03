package boot;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ConfigFileReader {
	WebDriver driver;
	
		@Test
		public void testFileReader() throws IOException {
			Properties prop = new Properties();
			try {
				InputStream input = new FileInputStream("configs//Configuration.properties");
				prop.load(input);
				System.out.println(prop.getProperty("browser"));
				System.out.println(prop.getProperty("url"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
}

