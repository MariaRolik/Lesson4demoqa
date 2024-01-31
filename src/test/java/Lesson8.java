import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson8 {

    @BeforeEach
    void openPage() {
        Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void closeWindow() {
        WebDriverRunner.closeWindow();
    }

    @Test
    void openSolutions() {
        open("https://github.com/");
        $$(".HeaderMenu-item").get(1).shouldHave(text("Solutions")).hover();
        $("html").$(byText("Enterprise")).click();
        $(".application-main").shouldHave(text("The AI-powered\n"+"developer platform."));
    }

    @Test
    void dragDropWithActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }


    @Test
    void dragDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        $("#column-a").dragAndDrop(to("#column-b"));

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

}
