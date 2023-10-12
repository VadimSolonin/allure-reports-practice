package pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$x;

public class RepositoryIssuePage {

    TestData testData = new TestData();

    SelenideElement issueExample = $x("//div[contains(@aria-label, 'Issues')]");

    public RepositoryIssuePage clickIssueValue() {
        issueExample.$(byText(testData.ISSUE_NAME)).click();
        return this;
    }
}
