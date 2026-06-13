package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ChallengePage {
    private SelenideElement searchFld = $("[placeholder='Поиск']");
    private SelenideElement habiticaOfficialTextBox = $("[for=\"habitica_official\"]");
    private SelenideElement createChallengeBtn = $x("//span[contains(text(),'Создать испытание')]");

    //Блок создания испытания
    private SelenideElement nameChallenge = $("[placeholder='Как назовешь свое испытание?']");
    private SelenideElement shortChallengeName = $("[placeholder='Какой короткий тег использовать для вашего испытания?']");
    private SelenideElement resume = $("[class='summary-textarea form-control']");
    private SelenideElement descriptionChallenge = $("[class='description-textarea form-control']");


    @Step("")

}
