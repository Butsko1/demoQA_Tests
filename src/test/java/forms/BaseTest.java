package forms;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    @Step("Открываем https://demoqa.com/automation-practice-form")
    void openPage(){
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterAll
    static void closeAll(){
        closeWebDriver();

    }
}
