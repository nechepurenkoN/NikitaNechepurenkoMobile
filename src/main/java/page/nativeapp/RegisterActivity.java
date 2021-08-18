package page.nativeapp;

import dto.RegisterData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import page.BasePage;

@Slf4j
@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
public class RegisterActivity extends BasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement emailInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    WebElement usernameInput;

    @AndroidFindBy(id="platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement passwordInput;

    @AndroidFindBy(id="platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    WebElement passwordConfirmInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.CheckedTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
    WebElement agreementCheck;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    WebElement registerButton;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_cancel_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='cancel']")
    WebElement cancelButton;

    public RegisterActivity(AppiumDriver<WebElement> driver) {
        super(driver);
        super.init(this);
    }

    public void register(RegisterData data) {
        log.info("Performing registration with: {}", data);
        emailInput.sendKeys(data.getEmail());
        usernameInput.sendKeys(data.getUsername());
        passwordInput.sendKeys(data.getPassword());
        passwordConfirmInput.sendKeys(data.getPasswordConfirmed());
        if (data.getIsAgreed()) {
            agreementCheck.click();
        }
        registerButton.click();
    }
}
