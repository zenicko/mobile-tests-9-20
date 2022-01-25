package ru.zenicko.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;

import static ru.zenicko.wikipedia.config.Project.projectConfig;
import static ru.zenicko.wikipedia.config.browserstack.BrowserStack.browserStackConfig;

public class BrowserStackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", browserStackConfig.user());
        desiredCapabilities.setCapability("browserstack.key", browserStackConfig.key());
        desiredCapabilities.setCapability("browserstack.networkLogs", browserStackConfig.networkLogs());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", browserStackConfig.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", projectConfig.device());
        desiredCapabilities.setCapability("os_version", projectConfig.osVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", projectConfig.project());
        desiredCapabilities.setCapability("build", projectConfig.build());
        desiredCapabilities.setCapability("name", projectConfig.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver driver = new AndroidDriver(getBrowserStackUrl(), desiredCapabilities);

        return driver;
    }

    public static URL getBrowserStackUrl() {

        try {
            return new URL(browserStackConfig.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
