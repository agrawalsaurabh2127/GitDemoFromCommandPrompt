package selenium_Grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Selenium_Grid_Concept {

	public RemoteWebDriver driver;

	@BeforeClass
	@Parameters({"browserName"})
	public void setUp(String browserName) throws MalformedURLException {
		System.out.println("******* Invoking test with " + browserName + " browser*******");

		DesiredCapabilities caps = null;

		// Decide which browser need to invoke
		if (browserName.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.ANY);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");
			caps.setPlatform(Platform.ANY);
		}else if (browserName.equalsIgnoreCase("IE")) {
			caps = DesiredCapabilities.internetExplorer();
			caps.setBrowserName("IE");
			caps.setPlatform(Platform.ANY);
		}
		
		ChromeOptions options = new ChromeOptions();
		options.merge(caps);

		String hubUrl = "http://localhost:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubUrl), caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void testGooglePageTitle() {
		System.out.println("***** Navigation to Application *****");
		driver.get("https://www.google.co.in");
		String pageTitle = driver.getTitle();
		System.out.println("***** Verifying the Page Title *****");
		Assert.assertTrue(pageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
