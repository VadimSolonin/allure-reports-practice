package pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubPage {

    TestData testData = new TestData();
    SelenideElement searchInput = $(".search-input"),
            searchCombobox = $("#query-builder-test"),
            issueTab = $("#issues-tab"),
            issueExample = $x("//div[contains(@aria-label, 'Issues')]"),
            issueTitle = $(".markdown-title");

    public GithubPage openPage() {
        open(testData.PAGE_ADDRESS);
        return this;
    }

    public GithubPage setSearchInputValue() {
        searchInput.click();
        searchCombobox.setValue(testData.SELENIDE_SEARCH_TEXT).pressEnter();
        return this;
    }


    public GithubPage clickIssueTab() {
        issueTab.click();
        return this;
    }

    public GithubPage clickIssueValue() {
        issueExample.$(byText(testData.ISSUE_NAME)).click();
        return this;
    }

    public GithubPage verifyIssueTitle() {
        issueTitle.shouldHave(text(testData.ISSUE_NAME));
        return this;
    }


}
