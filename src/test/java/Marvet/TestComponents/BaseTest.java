package Marvet.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import Mavet.PageObjects.LandingPage;

public class BaseTest {
	public static WebDriver driver;
	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Marvet//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			// Edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException, InterruptedException {
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
}
