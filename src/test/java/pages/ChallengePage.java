package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.CreateChallengeModel;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ChallengePage {
    private SelenideElement searchFld = $("[placeholder='Поиск']");
    private SelenideElement habiticaOfficialTextBox = $("[for='habitica_official']");
    private SelenideElement createChallengeBtn = $x("//span[contains(text(),'Создать испытание')]");
    private SelenideElement challengeData = $(".sticky");
    private SelenideElement createBody = $("#challenge-modal___BV_modal_body_");
    private SelenideElement challengeFindData = $("[class='col-12 col-md-10 standard-page']");

    @Step("Создать испытание")
    public ChallengePage createChallenge() {
        createChallengeBtn.click();
        return this;
    }

    @Step("Ввести название испытания")
    public ChallengePage setChallenge(CreateChallengeModel data){
        createBody.$("[placeholder='Как назовешь свое испытание?']").setValue(data.getName());
        createBody.$("[placeholder='Какой короткий тег использовать для вашего испытания?']").setValue(data.getShortName());
        return this;
    }

    @Step("Ввести резюме испытания")
    public ChallengePage setResume(CreateChallengeModel data){
        createBody.$(".summary-textarea").setValue(data.getResume());
        return this;
    }

    @Step("Ввести описание испытания")
    public ChallengePage setDeskription(CreateChallengeModel data){
        createBody.$(".description-textarea").setValue(data.getDesk());
        return this;
    }

    @Step("Выбрать группу")
    public ChallengePage selectGroup(CreateChallengeModel data){
        createBody.$("select").selectOptionContainingText(data.getGroup());
        return this;
    }

    @Step("Выбрать категорию")
    public ChallengePage selectCategory(CreateChallengeModel data){
        SelenideElement categorySelect = createBody.$(".category-select");
        SelenideElement categoryBox = createBody.$(".category-box");
        categorySelect.click();
        data.getCategory().forEach(c -> categoryBox.find(byText(c)).click());
        categoryBox.find(byText("Закрыть")).click();
        return this;
    }

    @Step("Ввести приз")
    public ChallengePage inputNumber(CreateChallengeModel data){
        createBody.$("[type='number']").setValue(data.getGift());
        return this;
    }

    @Step("Сохранить испытание")
    public ChallengePage saveChallenge(){
        createBody.$(".submit-button-wrapper .btn-primary").scrollTo().click();
        return this;
    }

    @Step("Найти испытание")
    public ChallengePage searchChallenge(String name){
        challengeData.find(byText("Найти испытания")).click();
        habiticaOfficialTextBox.click();
        searchFld.setValue(name);
        return this;
    }

    @Step("Открыть мои испытания")
    public ChallengePage searchMyChallenge(){
        challengeData.find(byText("Мои испытания")).click();
        return this;
    }

    @Step("Проверит наличие испытания")
    public ChallengePage checkVisibleChallenge(String name){
        challengeData.find(byText(name));
        return this;
    }

    @Step("Открыть испытание")
    public ChallengePage openChallenge(String name){
        challengeFindData.find(byText(name)).click();
        return this;
    }
}


