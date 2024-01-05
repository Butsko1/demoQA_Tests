package page_objects;

import org.checkerframework.checker.units.qual.A;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebTables {
    public WebTables checkColumnName(int number, String name){
        $("[role = row]").$$("div.rt-resizable-header-content").get(number-1).shouldHave(text(name));
        return this;
    }
    public WebTables addRow(String FirstName, String LastName, String Email, String Age, String Salary, String Department){
        $(byText("Add")).click();
        $("#firstName").setValue(FirstName);
        $("#lastName").setValue(LastName    );
        $("#userEmail").setValue(Email);
        $("#age").setValue(Age);
        $("#salary").setValue(Salary);
        $("#department").setValue(Department);
        $("#submit").click();
        return this;
    }

    public WebTables doSearch(String name){
        $("#searchBox").setValue(name);
        $("#basic-addon2").click();

        return this;
    }

    public WebTables checkRow(String FirstName, String LastName, String Email, String Age, String Salary, String Department){
        $("[role = gridcell]:nth-child(1)").shouldHave(text(FirstName));
        $("[role = gridcell]:nth-child(2)").shouldHave(text(LastName));
        $("[role = gridcell]:nth-child(3)").shouldHave(text(Age));
        $("[role = gridcell]:nth-child(4)").shouldHave(text(Email));
        $("[role = gridcell]:nth-child(5)").shouldHave(text(Salary));
        $("[role = gridcell]:nth-child(6)").shouldHave(text(Department));
        return this;
    }
    public WebTables checkfirst(int column, String value){
        $("[role = gridcell]:nth-child(" + column + ")").shouldHave(text(value));
        return this;
    }

    public WebTables checkLast(int column, String value){
        $("[role=rowgroup]:nth-child(4)").$("[role = gridcell]:nth-child(" + column + ")").shouldHave(text(value));
        return this;
    }


    public WebTables clickColumn(int number){
        $("[role = row]").$$("div.rt-resizable-header-content").get(number-1).click();
        return this;
    }
}
