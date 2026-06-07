package data;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String username = faker.name().firstName()+"121";
    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password();


    public String getRandomEmail() {
        return faker.internet().emailAddress("ru");
    }

    public String getRandomPassword() {
        return faker.internet().password();
    }
}
