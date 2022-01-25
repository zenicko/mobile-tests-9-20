package ru.zenicko.wikipedia.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.zenicko.wikipedia.drivers.BrowserStackMobileDriver;

public class TestBase {

    @BeforeAll
    public static void SetUp() {
        Configuration.browser = BrowserStackMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        Selenide.open();
    }

    @AfterEach
    public void setDown() {
        Selenide.closeWebDriver();
    }
}
