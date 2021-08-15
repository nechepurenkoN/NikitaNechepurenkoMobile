package setup;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.webapp.WebPageObject;

@Slf4j
public class WebAppTest extends BaseTest {

    protected WebPageObject webApp;

    @Parameters({"platformName", "appType", "deviceName", "browserName", "app"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String browserName,
                      @Optional("") String app) {
        driver = DriverFactory.createDriver(platformName, appType, deviceName, browserName, app);
        log.info("New appium driver session has been created");
        webApp = new WebPageObject(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.closeApp();
        log.info("Driver has closed the app");
    }
}
