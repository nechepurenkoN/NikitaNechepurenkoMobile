package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import providers.SearchKeywordProvider;
import setup.BaseTest;
import setup.WebAppTest;

public class WebMobileTests extends WebAppTest {

    @Test(
        groups = {"web"},
        description = "Enter a keyword in the search field and expect the keyword in list",
        dataProviderClass = SearchKeywordProvider.class,
        dataProvider = "searchUrlAndKeyword"
    )
    public void simpleWebTest(String url, String keyword) {
        webApp.open(url)
              .sendKeysSearch(keyword)
              .performSearch()
              .assertThat()
              .resultTitlesTextContains(keyword);
    }

}
