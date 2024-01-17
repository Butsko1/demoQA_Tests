package forms;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import page_objects.PracticeForm;

import java.util.stream.Stream;

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
    static Stream<Arguments> methodSourse(){
        return Stream.of(
                Arguments.of("Test First Name1", "Test Last Name1", "testemail1@gmail.com", "Female", "1234567890",
                        "Maths","Reading", "Test","Test Current Address", "Rajasthan", "Jaipur"),
                Arguments.of("Test First Name", "Test Last Name", "testemail@gmail.com", "Male", "1234567890",
                        "Maths","Reading", "Test","Test Current Address", "Rajasthan", "Jaipur"),
                Arguments.of("Test First Name", "Test Last Name", "testemail@gmail.com", "Other", "1234567890",
                        "Maths","Reading", "Test","Test Current Address", "Rajasthan", "Jaipur")
        );
    }
    @MethodSource("methodSourse")
    @ParameterizedTest(name = "[{index}] gender is {3}")
    void testRegularSubmit(String name, String lastName,String email, String gender, String mobile, String subjects, String hobbies, String picture, String address, String state, String city){
        PracticeForm.setDateOfBirth("November", "2022", "15");
        practiceForm.fullFillForm(name, lastName, email, gender, mobile,
                subjects,hobbies, picture,address, state, city);
        practiceForm
                .checkStudentName(name, lastName)
                .checkStudentEmail(email)
                .checkGender(gender)
                .checkMobile(mobile)
                .checkDateOfBirth("November", "2022", "15")
                .checkSubject(subjects)
                .checkHobbies(hobbies)
                .checkPicture(picture)
                .checkAddress(address)
                .checkStateAndCity(state,city);

    }

}
