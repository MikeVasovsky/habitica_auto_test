package tests;

import allure.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;


import static io.qameta.allure.Allure.step;

public class BaseTest {
    TestData t = new TestData();
    AppSteps  actions = new AppSteps();
    AuthSteps authSteps = new AuthSteps(t);


    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());
        Configuration.browser = testConfig.getBrowser().toLowerCase();
        Configuration.browserVersion = testConfig.getBrowserVersion();
        Configuration.browserSize = testConfig.getBrowserSize();
        Configuration.baseUrl = testConfig.gerUrl();
        Configuration.pageLoadStrategy = testConfig.getLoadStrategy();
        Configuration.browserCapabilities = options;

    }

    @BeforeEach()
    void addListener() {
        actions.openPage();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterTest() {
        step("Приложить вложения", () -> {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        });
        step("Закрыть браузер", Selenide::closeWebDriver);
    }

}
