package tests;

import data.CreateChallengeData;
import model.CreateChallengeModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static data.CreateChallengeData.OFFICIAL_CHL;

public class ChallengeTest extends BaseTest {
    CreateChallengeData c = new CreateChallengeData();

    //ТЕСТ НЕСТАБИЛЕН ИЗЗА НОВЫХ ПРОФИЛЕЙ, ИМ НЕ ХВАТАЕТ ПРАВ НА СОЗДАНИЕ ИСПЫТАНИЙ
    @Test
    @DisplayName("Создать испытание")
    void searchNewChallenge() {
        CreateChallengeModel challenge = create();
        registrationAndLogin();
        mainPage
                .goToFindChallenge()
                .createChallenge(challenge);
    }

    @Test
    @DisplayName("Добавить себе испытание")
    void joinToChallenge() {
        registrationAndLogin();
        mainPage
                .goToFindChallenge()
                .searchChallenge(OFFICIAL_CHL)
                .openChallenge(OFFICIAL_CHL)
                .searchMyChallenge();
        step("Проверить наличие  добавленного испытания во вкладке 'Мои испытания'", () ->
                challengePage.checkVisibleChallenge(OFFICIAL_CHL));
    }


}
