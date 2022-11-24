package com.demoqa;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class TestData {
    public String firstName;
    public String lastName;
    public String userEmail;
    public String gender;
    public String userNumber;
    public String birthDay;
    public String birthMonth;
    public String birthYear;
    public String subject;
    public String hobbies;
    public String picture;
    public String address;
    public String state;
    public String city;

    public static TestData generate() {
        Faker faker = new Faker(new Locale("en"));
        TestData testData = new TestData();
        testData.firstName = faker.name().firstName();
        testData.lastName = faker.name().lastName();
        testData.userEmail = faker.internet().emailAddress();
        testData.gender = getGender();
        testData.userNumber = faker.phoneNumber().subscriberNumber(10);

        LocalDate randomDate = faker.date().birthday().toInstant().atZone(ZoneOffset.UTC).toLocalDate();

        testData.birthDay = (randomDate.getDayOfMonth() / 10 == 0 ? "0" : "") + randomDate.getDayOfMonth();
        testData.birthMonth = randomDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        testData.birthYear = String.valueOf(randomDate.getYear());
        testData.subject = getSubject();
        testData.hobbies = getHobby();
        testData.picture = "Screenshot 2022-11-17 at 16.11.13.png";
        testData.address = faker.address().fullAddress();
        testData.state = "NCR";
        testData.city = "Gurgaon";

        return testData;
    }

    public static String getGender() {
        String[] genders = {"Male", "Female", "Other"};
        String gender = genders[Math.abs(new Random().nextInt() % 3)];

        return gender;
    }

    public static String getSubject() {
        String[] subjects = {"English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies"};
        String subject = subjects[Math.abs(new Random().nextInt() % 6)];

        return subject;
    }

    public static String getHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        String hobby = hobbies[Math.abs(new Random().nextInt() % 3)];

        return hobby;
    }
}
