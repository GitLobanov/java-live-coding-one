package by.lobanov.training.ru.livecoding.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Проверьте, является ли входная строка корректным номером телефона.
 * Форматы могут быть:
 * (123) 456-7890
 * 123-456-7890
 */
public class ru_ValidPhoneNumberRegex {

    // 1. допускать два варианта формата номера

    public static void main(String[] args) {
        System.out.println(solutionValidate("(123) 456-7890")); // true
        System.out.println(solutionValidate("123-456-7890"));   // true
        System.out.println(solutionValidate("123-4567-890"));   // false
        System.out.println(solutionValidate("123 456-7890"));   // false
    }



    public static boolean solutionValidate (String phoneNumber) {
        // ((123)_ or 123-456-7890
        String regex = "^(?:\\(\\d{3}\\)\\s|\\d{3}-)\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
