package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome {

	public static WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		ChromeOptions options = new ChromeOptions();
				
		// String nodeURL = "http://localhost:4444";  //Use localhost when working on Standalone mode
		String nodeURL = "http://10.0.0.40:4444";
		
		WebDriverManager.chromedriver().arch64().setup();;
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrufu\\Downloads\\SeleniumGrid4\\chromedriver.exe");
		driver = new RemoteWebDriver(new URL(nodeURL), options);
		//driver = new ChromeDriver();
	}
	
	@Test
	public void maintest() {
		driver.get("http://google.com/");
		System.out.println("I AM IN CHROME");
		System.out.println("I AM IN CHROME : " + driver.getTitle());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
