package page;

import constants.Timeouts;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public abstract class BasePage implements IPageObject {
    protected AppiumDriver<WebElement> driver;
    protected Map<String, WebElement> attributes;

    public BasePage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        attributes = new HashMap<>();
    }

    protected void setWelement(String name, WebElement element) {
        attributes.put(name, element);
    }

    @SneakyThrows
    protected void setWelement(Field field) {
        attributes.put(field.getName(), (WebElement) field.get(this));
    }

    @Override
    public WebElement getWelement(String weName) {
        if (!attributes.containsKey(weName)) {
            throw new NoSuchElementException(
                String.format("Specified field %s does not exist in %s", weName, this.getClass().getSimpleName()));
        }
        return attributes.get(weName);
    }

    protected <T> void init(T child) {
        log.info("Initializing fields of {}", child.getClass().getSimpleName());
        PageFactory.initElements(new AppiumFieldDecorator(driver), child);
        Arrays.stream(child.getClass().getDeclaredFields())
              .filter(field -> field.getType().isAssignableFrom(WebElement.class))
              .peek(field -> field.setAccessible(true))
              .forEach(this::setWelement);
    }

    protected void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Timeouts.CLICKABLE)
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Timeouts.VISIBLE)
            .until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement webElement) {

        waitForElementToBeClickable(webElement);
        webElement.click();
    }

    protected void sendKeys(WebElement webElement, String message) {
        waitForElementToBeVisible(webElement);
        webElement.clear();
        webElement.sendKeys(message);
    }
}
