package providers;

import org.testng.annotations.DataProvider;

public class SearchKeywordProvider {
    @DataProvider
    public Object[][] searchUrlAndKeyword() {
        return new Object[][] {
            {"https://google.com", "EPAM"}
        };
    }
}
