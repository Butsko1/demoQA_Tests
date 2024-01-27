package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @Step("Заполняем форму")
    public  PracticeForm fullFillForm(String firstName, String lastName, String email, String gender, String mobile,
                                  String subjects, String hobbies, String picture, String currentAddress, String state, String city){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(mobile);
        $(byText(gender)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        return this;
    }
    @Step("Заполняем дату рождения")
    public static void setDateOfBirth(String mounth, String year, String day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(mounth)).click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(byText(day)).click();

    }
    @Step("Проверяем имя студента")
    public PracticeForm checkStudentName(String firstName, String lastName){
        SelenideElement element = $$("tr td:first-child").findBy(text("Student Name")).parent();
        element.$("td:last-child").shouldHave(text(firstName +" "+ lastName));
        return this;
    }
    @Step("Проверяем почту студента")
    public PracticeForm checkStudentEmail(String email){
        SelenideElement element =$$("tr td:first-child").findBy(text("Student Email")).parent();
        element.$("td:last-child").shouldHave(text(email));
        return this;
    }
    @Step("Проверяем пол студента")
    public PracticeForm checkGender(String gender){
        SelenideElement element =$$("tr td:first-child").findBy(text("Gender")).parent();
        element.$("td:last-child").shouldHave(text(gender));
        return this;
    }
    @Step("Провреяем номер студента")
    public PracticeForm checkMobile(String mobile){
        SelenideElement element = $$("tr td:first-child").findBy(text("Mobile")).parent();
        element.$("td:last-child").shouldHave(text(mobile));
        return this;
    }
    @Step("Проверяем дату рождения студента")
    public PracticeForm checkDateOfBirth(String mounth, String year, String day){
        SelenideElement element = $$("tr td:first-child").findBy(text("Date of Birth")).parent();
        element.$("td:last-child").shouldHave(text(day + " " + mounth + "," + year));
        return this;
    }
    @Step("Проверяем предмет")
    public PracticeForm checkSubject(String subject){
        SelenideElement element = $$("tr td:first-child").findBy(text("Subjects")).parent();
        element.$("td:last-child").shouldHave(text(subject));
        return this;
    }
    @Step("Проверяем хобби")
    public PracticeForm checkHobbies(String hobbie){
        SelenideElement element = $$("tr td:first-child").findBy(text("Hobbies")).parent();
        element.$("td:last-child").shouldHave(text(hobbie));
        return this;
    }
    @Step("Проверяем прикрепление картинки")
    public PracticeForm checkPicture(String puctureName){
        SelenideElement element = $$("tr td:first-child").findBy(text("Picture")).parent();
        element.$("td:last-child").shouldHave(text(puctureName));
        return this;
    }
    @Step("Проверяем адрес")
    public PracticeForm checkAddress(String address){
        SelenideElement element = $$("tr td:first-child").findBy(text("Address")).parent();
        element.$("td:last-child").shouldHave(text(address));
        return this;
    }
    @Step("Проверяем область и город")
    public PracticeForm checkStateAndCity(String state, String city){
        SelenideElement element = $$("tr td:first-child").findBy(text("State and City")).parent();
        element.$("td:last-child").shouldHave(text(state + " " + city));
        return this;
    }
}
//allure {
//    report {
//        version.set("2.17.3") //версия Allure Report (https://github.com/allure-framework/allure2)
//    }
//    adapter {
//        aspectjWeaver.set(true) // обработка аннотации @Step
//        frameworks {
//            junit5 {
//                adapterVersion.set("2.17.3") //версия Allure JUnit5 (https://github.com/allure-framework/allure-java)
//            }
//        }
//    }
//}