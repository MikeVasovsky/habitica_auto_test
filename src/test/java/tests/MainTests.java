package tests;

import data.TaskData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainTests extends BaseTest {

    private static Stream<Arguments> getTaskElementst() {
        Random r = new Random();
        return IntStream.range(0, 5)
                .mapToObj(i -> {
                    TaskData taskData = new TaskData();
                    return Arguments.of(
                            taskData.getTittle(),
                            taskData.getNote(),
                            taskData.getDifficult().get(r.nextInt(taskData.getDifficult().size())),
                            taskData.getTag().get(r.nextInt(taskData.getTag().size())),
                            taskData.getOffCount().get(r.nextInt(taskData.getOffCount().size()))
                    );
                });
    }

    @Test
    @DisplayName("Проверка отображения имени пользователя")
    public void registrationNewUser() {
        authSteps.registrationWithUsername(t.username)
                .checkNameOfMember(t.username);
    }

    @ParameterizedTest
    @DisplayName("Проверка добавления привычки")
    @MethodSource("getTaskElementst")
    void addHabitTest(String tittle, String note, String difficult, String tag, String offCount) {
        authSteps.registrationUser();
        actions.newUsername(t.username);
        actions.getMainPage().skipGreetings()
                .goToCreateHabit()
                .addTittleAbdNote(tittle, note)
                .createHabit(difficult, tag, offCount)
                .openCreateHabit(tittle)
                .checkCreateHabit(difficult, tag, offCount);
    }
}
