package utilities;
import constants.ExecutionType;
public class RuntimeConfig {

    public static String getBrowser() {

        String browser =
                System.getProperty("browser");

        if (browser != null &&
                !browser.isEmpty()) {

            return browser;
        }

        return ConfigReader.getProperty("browser");
    }

    public static boolean isHeadless() {

        String headless =
                System.getProperty("headless");

        if (headless != null &&
                !headless.isEmpty()) {

            return Boolean.parseBoolean(headless);
        }

        return Boolean.parseBoolean(
                ConfigReader.getProperty("headless"));
    }
    public static ExecutionType getExecutionType() {

        String execution =
                System.getProperty("execution");

        if (execution != null &&
                !execution.isEmpty()) {

            return ExecutionType.valueOf(
                    execution.toUpperCase());
        }

        return ExecutionType.valueOf(
                ConfigReader
                        .getProperty("execution")
                        .toUpperCase());
    }
    public static String getRemoteUrl() {

        String remoteUrl =
                System.getProperty("remoteUrl");

        if (remoteUrl != null &&
                !remoteUrl.isEmpty()) {

            return remoteUrl;
        }

        return ConfigReader.getProperty("remoteUrl");
    }
}