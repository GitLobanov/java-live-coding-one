package by.lobanov.training.ru.livecoding.core.regex;

import java.util.Arrays;
import java.util.List;

public class FindUniqueWordsRegex {

    public static void main(String[] args) {
        String text = "Hello, world! Hello Java. Java is great.";
        List<String> uniqueWords = findUniqueWords(text);
        System.out.println(uniqueWords);
    }

    private static List<String> findUniqueWords(String text) {
        return Arrays.stream(text.replaceAll("[!,.]", "").split("\\s"))
                .distinct().toList();
    }
}
