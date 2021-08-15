package scenarios;

import dto.LoginData;
import dto.RegisterData;
import org.testng.annotations.Test;
import providers.UserProvider;
import setup.NativeAppTest;

public class NativeMobileTests extends NativeAppTest {

    @Test(
        groups = {"native"},
        description = "User on the main screen, "
            + "when successfully proceed registration and login "
            + "then BudgetActivity is shown",
        dataProviderClass = UserProvider.class,
        dataProvider = "validRegisterAndLoginData"
    )
    public void simpleNativeTest(RegisterData registerData, LoginData loginData) {
        loginActivity.toRegister();
        registerActivity.register(registerData);
        loginActivity.signIn(loginData);
        budgetActivity.assertThat().activityTitleIsCorrect();
    }
}
