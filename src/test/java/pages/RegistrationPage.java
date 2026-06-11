package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private SelenideElement emailFld = $("[type='email']");
    private SelenideElement pwdFld = $("[placeholder='Пароль']");
    private SelenideElement confirmPwdFld = $("[placeholder='Подтвердите пароль']");
    private SelenideElement continueBtn = $("#continue-button");
    private SelenideElement acceptCoockie = $("[class='btn btn-primary mb-2']");
    private SelenideElement goToLoginPage = $("[href='/login']");


    @Step("Вводи почты и пароля")
    public RegistrationPage inputLogopass(String email, String password) {
        emailFld.setValue(email);
        pwdFld.setValue(password);
        confirmPwdFld.setValue(password);
        return this;
    }

    @Step("Подтвердить логин и пароль")
    public UsernamePage confirmLogopass(){
        continueBtn.click();
        return new UsernamePage();
    }

    @Step("Перейти на страницу логина")
    public LoginPage goToLoginPage(){
        goToLoginPage.click();
        return new LoginPage();
    }

    @Step("Принять куки")
    public RegistrationPage confirmCoockie(){
        acceptCoockie.click();
        return this;
    }
}
