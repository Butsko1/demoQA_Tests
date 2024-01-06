package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ButtonsTests {
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void openPage(){
        open("https://demoqa.com/buttons");
    }

    @Test
    void testDoubleClickButton(){
        $("#doubleClickBtn").doubleClick();
        $("#doubleClickMessage").shouldHave(text("You have done a double click"));
    }

    @Test
    void testRightClickButton(){
        $("#rightClickBtn").contextClick();
        $("#rightClickMessage").shouldHave(text("You have done a right click"));
    }

    @Test
    void testClickButton(){
        $(byText("Click Me")).click();
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
    }
}
