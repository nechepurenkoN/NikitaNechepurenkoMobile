package setup;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import page.IPageObject;
import page.nativeapp.NativePageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import page.webapp.WebPageObject;

@Slf4j
public abstract class BaseTest {

    protected AppiumDriver<WebElement> driver;

    @Parameters({"platformName", "appType", "deviceName"})
    @BeforeSuite(alwaysRun = true)
    public void setUpSuite(String platformName, String appType, @Optional("") String deviceName) {
        log.info("Running suite with {} appType on device: {} on platform: {}", appType, deviceName, platformName);
    }

}
