package ru.zenicko.wikipedia.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selectors;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AndroidTests extends TestBase{

    @Test
    void searchText() {

        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        sleep(5000);

        $$(Selectors.byClassName("android.widget.TextView")).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}
