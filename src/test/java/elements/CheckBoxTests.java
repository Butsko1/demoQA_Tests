package elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_objects.CheckBox;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckBoxTests {
    CheckBox checkBox = new CheckBox();
    @BeforeAll
    static void setConfigs(){
        Configuration.pageLoadStrategy = "eager";
    }
    @BeforeEach
    void openPage(){
        open("https://demoqa.com/checkbox");
    }
    @AfterEach
    void doClean(){
        clearBrowserLocalStorage();
        clearBrowserCookies();
    }
    @Test
    void testHome(){
        //Проверяем наличие Home, убеждаемся, что он не чекнут и раскрываем список
        checkBox
                .checkVisibility("Home",true)
                .isHomeChecked(false)
                .clickHome();
        //Проверяем, что появились элементы Desktop, Documents и Downloads
        checkBox
                .checkVisibility("Desktop",true)
                .checkVisibility("Documents",true)
                .checkVisibility("Downloads",true);
        //Проверяем, что соответствующие чекбоксы не чекнуты
        checkBox
                .isDesktopChecked(false)
                .isDocumentsChecked(false)
                .isDownloadsChecked(false);
        //Чекнем чекбокс Home и проверим Desktop, Documents и Downloads
        checkBox
                .checkingHome()
                .isHomeChecked(true)
                .isDesktopChecked(true)
                .isDocumentsChecked(true)
                .isDownloadsChecked(true)
                .checkMessage("home","desktop","notes","commands","documents","workspace","react","angular","veu","office","public","private","classified",
                "general","downloads","wordFile","excelFile");

        //Свернем список и проверим, что элементы скрыты
        checkBox
                .clickHome()
                .checkVisibility("Desktop",false)
                .checkVisibility("Documents",false)
                .checkVisibility("Downloads",false);
        //Развернем список и проверим, что все элементы остались чекнуты
        checkBox
                .clickHome()
                .isHomeChecked(true)
                .isDesktopChecked(true)
                .isDocumentsChecked(true)
                .isDownloadsChecked(true);
        //Снимем чекбокс с Home и проверим, что у остальных тоже снялся
        checkBox
                .checkingHome()
                .isHomeChecked(false)
                .isDesktopChecked(false)
                .isDocumentsChecked(false)
                .isDownloadsChecked(false);
    }

    @Test
    void testDesktop(){
        //Раскрываем списки Home и Desktop
        checkBox
                .clickHome()
                .clickDesktop();

        //Проверяем видимость Notes и Commands
        checkBox
                .checkVisibility("Notes",true)
                .checkVisibility("Commands",true);

        //Проверяем, что Notes и Commands не чекнуты
        checkBox
                .isNotesChecked(false)
                .isCommandsChecked(false);

        //Проверка изменения иконки Home, если чекнуть Desktop
        checkBox
                .checkingDesktop()
                .isHomeHalfChecked(true)
                .checkMessage("desktop","notes","commands");

        //Снимаем чек с Desktop и чекаем Notes. Проверяем изменение иконок Home и Desktop
        checkBox
                .checkingDesktop()
                .checkingNotes()
                .isDesktopHalfChecked(true)
                .isHomeHalfChecked(true)
                .checkMessage("notes");

        //Снимаем чек с Notes и чекаем Commands. Проверяем изменение иконок Home и Desktop
        checkBox
                .checkingNotes()
                .checkingCommands()
                .isDesktopHalfChecked(true)
                .isHomeHalfChecked(true)
                .checkMessage("commands");;

        //Чекаем Notes. Проверяем изменение иконок Home и Desktop
        checkBox
                .checkingNotes()
                .isDesktopChecked(true)
                .isHomeHalfChecked(true)
                .checkMessage("desktop","notes","commands");;
    }
}
