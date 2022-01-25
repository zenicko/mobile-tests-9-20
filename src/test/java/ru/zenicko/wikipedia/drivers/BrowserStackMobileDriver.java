package ru.zenicko.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;

public class BrowserStackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", "bot_l05D9g");
        desiredCapabilities.setCapability("browserstack.key", "jy2xzhDKAtFVyrp8Lc7x");
        desiredCapabilities.setCapability("browserstack.networkLogs", "true");

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver driver = new AndroidDriver(getBrowserStackUrl(), desiredCapabilities);

        return driver;
    }

    public static URL getBrowserStackUrl() {

        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
