package tests;

import data.CreateCaseData;
import data.CreateChallengeData;
import io.qameta.allure.Step;
import model.CreateCaseModel;
import model.CreateChallengeModel;
import pages.ChallengePage;
import pages.MainPage;
import pages.UsernamePage;

import static com.codeborne.selenide.Selenide.open;
import static data.CreateChallengeData.ADD_GROUP;

public class AppSteps {
    CreateCaseData createCaseData = new CreateCaseData();
    CreateChallengeData createChallengeData = new CreateChallengeData();
    UsernamePage usernamePage = new UsernamePage();
    MainPage mainPage = new MainPage();
    ChallengePage challengePage = new ChallengePage();

    @Step("Открыть страницу")
    void openPage() {
        open("");
    }

    @Step("Ввод нового имени пользователя")
    public void newUsername(String name) {
        usernamePage.inputName(name);
        usernamePage.confirmUsername();
    }

    @Step("Создание данных испытания")
    CreateCaseModel createEveryDayCaseData() {
        return new CreateCaseModel(
                createCaseData.getTittle(),
                createCaseData.getNote(),
                createCaseData.getPoint(),
                createCaseData.getDifficult(),
                createCaseData.getYear(),
                createCaseData.getMonth(),
                createCaseData.getDay(),
                createCaseData.getRepeat(),
                createCaseData.getRepeatDay(),
                createCaseData.getDayWeek(),
                createCaseData.getTag()
        );
    }

    @Step("Создать данные испытания")
    public CreateChallengeModel createChallengeData() {
        return new CreateChallengeModel(
                createChallengeData.getName(),
                createChallengeData.getShortName(),
                createChallengeData.getResume(),
                createChallengeData.getDesk(),
                ADD_GROUP,
                createChallengeData.getCategory(),
                createChallengeData.getGift());
    }
}
