package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement usernameFld = $("#usernameInput");
    private SelenideElement passwordFld = $("#passwordInput");
    private SelenideElement enterBtn = $("[type='submit']");
    private SelenideElement pwdMessage = $(".input-error");

    private SelenideElement wrongLogopassMessage = $x("//div[contains(text(), 'Ваша электронная почта, имя пользователя или пароль неверны. Пожалуйста, попробуйте ещё раз или нажмите кнопку \"Забыли пароль\".')]");

    @Step("Ввести email")
    public LoginPage setEmail(String email) {
        usernameFld.setValue(email);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage setPassword(String password) {
        passwordFld.setValue(password);
        return this;
    }

    @Step("Нажать кнопку входа")
    public MainPage clickLoginBtn() {
        enterBtn.click();
        return new MainPage();
    }

    @Step("Проверить сообщение о неверном логине или пароле")
    public void checkIncorrectLogopassMessage() {
        wrongLogopassMessage.shouldBe(visible);
    }


    @Step("Проверить отображение сообщения об отсутствии логина или пароля")
    public void checkILogopassMessageIfNotEnterLogin() {
        pwdMessage.shouldHave(text("Ваш пароль должен содержать как минимум 8 символов."));
    }
}
