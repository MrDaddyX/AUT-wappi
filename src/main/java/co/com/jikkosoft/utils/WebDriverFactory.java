package co.com.jikkosoft.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

	// @Managed
	private static WebDriver driver;

	public static WebDriverFactory web() {
		driver = getDriver();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return new WebDriverFactory();
	}

	public static WebDriver getDriver() {
		String webdriverstr = System.getProperty("serenity.driver.name");
		if (webdriverstr == null) {
			webdriverstr = "chrome";
		}

		switch (webdriverstr) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			FirefoxOptions fireopts = new FirefoxOptions();
			fireopts.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			return new FirefoxDriver();
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			ChromeOptions chropts = new ChromeOptions();
			chropts.setAcceptInsecureCerts(true);
			return new ChromeDriver();
		case "edge":
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/MicrosoftWebDriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.edge();
			capabilities.setJavascriptEnabled(true);
			capabilities.setAcceptInsecureCerts(true);
			return new EdgeDriver();
		default:
			throw new RuntimeException("Unsupported webdriver: " + webdriverstr);
		}
	}

	public WebDriver onPage(String url){
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
