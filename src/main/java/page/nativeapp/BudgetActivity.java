package page.nativeapp;

import constants.NativeApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import page.BasePage;

@Slf4j
@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
public class BudgetActivity extends BasePage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
    WebElement activityTitle;

    public BudgetActivity(AppiumDriver<WebElement> driver) {
        super(driver);
        super.init(this);
    }

    public BudgetAssertion assertThat() {
        return new BudgetAssertion(this);
    }

    public static class BudgetAssertion {

        private final BudgetActivity budgetActivity;

        public BudgetAssertion(BudgetActivity budgetActivity) {
            this.budgetActivity = budgetActivity;
        }

        public void activityTitleIsCorrect() {
            log.info("Check that activity title is equal to {}", NativeApp.BUDGET_ACTIVITY_TITLE);
            Assertions.assertThat(budgetActivity.getActivityTitle().getText()).isEqualTo(NativeApp.BUDGET_ACTIVITY_TITLE);
        }
    }
}
