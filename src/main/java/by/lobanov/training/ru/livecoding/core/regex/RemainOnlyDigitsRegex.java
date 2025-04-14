package by.lobanov.training.ru.livecoding.core.regex;

import java.util.Arrays;
import java.util.List;

public class RemainOnlyDigitsRegex {

    public static void main(String[] args) {
        String text = "Hello123 world! Hello45 Java. Java678 is great.9";
        String digits = extractDigits(text);
        System.out.println(digits);
    }

    private static String extractDigits(String text) {
        return text.replaceAll("\\D", "");
    }
}
