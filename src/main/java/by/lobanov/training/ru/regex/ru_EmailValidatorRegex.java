package by.lobanov.training.ru.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Проверьте, является ли email адрес корректным.
 * Правила:
 * должен содержать @
 * должна быть точка после @
 * локальная часть может содержать буквы, цифры, точки и подчеркивания
 */
public class ru_EmailValidatorRegex {

    public static void main(String[] args) {
        String[] testEmails = {
                "example@example.com", // true (корректный email)
                "user@.com", // false (некорректная доменная часть)
                "user@domain.c" // false (слишком короткое расширение домена)
        };

        System.out.println(solution(testEmails[0]));
        System.out.println(solution(testEmails[1]));
        System.out.println(solution(testEmails[2]));
    }

    private static boolean solution (String email) {
        String regex1 = "\\S+@\\S+\\.\\S{2,}$";
        String regex2 = "[a-z]+@[a-z]+\\.[a-z]{2,}$";
        String regex3 = "[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
