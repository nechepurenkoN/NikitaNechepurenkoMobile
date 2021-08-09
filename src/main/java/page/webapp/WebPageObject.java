package page.webapp;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

@Slf4j
@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
public class WebPageObject extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchInput;

    @FindBy(xpath = "//div[@id='rso']//a//div//div")
    List<WebElement> resultTitles;

    public WebPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
        super.init(this);
    }

    public WebPageObject open(String url) {
        log.info("Open {}", url);
        driver.get(url);
        return this;
    }

    public WebPageObject sendKeysSearch(String value) {
        log.info("Sending keys to search: {}", value);
        sendKeys(searchInput, value);
        return this;
    }

    public WebPageObjectAssertion assertThat() {
        return new WebPageObjectAssertion(this);
    }

    public WebPageObject performSearch() {
        log.info("Performing search");
        sendKeys(driver.getKeyboard(), Keys.ENTER);
        driver.hideKeyboard();
        return this;
    }

    public static class WebPageObjectAssertion {
        private final WebPageObject webPageObject;

        public WebPageObjectAssertion(WebPageObject webPageObject) {
            this.webPageObject = webPageObject;
        }

        public void resultTitlesTextContains(String value) {
            List<String> linkTexts = webPageObject.resultTitles.stream()
                                                              .map(WebElement::getText)
                                                              .collect(Collectors.toList());
            log.info("Check that {} is in results", value);
            Assertions.assertThat(linkTexts).anyMatch(text -> text.contains(value));
        }

    }
}
