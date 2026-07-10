package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ChallengePage {
    private SelenideElement searchFld = $("[placeholder='Поиск']");
    private SelenideElement habiticaOfficialTextBox = $("[for='habitica_official']");
    private SelenideElement createChallengeBtn = $x("//span[contains(text(),'Создать испытание')]");
    private SelenideElement challengeData = $(".sticky");
    private SelenideElement createBody = $("#challenge-modal___BV_modal_body_");
    private SelenideElement challengeNameFld = createBody.$("[placeholder='Как назовешь свое испытание?']");
    private SelenideElement shortNameFld = createBody.$("[placeholder='Какой короткий тег использовать для вашего испытания?']");
    private SelenideElement resumeFld = createBody.$(".summary-textarea");
    private SelenideElement descriptionFld = createBody.$(".description-textarea");
    private SelenideElement groupSelect = createBody.$("select");
    private SelenideElement categorySelect = createBody.$(".category-select");
    private SelenideElement categoryBox = createBody.$(".category-box");
    private SelenideElement giftFld = createBody.$("[type='number']");
    private SelenideElement saveChallengeBtn = createBody.$(".submit-button-wrapper .btn-primary");
    private SelenideElement challengeFindData = $("[class='col-12 col-md-10 standard-page']");

    @Step("Нажать кнопку создания испытания")
    public ChallengePage clickCreateChallengeBtn() {
        createChallengeBtn.click();
        return this;
    }

    @Step("Ввести название испытания")
    public ChallengePage setChallengeName(String name) {
        challengeNameFld.setValue(name);
        return this;
    }

    @Step("Ввести короткий тег испытания")
    public ChallengePage setShortName(String shortName) {
        shortNameFld.setValue(shortName);
        return this;
    }

    @Step("Ввести резюме испытания")
    public ChallengePage setResume(String resume) {
        resumeFld.setValue(resume);
        return this;
    }

    @Step("Ввести описание испытания")
    public ChallengePage setDescription(String description) {
        descriptionFld.setValue(description);
        return this;
    }

    @Step("Выбрать группу")
    public ChallengePage selectGroup(String group) {
        groupSelect.selectOptionContainingText(group);
        return this;
    }

    @Step("Открыть выбор категории")
    public ChallengePage openCategorySelector() {
        categorySelect.click();
        return this;
    }

    @Step("Выбрать категорию")
    public ChallengePage selectCategoryItem(String category) {
        categoryBox.find(byText(category)).click();
        return this;
    }

    @Step("Закрыть выбор категории")
    public ChallengePage closeCategorySelector() {
        categoryBox.find(byText("Закрыть")).click();
        return this;
    }

    @Step("Ввести приз")
    public ChallengePage setGift(String gift) {
        giftFld.setValue(gift);
        return this;
    }

    @Step("Сохранить испытание")
    public ChallengePage clickSaveChallengeBtn() {
        saveChallengeBtn.scrollTo().click();
        return this;
    }

    @Step("Перейти к поиску испытаний")
    public ChallengePage clickFindChallenges() {
        challengeData.find(byText("Найти испытания")).click();
        return this;
    }

    @Step("Выбрать фильтр официальных испытаний Habitica")
    public ChallengePage clickHabiticaOfficialFilter() {
        habiticaOfficialTextBox.click();
        return this;
    }

    @Step("Ввести запрос в поле поиска")
    public ChallengePage setSearchQuery(String name) {
        searchFld.setValue(name);
        return this;
    }

    @Step("Открыть мои испытания")
    public ChallengePage clickMyChallenges() {
        challengeData.find(byText("Мои испытания")).click();
        return this;
    }

    @Step("Проверит наличие испытания")
    public ChallengePage checkVisibleChallenge(String name) {
        challengeData.find(byText(name));
        return this;
    }

    @Step("Открыть испытание")
    public ChallengePage openChallenge(String name) {
        challengeFindData.find(byText(name)).click();
        return this;
    }
}
