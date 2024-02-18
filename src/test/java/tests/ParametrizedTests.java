package tests;

import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import data.Gender;
import java.util.Locale;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import utils.RandomUtils;


public class ParametrizedTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @CsvSource (value = {
            "Иван,Иванов,Male,1234567890",
            "Алиса,Петрова,Female,9012345678",
    })
    @ParameterizedTest
    void fillRequiredFieldsTest(String firstName, String lastName, String gender, String userNumber){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)

                .clickSubmit()

                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }


    @EnumSource(Gender.class)
    @ParameterizedTest
    void checkAllGendersTest(Gender gender){

        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String UserNumber = faker.number().digits(10);

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(String.valueOf(gender))
                .setUserNumber(UserNumber)

                .clickSubmit()

                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Gender", String.valueOf(gender))
                .checkResult("Mobile", UserNumber);
    }

    @ValueSource(strings = {
            "Sports",
            "Reading",
            "Music"
    })
    @ParameterizedTest(name="Проверка хобби: {0}")
    void checkAllHobbiesTest(String Hobbies){
        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String UserNumber = faker.number().digits(10);
        String gender = faker.options().option(RandomUtils.getRandomGender());

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(UserNumber)
                .setHobbies(Hobbies)

                .clickSubmit()

                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", UserNumber)
                .checkResult("Hobbies", Hobbies);
    }

}

