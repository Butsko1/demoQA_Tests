package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.WebTables;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTablesTests {
    WebTables webTable = new WebTables();
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";

    }
    @BeforeEach
    void openPage(){
        open("https://demoqa.com/webtables");
    }
    @Test
    void checkColumns(){
        webTable
                .checkColumnName(1,"First Name")
                .checkColumnName(2,"Last Name")
                .checkColumnName(3,"Age")
                .checkColumnName(4,"Email")
                .checkColumnName(5,"Salary")
                .checkColumnName(6,"Department")
                .checkColumnName(7,"Action");

    }
    @Test
    void testAddedRow(){
        webTable
                .addRow("AAA test", "AAA testov", "AAA@gmail.com", "23", "220000", "Aa")
                .doSearch("AAA test")
                .checkRow("AAA test", "AAA testov", "AAA@gmail.com", "23", "220000", "Aa");

    }
    @Test
    void testAfterOrder(){
        webTable
                .addRow("AAA test", "AAA testov", "AAA@gmail.com", "23", "22", "Aa")
                .clickColumn(1)
                .checkfirst(1,"AAA test")
                .clickColumn(1)
                .checkLast(1,"AAA test")
                .clickColumn(2)
                .checkfirst(2,"AAA testov")
                .clickColumn(2)
                .checkLast(2,"AAA testov")
                .clickColumn(4)
                .checkfirst(4,"AAA@gmail.com")
                .clickColumn(4)
                .checkLast(4,"AAA@gmail.com")
                .clickColumn(5)
                .checkfirst(5,"22")
                .clickColumn(5)
                .checkLast(5,"22")
                .clickColumn(6)
                .checkfirst(6,"Aa")
                .clickColumn(6)
                .checkLast(6,"Aa");;
    }



}
