package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edge {

	public static WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		EdgeOptions eoptions = new EdgeOptions();
		
		//String nodeURL = "http://localhost:4444";
		String nodeURL = "http://10.0.0.40:4444";
		
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\mrufu\\Downloads\\SeleniumGrid4\\edgedriver.exe");
		WebDriverManager.edgedriver().arch64().setup();;
		driver = new RemoteWebDriver(new URL(nodeURL), eoptions);
		//driver = new ChromeDriver();
	}
	
	@Test
	public void maintest() {
		driver.get("http://google.com/");
		System.out.println("I AM IN EDGE");
		System.out.println("I AM IN EDGE : " + driver.getTitle());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
