package data;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

@Data
public class CreateCaseData {
    Faker f = new Faker();

    String tittle = f.book().title();
    String note = f.lorem().characters(10,50);
    List<String> point;
    ArrayList<String> difficult;
    ArrayList<String> repeat;
    String year = valueOf(f.number().numberBetween(2020,2026));
    String month = f.options().option(months);
    String day = valueOf(f.number().numberBetween(1,28));
    String dayWeek = valueOf(f.number().numberBetween(0,6));
    String repeatDay = "1";
    String tag = "testTag";


    public CreateCaseData(){
        difficult = new ArrayList<>();
        repeat = new ArrayList<>();
        point = new ArrayList<>();
        setDifficult();
        setRepeat();
        setPoint();
    }

    public void setDifficult() {
        difficult.add("Пустяк");
        difficult.add("Легко");
        difficult.add("Нормально");
        difficult.add("Сложно");
    }

    public void setRepeat(){
        repeat.add("ежедневное дело");
        repeat.add("еженедельно");
        repeat.add("ежемесячно");
        repeat.add("ежегодно");
    }

    public void setPoint(){
        point.add(f.lorem().word());
        point.add(f.lorem().word());
    }

    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

}
