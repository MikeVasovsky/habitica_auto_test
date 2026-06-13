package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.TestData.EMAIL;
import static data.TestData.PWD;

public class ChallengeTest extends BaseTest{

    @Test
    @DisplayName("Создать испытание")
    void searchNewChallenge(){
        regPage.goToLoginPage()
                .enterLogopass(EMAIL, PWD)
                .goToFindChallenge();
    }
}
