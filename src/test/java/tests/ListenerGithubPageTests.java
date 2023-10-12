package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GithubPage;

public class ListenerGithubPageTests extends TestBase {
    GithubPage githubPage = new GithubPage();

    @Test
    @DisplayName("Проверка Issue")
    @Owner("VS")
    @Severity(SeverityLevel.NORMAL)
    void verifyIssueTitleSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        githubPage.openPage()
                .setSearchInputValue()
                .clickIssueTab()
                .clickIssueValue()
                .verifyIssueTitle();
    }
}
