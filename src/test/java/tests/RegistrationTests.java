package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("registrationTest")
public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Проверка отображения измененного имени пользователя")
    public void registrationNewUser() {
        authSteps.registrationUser();
        actions.newUsername(t.username);
        actions.getMainPage().skipGreetings()
                .checkNameOfMember(t.username);
    }
}
