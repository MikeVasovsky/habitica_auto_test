package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UsernamePage {
    private SelenideElement usernameInputFld = $("#usernameInput");
    private SelenideElement submitUsernameBtn = $("[type='submit']");
    private SelenideElement checkBox = $("[for='privacyTOS']");

    @Step("Очистить поле имени пользователя")
    public UsernamePage clearUsername() {
        usernameInputFld.clear();
        return this;
    }

    @Step("Ввести имя пользователя")
    public UsernamePage inputName(String name) {
        usernameInputFld.setValue(name);
        return this;
    }

    @Step("Принять пользовательское соглашение")
    public UsernamePage clickPrivacyCheckbox() {
        checkBox.click();
        return this;
    }

    @Step("Подтвердить имя пользователя")
    public MainPage clickSubmitUsernameBtn() {
        submitUsernameBtn.click();
        return new MainPage();
    }
}
