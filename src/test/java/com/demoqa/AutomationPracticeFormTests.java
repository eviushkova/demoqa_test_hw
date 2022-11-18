package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1792x1015";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        fillForm();
        checkForm();
    }

    private static void fillForm() {
        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //executeJavaScript("$('#RightSide_Advertisement').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov.ivan@test.com");
        $("#userEmail").setValue("ivanov.ivan@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("88009009090");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Screenshot 2022-11-17 at 16.11.13.png"));
        $("#currentAddress").setValue("London, UK");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();
    }

    private static void checkForm() {
        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(Condition.text("Ivan Ivanov"));
        $(".modal-content").shouldHave(Condition.text("ivanov.ivan@test.com"));
        $(".modal-content").shouldHave(Condition.text("Male"));
        $(".modal-content").shouldHave(Condition.text("8800900909"));
        $(".modal-content").shouldHave(Condition.text("14 April,1995"));
        $(".modal-content").shouldHave(Condition.text("Economics"));
        $(".modal-content").shouldHave(Condition.text("Reading, Music"));
        $(".modal-content").shouldHave(Condition.text("Screenshot 2022-11-17 at 16.11.13.png"));
        $(".modal-content").shouldHave(Condition.text("London, UK"));
        $(".modal-content").shouldHave(Condition.text("NCR Gurgaon"));
        $("#closeLargeModal").click();
    }
}
