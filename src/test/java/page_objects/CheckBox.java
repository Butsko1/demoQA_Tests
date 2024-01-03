package page_objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBox {
    public CheckBox clickHome(){
        $("ol li button").click();
        return this;
    }

    public CheckBox checkVisibility(String element, Boolean bool){
        if(bool){
            $(byText(element)).shouldBe(visible);
        }
        else{
            $(byText(element)).shouldNotBe(visible);
        }
        return this;
    }

    public CheckBox isDesktopChecked(Boolean bool){
        if(bool){
            $$("ol li label span svg").get(2).shouldHave(cssClass("rct-icon-check"));
        }
        else{
            $$("ol li label span svg").get(2).shouldHave(cssClass("rct-icon-uncheck"));
        }
        return this;
    }
    public CheckBox isDocumentsChecked(Boolean bool){
        if(bool){
            $$("ol li label span svg").get(4).shouldHave(cssClass("rct-icon-check"));
        }
        else{
            $$("ol li label span svg").get(4).shouldHave(cssClass("rct-icon-uncheck"));
        }
        return this;
    }
    public CheckBox isDownloadsChecked(Boolean bool){
        if(bool){
            $$("ol li label span svg").get(6).shouldHave(cssClass("rct-icon-check"));
        }
        else{
            $$("ol li label span svg").get(6).shouldHave(cssClass("rct-icon-uncheck"));
        }
        return this;
    }
    public CheckBox isHomeChecked(Boolean bool){
        if(bool){
            $$("ol li label span svg").get(0).shouldHave(cssClass("rct-icon-check"));
        }
        else{
            $$("ol li label span svg").get(0).shouldHave(cssClass("rct-icon-uncheck"));
        }
        return this;
    }

    public CheckBox checkingHome(){
        $$("ol li label span svg").get(0).click();
        return this;
    }

    public CheckBox clickDesktop(){
        $("ol ol li:first-child button").click();
        return this;
    }
    public CheckBox isNotesChecked(Boolean bool){
        if(bool){
            $$("ol li span span.rct-checkbox svg").get(2).shouldHave(cssClass("rct-icon-check"));
        }
        else{
            $$("ol li span span.rct-checkbox svg").get(2).shouldHave(cssClass("rct-icon-uncheck"));
        }
        return this;
    }
    public CheckBox isCommandsChecked(Boolean bool){
        if(bool){
            $$("ol li span span.rct-checkbox svg").get(3).shouldHave(cssClass("rct-icon-check"));
        }
        else{
            $$("ol li span span.rct-checkbox svg").get(3).shouldHave(cssClass("rct-icon-uncheck"));
        }
        return this;
    }
    public CheckBox checkingDesktop(){
        $$("ol li label span svg").get(2).click();
        return this;
    }
    public CheckBox isHomeHalfChecked(Boolean bool){
        if(bool){
            $$("ol li label span svg").get(0).shouldHave(cssClass("rct-icon-half-check"));
        }
        else{
            $$("ol li label span svg").get(0).shouldNotHave(cssClass("rct-half-icon-uncheck"));
        }
        return this;
    }
    public CheckBox checkingNotes(){
        $$("ol li span span.rct-checkbox svg").get(2).click();
        return this;
    }
    public CheckBox checkingCommands(){
        $$("ol li span span.rct-checkbox svg").get(3).click();
        return this;
    }
    public CheckBox isDesktopHalfChecked(Boolean bool){
        if(bool){
            $$("ol li label span svg").get(2).shouldHave(cssClass("rct-icon-half-check"));
        }
        else{
            $$("ol li label span svg").get(2).shouldNotHave(cssClass("rct-half-icon-uncheck"));
        }
        return this;
    }

    public CheckBox checkMessage(String ... s){
        for (String string : s) {
            $("#result").shouldHave(text(string));
        }
        return this;
    }
}
