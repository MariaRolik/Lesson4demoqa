package utils;

import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker();

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++)
            result.append(AB.charAt(rnd.nextInt(AB.length())));

        return result.toString();
    }

    public static String getRandomAddress() {
        return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {
                "Male",
                "Female",
                "Other"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomSubjects() {
        String[] Subjects = {
                "Maths",
                "History",
                "English",
                "Arts",
                "Computer Science",
                "Physics"};
        int index = getRandomInt(0, Subjects.length - 1);
        return Subjects[index];
    }

    public static String getRandomHobbies() {
        String[] Hobbies = {
                "Sports",
                "Reading",
                "Music"};
        int index = getRandomInt(0, Hobbies.length - 1);
        return Hobbies[index];
    }

    public static String getRandomState() {

        return faker.options().option(
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan");
    }
    public static String getRandomCity(String state){

        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> state;
        };
    }



    public static String getRandomDay() {
        return String.valueOf(getRandomInt(1, 28));

    }

    public static String getRandomMonth() {

        return faker.options().option(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
    }

    public static String getRandomYear() {
        return String.valueOf(getRandomInt(1900, 2024));
    }


}