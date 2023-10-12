package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GithubPage;
import pages.IssueExamplePage;
import pages.RepositoryCodePage;
import pages.RepositoryIssuePage;

public class ListenerGithubPageTests extends TestBase {
    GithubPage githubPage = new GithubPage();
    RepositoryCodePage repositoryCodePage = new RepositoryCodePage();
    RepositoryIssuePage repositoryIssuePage = new RepositoryIssuePage();
    IssueExamplePage issueExamplePage = new IssueExamplePage();

    @Test
    @DisplayName("Проверка Issue")
    @Owner("VS")
    @Severity(SeverityLevel.NORMAL)
    void verifyIssueTitleSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        githubPage.openPage()
                .setSearchInputValue();
        repositoryCodePage.clickIssueTab();
        repositoryIssuePage.clickIssueValue();
        issueExamplePage.verifyIssueTitle();
    }
}
