package components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;


public class ModalWindowComponent {
    public void checkSubmitForm (String fieldName, String value) {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").$(byText(fieldName)).parent().shouldHave(text(value));
    }
}
