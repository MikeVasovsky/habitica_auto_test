package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static config.Remote.REMOTE;

public class WebConfig {
    private final TestConfig testConfig;

    public WebConfig(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public void testConfig() {
        Configuration.baseUrl = testConfig.gerUrl();
        Configuration.browser = testConfig.getBrowser().name().toLowerCase();
        Configuration.browserVersion = testConfig.getBrowserVersion();
        Configuration.browserSize = testConfig.getBrowserSize();
        Configuration.pageLoadStrategy = testConfig.getLoadStrategy();
        if (testConfig.getEnv() == REMOTE) {
            Configuration.remote = testConfig.getRemoteUrl();
        }
        Configuration.browserCapabilities =
                switch (testConfig.getBrowser()) {
                    case CHROME -> new ChromeOptions();
                    case FIREFOX -> new FirefoxOptions();
                };
        System.setProperty("jdk.tls.maxCertificateChainLength", "50");
    }
}
