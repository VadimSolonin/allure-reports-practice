package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GithubPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaGithubPageTests extends TestBase {

    @Test
    @DisplayName("Проверка Issue при помощи Lambda шагов")
    @Owner("VS")
    @Severity(SeverityLevel.NORMAL)
    void verifyIssueTitleLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        TestData testData = new TestData();

        step("Открываем главную страницу", () -> {
            open(testData.PAGE_ADDRESS);
        });

        step("Вводим значение репозитория", () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(testData.SELENIDE_SEARCH_TEXT).pressEnter();
        });
        step("Кликаем по табу Issue", () -> {
            $("#issues-tab").click();
        });
        step("Кликаем по конкретному issue", () -> {
            $x("//div[contains(@aria-label, 'Issues')]").$(byText(testData.ISSUE_NAME)).click();
        });
        step("Проверяем, что заголовок содержит имя issue", () -> {
            $(".markdown-title").shouldHave(text(testData.ISSUE_NAME));
        });
    }
}
