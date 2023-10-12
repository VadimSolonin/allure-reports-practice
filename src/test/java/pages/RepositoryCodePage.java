package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RepositoryCodePage {

    SelenideElement issueTab = $("#issues-tab");


    public RepositoryCodePage clickIssueTab() {
        issueTab.click();
        return this;
    }


}
