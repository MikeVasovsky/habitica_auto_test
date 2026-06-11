package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.TestData.*;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Проверка логина зарегистрированного пользователя")
    void correctLoginTest(){
        regPage.goToLoginPage()
                .enterLogopass(EMAIL, PWD)
                .checkEmailOfMember(DOMAIN);
    }

    @Test
    @DisplayName("Проверка логина по незарегистрированному логопассу")
    void wrongLogopassLoginTest(){
        regPage.goToLoginPage()
                .enterNotRegisterLogopass(t.email,t.password);
    }

    @Test
    @DisplayName("Проверка логина с некорректным паролем")
    void wrongPasswordLoginTest(){
        regPage.goToLoginPage()
                .enterWrongPwd(t.wrongPassword);
    }
}
