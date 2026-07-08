package tests;

import model.CreateChallengeModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ChallengePage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static data.CreateChallengeData.OFFICIAL_CHL;

@Tag(TestTags.HABITICA)
@Tag(TestTags.CHALLENGE)
public class ChallengeTest extends BaseTest {

    //ТЕСТ НЕСТАБИЛЕН ИЗЗА НОВЫХ ПРОФИЛЕЙ, ИМ НЕ ХВАТАЕТ ПРАВ НА СОЗДАНИЕ ИСПЫТАНИЙ
    @Test
    @Disabled
    @DisplayName("Создать испытание")
    void searchNewChallenge() {
        CreateChallengeModel challenge = actions.createChallengeData();
        authSteps.registrationAndLogin();

        ChallengePage challengePage = actions.getMainPage()
                .goToFindChallenge()
                .clickCreateChallengeBtn()
                .setChallengeName(challenge.getName())
                .setShortName(challenge.getShortName())
                .setResume(challenge.getResume())
                .setDescription(challenge.getDesk())
                .selectGroup(challenge.getGroup())
                .setGift(challenge.getGift());

        challengePage.openCategorySelector();
        challenge.getCategory().forEach(challengePage::selectCategoryItem);
        challengePage.closeCategorySelector()
                .clickSaveChallengeBtn();
    }

    @Test
    @DisplayName("Добавить себе испытание")
    void joinToChallenge() {
        authSteps.registrationAndLogin();
        actions.getMainPage()
                .goToFindChallenge()
                .clickFindChallenges()
                .clickHabiticaOfficialFilter()
                .setSearchQuery(OFFICIAL_CHL)
                .openChallenge(OFFICIAL_CHL)
                .clickMyChallenges();
        step("Проверить наличие  добавленного испытания во вкладке 'Мои испытания'", () ->
                actions.getChallengePage().checkVisibleChallenge(OFFICIAL_CHL));
    }
}
