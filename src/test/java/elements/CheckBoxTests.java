package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckBoxTests {
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void testHome(){
        open("https://demoqa.com/checkbox");
        $(byText("Home")).shouldBe(visible);
        $$("ol li label span svg").get(0).shouldHave(cssClass("rct-icon-uncheck"));
        $("ol li button").click();
        //Проверяем, что появились элементы Desktop, Documents и Downloads
        $(byText("Desktop")).shouldBe(visible);
        $(byText("Documents")).shouldBe(visible);
        $(byText("Downloads")).shouldBe(visible);
        //Проверяем, что соответствующие чекбоксы не чекнуты
        $$("ol li label span svg").get(2).shouldHave(cssClass("rct-icon-uncheck"));
        $$("ol li label span svg").get(4).shouldHave(cssClass("rct-icon-uncheck"));
        $$("ol li label span svg").get(6).shouldHave(cssClass("rct-icon-uncheck"));
        //Чекнем чекбокс Home и проверим Desktop, Documents и Downloads
        $$("ol li label span svg").get(0).click();
        $$("ol li label span svg").get(0).shouldHave(cssClass("rct-icon-check"));
        $$("ol li label span svg").get(2).shouldHave(cssClass("rct-icon-check"));
        $$("ol li label span svg").get(4).shouldHave(cssClass("rct-icon-check"));
        $$("ol li label span svg").get(6).shouldHave(cssClass("rct-icon-check"));
        //Свернем список и проверим, что элементы скрыты
        $("ol li button").click();
        $(byText("Desktop")).shouldNotBe(visible);
        $(byText("Documents")).shouldNotBe(visible);
        $(byText("Downloads")).shouldNotBe(visible);
        //Развернем список и проверим, что все элементы остались чекнуты
        $("ol li button").click();
        $$("ol li label span svg").get(2).shouldHave(cssClass("rct-icon-check"));
        $$("ol li label span svg").get(4).shouldHave(cssClass("rct-icon-check"));
        $$("ol li label span svg").get(6).shouldHave(cssClass("rct-icon-check"));
        //Снимем чекбокс с Home и проверим, что у остальных тоже снялся
        $$("ol li label span svg").get(0).click();
        $$("ol li label span svg").get(0).shouldHave(cssClass("rct-icon-uncheck"));
        $$("ol li label span svg").get(2).shouldHave(cssClass("rct-icon-uncheck"));
        $$("ol li label span svg").get(4).shouldHave(cssClass("rct-icon-uncheck"));
        $$("ol li label span svg").get(6).shouldHave(cssClass("rct-icon-uncheck"));


    }
}
