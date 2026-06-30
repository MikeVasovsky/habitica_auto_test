package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.container.MainTittle;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
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
    private SelenideElement addCaseBtn = $x("//div[contains(text(),'ежедневное дело')]");
    private SelenideElement addTittle = $("[placeholder='Добавить название']");
    private SelenideElement addNote = $("[placeholder='Добавить заметку']");
    private SelenideElement modal = $("#task-modal___BV_modal_content_");
    private SelenideElement diffFld = $("[class='difficulty-item isButton']");
    private SelenideElement tagFld = $("[class='multi-list d-flex flex-wrap']");
    private SelenideElement countFld = $("[class='array-select']");
    private SelenideElement dropdownMenu = $("[class='dropdown-menu show']");
    private SelenideElement taskList = $("[class='tasks-column col-lg-3 col-md-6 habit']");
    private SelenideElement caseList = $("[class=['tasks-column col-lg-3 col-md-6 daily']");
    private SelenideElement diffTittle=$x("//label[contains(text(), 'Сложность')]");
    private SelenideElement createBtn=$x("//button[contains(text(), 'Создать')]");


    @Step("Проверить отображение имени на главной страниц")
    public void checkNameOfMember(String name) {
        memberStats.find(".member-stats h3 span")
                .scrollTo()
                .shouldHave(text(name));
    }

    @Step("Проверить отображение почты на главной страниц")
    public void checkEmailOfMember(String name) {
        memberStats.find(".member-stats [class='small-text character-level'] span").shouldHave(text(name));
    }

    @Step("Пропустить экраны приветствия и настройки персонажа")
    public MainPage skipGreetings() {
        if (nextFooter.is(visible, Duration.ofSeconds(10))){
            nextFooter.scrollIntoView(true).click();
        }
        if (closeFooter.is(visible, Duration.ofSeconds(10))){
            closeFooter.scrollIntoView(true).click();
        }
        if (letsGetStartBtn.is(visible, Duration.ofSeconds(10))) {
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

    @Step("Перейти к созданию ежедневного дела")
    public CasePage goToCreateCase(){
        addTaskBtn.click();
        addCaseBtn.click();
        return new CasePage();
    }

    @Step("Создать привычку")
    public MainPage createHabit(){
        createBtn.click();
        return this;
    }

    @Step("Выбрать сложность")
    public MainPage addDifficult(String diff){
        diffTittle.click();
        SelenideElement difficultyToggle = modal.$("[class='difficulty-select'] button.dropdown-toggle");
        if (!difficultyToggle.$(".label").is(text(diff))) {
            difficultyToggle.scrollIntoView(true).click(usingJavaScript());
            dropdownMenu.shouldBe(visible, Duration.ofSeconds(10)).find(byText(diff)).click();
        }
        return this;
    }

    @Step("Выбрать тэг")
    public MainPage addTag(String tag){
        tagFld.click();
        dropdownMenu.find(byText(tag)).click();
        diffTittle.click();
        return this;
    }

    @Step("Выбрать счетчик")
    public MainPage addCount(String count){
        modal.$("[class='array-select']").click();
        dropdownMenu.find(byText(count)).click();
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
