package drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.ExecutionType;
import factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.RuntimeConfig;

public class BrowserManager {

    public static void initializeBrowser(String browser, boolean headless) {

        WebDriver driver = null;

        ExecutionType execution = RuntimeConfig.getExecutionType();
        String remoteUrl = RuntimeConfig.getRemoteUrl();

        switch (browser.toLowerCase()) {

        case "chrome":
            driver = createChromeDriver(headless, execution, remoteUrl);
            break;

        case "firefox":
            driver = createFirefoxDriver(headless, execution, remoteUrl);
            break;

        case "edge":
            driver = createEdgeDriver(headless, execution, remoteUrl);
            break;

        default:
            throw new IllegalArgumentException("Invalid Browser: " + browser);
        }

        driver.manage().window().maximize();
        DriverFactory.setDriver(driver);
    }

    public static WebDriver createChromeDriver(
            boolean headless,
            ExecutionType execution,
            String remoteUrl) {

        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless=new");
        }

        if (execution == ExecutionType.REMOTE) {
            return createRemoteDriver(remoteUrl, options);
        }

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    public static WebDriver createFirefoxDriver(
            boolean headless,
            ExecutionType execution,
            String remoteUrl) {

        FirefoxOptions options = new FirefoxOptions();

        if (headless) {
            options.addArguments("--headless");
        }

        if (execution == ExecutionType.REMOTE) {
            return createRemoteDriver(remoteUrl, options);
        }

        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(options);
    }

    public static WebDriver createEdgeDriver(
            boolean headless,
            ExecutionType execution,
            String remoteUrl) {

        EdgeOptions options = new EdgeOptions();

        if (headless) {
            options.addArguments("--headless=new");
        }

        if (execution == ExecutionType.REMOTE) {
            return createRemoteDriver(remoteUrl, options);
        }

        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(options);
    }

    private static WebDriver createRemoteDriver(
            String remoteUrl,
            MutableCapabilities capabilities) {

        try {

            return new RemoteWebDriver(
                    new URL(remoteUrl),
                    capabilities);

        } catch (MalformedURLException e) {

            throw new RuntimeException(
                    "Invalid Remote URL: " + remoteUrl,
                    e);
        }
    }
}