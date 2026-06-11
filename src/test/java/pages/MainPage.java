package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.container.MainTittle;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    MainTittle mainTittle = new MainTittle();
    private SelenideElement nextFooter = $(".next");
    private SelenideElement closeFooter = $("[class='next-outer disabled']");
    private SelenideElement memberStats = $(".member-stats");
    private SelenideElement letsGetStartBtn = $x("//a[contains(text(),'Начнем!')]");
    private SelenideElement addTaskBtn = $("#create-task-btn");
    private SelenideElement addHabitBtn = $x("//div[contains(text(),'привычку')]");
    private SelenideElement addTittle = $("[placeholder='Добавить название']");
    private SelenideElement addNote = $("[placeholder='Добавить заметку']");
    private SelenideElement modal = $("#task-modal___BV_modal_body_");
    private SelenideElement diffFld = $("[class='difficulty-item isButton']");
    private SelenideElement tagFld = $("[class='multi-list d-flex flex-wrap']");
    private SelenideElement countFld = $x("(//*[@class='btn dropdown-toggle btn-secondary'])[3]");
    private SelenideElement taskList = $("[class='tasks-column col-lg-3 col-md-6 habit']");
    private SelenideElement diffTittle=$x("//label[contains(text(), 'Сложность')]");
    private SelenideElement createBtn=$x("//button[contains(text(), 'Создать')]");


    @Step("Проверить отображение имени на главной страниц")
    public void checkNameOfMember(String name) {
        memberStats.find(".member-stats h3 span").shouldHave(text(name));
    }

    @Step("Проверить отображение почты на главной страниц")
    public void checkEmailOfMember(String name) {
        memberStats.find(".member-stats [class='small-text character-level'] span").shouldHave(text(name));
    }

    @Step("Пропустить экраны приветствия и настройки персонажа")
    public MainPage skipGreetings() {
        nextFooter.click();
        closeFooter.click();
        letsGetStartBtn.shouldBe(visible);
        if (letsGetStartBtn.isDisplayed()){
        letsGetStartBtn.click();
        }
        return this;
    }

    @Step("Перейти с созданию привычки")
    public MainPage goToCreateHabit() {
        addTaskBtn.click();
        addHabitBtn.click();
        return this;
    }

    @Step("Создать привычку")
    public MainPage createHabit(String diff,
                                String tag,
                                String count){
        diffFld.click();
        modal.find(byText(diff)).click();
        tagFld.click();
        modal.find(byText(tag)).click();
        diffTittle.click();
        countFld.click();
        modal.find(byText(count)).click();
        createBtn.click();
        return this;
    }

    @Step("Ввести название и описание привычки")
    public MainPage addTittleAbdNote(String tittle,
                                     String note){
        addTittle.sendKeys(tittle);
        addNote.sendKeys(note);
        return this;
    }

    @Step("Открыть созданную привычку")
    public MainPage openCreateHabit(String name){
        taskList.find(byText(name)).click();
        return this;
    }

    @Step("Проверить созданную привычку")
    public void checkCreateHabit(
                                 String diff,
                                 String tag,
                                 String count){
        diffFld.shouldHave(text(diff));
        tagFld.shouldHave(text(tag));
        countFld.shouldHave(text(count));
    }

    @Step("Перейти на страницу поиска испытаний")
    public ChallengePage goToFindChallenge(){
        mainTittle.goToSearchChallenge();
        return new ChallengePage();
    }


}
