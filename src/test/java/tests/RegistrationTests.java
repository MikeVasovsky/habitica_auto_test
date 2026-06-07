package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTests extends BaseTest{

    @Test
    @DisplayName("Проверка отображения имени пользователя")
    public void registrationNewUser(){
        registrationUser();
        newUsername(t.username);
        mainPage.skipGreetings()
                .checkNameOfMember(t.username);
    }
}
