package data;


import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;
@Data
public class TaskData {
    Faker f = new Faker();

    ArrayList<String> difficult;
    ArrayList<String> tag;
    ArrayList<String> offCount;
    String tittle;
    String note;

    public TaskData(){
        difficult = new ArrayList<>();
        tag = new ArrayList<>();
        offCount = new ArrayList<>();
        setDifficult();
        setTag();
        setOffCount();
        tittle = f.name().firstName();
        note = f.book().publisher();
    }

    public void setDifficult() {
        difficult.add("Пустяк");
        difficult.add("Легко");
        difficult.add("Нормально");
        difficult.add("Сложно");
    }
    public void setTag(){
        tag.add("Работа");
        tag.add("Спортивные упражнения");
        tag.add("Здоровье и образ жизни");
        tag.add("Учеба");
        tag.add("Работа в команде");
        tag.add("Домашние дела");
        tag.add("Творчество");
    }

    public void setOffCount() {
        offCount.add("ежедневное дело");
        offCount.add("еженедельно");
        offCount.add("ежемесячно");
    }
}
