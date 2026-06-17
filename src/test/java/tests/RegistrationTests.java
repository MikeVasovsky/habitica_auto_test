package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Проверка отображения измененного имени пользователя")
    public void registrationNewUser() {
        authSteps.registrationUser();
        actions.newUsername(t.username);
        actions.mainPage.skipGreetings()
                .checkNameOfMember(t.username);
    }
}
