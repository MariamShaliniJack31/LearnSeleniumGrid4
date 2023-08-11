package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//C:\Users\mrufu\Downloads\SeleniumGrid4>java -jar selenium-server-4.11.0.jar standalone
//First Run this command to start Selenium Grid on localhost:4444
public class Params_Parallel {

	public static WebDriver driver;

	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser) throws MalformedURLException {

		//String nodeURL = "http://localhost:4444";
		System.out.println(browser);
		switch(browser.toLowerCase())	{

			case "chrome":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");;
				options.addArguments("--disable-extensions");;
				options.addArguments("--start-maximized");;
				WebDriverManager.chromedriver().arch64().setup();;
				driver = new ChromeDriver(options);
				System.out.println("I AM IN CHROME :):)");
				break;
	
			case "firefox":
				FirefoxOptions foptions = new FirefoxOptions();
				foptions.addArguments("--disable-notifications");;
				foptions.addArguments("--disable-extensions");;
				foptions.addArguments("--start-maximized");;
				WebDriverManager.firefoxdriver().arch64().setup();
				driver = new FirefoxDriver(foptions);
				System.out.println("I AM IN ff");
				break;
			
			case "edge":
				EdgeOptions eoptions = new EdgeOptions();
				eoptions.addArguments("--disable-notifications");;
				eoptions.addArguments("--disable-extensions");;
				eoptions.addArguments("--start-maximized");;
				WebDriverManager.edgedriver().arch64().setup();;
				driver = new EdgeDriver(eoptions);
				System.out.println("I AM IN EDGE");
				break;
			
			default:
				break;
		}

	}

	@Test
	public void maintest() {
		
		driver.get("http://google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Google"));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}