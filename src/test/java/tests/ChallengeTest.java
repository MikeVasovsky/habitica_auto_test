package tests;

import model.CreateChallengeModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static data.CreateChallengeData.OFFICIAL_CHL;
@Tag("challenge_test")
public class ChallengeTest extends BaseTest {


    //ТЕСТ НЕСТАБИЛЕН ИЗЗА НОВЫХ ПРОФИЛЕЙ, ИМ НЕ ХВАТАЕТ ПРАВ НА СОЗДАНИЕ ИСПЫТАНИЙ
    @Test
    @Disabled
    @DisplayName("Создать испытание")
    void searchNewChallenge() {
        CreateChallengeModel challenge = actions.createChallengeData();
        authSteps.registrationAndLogin();
        actions.getMainPage()
                .goToFindChallenge()
                .createChallenge()
                .setChallenge(challenge)
                .setResume(challenge)
                .setDeskription(challenge)
                .selectGroup(challenge)
                .selectCategory(challenge)
                .inputNumber(challenge)
                .saveChallenge();
    }

    @Test
    @DisplayName("Добавить себе испытание")
    void joinToChallenge() {
        authSteps.registrationAndLogin();
        actions.getMainPage()
                .goToFindChallenge()
                .searchChallenge(OFFICIAL_CHL)
                .openChallenge(OFFICIAL_CHL)
                .searchMyChallenge();
        step("Проверить наличие  добавленного испытания во вкладке 'Мои испытания'", () ->
                actions.getChallengePage().checkVisibleChallenge(OFFICIAL_CHL));
    }

}
