package setup;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    @SneakyThrows
    public static AppiumDriver<WebElement> createDriver(String platformName, String appType, String deviceName,
                                                        String browserName, String app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);

        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        AppiumDriver<WebElement> driver = new AppiumDriver<>(new URL(System.getProperty("ts.appium")), capabilities);

        // Timeouts tuning
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
