package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UsernamePage {
    private SelenideElement usernameInputFld = $("#usernameInput");
    private SelenideElement submitUsernameBtn = $("[type='submit']");
    private SelenideElement checkBox = $("[for='privacyTOS']");

    @Step("Подтвердить имя пользователя")
    public MainPage confirmUsername(){
        checkBox.click();
        submitUsernameBtn.click();
        return new MainPage();
    }

    @Step("Ввести имя пользователя")
    public UsernamePage inputName(String name){
        usernameInputFld.clear();
        usernameInputFld.setValue(name);
        return this;
    }
}
