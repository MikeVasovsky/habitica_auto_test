package tests;

import model.CreateCaseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("case")
public class CaseTest extends BaseTest{

    @Test
    @DisplayName("Проверка добавления нового ежедневного дела")
    void addEverydayCase(){
        CreateCaseModel model = actions.createEveryDayCaseData();
        authSteps.registrationAndLogin();
        actions.getMainPage().goToCreateCase()
                .createCase(model)
                .checkCreateCase(model.getTittle());
    }
}
