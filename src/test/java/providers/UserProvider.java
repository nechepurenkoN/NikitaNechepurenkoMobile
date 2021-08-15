package providers;

import com.google.gson.Gson;
import dto.LoginData;
import dto.RegisterData;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

public class UserProvider {
    private static final String CORRECT_USER_PATH = "/users/correct.json";

    @SneakyThrows
    @DataProvider
    public Object[][] validRegisterAndLoginData() {
        RegisterData registerData = new Gson().fromJson(
            FileUtils.readFileToString(
                new File(Objects.requireNonNull(this.getClass().getResource(CORRECT_USER_PATH)).getFile()),
                StandardCharsets.UTF_8
            ),
            RegisterData.class
        );

        return new Object[][] {
            {registerData, new LoginData(registerData.getEmail(), registerData.getPassword())}
        };
    }
}
