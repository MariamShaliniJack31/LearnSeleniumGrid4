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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//C:\Users\mrufu\Downloads\SeleniumGrid4>java -jar selenium-server-4.11.0.jar standalone
//First Run this command to start Selenium Grid on localhost:4444
public class Params_SA_Parallel {

	public static WebDriver driver;

	@Parameters({"browser1"})
	@BeforeTest
	public void setup(String browser) throws MalformedURLException {


		String nodeURL = "http://localhost:4444";
		System.out.println(browser);
		switch(browser)	{

			case "chrome":
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrufu\\Downloads\\SeleniumGrid4\\chromedriver.exe");
				driver = new RemoteWebDriver(new URL(nodeURL), options);
				//driver = new ChromeDriver();
				System.out.println("I AM IN CHROME");
				break;
	
			case "firefox":
				FirefoxOptions foptions = new FirefoxOptions();
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrufu\\Downloads\\SeleniumGrid4\\geckodriver.exe");
				driver = new RemoteWebDriver(new URL(nodeURL), foptions);
				//driver = new ChromeDriver();
				System.out.println("I AM IN ff");
				break;
			
			case "edge":
				EdgeOptions eoptions = new EdgeOptions();
				System.setProperty("webdriver.edge.driver", "C:\\Users\\mrufu\\Downloads\\SeleniumGrid4\\edgedriver.exe");
				driver = new RemoteWebDriver(new URL(nodeURL), eoptions);
				//driver = new ChromeDriver();
				System.out.println("I AM IN EDGE");
				break;
			
			default:
				break;
		}

	}

	@Test
	public void maintest() {
		driver.get("http://google.com/");
		System.out.println(driver.getTitle());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}