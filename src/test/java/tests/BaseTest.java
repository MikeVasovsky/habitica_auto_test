package tests;

import allure.Attach;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.TestConfig;
import config.WebConfig;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import tests.steps.AppSteps;
import tests.steps.AuthSteps;

import static io.qameta.allure.Allure.step;

public class BaseTest {
    TestData t = new TestData();
    AppSteps actions = new AppSteps();
    AuthSteps authSteps = new AuthSteps(t);
    LoginPage loginPage = new LoginPage();

    private static final TestConfig config = ConfigReader.Instance.read();

    @BeforeAll
    static void setUp() {
        WebConfig webConfig = new WebConfig(config);
        webConfig.testConfig();
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
