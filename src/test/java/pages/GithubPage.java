package pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestData;

import static com.codeborne.selenide.Selenide.*;

public class GithubPage {

    TestData testData = new TestData();
    SelenideElement searchInput = $(".search-input"),
            searchCombobox = $("#query-builder-test");



    public GithubPage openPage() {
        open(testData.PAGE_ADDRESS);
        return this;
    }

    public GithubPage setSearchInputValue() {
        searchInput.click();
        searchCombobox.setValue(testData.SELENIDE_SEARCH_TEXT).pressEnter();
        return this;
    }







}
