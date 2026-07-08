package pages;

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
    private SelenideElement dateMenu = $("[class='vdp-datepicker']");
    private SelenideElement yearMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_year']");
    private SelenideElement monthMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_month']");
    private SelenideElement dayMenu = $("[class='calendar-padding vdp-datepicker__calendar picker_day']");
    private SelenideElement dropdownMenu = $("[class='dropdown-menu show']");
    private SelenideElement addCaseBtn = $("[class='btn btn-primary btn-footer d-flex align-items-center justify-content-center']");
    private SelenideElement repeatLabel = $x("//label[contains(text(),'Повторения')]");
    private SelenideElement caseList = $("[class='tasks-column col-lg-3 col-md-6 daily']");

    @Step("Ввести заголовок дела")
    public CasePage inputTittle(String tittle) {
        createCaseTab.$("[placeholder='Добавить название']")
                .setValue(tittle);
        return this;
    }

    @Step("Ввести заметку")
    public CasePage inputNote(String note) {
        createCaseTab.$("[placeholder='Добавить заметку']")
                .setValue(note);
        return this;
    }

    @Step("Ввести список пунктов")
    public CasePage inputPoint(List<String> list) {
        if (list == null || list.isEmpty()) {
            return this;
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
        return this;
    }

    @Step("Выбрать сложность")
    public CasePage pickDifficult(String difficult) {
        createCaseTab.$("[class='difficulty-select']").click();
        dropdownMenu.find(byText(difficult)).click();
        return this;
    }

    @Step("Открыть календарь")
    public CasePage openDatePicker() {
        dateMenu.$("[class='vdp-datepicker__calendar-button input-group-icon input-group-prepend']")
                .click();
        return this;
    }

    @Step("Открыть выбор месяца")
    public CasePage openMonthPicker() {
        dateMenu.$("[class='day__month_btn up']").click();
        return this;
    }

    @Step("Открыть выбор года")
    public CasePage openYearPicker() {
        dateMenu.$("[class='month__year_btn up']").click();
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
        createCaseTab.$("[class='array-select']").click();
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
        createCaseTab.$("#task-modal___BV_modal_content_ [class='input-group-outer'] input")
                .setValue(s);
        return this;
    }

    @Step("Добавить тэг")
    public CasePage addTag(String t) {
        createCaseTab.$("[class='multi-list d-flex flex-wrap']")
                .click();
        createCaseTab.$("[placeholder='Введите тег']").setValue(t)
                .pressEnter();
        return this;
    }

    @Step("Выбрать день, когда не надо повторять дело")
    public CasePage chooseDay(String d) {
        createCaseTab.$$(".toggle-group .toggle-checkbox")
                .get(Integer.parseInt(d))
                .click();
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
        return createCaseTab.$(".toggle-group").exists();
    }
}
