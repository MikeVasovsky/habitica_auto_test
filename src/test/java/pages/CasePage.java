package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CasePage {
    private SelenideElement createCaseTab = $("#task-modal___BV_modal_content_");
    private SelenideElement titleFld = $("[placeholder='Добавить название']");
    private SelenideElement noteFld = $("[placeholder='Добавить заметку']");
    private SelenideElement checklistItemFld = $("[placeholder='Новый пункт списка']");
    private SelenideElement difficultySelect = $("[class='difficulty-select']");
    private SelenideElement repeatSelect = $("[class='array-select']");
    private SelenideElement repeatSizeFld = $("[class='input-group-outer'] input");
    private SelenideElement tagMultiList = $("[class='multi-list d-flex flex-wrap']");
    private SelenideElement tagInputFld = $("[placeholder='Введите тег']");
    private ElementsCollection dayWeekCheckboxes = createCaseTab.$$(".toggle-group .toggle-checkbox");
    private SelenideElement dateMenu = $("[class='vdp-datepicker']");
    private SelenideElement datePickerBtn = dateMenu.$("[class='vdp-datepicker__calendar-button input-group-icon input-group-prepend']");
    private SelenideElement monthPickerBtn = dateMenu.$("[class='day__month_btn up']");
    private SelenideElement yearPickerBtn = dateMenu.$("[class='month__year_btn up']");
    private SelenideElement yearMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_year']");
    private SelenideElement monthMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_month']");
    private SelenideElement dayMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_day']");
    private SelenideElement dropdownMenu = $("[class='dropdown-menu show']");
    private SelenideElement addCaseBtn = $("[class='btn btn-primary btn-footer d-flex align-items-center justify-content-center']");
    private SelenideElement repeatLabel = $x("//label[contains(text(),'Повторения')]");
    private SelenideElement caseList = $("[class='tasks-column col-lg-3 col-md-6 daily']");
    private SelenideElement dayWeekSelector = createCaseTab.$(".toggle-group");

    @Step("Ввести заголовок дела")
    public CasePage inputTittle(String tittle) {
        titleFld.setValue(tittle);
        return this;
    }

    @Step("Ввести заметку")
    public CasePage inputNote(String note) {
        noteFld.setValue(note);
        return this;
    }

    @Step("Ввести список пунктов")
    public CasePage inputPoint(List<String> list) {
        if (list == null || list.isEmpty()) {
            return this;
        }
        list.forEach(x -> {
            checklistItemFld.setValue(x).pressEnter();
            createCaseTab.$$(".checklist-group:not(.new-checklist) .custom-control-label")
                    .last()
                    .click();
            createCaseTab.$$(".checklist-group:not(.new-checklist) .custom-control-input")
                    .last()
                    .shouldBe(checked);
        });
        return this;
    }

    @Step("Выбрать сложность")
    public CasePage pickDifficult(String difficult) {
        difficultySelect.click();
        dropdownMenu.find(byText(difficult)).click();
        return this;
    }

    @Step("Открыть календарь")
    public CasePage openDatePicker() {
        datePickerBtn.click();
        return this;
    }

    @Step("Открыть выбор месяца")
    public CasePage openMonthPicker() {
        monthPickerBtn.click();
        return this;
    }

    @Step("Открыть выбор года")
    public CasePage openYearPicker() {
        yearPickerBtn.click();
        return this;
    }

    @Step("Выбрать год")
    public CasePage selectYear(String year) {
        yearMenu.find(byText(year)).click();
        return this;
    }

    @Step("Выбрать месяц")
    public CasePage selectMonth(String month) {
        monthMenu.find(byText(month)).click();
        return this;
    }

    @Step("Выбрать день")
    public CasePage selectDay(String day) {
        dayMenu.find(byText(day)).click();
        return this;
    }

    @Step("Открыть выбор периода повторения")
    public CasePage openRepeatPeriodSelect() {
        repeatSelect.click();
        return this;
    }

    @Step("Выбрать период повторения")
    public CasePage pickRepeatPeriod(String repeat) {
        dropdownMenu.find(byText(repeat)).click();
        repeatLabel.click();
        return this;
    }

    @Step("Выбрать частоту повторений")
    public CasePage addRepeatSize(String s) {
        repeatSizeFld.setValue(s);
        return this;
    }

    @Step("Добавить тэг")
    public CasePage addTag(String t) {
        tagMultiList.click();
        tagInputFld.setValue(t).pressEnter();
        return this;
    }

    @Step("Выбрать день, когда не надо повторять дело")
    public CasePage chooseDay(String d) {
        dayWeekCheckboxes.get(Integer.parseInt(d)).click();
        return this;
    }

    @Step("Сохранить ежедневное дело")
    public CasePage clickCreateCaseBtn() {
        addCaseBtn.click();
        return this;
    }

    @Step("Проверить наличие созданного ежедневного дела")
    public void checkCreateCase(String name) {
        caseList.find(byText(name)).shouldBe(visible);
    }

    public boolean hasDayWeekSelector() {
        return dayWeekSelector.exists();
    }
}
