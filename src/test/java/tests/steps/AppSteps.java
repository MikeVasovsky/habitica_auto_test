package tests.steps;

import data.CreateCaseData;
import data.CreateChallengeData;
import io.qameta.allure.Step;
import lombok.Data;
import model.CreateCaseModel;
import model.CreateChallengeModel;
import pages.ChallengePage;
import pages.MainPage;
import pages.UsernamePage;

import static com.codeborne.selenide.Selenide.open;
import static data.CreateChallengeData.ADD_GROUP;

@Data
public class AppSteps {
    CreateCaseData createCaseData = new CreateCaseData();
    CreateChallengeData createChallengeData = new CreateChallengeData();
    UsernamePage usernamePage = new UsernamePage();
    MainPage mainPage = new MainPage();
    ChallengePage challengePage = new ChallengePage();

    @Step("Открыть страницу")
    public void openPage() {
        open("");
    }

    @Step("Ввод нового имени пользователя")
    public void newUsername(String name) {
        usernamePage.clearUsername()
                .inputName(name)
                .clickPrivacyCheckbox()
                .clickSubmitUsernameBtn();
    }

    @Step("Создание данных испытания")
    public CreateCaseModel createEveryDayCaseData() {
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
