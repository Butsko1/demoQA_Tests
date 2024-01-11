package forms;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import page_objects.PracticeForm;

import static com.codeborne.selenide.Condition.text;
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
    @AfterAll
    static void closeAll(){
        closeWebDriver();

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
                .checkDateOfBirth("November", "2022", "15")
                .checkSubject("Maths")
                .checkHobbies("Reading")
                .checkPicture("Test.PNG")
                .checkAddress("Test Current Address")
                .checkStateAndCity("Rajasthan","Jaipur");

    }

}
