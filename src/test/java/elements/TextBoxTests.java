package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
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
    @Test
    void testEmail(){
        open("https://demoqa.com/text-box");
        $("#userEmail").setValue("Test@example.com");
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $("#email").shouldHave(text("Email:Test@example.com"));
    }

    @Test
    void testCurrentAddress(){
        open("https://demoqa.com/text-box");
        $("#currentAddress").setValue("Test Address");
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $("#currentAddress.mb-1").shouldHave(text("Current Address :Test Address"));
    }

    @Test
    void testPermanentAddress(){
        open("https://demoqa.com/text-box");
        $("#permanentAddress").setValue("Test Address");
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $("#permanentAddress.mb-1").shouldHave(text("Permananet Address :Test address"));
    }

    @Test
    void testAllFields(){
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Test");
        $("#userEmail").setValue("Test@example.com");
        $("#currentAddress").setValue("Test Address");
        $("#permanentAddress").setValue("Test Address");
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $("#name").shouldHave(text("Name:Test"));
        $("#email").shouldHave(text("Email:Test@example.com"));
        $("#currentAddress.mb-1").shouldHave(text("Current Address :Test Address"));
        $("#permanentAddress.mb-1").shouldHave(text("Permananet Address :Test address"));
    }
    @Test
    void testIncorrectEmail(){
        open("https://demoqa.com/text-box");
        $("#userEmail").setValue("Test");
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        $("#email").shouldNotBe(visible);
        $("#userEmail").shouldHave(cssValue("border","1px solid rgb(255, 0, 0)"));
    }


}
