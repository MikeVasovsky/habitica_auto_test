package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement nextFooter = $(".next");
    private SelenideElement closeFooter = $("[class='next-outer disabled']");
    private SelenideElement memberStats = $(".member-stats");
    private SelenideElement letsGetStartBtn = $x("//a[contains(text(),'Начнем!')]");
    @Step("Проверить отображение имени, указанного после регистрации")
    public void checkNameOfMember(String name) {
        memberStats.find(".member-stats h3 span").shouldHave(text(name));
    }

    @Step("Пропустить экраны приветствия и настройки персонажа")
    public MainPage skipGreetings() {
        nextFooter.click();
        closeFooter.click();
        letsGetStartBtn.click();
        return this;
    }

}
