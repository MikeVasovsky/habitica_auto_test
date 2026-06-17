package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage {
    private SelenideElement emailFld = $("[type='email']");
    private ElementsCollection passwordFlds = $$("#intro-signup form [type='password']");
    private SelenideElement continueBtn = $("#continue-button");
    private SelenideElement acceptCoockie = $("[class='btn btn-primary mb-2']");
    private SelenideElement goToLoginPage = $("[href='/login']");


    @Step("Вводи почты и пароля")
    public RegistrationPage inputLogopass(String email, String password) {
        emailFld.shouldBe(visible).setValue(email);
        passwordFlds.get(0).shouldBe(visible).setValue(password);
        passwordFlds.get(1).shouldBe(visible).setValue(password);
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
        if (acceptCoockie.is(visible, Duration.ofSeconds(5))) {
            acceptCoockie.click();
        }
        return this;
    }
}
