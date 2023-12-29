package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void testFullName(){
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Test");
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $("#name").shouldHave(text("Name:Test"));
    }
}
