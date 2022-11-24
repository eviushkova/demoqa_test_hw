package com.demoqa;

import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTestsWithPageObjects extends TestBase {

    @Test
    void fillForm() {

        TestData testData = TestData.generate();

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setPhone(testData.userNumber)
                .setBirthDate(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.picture)
                .setAddress(testData.address)
                .clickState()
                .setState(testData.state)
                .clickCity()
                .setCity(testData.city)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.userNumber)
                .verifyResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobbies)
                .verifyResult("Picture", testData.picture)
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", testData.state + " " + testData.city);

    }
}
