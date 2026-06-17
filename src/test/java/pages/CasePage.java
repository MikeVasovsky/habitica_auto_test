package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.CreateCaseModel;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CasePage {
    private SelenideElement createCaseTab = $("#task-modal___BV_modal_content_");
    private SelenideElement dateMenu = $("[class='vdp-datepicker']");
    private SelenideElement yearMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_year']");
    private SelenideElement monthMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_month']");
    private SelenideElement dayMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_day']");
    private SelenideElement dropdownMenu = $("[class='dropdown-menu show']");
    private SelenideElement addCaseBtn = $("[class='btn btn-primary btn-footer d-flex align-items-center justify-content-center']");
    private SelenideElement repeatLabel = $x("//label[contains(text(),'Повторения')]");
    private SelenideElement caseList = $("[class='tasks-column col-lg-3 col-md-6 daily']");

    @Step("Создать ежедневное дело")
    public CasePage createCase(CreateCaseModel model) {
        inputTittle(model.getTittle());
        inputNote(model.getNote());
        inputPoint(model.getPoint());
        pickDifficult(model.getDifficult());
        inputDate(model.getYear(), model.getMonth(), model.getDay());
        pickRepeatPeriod(model.getRepeat());
        addRepeatSize(model.getRepeatDay());
        addTag(model.getTag());
        if (createCaseTab.$(".toggle-group").exists()) {
            chooseDay(model.getDayWeek());
        }
        addCaseBtn.click();
        return this;
    }


    @Step("Ввести заголовок дела")
    public void inputTittle(String tittle) {
        createCaseTab.$("[placeholder='Добавить название']")
                .setValue(tittle);
    }

    @Step("Ввести заметку")
    public void inputNote(String note) {
        createCaseTab.$("[placeholder='Добавить заметку']")
                .setValue(note);
    }

    @Step("Ввести список пунктов")
    public void inputPoint(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.forEach(x -> {
            createCaseTab.$("[placeholder='Новый пункт списка']")
                    .setValue(x)
                    .pressEnter();
            createCaseTab.$$(".checklist-group:not(.new-checklist) .custom-control-label")
                    .last()
                    .click();
            createCaseTab.$$(".checklist-group:not(.new-checklist) .custom-control-input")
                    .last()
                    .shouldBe(checked);
        });
    }

    @Step("Выбрать сложность")
    public void pickDifficult(List<String> diff) {
        Random r = new Random();
        createCaseTab.$("[class='difficulty-select']").click();
        dropdownMenu.find(byText(diff.get(r.nextInt(diff.size())))).click();
    }

    @Step("Выбрать дату")
    public void inputDate(String year, String month, String day) {
        dateMenu.$("[class='vdp-datepicker__calendar-button input-group-icon input-group-prepend']")
                .click();
        dateMenu.$("[class='day__month_btn up']").click();
        dateMenu.$("[class='month__year_btn up']").click();
        yearMenu.find(byText(year)).click();
        monthMenu.find(byText(month)).click();
        dayMenu.find(byText(day)).click();
    }

    @Step("Выбрать повторение")
    public void pickRepeatPeriod(List<String> repeat) {
        Random r = new Random();
        createCaseTab.$("[class='array-select']")
                .click();
        dropdownMenu.find(byText(repeat.get(r.nextInt(repeat.size()))))
                .click();
        repeatLabel.click();
    }

    @Step("Выбрать частоту повторений")
    public void addRepeatSize(String s) {
        createCaseTab.$("#task-modal___BV_modal_content_ [class='input-group-outer'] input")
                .setValue(s);
    }

    @Step("Добавить тэг")
    public void addTag(String t) {
        createCaseTab.$("[class='multi-list d-flex flex-wrap']")
                .click();
        createCaseTab.$("[placeholder='Введите тег']").setValue(t)
                .pressEnter();
    }

    @Step("Выбрать день, когда не надо повторять дело")
    public void chooseDay(String d) {
        createCaseTab.$$(".toggle-group .toggle-checkbox")
                .get(Integer.parseInt(d))
                .click();
    }

    @Step("Проверить наличие созданного ежедневного дела")
    public void checkCreateCase(String name) {
        caseList.find(byText(name)).shouldBe(visible);
    }


}
