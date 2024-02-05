package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private SelenideElement

            userForm = $("#userForm"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");


       CalendarComponent calendarComponent = new CalendarComponent();
       ModalWindowComponent modalWindowComponent = new ModalWindowComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects (String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies (String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }


    public RegistrationPage uploadPicture(String img) {
        pictureInput.uploadFromClasspath(img);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }
    public RegistrationPage setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }


    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }


    public RegistrationPage checkResult(String fieldName, String value) {
        modalWindowComponent.checkSubmitForm(fieldName, value);
        return this;
    }
    public RegistrationPage checkValidation() {
        String valueName = "border-color";
        String colorRed = "rgb(220, 53, 69)";
        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue(valueName,colorRed));
        lastNameInput.shouldHave(cssValue(valueName,colorRed));
        genderWrapper.$(byText("Male")).shouldHave(cssValue(valueName,colorRed));
        genderWrapper.$(byText("Female")).shouldHave(cssValue(valueName,colorRed));
        genderWrapper.$(byText("Other")).shouldHave(cssValue(valueName,colorRed));
        userNumberInput.shouldHave(cssValue(valueName,colorRed));
        return this;
    }


}


