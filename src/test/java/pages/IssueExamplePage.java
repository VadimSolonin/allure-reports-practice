package pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class IssueExamplePage {

    TestData testData = new TestData();
    SelenideElement issueTitle = $(".markdown-title");

    public IssueExamplePage verifyIssueTitle() {
        issueTitle.shouldHave(text(testData.ISSUE_NAME));
        return this;
    }
}
