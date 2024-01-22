package forms;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page_objects.PracticeForm;

import java.util.Locale;
import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {
    PracticeForm practiceForm = new PracticeForm();
    static Faker faker = new Faker();
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    void openPage(){
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterAll
    static void closeAll(){
        closeWebDriver();

    }
    static Stream<Arguments> methodSourse(){
        return Stream.of(
                Arguments.of(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "Female", faker.number().digits(10),
                        "Maths","Reading", "images/Test.PNG",faker.address().fullAddress(), "Rajasthan", "Jaipur"),
                Arguments.of(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "Male", faker.number().digits(10),
                        "Maths","Reading", "images/Test.PNG",faker.address().fullAddress(), "Rajasthan", "Jaipur"),
                Arguments.of(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "Other", faker.number().digits(10),
                        "Maths","Reading", "images/Test.PNG",faker.address().fullAddress(), "Rajasthan", "Jaipur")
        );
    }
    @MethodSource("methodSourse")
    @ParameterizedTest(name = "gender is {3}")
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
                .checkPicture(picture.replace("images/",""))
                .checkAddress(address)
                .checkStateAndCity(state,city);
    }

}
