package data;

import com.github.javafaker.Faker;

import static java.lang.String.valueOf;

public class TestData {
    Faker faker = new Faker();

    public String username = faker.name().firstName() + faker.number().numberBetween(0, 10000);
    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password();
    public String wrongPassword = valueOf(faker.number().numberBetween(1000,10000));

    public static final String EMAIL = "pptestkrylov@gmail.com";
    public static final String PWD = "1234qwer";
    public static final String DOMAIN = "@pptestkrylov";

}
