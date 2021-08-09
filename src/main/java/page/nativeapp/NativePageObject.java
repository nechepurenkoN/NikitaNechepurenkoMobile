package page.nativeapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import page.BasePage;

@Slf4j
@Getter
public class NativePageObject {

    private final LoginActivity loginActivity;
    private final RegisterActivity registerActivity;
    private final BudgetActivity budgetActivity;

    public NativePageObject(AppiumDriver<WebElement> appiumDriver) {
        loginActivity = new LoginActivity(appiumDriver);
        registerActivity = new RegisterActivity(appiumDriver);
        budgetActivity = new BudgetActivity(appiumDriver);
    }
}
