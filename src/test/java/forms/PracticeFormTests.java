package forms;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import page_objects.PracticeForm;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends BaseTest {
    PracticeForm practiceForm = new PracticeForm();

    @Feature("Форма")
    @DisplayName("Заполнение с разным полом")
    @Story("Заполнение формы")
    @MethodSource("source.PracticeFormSource#methodSourse")
    @ParameterizedTest(name = "gender is {3}")
    void testRegularSubmit(String name, String lastName,String email, String gender, String mobile, String subjects, String hobbies, String picture, String address, String state, String city){
        SelenideLogger.addListener("allure",new AllureSelenide());
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
