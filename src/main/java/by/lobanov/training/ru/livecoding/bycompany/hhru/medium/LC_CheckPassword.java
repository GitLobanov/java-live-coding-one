package by.lobanov.training.ru.livecoding.bycompany.hhru.medium;

import java.util.ArrayList;
import java.util.List;

public class LC_CheckPassword {

    public static void main(String[] args) {
        System.out.println(findSafePasswords("Password1 Pass@word 12345 pass!word Passw@rd Password1!"));
        System.out.println(findSafePasswords("Password1 Pass@word 12345 pass!word"));
    }

    // Набор спецсимволов
    private static final String specialChars = "!@#$%^&*()-+";

    private static String findSafePasswords(String input) {
        String[] passwords = input.split(" ");
        List<String> safePasswords = new ArrayList<>();

        for (String password : passwords) {
            if (isPasswordSafe(password)) {
                safePasswords.add(password);
            }
        }

        if (safePasswords.isEmpty()) {
            return "Не найдено";
        } else {
            return String.join(" ", safePasswords);
        }
    }

    private static boolean isPasswordSafe(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.contains(String.valueOf(c))) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
