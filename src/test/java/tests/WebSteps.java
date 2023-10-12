package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    TestData testData = new TestData();

    @Step("Открываем главную страницу")
    public void openPage() {
        open(testData.PAGE_ADDRESS);
    }

    @Step("Вводим значение репозитория")
    public void setSearchInputValue() {
        $(".search-input").click();
        $("#query-builder-test").setValue(testData.SELENIDE_SEARCH_TEXT).pressEnter();
    }

    @Step("Кликаем по табу Issue")
    public void clickIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Кликаем по конкретному issue")
    public void clickIssueValue() {
        $x("//div[contains(@aria-label, 'Issues')]").$(byText(testData.ISSUE_NAME)).click();
    }

    @Step("Проверяем, что заголовок содержит имя issue")
    public void verifyIssueTitle() {
        $(".markdown-title").shouldHave(text(testData.ISSUE_NAME));
    }
}
