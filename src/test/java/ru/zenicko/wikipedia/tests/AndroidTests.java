package ru.zenicko.wikipedia.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Check search text")
    void searchText() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        $$(Selectors.byClassName("android.widget.TextView")).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    @DisplayName("Check default language (EN)")
    void defaultLanguageIsEn() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_lang_button")).shouldHave(Condition.text("EN"));
    }

    @ParameterizedTest(name = "ParameterizedTest: Change a default language on {1} and check the code language {0}")
    @CsvSource(value = {"RU:Русский:Russian"}, delimiter = ':')
    @Feature("Feature: Language panel")
    @Story("Story: Can choose a language")
    @DisplayName("DisplayName: Change a default language and check the code language")
    @Description("Description: It's the test description \"Change a language and check the code language\"")
    void CanChangelanguageParametrizedTest(String codeLanguage,
                                           String localizedLanguageName,
                                           String languageSubtitle) {
        String searchText = "Search Wikipedia";

        step(String.format("Enter searching text \"%s\" and click", searchText), () -> {
            $(MobileBy.AccessibilityId(searchText)).click();
        });

        step("Open the language panel", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_lang_button"))
                    .click();
            $$(MobileBy.id("org.wikipedia.alpha:id/preference_languages_list"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });

        step(String.format("Enter a short line of a searching text \"%s\"", languageSubtitle), () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_filter")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_filter")).setValue(languageSubtitle);
        });

        step(String.format("Choose the language %s:%s", localizedLanguageName, languageSubtitle), () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/localized_language_name")).shouldHave(Condition.text(localizedLanguageName));
            $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_filter")).shouldHave(Condition.text(languageSubtitle));
            $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_list")).click();
        });
        step(String.format("Check a code language: should be %s", codeLanguage), () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_lang_button")).shouldHave(Condition.text(codeLanguage));
        });
    }

}
