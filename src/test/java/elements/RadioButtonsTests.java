package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonsTests {
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void openPage(){
        open("https://demoqa.com/radio-button");
    }
    @Test
    void checkYesButton(){
        //Нажимаем на чекбокс "Yes" и проверяем его состояние
        $("[for = yesRadio]").click();
        $("#yesRadio").shouldBe(enabled).shouldBe(selected);
        $(".text-success").shouldHave(text("Yes"));
    }
    @Test
    void checkImpressiveButton(){
        //Нажимаем на чекбокс "Impressive" и проверяем его состояние
        $("[for = impressiveRadio]").click();
        $("#impressiveRadio").shouldBe(enabled).shouldBe(selected);
        $(".text-success").shouldHave(text("Impressive"));
    }

    @Test
    void checkNoButton(){
        //Нажимаем на чекбокс "Impressive" и проверяем его состояние
        $("[for = noRadio]").click();
        $("#noRadio").shouldHave(cssClass("disabled")).shouldNotBe(selected);
        $(".text-success").shouldNotBe(visible);
    }

    @Test
    void testManySelects(){
        //Нажимаем на чекбокс "Yes" и проверяем его состояние
        $("[for = yesRadio]").click();
        $("#yesRadio").shouldBe(enabled).shouldBe(selected);
        $(".text-success").shouldHave(text("Yes"));
        //Нажимаем на чекбокс "Impressive" и проверяем его состояние
        $("[for = impressiveRadio]").click();
        $("#impressiveRadio").shouldBe(enabled).shouldBe(selected);
        $(".text-success").shouldHave(text("Impressive"));
        //Проверяем состояние чекбокса "Yes"
        $("#yesRadio").shouldBe(enabled).shouldNotBe(selected);
    }
}
