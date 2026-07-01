package factory;

import constants.ExecutionType;
import drivers.BrowserManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(
            String browser,
            boolean headless,
            ExecutionType execution,
            String remoteUrl) {

        switch (browser.toLowerCase()) {

            case "chrome":
                return BrowserManager.createChromeDriver(
                        headless,
                        execution,
                        remoteUrl);

            case "firefox":
                return BrowserManager.createFirefoxDriver(
                        headless,
                        execution,
                        remoteUrl);

            case "edge":
                return BrowserManager.createEdgeDriver(
                        headless,
                        execution,
                        remoteUrl);

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser : " + browser);
        }
    }
}