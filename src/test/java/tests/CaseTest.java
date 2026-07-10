package tests;

import model.CreateCaseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CasePage;

import java.util.Random;

@Tag(TestTags.HABITICA)
@Tag(TestTags.CASE)
public class CaseTest extends BaseTest {

    @Test
    @DisplayName("Проверка добавления нового ежедневного дела")
    void addEverydayCase() {
        CreateCaseModel model = actions.createEveryDayCaseData();
        Random random = new Random();
        String difficult = model.getDifficult().get(random.nextInt(model.getDifficult().size()));
        String repeat = model.getRepeat().get(random.nextInt(model.getRepeat().size()));

        authSteps.registrationAndLogin();

        CasePage casePage = actions.getMainPage()
                .clickAddTaskBtn()
                .clickAddDailyCaseBtn();
        casePage.inputTittle(model.getTittle())
                .inputNote(model.getNote())
                .inputPoint(model.getPoint())
                .pickDifficult(difficult)
                .openDatePicker()
                .openMonthPicker()
                .openYearPicker()
                .selectYear(model.getYear())
                .selectMonth(model.getMonth())
                .selectDay(model.getDay())
                .openRepeatPeriodSelect()
                .pickRepeatPeriod(repeat)
                .addRepeatSize(model.getRepeatDay())
                .addTag(model.getTag());

        if (casePage.hasDayWeekSelector()) {
            casePage.chooseDay(model.getDayWeek());
        }

        casePage.clickCreateCaseBtn()
                .checkCreateCase(model.getTittle());
    }
}
