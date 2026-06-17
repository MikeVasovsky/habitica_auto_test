package tests;

import model.CreateCaseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CaseTest extends BaseTest{

    @Test
    @DisplayName("Проверка добавления нового ежедневного дела")
    void addEverydayCase(){
        CreateCaseModel model = actions.createEveryDayCaseData();
        authSteps.preSaveUserLogin();
        actions.mainPage.goToCreateCase()
                .createCase(model)
                .checkCreateCase(model.getTittle());
    }
}
