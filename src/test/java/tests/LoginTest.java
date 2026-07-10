package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.TestData.*;

@Tag(TestTags.HABITICA)
@Tag(TestTags.LOGIN)
public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Проверка логина зарегистрированного пользователя")
    void correctLoginTest(){
        authSteps.openLoginPage()
                .setEmail(EMAIL)
                .setPassword(PWD)
                .clickLoginBtn()
                .checkEmailOfMember(DOMAIN);
    }

    @Test
    @DisplayName("Проверка логина по незарегистрированному логопассу")
    void wrongLogopassLoginTest(){
        authSteps.openLoginPage()
                .setEmail(t.email)
                .setPassword(t.password)
                .clickLoginBtn();
        loginPage.checkIncorrectLogopassMessage();
    }

    @Test
    @DisplayName("Проверка логина с некорректным паролем")
    void wrongPasswordLoginTest(){
        authSteps.openLoginPage()
                .enterWrongPwd(t.wrongPassword);
        loginPage.checkILogopassMessageIfNotEnterLogin();
    }
}
