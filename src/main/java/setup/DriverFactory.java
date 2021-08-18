package setup;

import static java.lang.String.format;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    @SneakyThrows
    public static AppiumDriver<WebElement> createDriver(String platformName, String appType, String deviceName,
                                                        String udid, String browserName, String app,
                                                        String appPackage, String appActivity,
                                                        String bundleId) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);

        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        capabilities.setCapability("bundleId", bundleId);

        AppiumDriver<WebElement> driver = new AppiumDriver<>(
            new URL(getHubURL()), capabilities);

        // Timeouts tuning
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @SneakyThrows
    private static String getHubURL() {
        String url = System.getProperty("ts.appium");

        if (System.getProperty("cloud") != null) {
            url = format(url, URLEncoder.encode(System.getProperty("token"), StandardCharsets.UTF_8.name()));
        }

        return url;
    }
}
