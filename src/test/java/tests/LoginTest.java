package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.TestData.*;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Проверка логина зарегистрированного пользователя")
    void correctLoginTest(){
        authSteps.openLoginPage()
                .enterLogopass(EMAIL, PWD)
                .checkEmailOfMember(DOMAIN);
    }

    @Test
    @DisplayName("Проверка логина по незарегистрированному логопассу")
    void wrongLogopassLoginTest(){
        authSteps.openLoginPage()
                .enterNotRegisterLogopass(t.email,t.password);
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
