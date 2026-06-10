package data;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String username = faker.name().firstName() + faker.number().numberBetween(0, 10000);
    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password();

}
