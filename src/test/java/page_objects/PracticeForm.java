package page_objects;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

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

    public static void setDateOfBirth(String mounth, String year, String day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(mounth)).click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(byText(day)).click();

    }

    public PracticeForm checkStudentName(String firstName, String lastName){
        SelenideElement element = $$("tr td:first-child").findBy(text("Student Name")).parent();
        element.$("td:last-child").shouldHave(text(firstName +" "+ lastName));
        return this;
    }

    public PracticeForm checkStudentEmail(String email){
        SelenideElement element =$$("tr td:first-child").findBy(text("Student Email")).parent();
        element.$("td:last-child").shouldHave(text(email));
        return this;
    }

    public PracticeForm checkGender(String gender){
        SelenideElement element =$$("tr td:first-child").findBy(text("Gender")).parent();
        element.$("td:last-child").shouldHave(text(gender));
        return this;
    }

    public PracticeForm checkMobile(String mobile){
        SelenideElement element = $$("tr td:first-child").findBy(text("Mobile")).parent();
        element.$("td:last-child").shouldHave(text(mobile));
        return this;
    }

    public PracticeForm checkDateOfBirth(String mounth, String year, String day){
        SelenideElement element = $$("tr td:first-child").findBy(text("Date of Birth")).parent();
        element.$("td:last-child").shouldHave(text(day + " " + mounth + "," + year));
        return this;
    }

    public PracticeForm checkSubject(String subject){
        SelenideElement element = $$("tr td:first-child").findBy(text("Subjects")).parent();
        element.$("td:last-child").shouldHave(text(subject));
        return this;
    }

    public PracticeForm checkHobbies(String hobbie){
        SelenideElement element = $$("tr td:first-child").findBy(text("Hobbies")).parent();
        element.$("td:last-child").shouldHave(text(hobbie));
        return this;
    }

    public PracticeForm checkPicture(String puctureName){
        SelenideElement element = $$("tr td:first-child").findBy(text("Picture")).parent();
        element.$("td:last-child").shouldHave(text(puctureName));
        return this;
    }

    public PracticeForm checkAddress(String address){
        SelenideElement element = $$("tr td:first-child").findBy(text("Address")).parent();
        element.$("td:last-child").shouldHave(text(address));
        return this;
    }

    public PracticeForm checkStateAndCity(String state, String city){
        SelenideElement element = $$("tr td:first-child").findBy(text("State and City")).parent();
        element.$("td:last-child").shouldHave(text(state + " " + city));
        return this;
    }
}
