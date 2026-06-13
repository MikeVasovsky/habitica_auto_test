package data;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateChallengeData {
    Faker f = new Faker();

    public final static String ADD_GROUP = "Публичные испытания";
    public final static String OFFICIAL_CHL= "Register to Vote or Check Your Voter Registration!";

    String name = f.backToTheFuture().character();
    String shortName = f.name().name();
    String resume = f.relationships().any();
    String desk = f.artist().name();
    List<String>category;
    String gift = f.random().nextInt(1,10).toString();

    public CreateChallengeData(){
        category = new ArrayList<>();
        category.add("Обучение");
        category.add("Пропаганда + вызовы");
        category.add("Творчество");
        category.add("Развлечения");
        category.add("Финансы");
        category.add("Здоровье + физическая форма");
        category.add("Хобби и занятия");
        category.add("По географическому положению");
    }

}
