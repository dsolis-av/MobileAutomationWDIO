package org.globant.utils;
import java.util.Random;

public class RandomCredentialGenerator {
    private static final String[] DOMAINS = {"example.com", "test.org", "demo.net", "mail.io"};
    private static final String USERNAME_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final String PASSWORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$&*-_";

    public static String generateRandomEmail() {
        Random random = new Random();
        int usernameLength = 6 + random.nextInt(5); //6 to 10 characters
        StringBuilder username = new StringBuilder();

        for (int i = 0; i < usernameLength; i++) {
            username.append(USERNAME_CHARS.charAt(random.nextInt(USERNAME_CHARS.length())));
        }

        String domain = DOMAINS[random.nextInt(DOMAINS.length)];
        return username + "@" + domain;
    }

    public static String generateRandomPassword() {
        Random random = new Random();
        int passwordLength = 8 + random.nextInt(5); // 8 to 12 characters
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            password.append(PASSWORD_CHARS.charAt(random.nextInt(PASSWORD_CHARS.length())));
        }

        return password.toString();
    }
}

