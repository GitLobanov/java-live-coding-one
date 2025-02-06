package by.lobanov.training.ru.core.livecoding.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// Напишите программу для подсчета количества конкретных слов в строке, используя HashMap.
public class TC20_ru_CountWordsInStringUsingHashMap_LC {


    public static void main(String[] args) {
        String s = "task";
        String st = "This task task will be solved by by by Java developer developer";
        System.out.println(countWordWithStream(s, st));
        System.out.println(countWordWithoutStream(s, st));
        System.out.println(countWordWithoutStream(s, st) == countWordWithStream(s, st));
    }

    private static long countWordWithoutStream (String searchWord, String sentence) {
        String [] words = sentence.split(" ");

        Map<String, Long> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (map.containsKey(words[i])) {
                map.put(currentWord, map.get(currentWord) + 1);
            } else {
                map.put(currentWord, 1L);
            }
        }

        return map.get(searchWord);
    }

    private static long countWordWithStream (String searchWord, String sentence) {
        String [] words = sentence.split(" ");
        Map<String, Long> collect = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        return collect.get(searchWord);
    }
}
