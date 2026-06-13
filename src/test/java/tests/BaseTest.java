package tests;

import allure.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import data.CreateChallengeData;
import data.TestData;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import model.CreateChallengeModel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ChallengePage;
import pages.MainPage;
import pages.RegistrationPage;
import pages.UsernamePage;

import static com.codeborne.selenide.Selenide.open;
import static data.CreateChallengeData.ADD_GROUP;
import static io.qameta.allure.Allure.step;

public class BaseTest {
    RegistrationPage regPage = new RegistrationPage();
    UsernamePage usernamePage = new UsernamePage();
    MainPage mainPage = new MainPage();
    ChallengePage challengePage = new ChallengePage();

    TestData t = new TestData();
    CreateChallengeData c = new CreateChallengeData();

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
        openPage();
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

    @Step("Открыть страницу")
    void openPage() {
        open("");
    }

    @Step("Создать нового пользователя и авторозиция")
    public void registrationAndLogin() {
        regPage.confirmCoockie()
                .inputLogopass(t.email, t.password)
                .confirmLogopass()
                .confirmUsername()
                .skipGreetings();
    }

    @Step("Регистрация нового пользователя")
    public void registrationUser() {
        regPage.inputLogopass(t.email, t.password)
                .confirmLogopass();
    }


    @Step("Ввод нового имени пользователя")
    public void newUsername(String name) {
        usernamePage.inputName(name);
        usernamePage.confirmUsername();
    }

    @Step("Создать данные испытания")
    public CreateChallengeModel create() {
        return new CreateChallengeModel(
                c.getName(),
                c.getShortName(),
                c.getResume(),
                c.getDesk(),
                ADD_GROUP,
                c.getCategory(),
                c.getGift());
    }

}
