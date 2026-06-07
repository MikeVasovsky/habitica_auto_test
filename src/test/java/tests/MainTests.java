package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTests extends BaseTest{
    @Test
    @DisplayName("Проверка отображения имени пользователя")
    public void registrationNewUser(){
        regPage.confirmCoockie()
                .inputLogopass(t.email,t.password)
                .confirmLogopass()
                .inputName(t.username)
                .confirmUsername()
                .skipGreetings()
                .checkNameOfMember(t.username);
    }
}
