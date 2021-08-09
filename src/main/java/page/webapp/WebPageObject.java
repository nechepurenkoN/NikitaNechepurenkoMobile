package page.webapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page.IPageObject;

public class WebPageObject implements IPageObject {

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }

    @Override
    public WebElement getWelement(String weName) {
        return null;
    }
}
