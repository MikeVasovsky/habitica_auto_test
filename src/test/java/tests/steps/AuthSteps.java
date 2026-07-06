package tests.steps;


import data.TestData;
import io.qameta.allure.Step;

import lombok.Data;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import static data.TestData.EMAIL;
import static data.TestData.PWD;

@Data
public class AuthSteps {
    RegistrationPage regPage = new RegistrationPage();
    TestData t;

    public AuthSteps(TestData t) {
        this.t = t;
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

    @Step("Авторизация предустановленного пользователя")
    public void preSaveUserLogin() {
        regPage.goToLoginPage()
                .enterLogopass(EMAIL, PWD);
    }

    @Step("Перейти на страницу логина")
    public LoginPage openLoginPage() {
        return regPage.goToLoginPage();
    }

    @Step("Регистрация нового пользователя с указанным именем")
    public MainPage registrationWithUsername(String username) {
        return regPage.confirmCoockie()
                .inputLogopass(t.email, t.password)
                .confirmLogopass()
                .inputName(username)
                .confirmUsername()
                .skipGreetings();
    }

}
