package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.remote;

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
        if (testConfig.getEnv()==Remote.remote) {
            remote = testConfig.getRemoteUrl();
        }
        Configuration.browserCapabilities =
                switch (testConfig.getBrowser()) {
                    case CHROME -> chromeOptionsWithLanguage();
                    case FIREFOX -> firefoxOptionsWithLanguage();
                };
        System.setProperty("jdk.tls.maxCertificateChainLength", "50");
    }

    private ChromeOptions chromeOptionsWithLanguage() {
        ChromeOptions options = new ChromeOptions();
        String language = testConfig.getBrowserLanguage();
        options.addArguments("--lang=" + language.split("-")[0]);
        if (testConfig.isHeadless()) {
            options.addArguments("--headless=new");
        }
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", language);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    private FirefoxOptions firefoxOptionsWithLanguage() {
        FirefoxOptions options = new FirefoxOptions();
        if (testConfig.isHeadless()) {
            options.addArguments("-headless");
        }
        return options;
    }
}
