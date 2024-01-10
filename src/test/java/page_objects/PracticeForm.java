package page_objects;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.net.URL;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    public PracticeForm fullFillForm(String firstName, String lastName, String email, String gender, String mobile, PracticeForm dateOfBirth,
                                  String subjects, String hobbies, String picture, String currentAddress, String state, String city){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(mobile);
        $(byText(gender)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText(hobbies)).click();
        ClassLoader classLoader = getClass().getClassLoader();
        File testFile = new File(classLoader.getResource("images/"+ picture +".PNG").getFile());
        $("#uploadPicture").uploadFile(testFile);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        return this;
    }

    public PracticeForm setDateOfBirth(String mounth, String year, String day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(mounth)).click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(byText(day)).click();
        return this;
    }

    public PracticeForm checkStudentName(String firstName, String lastName){
        SelenideElement element = $(byText("Student Name")).parent();
        element.$("td:last-child").shouldHave(text(firstName +" "+ lastName));
        return this;
    }

    public PracticeForm checkStudentEmail(String email){
        SelenideElement element = $(byText("Student Email")).parent();
        element.$("td:last-child").shouldHave(text(email));
        return this;
    }

    public PracticeForm checkGender(String gender){
        SelenideElement element = $(byText("Gender")).parent();
        $("td:last-child").shouldHave(text(gender));
        return this;
    }

    public PracticeForm checkMobile(String mobile){
        SelenideElement element = $(byText("Mobile")).parent();
        element.$("td:last-child").shouldHave(text(mobile));
        return this;
    }

    public PracticeForm checkDateofBirth(String mounth, String year, String day){
        SelenideElement element = $(byText("Date of Birth")).parent();
        element.$("td:nth-child(2)").shouldHave(text(day + " " + mounth + "," + year));
        return this;
    }

}
