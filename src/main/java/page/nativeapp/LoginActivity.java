package page.nativeapp;

import dto.LoginData;
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
public class LoginActivity extends BasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement emailUsernameInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement passwordInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInButton;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerButton;

    public LoginActivity(AppiumDriver<WebElement> driver) {
        super(driver);
        super.init(this);
    }

    public void toRegister() {
        log.info("Moving to register activity");
        registerButton.click();
    }

    protected void signIn() {
        log.info("Click on login button");
        signInButton.click();
    }

    public void signIn(LoginData data) {
        log.info("Performing login with: {}", data);
        emailUsernameInput.click();
        emailUsernameInput.sendKeys(data.getEmailUsername());
        passwordInput.click();
        passwordInput.sendKeys(data.getPassword());
        signIn();
    }
}
