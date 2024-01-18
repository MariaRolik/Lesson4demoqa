import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SimpleJUnitTests {

    @BeforeEach
    void openPage() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://demoqa.com/automation-practice-form");
        }


    @Test
    void firstTest(){
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("Ivanov@mail.ru");
        $(".custom-control-label").click();
        $("[id=userNumber]").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("1");
        $(".react-datepicker__day--014").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2024");
        $("#dateOfBirth-label").click();
        $("[id=subjectsInput]").setValue("a").sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        $("label[for='hobbies-checkbox-1']").click();
        $("[id=uploadPicture]").uploadFromClasspath("img1.png");
        $("[id=currentAddress]").setValue("pyshkin street");
        $("[id=react-select-3-input]").setValue("NCR").sendKeys(Keys.ENTER);
        $("[id=react-select-4-input]").setValue("Delhi").sendKeys(Keys.ENTER);

        $("[id=submit]").click();




        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("Ivanov@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("14 February,2024"));
        $(".table-responsive").shouldHave(text("Accounting"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("img1.png"));
        $(".table-responsive").shouldHave(text("pyshkin street"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}
