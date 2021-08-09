package scenarios;

import dto.LoginData;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.NativeAppTest;

public class NativeMobileTests extends NativeAppTest {

    @Test(
        groups = {"native"},
        description = "User on the main screen, "
            + "when successfully proceed registration and login "
            + "then BudgetActivity is shown"
    )
    public void simpleNativeTest() {
        nativeApp.getLoginActivity().signIn(new LoginData("123@123.com", "12345678"));
        System.out.println("Simplest Android native test done");
    }
}
