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

    @Step("Ввести корректный email и пароль")
    public MainPage enterLogopass(String email, String password){
        usernameFld.setValue(email);
        passwordFld.setValue(password);
        enterBtn.click();
        return new MainPage();
    }

    @Step("Ввести незарегистрированный email и пароль")
    public void enterNotRegisterLogopass(String email, String password){
        usernameFld.setValue(email);
        passwordFld.setValue(password);
        enterBtn.click();
    }

    @Step("Проверить сообщение о неверном логине или пароле")
    public void checkIncorrectLogopassMessage(){
        wrongLogopassMessage.shouldBe(visible);
    }

    @Step("Ввести некорректный пароль и проверить текст ошибки")
    public void enterWrongPwd(String pwd){
        passwordFld.setValue(pwd);
    }

    @Step("Проверить отображение сообщения об отсутствии логина или пароля")
    public void checkILogopassMessageIfNotEnterLogin(){
        pwdMessage.shouldHave(text("Ваш пароль должен содержать как минимум 8 символов."));
    }

}
