package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WinChrome {

	public static WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		String nodeURL = "http://192.168.1.3:19184/wd/hub";
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrufu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//driver = new RemoteWebDriver(new URL(nodeURL), cap);
		driver = new ChromeDriver();
	}
	
	@Test
	public void maintest() {
		driver.get("http://google.com/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
