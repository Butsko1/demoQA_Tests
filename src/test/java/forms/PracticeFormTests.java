package forms;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.PracticeForm;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    PracticeForm practiceForm = new PracticeForm();
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    void openPage(){
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void doClean(){
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

    @Test
    void testRegularSubmit(){
        practiceForm.fullFillForm("Test First Name", "Test Last Name", "testemail@gmail.com", "Female", "1234567890", practiceForm.setDateOfBirth("November", "2022", "15"),
                "Maths","Reading", "Test","Test Current Address", "Rajasthan", "Jaipur");
        practiceForm
                .checkStudentName("Test First Name", "Test Last Name")
                .checkStudentEmail("testemail@gmail.com")
                .checkGender("Female")
                .checkMobile("1234567890")
                .checkDateofBirth("November", "2022", "15");

    }

}
