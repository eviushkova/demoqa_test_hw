package com.demoqa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeFormTestsWithPageObjects extends TestBase {

    @Test
    void fillFormTest() {

        fillForm();
//        checkForm();
    }

    void fillForm() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivanov.ivan@test.com")
                .setGender("Male")
                .setPhone("8800900909")
                .setBirthDate("14", "April", "1995")
                .setSubject("Economics")
                .setHobbies("Reading")
                .uploadPicture("Screenshot 2022-11-17 at 16.11.13.png")
                .setAddress("London, UK")
                .clickState()
                .setState("NCR")
                .clickCity()
                .setCity("Gurgaon")
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", "Ivan Ivanov")
                .verifyResult("Student Email", "ivanov.ivan@test.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8800900909")
                .verifyResult("Date of Birth", "14 April,1995")
                .verifyResult("Subjects", "Economics")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "Screenshot 2022-11-17 at 16.11.13.png")
                .verifyResult("Address", "London, UK")
                .verifyResult("State and City", "NCR Gurgaon");

        $(".table-responsive").shouldHave(text("Ivan"), text("Ivanov"), text("ivanov.ivan@test.com"), text("Male"), text("8800900909"));
    }

//    private static void checkForm() {
//        $(".modal-content").shouldBe(Condition.visible);
//        $(".modal-content").shouldHave(text("Ivan Ivanov"));
//        $(".modal-content").shouldHave(text("ivanov.ivan@test.com"));
//        $(".modal-content").shouldHave(text("Male"));
//        $(".modal-content").shouldHave(text("8800900909"));
//        $(".modal-content").shouldHave(text("14 April,1995"));
//        $(".modal-content").shouldHave(text("Economics"));
//        $(".modal-content").shouldHave(text("Reading"));
//        $(".modal-content").shouldHave(text("Screenshot 2022-11-17 at 16.11.13.png"));
//        $(".modal-content").shouldHave(text("London, UK"));
//        $(".modal-content").shouldHave(text("NCR Gurgaon"));
//        $("#closeLargeModal").click();
//    }
}
