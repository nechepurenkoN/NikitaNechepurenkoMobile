package page.nativeapp;

import dto.RegisterData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
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
    WebElement emailInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement usernameInput;

    @AndroidFindBy(id="platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordInput;

    @AndroidFindBy(id="platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement passwordConfirmInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.CheckedTextView")
    WebElement agreementCheck;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerButton;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_cancel_button")
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
