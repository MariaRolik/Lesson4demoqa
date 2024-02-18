package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;


public class RegistrationWithFakerTests extends TestBase {
    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker(new Locale("en"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = getRandomAddress();
        String gender = faker.options().option(RandomUtils.getRandomGender());
        String UserNumber = faker.number().digits(10);
        String Day = getRandomDay();
        String Month = getRandomMonth();
        String Year = getRandomYear();
        String Subjects = getRandomSubjects();
        String Hobbies = getRandomHobbies();
        String State = getRandomState();
        String City = getRandomCity(State);

        open("/automation-practice-form");

    RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(UserNumber)
                .setDateOfBirth(Day, Month, Year)
                .setSubjects(Subjects)
                .setHobbies(Hobbies)
                .setAddress(streetAddress)
                .setState(State)
                .setCity(City)

                .clickSubmit()

                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", UserNumber)
                .checkResult("Date of Birth", Day+" "+Month+","+Year)
                .checkResult("Subjects", Subjects)
                .checkResult("Hobbies", Hobbies)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", State+" "+City);
    }
}

