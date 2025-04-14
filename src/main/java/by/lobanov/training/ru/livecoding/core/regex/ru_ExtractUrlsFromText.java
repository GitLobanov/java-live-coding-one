package by.lobanov.training.ru.livecoding.core.regex;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Извлеките все URL из текста.
 * Правила:
 * URL может начинаться с http://, https:// или www..
 * Может содержать буквы, цифры, дефисы и точки.
 * Может заканчиваться на / или без него.
 * Тестовые случаи:
 */
public class ru_ExtractUrlsFromText {

    public static void main(String[] args) {
        String text = """
                    Visit our website at http://example.com or https://www.example.org/path.
                    You can also check www.test-site.com for more information.
                    Invalid links like example and ftp://example.com should not be extracted.
                """;

        List<String> expectedUrls = List.of(
                "http://example.com",
                "https://www.example.org/path",
                "www.test-site.com"
        );

        solution(text).stream()
                .map(s -> expectedUrls.stream().anyMatch(s1 -> s1.equals(s)))
                .forEach(System.out::println);
    }

    private static List<String> solution(String text) {
        List<String> list = new ArrayList<>();
        String regex = "\\b(?:https?://|www\\.)[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:/[A-Za-z]*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
